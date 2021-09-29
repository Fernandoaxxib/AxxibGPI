package mx.axxib.gpi.ctrll;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	

	/**********************************************
	 * DETALLE: LOGIN 
	 *           Valida que los datos de ingreso no sean nulos
	 **********************************************/
	@GetMapping(value = { "/home"})
	public String home(Model model)  {
     String vistaRetorno = null;
     vistaRetorno ="view_home/home";		
		return vistaRetorno;
	
	}

	
}
