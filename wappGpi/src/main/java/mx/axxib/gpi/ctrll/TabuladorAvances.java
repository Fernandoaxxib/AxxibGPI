package mx.axxib.gpi.ctrll;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import mx.axxib.gpi.eml.Portafolio;
import mx.axxib.gpi.eml.Registro;
import mx.axxib.gpi.eml.Reporte;
import mx.axxib.gpi.eml.ReporteResponse;

@Controller
public class TabuladorAvances {
	private static final Logger LOGGER = LogManager.getLogger(TabuladorAvances.class);
	
	@Autowired
	private Environment env;

	@RequestMapping(value = "/tab", method = RequestMethod.POST)
	public String carga2(@RequestParam String idPortafolio, Model model) {
		String s = idPortafolio;
		String portafolio = null;

		switch (s) {
		case "1": {
			portafolio = "BP OPERACIONES";
			break;
		}
		case "2": {
			portafolio = "BP INVERSIONES";
			break;
		}
		case "3": {
			portafolio = "BP COMERCIAL";
			break;
		}
		case "4": {
			portafolio = "BP ADMINISTRACIÓN Y FINANZAS";
			break;
		}
		default: {
			portafolio = "";
			break;
		}
		}
		
		LOGGER.info("# TABULADOR - VISTA (TABULADOR) - IDPROCESO:{} ", portafolio);

		model.addAttribute("idPortafolio", idPortafolio);
		model.addAttribute("portafolio", portafolio);
		return "view_tabulador/tabuladorAvances";
	}

	@RequestMapping(value = "/tabulador", method = RequestMethod.POST)
	public String tabulador(@RequestParam String portafolio, @RequestParam String idPortafolio, Model model) {
		Portafolio portafol = new Portafolio();

		portafol.setColumnas(getColumnas());
		portafol.setIdPortafolio(idPortafolio);
		portafol.setNombrePortafolio(portafolio);
		portafol.setListaReportes(cargarDatos(portafolio));

		model.addAttribute("portafolio", portafolio);
		model.addAttribute("portafol", portafol);

		LOGGER.info("# TABULADOR - VISTA (TABULADOR) - IDPORTAFOLIO:{}, PORTAFOLIO:{} ", idPortafolio, portafolio);
		
		return "view_tabulador/tabuladorAvances";
	}

	public List<Reporte> cargarDatos(String tipoReporte) {

		try {
			//String url =  "http://172.20.236.11:8081/axxibgpiapi/recuperaPortafolio/";			
			//String url2=  "http://localhost:9000/axxibgpiapi/recuperaPortafolio/";
			
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userName = user.getUsername();
			
			 JSONObject carga = new JSONObject(); 
			 carga.put("usResponsable", userName);
			 carga.put("tipoReporte", "BP_OPERACIONES");
			 						
			HttpHeaders headers = new HttpHeaders();			
			//headers.add("Authorization", "Basic YXh4aWJDb25uR3BwaTpAeHgxYkMwbm5HcHAx");			
			headers.add("Authorization", this.env.getProperty("header.autorizacion"));			
			headers.setContentType(MediaType.APPLICATION_JSON);		

			HttpEntity<String> request = new HttpEntity<String>(carga.toString() , headers);
			
			RestTemplate restTemplate = new RestTemplate();						
	
			ReporteResponse response= restTemplate.postForObject(this.env.getProperty("direccion.recuperaPortafolio"), request, ReporteResponse.class);
			
		  //  ResponseEntity<ReporteResponse> response = restTemplate.exchange(url, HttpMethod.GET, request, ReporteResponse.class,carga.toString());
			
		//	ReporteResponse repo= response.getBody();
			
		//	System.out.println(repo.getMensaje()+""+repo.getCodRespuesta());			
			
			LOGGER.info("# SERVICIO RECUPERA PORTAFOLIO - TIPOREPORTE, RESPUESTA:{}", tipoReporte, response.getReporte());
			
			return response.getReporte();

		} catch (final HttpClientErrorException httpClientErrorException) {	
			
			LOGGER.error("# ERROR EN SERVICIO RECUPERA PORTAFOLIO - MENSAJE:{}",  httpClientErrorException.getMessage() + " - "
					+ httpClientErrorException.getResponseBodyAsString() + " - "
					+ httpClientErrorException.getMostSpecificCause() + " - " + httpClientErrorException.getRootCause()
					+ " - " + httpClientErrorException.getStackTrace().toString());
			
		} catch (HttpServerErrorException httpServerErrorException) {		
			
			LOGGER.error("# ERROR EN SERVICIO RECUPERA PORTAFOLIO - MENSAJE:{}", httpServerErrorException);
			
		} catch (Exception exception) {
			LOGGER.error("# ERROR EN SERVICIO RECUPERA PORTAFOLIO - MENSAJE:{}", exception);
		}
		return null;

	}

	public List<String> getColumnas() {
		List<String> columnas = new ArrayList<>();
		columnas.add("T3(JUL 2021)");
		columnas.add("T3(AGS 2021)");
		columnas.add("T3(SEP 2021)");
		columnas.add("T4(OCT 2021)");
		columnas.add("T4(NOV 2021)");
		columnas.add("T4(DIC 2021)");
		columnas.add("T1(ENE 2022)");
		columnas.add("T1(FEB 2022)");
		columnas.add("T1(MAR 2022)");
		return columnas;
	}
}
