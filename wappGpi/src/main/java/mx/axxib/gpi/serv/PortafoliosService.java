package mx.axxib.gpi.serv;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import mx.axxib.gpi.eml.AccionesRequest;
import mx.axxib.gpi.eml.AccionesResponse;
import mx.axxib.gpi.eml.AltaPortafolioRequest;
import mx.axxib.gpi.eml.AltaPortafolioResponse;
import mx.axxib.gpi.eml.AltaProyectoRequest;
import mx.axxib.gpi.eml.AltaProyectoResponse;
import mx.axxib.gpi.eml.BPRequest;
import mx.axxib.gpi.eml.BPResponse;
import mx.axxib.gpi.eml.CentroCostosRequest;
import mx.axxib.gpi.eml.CentroCostosResponse;
import mx.axxib.gpi.eml.CircuitosRequest;
import mx.axxib.gpi.eml.CircuitosResponse;
import mx.axxib.gpi.eml.ConsultaAccionesResponse;
import mx.axxib.gpi.eml.ConsultaBPResponse;
import mx.axxib.gpi.eml.ConsultaCentroCostosResponse;
import mx.axxib.gpi.eml.ConsultaCircuitosResponse;
import mx.axxib.gpi.eml.ConsultaEstatusResponse;
import mx.axxib.gpi.eml.ConsultaIniciativasResponse;
import mx.axxib.gpi.eml.ConsultaMetasResponse;
import mx.axxib.gpi.eml.ConsultaObjetivosResponse;
import mx.axxib.gpi.eml.ConsultaPortafolioResponse;
import mx.axxib.gpi.eml.ConsultaPresupuestosResponse;
import mx.axxib.gpi.eml.ConsultaTipoGastoResponse;
import mx.axxib.gpi.eml.EstatusRequest;
import mx.axxib.gpi.eml.EstatusResponse;
import mx.axxib.gpi.eml.IniciativasRequest;
import mx.axxib.gpi.eml.IniciativasResponse;
import mx.axxib.gpi.eml.MetasRequest;
import mx.axxib.gpi.eml.MetasResponse;
import mx.axxib.gpi.eml.ObjetivosRequest;
import mx.axxib.gpi.eml.ObjetivosResponse;
import mx.axxib.gpi.eml.ObtieneSecuenciaResponse;
import mx.axxib.gpi.eml.PortafoliosRequest;
import mx.axxib.gpi.eml.PortafoliosResponse;
import mx.axxib.gpi.eml.PresupuestosRequest;
import mx.axxib.gpi.eml.PresupuestosResponse;
import mx.axxib.gpi.eml.ProyectosResponse;
import mx.axxib.gpi.eml.RegistroAvance;
import mx.axxib.gpi.eml.RegistroAvanceResponse;
import mx.axxib.gpi.eml.TipoGastoRequest;
import mx.axxib.gpi.eml.TipoGastoResponse;

@Service
public class PortafoliosService {

	private static final Logger LOGGER = LogManager.getLogger(PortafoliosService.class);

	@Autowired
	private Environment env;

	/**************************************************************************
	 * @author sygno.asoto
	 * @DETALLE: Metodo par dar de alta portafolios
	 * @param: OBJETO AltaPortafolioRequest *
	 * @return: String con el resultado.
	 * @Logica: Consume el servicio REST Metodo: insertaPortafolio.
	 **************************************************************************/
	public String altaPortafolio(AltaPortafolioRequest altaPortafolioRequest) {
		RestTemplate restTemplate = new RestTemplate();
		String idPortafolio = null;
		JSONObject insertaProyecto = new JSONObject();
		AltaPortafolioResponse altaPortafolioResponse = new AltaPortafolioResponse();

		try {

			JSONObject jsonObject = new JSONObject(altaPortafolioRequest);

			insertaProyecto.put("portafolio", jsonObject);
			insertaProyecto.put("token", "");

			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", this.env.getProperty("header.autorizacion"));
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> request = new HttpEntity<String>(insertaProyecto.toString(), headers);

			altaPortafolioResponse = restTemplate.postForObject(this.env.getProperty("REST.URL.ALTAPORTAFOLIO"),
					request, AltaPortafolioResponse.class);

			if (altaPortafolioResponse.getCodRespuesta().equals("200")) {
				idPortafolio = String.valueOf(altaPortafolioResponse.getLista().get(0).getId());
			}

			LOGGER.info("# ALTA PROYECTO -  MENSAJE:{}, CODIGO:{}, IDPORTAFOLIO:{}",
					altaPortafolioResponse.getMensaje(), altaPortafolioResponse.getCodRespuesta(), idPortafolio);

		} catch (final HttpClientErrorException httpClientErrorException) {
			LOGGER.error("# ERROR EN SERVICIO INSERTA PROYECTO - MENSAJE CLIENTE:{}",
					httpClientErrorException.getMessage());
		} catch (HttpServerErrorException httpServerErrorException) {
			LOGGER.error("# ERROR EN SERVICIO INSERTA PROYECTO - MENSAJE SERVER:{}",
					httpServerErrorException.getMessage());
		} catch (Exception exception) {
			LOGGER.error("# ERROR EN SERVICIO INSERTA PROYECTO - MENSAJE GENERAL:{}", exception.toString());
		}

		return idPortafolio;
	}

