package mx.axxib.gpi.ctrll;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import mx.axxib.gpi.config.ReporteConfig;
import mx.axxib.gpi.eml.CargaResponse;
import mx.axxib.gpi.eml.ReporteJson;

@Controller
public class CargaReporte {
	private static final Logger LOGGER = LogManager.getLogger(CargaReporte.class);

	@Autowired
	private Environment env;

	private static List<ReporteJson> reportes = null;

	@GetMapping(value = { "/carga", "/carga" })
	public String carga(Model model) {
		LOGGER.info("# CARGA REPORTE  - VISTA (CARGA REPORTE) ");
		try {
			reportes =  ReporteConfig.getReportes();
			model.addAttribute("tipos",reportes);
		} catch (Exception e) {
			LOGGER.error("# ERROR - NO SE PUDO OBTENER LOS TIPOS DE REPORTE - MENSAJE:{}", e.toString());
		}
		return "view_carga/cargaReporte";
	}

	//@PostMapping("/uploadFile")
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("tipos") String tipo, Model model) {

		String msg = "";
		String error = "";
		if (!file.isEmpty()) {
			try {
				String nombre = file.getOriginalFilename();
				boolean valido = false;

				if (!tipo.isEmpty() && !tipo.contains("hide")) {

					ReporteJson reporte = reportes.stream().filter(rep -> rep.getId().equals(tipo)).findAny()
							.orElse(null);
					if (reporte != null) {
						if (nombre.toUpperCase().equals(reporte.getArchivo())) {
							valido = true;
						} else {
							error = "EL ARCHIVO DEBE LLAMARSE: " + reporte.getArchivo();
						}
					} else {
						error = "SE PRODUJO UN ERROR INESPERADO";
						LOGGER.error("# CARGA REPORTE  - NO SE HA ENCONTRADO LA LISTA DE TIPOS DE REPORTES");
					}
				} else {
					error = "DEBE SELECCIONAR UNA OPCIÓN DE CARGA";
					LOGGER.error("# CARGA REPORTE  - NO SE HA SELECCIONADO UNA OPCIÓN");
				}

				if (valido) {

					User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
					String userName = user.getUsername();
					byte[] bytes = file.getBytes();

					HttpHeaders headers = new HttpHeaders();
					headers.add("Authorization", this.env.getProperty("header.autorizacion"));
					headers.setContentType(MediaType.APPLICATION_JSON);

					org.json.JSONObject carga = new org.json.JSONObject();
					carga.put("usResponsable", userName);
					carga.put("tipoReporte", nombre.toUpperCase().replace(".XLSX", ""));
					carga.put("documento", bytes);

					HttpEntity<String> request = new HttpEntity<String>(carga.toString(), headers);
					RestTemplate restTemplate = new RestTemplate();

					CargaResponse res = restTemplate.postForObject(this.env.getProperty("direccion.cargaReporte"),
							request, CargaResponse.class);
					if (res.getCodRespuesta().equals("1")) {
						msg = "ARCHIVO CARGADO CORRECTAMENTE";
						LOGGER.info(
								"# CARGA REPORTE  - ARCHIVO CARGADO - NOMBREARCHIVO:{}, URL:{}, MENSAJE:{}",
								nombre, this.env.getProperty("direccion.cargaReporte"), msg);
					} else {
						error = res.getMensaje();
						LOGGER.error("# CARGA REPORTE  - ERROR OBTENIDO DEL SERVICIO REST  -  MENSAJE:{}", error);
					}
				} else {
					LOGGER.error("# CARGA REPORTE  - ERROR AL CARGAR EL ARCHIVO  -  MENSAJE:{}", error);
				}
			} catch (Exception e) {
				error = "SE PRODUJO UN ERROR INESPERADO";
				LOGGER.error("# ERROR EN CARGA REPORTE  - ERROR AL INVOCAR EL SERVICIO - URL:{}, MENSAJE:{}",
						this.env.getProperty("direccion.cargaReporte"), error);
			}
		} else {
			error = "DEBE SELECCIONAR UN ARCHIVO";
			LOGGER.error("# ERROR EN CARGA REPORTE  - URL:{}, MENSAJE:{}",
					this.env.getProperty("direccion.cargaReporte"), error);
		}

		model.addAttribute("mensaje", msg);
		model.addAttribute("error", error);
		model.addAttribute("tipos" ,reportes);
		
		return "view_carga/cargaReporte";

	}

}
