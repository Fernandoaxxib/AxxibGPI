package mx.axxib.gpi.ctrll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import mx.axxib.gpi.eml.Periodos;
import mx.axxib.gpi.eml.Portafolio;
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
		String nombrePortafolio;

		if (portafolio.equals("BP ADMINISTRACIÓN Y FINANZAS")) {
			nombrePortafolio = "BP_ADMINISTRACION";
		} else {
			nombrePortafolio = portafolio.replace(" ", "_");
		}

		List<Reporte> listaReportes = cargarDatos(nombrePortafolio);

		if (listaReportes != null) {
			portafol.setListaReportes(generaPeriodos(listaReportes));
			portafol.setColumnas(getColumnas(listaReportes));
			portafol.setIdPortafolio(idPortafolio);
			portafol.setNombrePortafolio(portafolio);
			
		}
		model.addAttribute("portafolio", portafolio);
		model.addAttribute("portafol", portafol);

		LOGGER.info("# TABULADOR - VISTA (TABULADOR) - IDPORTAFOLIO:{}, PORTAFOLIO:{} ", idPortafolio, portafolio);

		return "view_tabulador/tabuladorAvances";
	}

	public List<Reporte> cargarDatos(String tipoReporte) {
		try {
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userName = user.getUsername();

			JSONObject carga = new JSONObject();
			carga.put("usResponsable", userName);
			carga.put("tipoReporte", tipoReporte);

			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", this.env.getProperty("header.autorizacion"));
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> request = new HttpEntity<String>(carga.toString(), headers);

			RestTemplate restTemplate = new RestTemplate();

			ReporteResponse response = restTemplate.postForObject(this.env.getProperty("direccion.recuperaPortafolio"),
					request, ReporteResponse.class);

			if (response.getCodRespuesta() == 1) {
				if (response.getReporte() != null) {
					LOGGER.info("# SERVICIO RECUPERA PORTAFOLIO - TIPOREPORTE, RESPUESTA:{}", tipoReporte,
							response.getReporte());
					return response.getReporte();
				}
			} else {
				LOGGER.info("# SERVICIO RECUPERA PORTAFOLIO - TIPOREPORTE, RESPUESTA:{}", tipoReporte,
						response.getReporte());
				return null;
			}
		} catch (final HttpClientErrorException httpClientErrorException) {
			LOGGER.error("# ERROR EN SERVICIO RECUPERA PORTAFOLIO - MENSAJE:{}",
					httpClientErrorException.getMessage() + " - " + httpClientErrorException.getResponseBodyAsString()
							+ " - " + httpClientErrorException.getMostSpecificCause() + " - "
							+ httpClientErrorException.getRootCause() + " - "
							+ httpClientErrorException.getStackTrace().toString());
		} catch (HttpServerErrorException httpServerErrorException) {
			LOGGER.error("# ERROR EN SERVICIO RECUPERA PORTAFOLIO - MENSAJE:{}", httpServerErrorException);
		} catch (Exception exception) {
			LOGGER.error("# ERROR EN SERVICIO RECUPERA PORTAFOLIO - MENSAJE:{}", exception);
		}
		return null;
	}

	public List<String> getColumnas(List<Reporte> listaReportes) {
		List<String> columnas = new ArrayList<>();
        List<String> cadenaPeriodos= new ArrayList<>();        
		List<Periodos> listaPeriodos = new ArrayList<>();
		
		listaReportes.forEach(p -> {
			p.getPeriodos().forEach(x -> {
				listaPeriodos.add(x);
			});
		});

		List<Integer> anios = new ArrayList<>();

		listaPeriodos.forEach(n -> {
			anios.add(Integer.valueOf(n.getAnio()));
		});

		Integer anioInicial = Collections.min(anios);
		Integer anioFinal = Collections.max(anios);
		Integer trimestreInicial = 4;

		for (Periodos p : listaPeriodos) {
			if (Integer.valueOf(p.getAnio()) == anioInicial) {
				if (Integer.valueOf(p.getTrimestre()) < trimestreInicial) {
					trimestreInicial = Integer.valueOf(p.getTrimestre());
				}
			}
		}
 
        //se pone trimestreInicial = 1 porque el Json no está regresando el correctamente el trimestre de cada periodo
		trimestreInicial=1;
		while (anioInicial <= anioFinal) {
			if (trimestreInicial <= 4) {
				switch (trimestreInicial) {
				case 1: {
					String columna = "T" + trimestreInicial + "(ENE " + anioInicial + ")";
					String columna2 = "T" + trimestreInicial + "(FEB " + anioInicial + ")";
					String columna3 = "T" + trimestreInicial + "(MAR " + anioInicial + ")";
					columnas.add(columna);
					columnas.add(columna2);
					columnas.add(columna3);
					break;
				}
				case 2: {
					String columna = "T" + trimestreInicial + "(ABR " + anioInicial + ")";
					String columna2 = "T" + trimestreInicial + "(MAY " + anioInicial + ")";
					String columna3 = "T" + trimestreInicial + "(JUN " + anioInicial + ")";
					columnas.add(columna);
					columnas.add(columna2);
					columnas.add(columna3);
					break;
				}
				case 3: {
					String columna = "T" + trimestreInicial + "(JUL " + anioInicial + ")";
					String columna2 = "T" + trimestreInicial + "(AGS " + anioInicial + ")";
					String columna3 = "T" + trimestreInicial + "(SEP " + anioInicial + ")";
					columnas.add(columna);
					columnas.add(columna2);
					columnas.add(columna3);
					break;
				}
				case 4: {
					String columna = "T" + trimestreInicial + "(OCT " + anioInicial + ")";
					String columna2 = "T" + trimestreInicial + "(NOV " + anioInicial + ")";
					String columna3 = "T" + trimestreInicial + "(DIC " + anioInicial + ")";
					columnas.add(columna);
					columnas.add(columna2);
					columnas.add(columna3);
					break;
				}
				}
				trimestreInicial++;
			} else {
				anioInicial++;
				trimestreInicial = 1;
			}
		}		
		
		listaPeriodos.forEach(t->{
			cadenaPeriodos.add(t.getPeriodo());
		});
				
		
		List<String> columnasFinales= new ArrayList<>();
		
		for (String cadena : columnas) {
			if(cadenaPeriodos.contains(cadena)) {
		    	   columnasFinales.add(cadena);
		       }
		}
		
		
		return columnasFinales;
	}

	public List<Reporte> generaPeriodos(List<Reporte> reportes) {
		reportes.forEach(p -> {
			if (p.getPeriodos() != null) {
				p.getPeriodos().forEach(x -> {
					switch (x.getMes()) {

					case "ENE":
					case "FEB":
					case "MAR": {
						x.setPeriodo("T1(" + x.getMes() + " " + x.getAnio() + ")");
						break;
					}
					case "ABR":
					case "MAY":
					case "JUN":{
						x.setPeriodo("T2(" + x.getMes() + " " + x.getAnio() + ")");
						break;
					}
					case "JUL":
					case "AGS":
					case "SEP":{
						x.setPeriodo("T3(" + x.getMes() + " " + x.getAnio() + ")");
						break;
					}
					case "OCT":
					case "NOV":
					case "DIC":{
						x.setPeriodo("T4(" + x.getMes() + " " + x.getAnio() + ")");
						break;
					}
					}
				});
			}
		});
		return reportes;
	}
}