	/**************************************************************************
	 * @author sygno.asoto
	 * @DETALLE: Metodo par dar de alta proyectos
	 * @param: OBJETO AltaProyectoRequest
	 * @return: String con el resultado.
	 * @Logica: Consume el servicio REST Metodo: insertaProyecto.
	 **************************************************************************/
	public String altaProyecto(AltaProyectoRequest altaProyectoRequest) {
		RestTemplate restTemplate = new RestTemplate();
		JSONObject insertaProyecto = new JSONObject();
		AltaProyectoResponse altaProyectoResponse = new AltaProyectoResponse();

		try {

			JSONObject jsonObject = new JSONObject(altaProyectoRequest);

			insertaProyecto.put("proyecto", jsonObject);
			insertaProyecto.put("token", "");

			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", this.env.getProperty("header.autorizacion"));
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> request = new HttpEntity<String>(insertaProyecto.toString(), headers);

			altaProyectoResponse = restTemplate.postForObject(this.env.getProperty("REST.URL"), request,
					AltaProyectoResponse.class);

			LOGGER.info("# ALTA PROYECTO -  MENSAJE:{}, CODIGO:{}", altaProyectoResponse.getMensaje(),
					altaProyectoResponse.getCodRespuesta());

		} catch (final HttpClientErrorException httpClientErrorException) {
			LOGGER.error("# ERROR EN SERVICIO INSERTA PROYECTO - MENSAJE CLIENTE:{}",
					httpClientErrorException.getMessage());
		} catch (HttpServerErrorException httpServerErrorException) {
			LOGGER.error("# ERROR EN SERVICIO INSERTA PROYECTO - MENSAJE SERVER:{}",
					httpServerErrorException.getMessage());
		} catch (Exception exception) {
			LOGGER.error("# ERROR EN SERVICIO INSERTA PROYECTO - MENSAJE GENERAL:{}", exception.toString());
		}

		return altaProyectoResponse.getCodRespuesta();
	}

