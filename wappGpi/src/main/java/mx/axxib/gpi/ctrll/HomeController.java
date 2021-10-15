package mx.axxib.gpi.ctrll;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	private static final Logger LOGGER = LogManager.getLogger(HomeController.class);

	/**********************************************
	 * DETALLE: VISTA HOME            
	 **********************************************/
	@GetMapping(value = { "/home"})
	public String home(Model model) throws Exception {
     String vistaRetorno = null;
     
     try {
    	 
     vistaRetorno ="view_home/home";
     
     LOGGER.info("# HOME  - VISTA (HOME) ");
     
     }catch (Exception e) {
 		LOGGER.error("# ERROR - LOGIN  - MENSAJE:{}", e.toString());
 		throw new Exception();

 	}
     
		return vistaRetorno;
	
	}

	
}
