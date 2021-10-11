package mx.axxib.gpi.ctrll;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mx.axxib.gpi.util.ConteoUsuario;

@Controller
public class LoginController {
	private static final Logger LOGGER = LogManager.getLogger(LoginController.class);

	@Autowired
	private Environment env;

	/**********************************************
	 * DETALLE: VISTA LOGIN Valida que los datos de ingreso no sean nulos
	 **********************************************/
	@GetMapping(value = { "/", "/login" })
	public String login(@RequestParam(value = "error", required = false) String error, Model model,
			Principal principal) {
		String vistaRetorno = null;
		String errorMessge = null;

		String registroUsuario = null;
		boolean usuarioEncontrado = false;
		File file = null;

		String[] parts = null;
		String part1 = null;
		String part2 = null;
		int conteo = 0;

		if (principal != null) {

			return "redirect:/home";
		}

		if (error != null) {

			errorMessge = "Usuario o contraseña incorrectos!";
		}

		model.addAttribute("errorMessge", errorMessge);

		vistaRetorno = "view_login/login";

		LOGGER.info("# LOGIN  - VISTA INICIO LOGIN ");

		return vistaRetorno;

	}

	@GetMapping(value = "/logout")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String retorno = null;

		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		retorno = "redirect:/login?logout";

		LOGGER.info("# LOGIN  - VISTA LOGIN (LOGOUT) ");

		return retorno;
	}

	@GetMapping(value = "/acessoDenegado")
	public String acessoDenegado(HttpServletRequest request, HttpServletResponse response, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String perfil = auth.getAuthorities().toString();
		String errorMessge = null;
		String retorno = null;

		File file = null;
		FileReader fr = null;
		BufferedReader br = null;
		String registroUsuario = null;
		boolean usuarioEncontrado = false;

		String[] parts = null;
		String part1 = null;
		String part2 = null;
		int conteo = 0;

		String usuarioObtenido = null;

		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		LOGGER.info("# LOGIN  - VISTA LOGIN (LOGOUT) - PERFIL:{}, USUARIO:{}" , perfil, auth.getName());
		
		

		if(perfil.equals("[]")) {
			
			try {
	 	         
		   		  file = new File (this.env.getProperty("ruta.archivoConteoUsuarios"));
		 	         fr = new FileReader (file);
		 	         br = new BufferedReader(fr);
		 	         
		 	         while((registroUsuario = br.readLine())!=null)          	        	 
		 	        	 if(registroUsuario.toUpperCase().trim().contains(auth.getName().toUpperCase())) {
		 	        		usuarioObtenido = registroUsuario.toUpperCase().trim();
		 	        		usuarioEncontrado = true;
		 	        		
		 	        		 break; 
		 	        		 
		 	        	 }
		 	         
		 	      }
		 	      catch(Exception e){
		 	         e.printStackTrace();
		 	        LOGGER.error("# ERROR - ERROR AL CONSULTAR USUARIO EN EL ARCHIVO - ERROR  -  MENSAJE:{}", e.toString());
		 	      }finally{
		 	        
		 	         try{                    
		 	            if( null != fr ){   
		 	               fr.close();     
		 	            }                  
		 	         }catch (Exception e2){ 
		 	            e2.printStackTrace();
		 	           LOGGER.error("# ERROR - ERROR AL CONSULTAR USUARIO EN EL ARCHIVO - ERROR  -  MENSAJE:{}", e2.toString());
		 	         }
		 	      }
		      	
		      	
		      
			
			  if(usuarioEncontrado) {
				  parts = usuarioObtenido.split(" TOTAL: ");
		       	  part2 = parts[1];
		       	  conteo = Integer.parseInt(part2);
				  
			  }
			  

	  LOGGER.info("# LOGIN  - VISTA LOGIN (LOGOUT) - PERFIL:{}, USUARIO:{}, TOTAL:{}" , perfil, auth.getName(), conteo);
		if(conteo >= 2 ) {
			model.addAttribute("errorMessge", "Lleva dos intentos de acceso fallidos. Para evitar bloquear el usuario, le recomendamos consultar sus datos de acceso.");
		}else {
			model.addAttribute("errorMessge",
					"Usuario o contraseña incorrectos!!");
		}
		
		}else if(perfil.equals("[ROLE_SE]")) {
			model.addAttribute("errorMessge",
					"Usuario no autorizado para ingresar al portal. Contacte al administrador de sitio.");
		}else {
			model.addAttribute("errorMessge",
					"Usuario o contraseña incorrectos!!");
		}

		retorno = "view_login/login";

		LOGGER.info("# LOGIN  - VISTA LOGIN (ACCESO DENEGADO) ");
		return retorno;
	}

}