	/**************************************************************************
	 * @author sygno.asoto
	 * @DETALLE: Metodo para consultar los proyectos
	 * @param: OBJETO AltaProyectoRequest
	 * @return: String con el resultado.
	 * @Logica: Consume el servicio REST Metodo: consultaProyecto.
	 **************************************************************************/
	public List<ProyectosResponse> consultaProyectos() {

		AltaProyectoResponse altaProyectoResponse = new AltaProyectoResponse();
		List<ProyectosResponse> lProyectos = new ArrayList<ProyectosResponse>();
		RestTemplate restTemplate = new RestTemplate();
		JSONObject consulta = new JSONObject();

		try {

			consulta.put("tipoConsulta", 0);
			consulta.put("token", "");

			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", this.env.getProperty("header.autorizacion"));
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> request = new HttpEntity<String>(consulta.toString(), headers);

			altaProyectoResponse = restTemplate.postForObject(this.env.getProperty("REST.URL.CONSULTAPROYECTO"),
					request, AltaProyectoResponse.class);

			lProyectos = altaProyectoResponse.getLista();

			LOGGER.info("RESULTADO CONSULTA PROYECTOS: MENSAJE:{}, CODIGO:{}", altaProyectoResponse.getMensaje(),
					altaProyectoResponse.getCodRespuesta());

		} catch (final HttpClientErrorException httpClientErrorException) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA PROYECTO - MENSAJE CLIENTE:{}",
					httpClientErrorException.getMessage());
		} catch (HttpServerErrorException httpServerErrorException) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA PROYECTO - MENSAJE SERVER:{}",
					httpServerErrorException.getMessage());
		} catch (Exception exception) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA PROYECTO - MENSAJE GENERAL:{}", exception.toString());
		}

		return lProyectos;
	}

	/**************************************************************************
	 * @author sygno.asoto
	 * @DETALLE: Metodo para consultar los proyectos
	 * @param: OBJETO AltaProyectoRequest
	 * @return: String con el resultado.
	 * @Logica: Consume el servicio REST Metodo: consultaCatalogo.
	 **************************************************************************/
	public List<EstatusResponse> consultaEstatus() {

		ConsultaEstatusResponse consultaEstatusResponse = new ConsultaEstatusResponse();
		List<EstatusResponse> lestatus = new ArrayList<EstatusResponse>();
		RestTemplate restTemplate = new RestTemplate();
		JSONObject consultaEstatus = new JSONObject();

		try {

			consultaEstatus.put("tabla", "TC_ESTATUS");
			consultaEstatus.put("tipoConsulta", 0);
			consultaEstatus.put("token", "");

			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", this.env.getProperty("header.autorizacion"));
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> request = new HttpEntity<String>(consultaEstatus.toString(), headers);

			consultaEstatusResponse = restTemplate.postForObject(this.env.getProperty("REST.URL.CONSULTACATALOGOS"),
					request, ConsultaEstatusResponse.class);

			lestatus = consultaEstatusResponse.getLista();

			LOGGER.info("RESULTADO CONSULTA ESTATUS: MENSAJE:{}, CODIGO:{}", consultaEstatusResponse.getMensaje(),
					consultaEstatusResponse.getCodRespuesta());

		} catch (final HttpClientErrorException httpClientErrorException) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA ESTATUS - MENSAJE CLIENTE:{}",
					httpClientErrorException.getMessage());
		} catch (HttpServerErrorException httpServerErrorException) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA ESTATUS - MENSAJE SERVER:{}",
					httpServerErrorException.getMessage());
		} catch (Exception exception) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA ESTATUS - MENSAJE GENERAL:{}", exception.toString());
		}

		return lestatus;
	}

	/**************************************************************************
	 * @author sygno.asoto
	 * @DETALLE: Metodo para consultar los portafolios
	 * @param: OBJETO AltaProyectoRequest
	 * @return: String con el resultado.
	 * @Logica: Consume el servicio REST Metodo: consultaCatalogo.
	 **************************************************************************/
	public List<PortafoliosResponse> consultaPortafolios() {

		ConsultaPortafolioResponse consultaPortafoliosResponse = new ConsultaPortafolioResponse();
		List<PortafoliosResponse> lportafolios = new ArrayList<PortafoliosResponse>();
		RestTemplate restTemplate = new RestTemplate();
		JSONObject catalogo = new JSONObject();

		try {

			catalogo.put("tipoConsulta", 0);
			catalogo.put("token", "");

			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", this.env.getProperty("header.autorizacion"));
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> request = new HttpEntity<String>(catalogo.toString(), headers);

			consultaPortafoliosResponse = restTemplate.postForObject(
					this.env.getProperty("REST.URL.CONSULTAPORTAFOLIO"), request, ConsultaPortafolioResponse.class);

			lportafolios = consultaPortafoliosResponse.getLista();

			LOGGER.info("RESULTADO CONSULTA PORTAFOLIOS: MENSAJE:{}, CODIGO:{}",
					consultaPortafoliosResponse.getMensaje(), consultaPortafoliosResponse.getCodRespuesta());

		} catch (final HttpClientErrorException httpClientErrorException) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA PORTAFOLIOS - MENSAJE CLIENTE:{}",
					httpClientErrorException.getMessage());
		} catch (HttpServerErrorException httpServerErrorException) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA PORTAFOLIOS - MENSAJE SERVER:{}",
					httpServerErrorException.getMessage());
		} catch (Exception exception) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA PORTAFOLIOS - MENSAJE GENERAL:{}", exception.toString());
		}

		return lportafolios;
	}

	/**************************************************************************
	 * @author sygno.asoto
	 * @DETALLE: Metodo para consultar los circuitos
	 * @param: OBJETO AltaProyectoRequest
	 * @return: String con el resultado.
	 * @Logica: Consume el servicio REST Metodo: consultaCatalogo.
	 **************************************************************************/
	public List<CircuitosResponse> consultaCircuitos() {

		ConsultaCircuitosResponse consultaCircuitosResponse = new ConsultaCircuitosResponse();
		List<CircuitosResponse> lcircuitos = new ArrayList<CircuitosResponse>();
		RestTemplate restTemplate = new RestTemplate();
		JSONObject catalogo = new JSONObject();

		try {

			catalogo.put("tabla", "TC_CIRCUITOS");
			catalogo.put("tipoConsulta", 0);
			catalogo.put("token", "");

			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", this.env.getProperty("header.autorizacion"));
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> request = new HttpEntity<String>(catalogo.toString(), headers);

			consultaCircuitosResponse = restTemplate.postForObject(this.env.getProperty("REST.URL.CONSULTACATALOGOS"),
					request, ConsultaCircuitosResponse.class);

			lcircuitos = consultaCircuitosResponse.getLista();

			LOGGER.info("RESULTADO CONSULTA CIRCUITOS: MENSAJE:{}, CODIGO:{}", consultaCircuitosResponse.getMensaje(),
					consultaCircuitosResponse.getCodRespuesta());

		} catch (final HttpClientErrorException httpClientErrorException) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA CIRCUITOS - MENSAJE CLIENTE:{}",
					httpClientErrorException.getMessage());
		} catch (HttpServerErrorException httpServerErrorException) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA CIRCUITOS - MENSAJE SERVER:{}",
					httpServerErrorException.getMessage());
		} catch (Exception exception) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA CIRCUITOS - MENSAJE GENERAL:{}", exception.toString());
		}

		return lcircuitos;
	}

	/**************************************************************************
	 * @author sygno.asoto
	 * @DETALLE: Metodo para consultar inicitivas
	 * @param: OBJETO AltaProyectoRequest
	 * @return: String con el resultado.
	 * @Logica: Consume el servicio REST Metodo: consultaCatalogo.
	 **************************************************************************/
	public List<IniciativasResponse> consultaIniciativas() {

		ConsultaIniciativasResponse consultaInciativasResponse = new ConsultaIniciativasResponse();
		List<IniciativasResponse> liniciativas = new ArrayList<IniciativasResponse>();
		RestTemplate restTemplate = new RestTemplate();
		JSONObject catalogo = new JSONObject();

		try {

			catalogo.put("tabla", "TC_INICIATIVAS");
			catalogo.put("tipoConsulta", 0);
			catalogo.put("token", "");

			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", this.env.getProperty("header.autorizacion"));
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> request = new HttpEntity<String>(catalogo.toString(), headers);

			consultaInciativasResponse = restTemplate.postForObject(this.env.getProperty("REST.URL.CONSULTACATALOGOS"),
					request, ConsultaIniciativasResponse.class);

			liniciativas = consultaInciativasResponse.getLista();

			LOGGER.info("RESULTADO CONSULTA INICIATIVAS: MENSAJE:{}, CODIGO:{}",
					consultaInciativasResponse.getMensaje(), consultaInciativasResponse.getCodRespuesta());

		} catch (final HttpClientErrorException httpClientErrorException) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA INICIATIVAS - MENSAJE CLIENTE:{}",
					httpClientErrorException.getMessage());
		} catch (HttpServerErrorException httpServerErrorException) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA INICIATIVAS - MENSAJE SERVER:{}",
					httpServerErrorException.getMessage());
		} catch (Exception exception) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA INICIATIVAS - MENSAJE GENERAL:{}", exception.toString());
		}

		return liniciativas;
	}

	/**************************************************************************
	 * @author sygno.asoto
	 * @DETALLE: Metodo para consultar los objetivos
	 * @param: OBJETO AltaProyectoRequest
	 * @return: String con el resultado.
	 * @Logica: Consume el servicio REST Metodo: consultaCatalogo.
	 **************************************************************************/
	public List<ObjetivosResponse> consultaObjetivos() {

		ConsultaObjetivosResponse consultaObjetivosResponse = new ConsultaObjetivosResponse();
		List<ObjetivosResponse> lobjetivos = new ArrayList<ObjetivosResponse>();
		RestTemplate restTemplate = new RestTemplate();
		JSONObject catalogo = new JSONObject();

		try {

			catalogo.put("tabla", "TC_OBJETIVOS");
			catalogo.put("tipoConsulta", 0);
			catalogo.put("token", "");

			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", this.env.getProperty("header.autorizacion"));
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> request = new HttpEntity<String>(catalogo.toString(), headers);

			consultaObjetivosResponse = restTemplate.postForObject(this.env.getProperty("REST.URL.CONSULTACATALOGOS"),
					request, ConsultaObjetivosResponse.class);

			lobjetivos = consultaObjetivosResponse.getLista();

			LOGGER.info("RESULTADO CONSULTA OBJETIVOS: MENSAJE:{}, CODIGO:{}", consultaObjetivosResponse.getMensaje(),
					consultaObjetivosResponse.getCodRespuesta());

		} catch (final HttpClientErrorException httpClientErrorException) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA OBJETIVOS - MENSAJE CLIENTE:{}",
					httpClientErrorException.getMessage());
		} catch (HttpServerErrorException httpServerErrorException) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA OBJETIVOS - MENSAJE SERVER:{}",
					httpServerErrorException.getMessage());
		} catch (Exception exception) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA OBJETIVOS - MENSAJE GENERAL:{}", exception.toString());
		}

		return lobjetivos;
	}

	/**************************************************************************
	 * @author sygno.asoto
	 * @DETALLE: Metodo para consultar acciones
	 * @param: OBJETO AltaProyectoRequest
	 * @return: String con el resultado.
	 * @Logica: Consume el servicio REST Metodo: consultaCatalogo.
	 **************************************************************************/
	public List<AccionesResponse> consultaAcciones() {

		ConsultaAccionesResponse consultaAccionesResponse = new ConsultaAccionesResponse();
		List<AccionesResponse> lacciones = new ArrayList<AccionesResponse>();
		RestTemplate restTemplate = new RestTemplate();
		JSONObject catalogo = new JSONObject();

		try {

			catalogo.put("tabla", "TC_ACCIONES");
			catalogo.put("tipoConsulta", 0);
			catalogo.put("token", "");

			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", this.env.getProperty("header.autorizacion"));
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> request = new HttpEntity<String>(catalogo.toString(), headers);

			consultaAccionesResponse = restTemplate.postForObject(this.env.getProperty("REST.URL.CONSULTACATALOGOS"),
					request, ConsultaAccionesResponse.class);

			lacciones = consultaAccionesResponse.getLista();

			LOGGER.info("RESULTADO CONSULTA ACCIONES: MENSAJE:{}, CODIGO:{}", consultaAccionesResponse.getMensaje(),
					consultaAccionesResponse.getCodRespuesta());

		} catch (final HttpClientErrorException httpClientErrorException) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA ACCIONES - MENSAJE CLIENTE:{}",
					httpClientErrorException.getMessage());
		} catch (HttpServerErrorException httpServerErrorException) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA ACCIONES - MENSAJE SERVER:{}",
					httpServerErrorException.getMessage());
		} catch (Exception exception) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA ACCIONES - MENSAJE GENERAL:{}", exception.toString());
		}

		return lacciones;
	}

	/**************************************************************************
	 * @author sygno.asoto
	 * @DETALLE: Metodo para consultar metas
	 * @param: OBJETO AltaProyectoRequest
	 * @return: String con el resultado.
	 * @Logica: Consume el servicio REST Metodo: consultaCatalogo.
	 **************************************************************************/
	public List<MetasResponse> consultaMetas() {

		ConsultaMetasResponse consultaMetasResponse = new ConsultaMetasResponse();
		List<MetasResponse> lmetas = new ArrayList<MetasResponse>();
		RestTemplate restTemplate = new RestTemplate();
		JSONObject catalogo = new JSONObject();

		try {

			catalogo.put("tabla", "TC_METAS");
			catalogo.put("tipoConsulta", 0);
			catalogo.put("token", "");

			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", this.env.getProperty("header.autorizacion"));
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> request = new HttpEntity<String>(catalogo.toString(), headers);

			consultaMetasResponse = restTemplate.postForObject(this.env.getProperty("REST.URL.CONSULTACATALOGOS"),
					request, ConsultaMetasResponse.class);

			lmetas = consultaMetasResponse.getLista();

			LOGGER.info("RESULTADO CONSULTA METAS: MENSAJE:{}, CODIGO:{}", consultaMetasResponse.getMensaje(),
					consultaMetasResponse.getCodRespuesta());

		} catch (final HttpClientErrorException httpClientErrorException) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA METAS - MENSAJE CLIENTE:{}",
					httpClientErrorException.getMessage());
		} catch (HttpServerErrorException httpServerErrorException) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA METAS - MENSAJE SERVER:{}",
					httpServerErrorException.getMessage());
		} catch (Exception exception) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA METAS - MENSAJE GENERAL:{}", exception.toString());
		}

		return lmetas;
	}

	/**************************************************************************
	 * @author sygno.asoto
	 * @DETALLE: Metodo para consultar costos
	 * @param: OBJETO AltaProyectoRequest
	 * @return: String con el resultado.
	 * @Logica: Consume el servicio REST Metodo: consultaCatalogo.
	 **************************************************************************/
	public List<CentroCostosResponse> consultaCostos() {

		ConsultaCentroCostosResponse consultaCentroCostosResponse = new ConsultaCentroCostosResponse();
		List<CentroCostosResponse> lcostos = new ArrayList<CentroCostosResponse>();
		RestTemplate restTemplate = new RestTemplate();
		JSONObject catalogo = new JSONObject();

		try {

			catalogo.put("tabla", "TC_CENTRO_COSTOS");
			catalogo.put("tipoConsulta", 0);
			catalogo.put("token", "");

			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", this.env.getProperty("header.autorizacion"));
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> request = new HttpEntity<String>(catalogo.toString(), headers);

			consultaCentroCostosResponse = restTemplate.postForObject(
					this.env.getProperty("REST.URL.CONSULTACATALOGOS"), request, ConsultaCentroCostosResponse.class);

			lcostos = consultaCentroCostosResponse.getLista();

			LOGGER.info("RESULTADO CONSULTA COSTOS: MENSAJE:{}, CODIGO:{}", consultaCentroCostosResponse.getMensaje(),
					consultaCentroCostosResponse.getCodRespuesta());

		} catch (final HttpClientErrorException httpClientErrorException) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA COSTOS - MENSAJE CLIENTE:{}",
					httpClientErrorException.getMessage());
		} catch (HttpServerErrorException httpServerErrorException) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA COSTOS - MENSAJE SERVER:{}",
					httpServerErrorException.getMessage());
		} catch (Exception exception) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA COSTOS - MENSAJE GENERAL:{}", exception.toString());
		}

		return lcostos;
	}

	/**************************************************************************
	 * @author sygno.asoto
	 * @DETALLE: Metodo para consultar tipo gastos
	 * @param: OBJETO AltaProyectoRequest
	 * @return: String con el resultado.
	 * @Logica: Consume el servicio REST Metodo: consultaCatalogo.
	 **************************************************************************/
	public List<TipoGastoResponse> consultaTipoGasto() {

		ConsultaTipoGastoResponse consultaTipoGastoResponse = new ConsultaTipoGastoResponse();
		List<TipoGastoResponse> ltipoGastos = new ArrayList<TipoGastoResponse>();
		RestTemplate restTemplate = new RestTemplate();
		JSONObject catalogo = new JSONObject();

		try {

			catalogo.put("tabla", "TC_TIPO_GASTO");
			catalogo.put("tipoConsulta", 0);
			catalogo.put("token", "");

			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", this.env.getProperty("header.autorizacion"));
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> request = new HttpEntity<String>(catalogo.toString(), headers);

			consultaTipoGastoResponse = restTemplate.postForObject(this.env.getProperty("REST.URL.CONSULTACATALOGOS"),
					request, ConsultaTipoGastoResponse.class);

			ltipoGastos = consultaTipoGastoResponse.getLista();

			LOGGER.info("RESULTADO CONSULTA TIPO GASTOS : MENSAJE:{}, CODIGO:{}",
					consultaTipoGastoResponse.getMensaje(), consultaTipoGastoResponse.getCodRespuesta());

		} catch (final HttpClientErrorException httpClientErrorException) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA TIPO GASTOS - MENSAJE CLIENTE:{}",
					httpClientErrorException.getMessage());
		} catch (HttpServerErrorException httpServerErrorException) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA TIPO GASTOS - MENSAJE SERVER:{}",
					httpServerErrorException.getMessage());
		} catch (Exception exception) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA TIPO GASTOS - MENSAJE GENERAL:{}", exception.toString());
		}

		return ltipoGastos;
	}

	/**************************************************************************
	 * @author sygno.asoto
	 * @DETALLE: Metodo para consultar presupuesto
	 * @param: OBJETO AltaProyectoRequest
	 * @return: String con el resultado.
	 * @Logica: Consume el servicio REST Metodo: consultaCatalogo.
	 **************************************************************************/
	public List<PresupuestosResponse> consultaPresupuesto() {

		ConsultaPresupuestosResponse consultaPresupuestosResponse = new ConsultaPresupuestosResponse();
		List<PresupuestosResponse> lpresupuestos = new ArrayList<PresupuestosResponse>();
		RestTemplate restTemplate = new RestTemplate();
		JSONObject catalogo = new JSONObject();

		try {

			catalogo.put("tabla", "TC_PRESUPUESTOS");
			catalogo.put("tipoConsulta", 0);
			catalogo.put("token", "");

			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", this.env.getProperty("header.autorizacion"));
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> request = new HttpEntity<String>(catalogo.toString(), headers);

			consultaPresupuestosResponse = restTemplate.postForObject(
					this.env.getProperty("REST.URL.CONSULTACATALOGOS"), request, ConsultaPresupuestosResponse.class);

			lpresupuestos = consultaPresupuestosResponse.getLista();

			LOGGER.info("RESULTADO CONSULTA PRESUPUESTOS : MENSAJE:{}, CODIGO:{}",
					consultaPresupuestosResponse.getMensaje(), consultaPresupuestosResponse.getCodRespuesta());

		} catch (final HttpClientErrorException httpClientErrorException) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA PRESUPUESTOS - MENSAJE CLIENTE:{}",
					httpClientErrorException.getMessage());
		} catch (HttpServerErrorException httpServerErrorException) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA PRESUPUESTOS - MENSAJE SERVER:{}",
					httpServerErrorException.getMessage());
		} catch (Exception exception) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA PRESUPUESTOS - MENSAJE GENERAL:{}", exception.toString());
		}

		return lpresupuestos;
	}

	/**************************************************************************
	 * @author sygno.asoto
	 * @DETALLE: Metodo para consultar BP
	 * @param: OBJETO AltaProyectoRequest
	 * @return: String con el resultado.
	 * @Logica: Consume el servicio REST Metodo: consultaCatalogo.
	 **************************************************************************/
	public List<BPResponse> consultaBP() {

		ConsultaBPResponse consultaBPResponse = new ConsultaBPResponse();
		List<BPResponse> LBP = new ArrayList<BPResponse>();
		RestTemplate restTemplate = new RestTemplate();
		JSONObject catalogo = new JSONObject();

		try {

			catalogo.put("tabla", "TC_BP");
			catalogo.put("tipoConsulta", 0);
			catalogo.put("token", "");

			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", this.env.getProperty("header.autorizacion"));
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> request = new HttpEntity<String>(catalogo.toString(), headers);

			consultaBPResponse = restTemplate.postForObject(this.env.getProperty("REST.URL.CONSULTACATALOGOS"), request,
					ConsultaBPResponse.class);

			LBP = consultaBPResponse.getLista();

			LOGGER.info("RESULTADO CONSULTA BP : MENSAJE:{}, CODIGO:{}", consultaBPResponse.getMensaje(),
					consultaBPResponse.getCodRespuesta());

		} catch (final HttpClientErrorException httpClientErrorException) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA BP - MENSAJE CLIENTE:{}", httpClientErrorException.getMessage());
		} catch (HttpServerErrorException httpServerErrorException) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA BP - MENSAJE SERVER:{}", httpServerErrorException.getMessage());
		} catch (Exception exception) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA BP - MENSAJE GENERAL:{}", exception.toString());
		}

		return LBP;
	}

	/**************************************************************************
	 * @author sygno.asoto
	 * @DETALLE: Metodo para consultar id del Portafolio
	 * @param: OBJETO AltaProyectoRequest
	 * @return: String con el resultado.
	 * @Logica: Consume el servicio REST Metodo: consultaSeqPortafolio.
	 **************************************************************************/
	public String consultaIdPortafolio() {

		ObtieneSecuenciaResponse secuenciaResponse = new ObtieneSecuenciaResponse();
		RestTemplate restTemplate = new RestTemplate();
		JSONObject catalogo = new JSONObject();
		String idSecuencia = null;

		try {

			catalogo.put("token", "");

			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", this.env.getProperty("header.autorizacion"));
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> request = new HttpEntity<String>(catalogo.toString(), headers);

			secuenciaResponse = restTemplate.postForObject(this.env.getProperty("REST.URL.SECPORTAFOLIO"), request,
					ObtieneSecuenciaResponse.class);

			if (secuenciaResponse.getCodRespuesta().equals("200")) {
				idSecuencia = String.valueOf(secuenciaResponse.getId());
			} else {
				idSecuencia = "0";
			}

			LOGGER.info("RESULTADO CONSULTA SECUENCIA PORTAFOLIO : MENSAJE:{}, CODIGO:{}",
					secuenciaResponse.getMensaje(), secuenciaResponse.getCodRespuesta());

		} catch (final HttpClientErrorException httpClientErrorException) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA SECUENCIA PORTAFOLIO - MENSAJE CLIENTE:{}",
					httpClientErrorException.getMessage());
		} catch (HttpServerErrorException httpServerErrorException) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA SECUENCIA PORTAFOLIO - MENSAJE SERVER:{}",
					httpServerErrorException.getMessage());
		} catch (Exception exception) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA SECUENCIA PORTAFOLIO - MENSAJE GENERAL:{}",
					exception.toString());
		}

		return idSecuencia;
	}

	/**************************************************************************
	 * @author sygno.asoto
	 * @DETALLE: Metodo para consultar id del Proyecto
	 * @param: OBJETO AltaProyectoRequest
	 * @return: String con el resultado.
	 * @Logica: Consume el servicio REST Metodo: consultaSeqProyecto.
	 **************************************************************************/
	public String consultaIdProyecto() {

		ObtieneSecuenciaResponse secuenciaResponse = new ObtieneSecuenciaResponse();
		RestTemplate restTemplate = new RestTemplate();
		JSONObject catalogo = new JSONObject();
		String idSecuencia = null;

		try {

			catalogo.put("token", "");

			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", this.env.getProperty("header.autorizacion"));
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> request = new HttpEntity<String>(catalogo.toString(), headers);

			secuenciaResponse = restTemplate.postForObject(this.env.getProperty("REST.URL.SECPROYECTO"), request,
					ObtieneSecuenciaResponse.class);

			if (secuenciaResponse.getCodRespuesta().equals("200")) {
				idSecuencia = String.valueOf(secuenciaResponse.getId());
			} else {
				idSecuencia = "0";
			}

			LOGGER.info("RESULTADO CONSULTA SECUENCIA PROYECTO : MENSAJE:{}, CODIGO:{}", secuenciaResponse.getMensaje(),
					secuenciaResponse.getCodRespuesta());

		} catch (final HttpClientErrorException httpClientErrorException) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA SECUENCIA PROYECTO - MENSAJE CLIENTE:{}",
					httpClientErrorException.getMessage());
		} catch (HttpServerErrorException httpServerErrorException) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA SECUENCIA PROYECTO - MENSAJE SERVER:{}",
					httpServerErrorException.getMessage());
		} catch (Exception exception) {
			LOGGER.error("# ERROR EN SERVICIO CONSULTA SECUENCIA PROYECTO - MENSAJE GENERAL:{}", exception.toString());
		}

		return idSecuencia;
	}
	
	
	/**************************************************************************
	 * @author sygno.asoto
	 * @DETALLE: Metodo para dar de alta el registro de avance
	 * @param: OBJETO RegistroAvanceRequest
	 * @return: String con el resultado.
	 * @Logica: Consume el servicio REST Metodo: registraAvance.
	 **************************************************************************/
	public String registroAvance(RegistroAvance registroAvance) {

		RegistroAvanceResponse registroResponse = new RegistroAvanceResponse();
		RestTemplate restTemplate = new RestTemplate();
		JSONObject catalogo = new JSONObject();
		String idSecuencia = null;

		try {

			catalogo.put("token", "");
			catalogo.put("avance", registroAvance.getAvance());
			catalogo.put("idProyecto", registroAvance.getIdProyecto());
			catalogo.put("periodo", registroAvance.getPeriodo());
			catalogo.put("porcentaje", registroAvance.getPorcentaje());
			catalogo.put("indicador", registroAvance.getIndicador());

			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", this.env.getProperty("header.autorizacion"));
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> request = new HttpEntity<String>(catalogo.toString(), headers);

			registroResponse = restTemplate.postForObject(this.env.getProperty("REST.URL.REGISTRARAVANCE"), request,
					RegistroAvanceResponse.class);

			
			LOGGER.info("RESULTADO REGISTRO AVANCE : MENSAJE:{}, CODIGO:{}", registroResponse.getMensaje(),
					registroResponse.getCodRespuesta());

		} catch (final HttpClientErrorException httpClientErrorException) {
			LOGGER.error("# ERROR REGISTRO AVANCE - MENSAJE CLIENTE:{}",
					httpClientErrorException.getMessage());
		} catch (HttpServerErrorException httpServerErrorException) {
			LOGGER.error("# ERROR REGISTRO DE AVANCE - MENSAJE SERVER:{}",
					httpServerErrorException.getMessage());
		} catch (Exception exception) {
			LOGGER.error("# ERROR REGISTRO DE AVANCE - MENSAJE GENERAL:{}", exception.toString());
		}

		return registroResponse.getCodRespuesta();
	}
	
	/**************************************************************************
	 * @author sygno.asoto
	 * @DETALLE: Metodo para consultar  registro de avance
	 * @param: OBJETO RegistroAvanceRequest
	 * @return: String con el resultado.
	 * @Logica: Consume el servicio REST Metodo: registraAvance.
	 **************************************************************************/
	public List<RegistroAvance> consultaRegistroAvance() {

		RegistroAvanceResponse registroResponse = new RegistroAvanceResponse();
		 List<RegistroAvance>  lregistroAvance= new  ArrayList<RegistroAvance>();
		RestTemplate restTemplate = new RestTemplate();
		JSONObject catalogo = new JSONObject();
			

		try {

			catalogo.put("token", "");
			catalogo.put("tipoConsulta", "0");

			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", this.env.getProperty("header.autorizacion"));
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> request = new HttpEntity<String>(catalogo.toString(), headers);

			registroResponse = restTemplate.postForObject(this.env.getProperty("REST.URL.CONSULTAREGISTROAVANCE"), request,
					RegistroAvanceResponse.class);

			lregistroAvance = registroResponse.getLista();
			LOGGER.info("RESULTADO REGISTRO AVANCE : MENSAJE:{}, CODIGO:{}", registroResponse.getMensaje(),
					registroResponse.getCodRespuesta());

		} catch (final HttpClientErrorException httpClientErrorException) {
			LOGGER.error("# ERROR REGISTRO AVANCE - MENSAJE CLIENTE:{}",
					httpClientErrorException.getMessage());
		} catch (HttpServerErrorException httpServerErrorException) {
			LOGGER.error("# ERROR REGISTRO DE AVANCE - MENSAJE SERVER:{}",
					httpServerErrorException.getMessage());
		} catch (Exception exception) {
			LOGGER.error("# ERROR REGISTRO DE AVANCE - MENSAJE GENERAL:{}", exception.toString());
		}

		return lregistroAvance;
	}

}
