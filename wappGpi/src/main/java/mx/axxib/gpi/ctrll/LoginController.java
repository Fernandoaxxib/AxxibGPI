package mx.axxib.gpi.ctrll;


import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	/**********************************************
	 * DETALLE: LOGIN 
	 *           Valida que los datos de ingreso no sean nulos
	 **********************************************/
	@GetMapping(value = {"/", "/login"})
	public String login(@RequestParam(value = "error", required = false) String error, Model model, Principal principal)  {
     String vistaRetorno = null;     
     String errorMessge = null;
     
		if (principal != null) {	
					
					return "redirect:/home";
		}	
		
		if (error != null) {		
			errorMessge = "Usuario o contraseña incorrectos!";
		}

		model.addAttribute("errorMessge", errorMessge);
	
        vistaRetorno ="view_login/login";
		
		return vistaRetorno;
	
	}
	
	@GetMapping(value = "/logout")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response)  {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String retorno = null;
		
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		  retorno= "redirect:/login?logout";
		
		return retorno;
	}
	
	
	@GetMapping(value = "/acessoDenegado")
	public String acessoDenegado(HttpServletRequest request, HttpServletResponse response, Model model)  {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String errorMessge = null;
		String retorno = null;
		
		
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		
		 model.addAttribute("errorMessge", errorMessge);
		 
		  retorno = "ms_security/login";
		 
		
		return retorno;
	}

	
}
