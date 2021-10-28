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
import mx.axxib.gpi.config.ReporteConfig;
import mx.axxib.gpi.eml.AccionEstrategica;
import mx.axxib.gpi.eml.Iniciativa;
import mx.axxib.gpi.eml.Objetivo;
import mx.axxib.gpi.eml.Periodos;
import mx.axxib.gpi.eml.Portafolio;
import mx.axxib.gpi.eml.ReporteJson;
import mx.axxib.gpi.eml.ReporteResponse;

@Controller
public class TabuladorAvances {
	private static final Logger LOGGER = LogManager.getLogger(TabuladorAvances.class);

	@Autowired
	private Environment env;

	private static List<ReporteJson> listaReportes = null;

	@RequestMapping(value = "/tab", method = RequestMethod.GET)
	public String portafolioProyecto(Model model) {
		try {
			listaReportes = ReporteConfig.getReportes();
		} catch (Exception e) {
			LOGGER.error("# ERROR - NO SE PUDO OBTENER LOS TIPOS DE REPORTE - MENSAJE:{}", e.toString());
		}
		LOGGER.info("# TABULADOR - VISTA (TABULADOR)");
		model.addAttribute("listaReportes", listaReportes);
		return "view_tabulador/portafolioProyectos";
	}

	@RequestMapping(value = "/tab", method = RequestMethod.POST)
	public String carga2(@RequestParam String idPortafolio, Model model) {
		LOGGER.info("# TABULADOR - VISTA (TABULADOR) - IDPROCESO:{} ", idPortafolio);
		model.addAttribute("idPortafolio", idPortafolio);
		return "view_tabulador/tabuladorAvances";
	}

	@RequestMapping(value = "/tabulador", method = RequestMethod.POST)
	public String tabulador(@RequestParam String idPortafolio, Model model) {
		Portafolio portafol = new Portafolio();
		String mensaje = "";
		String nombrePortafolio = "BP_";

		ReporteResponse response = cargarDatos(nombrePortafolio.concat(idPortafolio));
		if (response.getReporte() != null) {
			List<Iniciativa> iniciativas = response.getReporte().getIniciativas();
			iniciativas = generaPeriodos(response.getReporte().getIniciativas());

			portafol.setIniciativas(actualizarRows(iniciativas));
			portafol.setColumnas(getColumnas(iniciativas));

			portafol.setIdPortafolio(idPortafolio);

		} else {
			mensaje = response.getMensaje();
		}

		model.addAttribute("msj", mensaje);
		model.addAttribute("idPortafolio", idPortafolio);
		model.addAttribute("portafol", portafol);

		LOGGER.info("# TABULADOR - VISTA (TABULADOR) - IDPORTAFOLIO:{}, PORTAFOLIO:{} ", idPortafolio, idPortafolio);

		return "view_tabulador/tabuladorAvances";
	}

	public List<String> getColumnas(List<Iniciativa> iniciativas) {
		List<String> columnas = new ArrayList<>();
		List<String> cadenaPeriodos = new ArrayList<>();
		List<Periodos> listaPeriodos = new ArrayList<>();

		if (iniciativas != null) {
			iniciativas.forEach(w -> {
				if (w.getObjetivos() != null) {
					w.getObjetivos().forEach(x -> {
						if (x.getAccionesEstrategicas() != null) {
							x.getAccionesEstrategicas().forEach(y -> {
								if (y.getProyectos() != null) {
									y.getProyectos().forEach(z -> {
										if (z.getPeriodos() != null) {
											z.getPeriodos().forEach(p -> {
												listaPeriodos.add(p);
											});
										}
									});
								}
							});
						}
					});
				}
			});
		}

		if (!listaPeriodos.isEmpty()) {
			List<Integer> anios = new ArrayList<>();

			listaPeriodos.forEach(n -> {
				anios.add(Integer.valueOf(n.getAnio()));
			});

			Integer anioInicial = Collections.min(anios);
			Integer anioFinal = Collections.max(anios);
			Integer trimestreInicial = 1;

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

			listaPeriodos.forEach(t -> {
				cadenaPeriodos.add(t.getPeriodo());
			});

			List<String> columnasFinales = new ArrayList<>();

			for (String cadena : columnas) {
				if (cadenaPeriodos.contains(cadena)) {
					columnasFinales.add(cadena);
				}
			}

			String periodoInicial = columnasFinales.get(0).toString();

			boolean bandera = true;

			while (bandera) {
				if (!columnas.get(0).equals(periodoInicial)) {
					columnas.remove(0);
				} else {
					bandera = false;
				}
			}
		}
		return columnas;
	}

