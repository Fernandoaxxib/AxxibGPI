package mx.axxib.gpi.ctrll;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import mx.axxib.gpi.eml.CargaResponse;



@Controller
public class CargaReporte {
	private static final Logger LOGGER = LogManager.getLogger(CargaReporte.class);
	
	@Autowired
	private Environment env;
	
	@GetMapping(value = { "/carga", "/carga" })
	public String carga(Model model) {
		LOGGER.info("# CARGA REPORTE  - VISTA (CARGA REPORTE) ");
		return "view_carga/cargaReporte";
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("action") String action,
			Model model) {

		String msg = "";
		String error = "";
		if (!file.isEmpty()) {
			try {
			
				String nombre = file.getOriginalFilename();
				boolean valido = false;
				
				if (action.toUpperCase().contains("OPERACIONES")) {
					if(nombre.toUpperCase().equals("BP_OPERACIONES.XLSX")) {
						valido = true;
					} else {
						error = "EL ARCHIVO PARA OPERACIONES DEBE LLAMARSE: BP_OPERACIONES.XLSX";
					}
				} else if (action.toUpperCase().contains("INVERSIONES")) {
					if(nombre.toUpperCase().equals("BP_INVERSIONES.XLSX")) {
						valido = true;
					} else {
						error = "EL ARCHIVO PARA INVERSIONES DEBE LLAMARSE: BP_INVERSIONES.XLSX";
					}
				} else if (action.toUpperCase().contains("COMERCIAL")) {
					if(nombre.toUpperCase().equals("BP_COMERCIAL.XLSX")) {
						valido = true;
					} else {
						error = "EL ARCHIVO PARA COMERCIAL DEBE LLAMARSE: BP_COMERCIAL.XLSX";
					}
				} else if (action.toUpperCase().contains("ADMON")) {
					if(nombre.toUpperCase().equals("BP_ADMINISTRACION.XLSX")) {
						valido = true;
					} else {
						error = "EL ARCHIVO PARA ADMINISTRACIÓN DEBE LLAMARSE: BP_ADMINISTRACION.XLSX";
					}
				}
				
				if (valido) {
					//String url = "http://172.20.236.11:8081/axxibgpiapi/cargaReporteAvances/";
					User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
					String userName = user.getUsername();	
					byte[] bytes = file.getBytes();
				
					HttpHeaders headers = new HttpHeaders();

					//headers.add("Authorization", "Basic YXh4aWJDb25uR3BwaTpAeHgxYkMwbm5HcHAx");
					headers.add("Authorization", this.env.getProperty("header.autorizacion"));
					headers.setContentType(MediaType.APPLICATION_JSON);

					JSONObject carga = new JSONObject();
					carga.put("usResponsable", userName);
					carga.put("tipoReporte", nombre.toUpperCase().replace(".XLSX", ""));
					carga.put("documento", bytes);

					HttpEntity<String> request = new HttpEntity<String>(carga.toString(), headers);
					RestTemplate restTemplate = new RestTemplate();

					CargaResponse res = restTemplate.postForObject(this.env.getProperty("direccion.cargaReporte"), request, CargaResponse.class);
					if(res.getCodRespuesta().equals("1")) {
						msg = "ARCHIVO CARGADO CORRECTAMENTE";
						LOGGER.info("# CARGA REPORTE  - ARCHIVO CARGADO - OPERACION:{},  NOMBREARCHIVO:{}, URL:{}, MENSAJE:{}", action, nombre,  this.env.getProperty("direccion.cargaReporte"), msg);
					} else {
						error = res.getMensaje();
						LOGGER.error("# CARGA REPORTE  - ERROR OBTENIDO DEL SERVICIO REST  -  MENSAJE:{}", error);
					}
				} else {
					LOGGER.error("# CARGA REPORTE  - ERROR AL CARGAR EL ARCHIVO  -  MENSAJE:{}", error);
				}
				
			} catch (Exception e) {
				error = "SE PRODUJO UN ERROR INESPERADO";
				LOGGER.error("# ERROR EN CARGA REPORTE  - ERROR AL INVOCAR EL SERVICIO - URL:{}, MENSAJE:{}", this.env.getProperty("direccion.cargaReporte") , error);
			}
		} else {
			error = "DEBE SELECCIONAR UN ARCHIVO";
			LOGGER.error("# ERROR EN CARGA REPORTE  - URL:{}, MENSAJE:{}", this.env.getProperty("direccion.cargaReporte") , error);
		}

		model.addAttribute("mensaje", msg);
		model.addAttribute("error", error);
		return "view_carga/cargaReporte";

	}

}
