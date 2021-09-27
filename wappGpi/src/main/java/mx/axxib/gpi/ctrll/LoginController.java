package mx.axxib.gpi.ctrll;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	

	/**********************************************
	 * DETALLE: LOGIN 
	 *           Valida que los datos de ingreso no sean nulos
	 **********************************************/
	@GetMapping(value = {"/", "/login"})
	public String login(Model model)  {
     String vistaRetorno = null;
     
     
	 model.addAttribute("ejemploMsg", "Adri");
     vistaRetorno ="view_login/login";
		
		return vistaRetorno;
	
	}

	
}