	public List<Iniciativa> generaPeriodos(List<Iniciativa> iniciativas) {
		if (iniciativas != null) {
			iniciativas.forEach(p -> {
				if (p.getObjetivos() != null) {
					p.getObjetivos().forEach(w -> {
						if (w.getAccionesEstrategicas() != null) {
							w.getAccionesEstrategicas().forEach(x -> {
								if (x.getProyectos() != null) {
									x.getProyectos().forEach(y -> {
										if (y.getPeriodos() != null) {
											y.getPeriodos().forEach(z -> {
												switch (z.getMes()) {

												case "ENE":
												case "FEB":
												case "MAR": {
													z.setPeriodo("T1(" + z.getMes() + " " + z.getAnio() + ")");
													break;
												}
												case "ABR":
												case "MAY":
												case "JUN": {
													z.setPeriodo("T2(" + z.getMes() + " " + z.getAnio() + ")");
													break;
												}
												case "JUL":
												case "AGS":
												case "SEP": {
													z.setPeriodo("T3(" + z.getMes() + " " + z.getAnio() + ")");
													break;
												}
												case "OCT":
												case "NOV":
												case "DIC": {
													z.setPeriodo("T4(" + z.getMes() + " " + z.getAnio() + ")");
													break;
												}
												}
											});
										}
									});
								}
							});
						}
					});
				}
			});
		}
		return iniciativas;
	}

	public ReporteResponse cargarDatos(String nombrePortafolio) {
		ReporteResponse response = new ReporteResponse();

		try {
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userName = user.getUsername();

			JSONObject carga = new JSONObject();
			carga.put("usResponsable", userName);
			carga.put("tipoReporte", nombrePortafolio);

			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", this.env.getProperty("header.autorizacion"));
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> request = new HttpEntity<String>(carga.toString(), headers);

			RestTemplate restTemplate = new RestTemplate();

			response = restTemplate.postForObject(this.env.getProperty("direccion.recuperaPortafolio"), request,
					ReporteResponse.class);

			if (response.getCodRespuesta() == 1) {
				if (response.getReporte() != null) {
					LOGGER.info("# SERVICIO RECUPERA PORTAFOLIO - TIPOREPORTE, RESPUESTA:{}", nombrePortafolio,
							response.getReporte());
					return response;
				}
			} else {
				response.setMensaje("ERROR OBTENIDO DEL SERVICIO REST - " + response.getMensaje());
				LOGGER.info("# SERVICIO RECUPERA PORTAFOLIO - TIPOREPORTE, RESPUESTA:{}", nombrePortafolio, response);
				return response;
			}
		} catch (final HttpClientErrorException httpClientErrorException) {
			response.setMensaje("SE PRODUJO UN ERROR INESPERADO");
			LOGGER.error("# ERROR EN SERVICIO RECUPERA PORTAFOLIO - MENSAJE:{}", httpClientErrorException.getMessage());
		} catch (HttpServerErrorException httpServerErrorException) {
			response.setMensaje("SE PRODUJO UN ERROR INESPERADO");
			LOGGER.error("# ERROR EN SERVICIO RECUPERA PORTAFOLIO - MENSAJE:{}", httpServerErrorException.getMessage());
		} catch (Exception exception) {
			response.setMensaje("SE PRODUJO UN ERROR INESPERADO");
			LOGGER.error("# ERROR EN SERVICIO RECUPERA PORTAFOLIO - MENSAJE:{}", exception.getMessage());
		}
		return response;
	}

	public List<Iniciativa> actualizarRows(List<Iniciativa> iniciativas) {
		iniciativas.forEach(v -> {
			v.getObjetivos().forEach(w -> {
				if (w.getAccionesEstrategicas().size() > 0) {
					w.getAccionesEstrategicas().forEach(x -> {
						if (x.getRS_ACCION() > 0) {
							x.setRS_ACCION(x.getRS_ACCION() + 1);
						}
					});
				}
			});
		});
		int rowIniciativa = 0;
		for (Iniciativa iniciativa : iniciativas) {
			int rowObjetivo = 0;
			for (Objetivo objetivo : iniciativa.getObjetivos()) {

				for (AccionEstrategica accion : objetivo.getAccionesEstrategicas()) {
					rowObjetivo += accion.getRS_ACCION();
				}
				objetivo.setRS_OBJETIVO(rowObjetivo + 1);
				rowObjetivo = 0;
				rowIniciativa += objetivo.getRS_OBJETIVO();
			}
			iniciativa.setRS_INICIATIVA(rowIniciativa + 1);
			rowIniciativa = 0;
		}
		return iniciativas;
	}

}
