package mx.axxib.gpi.ctrll;


import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Controller
public class ExcepcionController   {
	
	@Autowired
	private Environment env;	
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
    public String renderErrorPage(Model model, HttpServletRequest httpRequest) {
        
		 String retorno = null;
        String errorMsg = "";
       
        int httpErrorCode = getErrorCode(httpRequest);

       switch (httpErrorCode) {
            case 400: {
            	
                errorMsg = env.getProperty("mensaje.excepcion.erro");
                break;
            }
            case 401: {
                errorMsg = env.getProperty("mensaje.excepcion.error");
                break;
            }
            case 404: {
                errorMsg = env.getProperty("mensaje.excepcion.error");
                break;
            }
            case 500: {
                errorMsg = env.getProperty("mensaje.excepcion.error");
                break;
            }
        }
       model.addAttribute("errorMsg", errorMsg);
       retorno = "view_error/Error";
        
        return retorno;
    }
    
    private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest
          .getAttribute("javax.servlet.error.status_code");
    }
    

}
