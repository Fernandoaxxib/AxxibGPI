package mx.axxib.gpi.ctrll;


import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import mx.axxib.gpi.eml.AccionesRequest;
import mx.axxib.gpi.eml.AccionesResponse;
import mx.axxib.gpi.eml.AltaPortafolioRequest;
import mx.axxib.gpi.eml.AltaProyectoRequest;
import mx.axxib.gpi.eml.BPRequest;
import mx.axxib.gpi.eml.BPResponse;
import mx.axxib.gpi.eml.CentroCostosRequest;
import mx.axxib.gpi.eml.CentroCostosResponse;
import mx.axxib.gpi.eml.CircuitosRequest;
import mx.axxib.gpi.eml.CircuitosResponse;
import mx.axxib.gpi.eml.EstatusRequest;
import mx.axxib.gpi.eml.EstatusResponse;
import mx.axxib.gpi.eml.IniciativasRequest;
import mx.axxib.gpi.eml.IniciativasResponse;
import mx.axxib.gpi.eml.MetasRequest;
import mx.axxib.gpi.eml.MetasResponse;
import mx.axxib.gpi.eml.ObjetivosRequest;
import mx.axxib.gpi.eml.ObjetivosResponse;
import mx.axxib.gpi.eml.PortafoliosRequest;
import mx.axxib.gpi.eml.PortafoliosResponse;
import mx.axxib.gpi.eml.PresupuestosRequest;
import mx.axxib.gpi.eml.PresupuestosResponse;
import mx.axxib.gpi.eml.ProyectosResponse;
import mx.axxib.gpi.eml.RegistroAvance;
import mx.axxib.gpi.eml.TipoGastoRequest;
import mx.axxib.gpi.eml.TipoGastoResponse;
import mx.axxib.gpi.serv.PortafoliosService;
import mx.axxib.gpi.util.AltaPortafolioForm;
import mx.axxib.gpi.util.AltaProyectoForm;
import mx.axxib.gpi.util.UtileriaGeneral;

@Controller
public class PortafolioController {

	private static final Logger LOGGER = LogManager.getLogger(PortafolioController.class);

	@Autowired
	private PortafoliosService portafolio;

	/**************************************************************************	 
	 * DETALLE: VISTA GENERAL DE PORTAFOLIO
	 * PARA LLENAR LA VISTA: CONSULTA LOS PORTAFOLIOS  Y  PLANES EXISTENTES.
	 * REST METODOS USADOS: (consultaPortafolio, consultaProyecto);
	 **************************************************************************/
	
	@GetMapping(value = { "/portafolio" })
	public String portafolio(Model model) throws Exception {
		String vistaRetorno = null;
		List<ProyectosResponse> lProyectos = new ArrayList<ProyectosResponse>();
		List<PortafoliosResponse> lportafolios = new ArrayList<PortafoliosResponse>();

		try {

			lportafolios = portafolio.consultaPortafolios();
			lProyectos = portafolio.consultaProyectos();

			model.addAttribute("lportafolios", lportafolios);
			model.addAttribute("lplanes", lProyectos);

			vistaRetorno = "view_portafolio/portafolios";

			LOGGER.info("# PORTAFOLIO  - VISTA (ALTA PORTAFOLIO) ");

		} catch (Exception e) {
			LOGGER.error("# ERROR - LOGIN  - MENSAJE:{}", e.toString());
			throw new Exception();

		}

		return vistaRetorno;

	}

	/*********************************************************** 
	 * DETALLE: VISTA PORTAFOLIO (ALTA PORTAFOLIO)
	 * PARA LLENAR LA VISTA  CONSULTA LOS SIGUIENTES CATALOGOS:
	 *    - ESTATUS, CIRCUITOS, INICIATIVAS, OBJETIVOS, ACCIONES, 
	 *    - METAS CENTROCOSTOS, TIPOGASTO, PRESUPUESTO, BP
	 * REST METODO USADO: (consultaCatalogo);
	 ************************************************************/
	
	@RequestMapping(value = "/portafolios", method = RequestMethod.GET)
	public String altaPortafolios(Model model) throws Exception {
		
		List<EstatusResponse> lestatus = new ArrayList<EstatusResponse>();
		List<CircuitosResponse> lcircuitos = new ArrayList<CircuitosResponse>();
		List<IniciativasResponse> liniciativas = new ArrayList<IniciativasResponse>();
		List<ObjetivosResponse> lobjetivos = new ArrayList<ObjetivosResponse>();
		List<AccionesResponse> lacciones = new ArrayList<AccionesResponse>();
		List<MetasResponse> lmetas = new ArrayList<MetasResponse>();
		List<CentroCostosResponse> lcostos = new ArrayList<CentroCostosResponse>();
		List<TipoGastoResponse> ltipoGastos = new ArrayList<TipoGastoResponse>();
		List<PresupuestosResponse> lpresupuestos = new ArrayList<PresupuestosResponse>();
		List<BPResponse> LBP = new ArrayList<BPResponse>();
		String vistaRetorno = null;

		try {
			
			lestatus = portafolio.consultaEstatus();
			lcircuitos = portafolio.consultaCircuitos();
			liniciativas = portafolio.consultaIniciativas();
			lobjetivos = portafolio.consultaObjetivos();
			lacciones = portafolio.consultaAcciones();
			lmetas = portafolio.consultaMetas();
			lcostos = portafolio.consultaCostos();
			ltipoGastos = portafolio.consultaTipoGasto();
			lpresupuestos = portafolio.consultaPresupuesto();
			LBP = portafolio.consultaBP();
			
			
			model.addAttribute("clavePortafolio", UtileriaGeneral.generaClavePortafolio(portafolio.consultaIdPortafolio()));
			model.addAttribute("claveProyecto", UtileriaGeneral.generaClaveProyecto(portafolio.consultaIdProyecto()));
			
			model.addAttribute("LBP", LBP);
			model.addAttribute("lestatus", lestatus);
			model.addAttribute("lcircuitos", lcircuitos);
			model.addAttribute("liniciativas", liniciativas);
			model.addAttribute("lobjetivos", lobjetivos);
			model.addAttribute("lacciones", lacciones);
			model.addAttribute("lmetas", lmetas);
			model.addAttribute("lcostos", lcostos);
			model.addAttribute("ltipoGastos", ltipoGastos);
			model.addAttribute("lpresupuestos", lpresupuestos);

			vistaRetorno = "view_portafolio/altaPortafolio";
			LOGGER.info("# PORTAFOLIO  - VISTA (ALTA PORTAFOLIO) ");

		} catch (Exception e) {
			LOGGER.error("# ERROR - LOGIN  - MENSAJE:{}", e.toString());
			throw new Exception();

		}

		return vistaRetorno;

	}

	/******************************************************************* 
	 * DETALLE: CONTROLADOR QUE HACE LA INSERCION DE UN PORTAFOLIO.
	 * USA METODO AJAX UBICADO EN la carpeta: JS
	 *             con el nombre: altaPortafolio.js	              
	 * REST METODOS USADOS: (insertaPortafolio, insertaProyecto); 
	 ********************************************************************/
	@RequestMapping(value = "/altaPortafolio", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody AltaPortafolioForm altaPortafolio(@RequestBody AltaPortafolioForm altaForm, Model model)
			throws Exception {

		String respuestaAlta = null;
		String idPortafolio = null;
		String msg = null;
		AltaProyectoRequest altaProyectoRequest = new AltaProyectoRequest();
		AltaPortafolioRequest altaPortafolioRequest = new AltaPortafolioRequest();
		EstatusRequest estatusPortafolio = new EstatusRequest();

		BPRequest bp = new BPRequest();
		EstatusRequest estatus = new EstatusRequest();
		PortafoliosRequest portafolioReq = new PortafoliosRequest();
		CircuitosRequest circuito = new CircuitosRequest();
		IniciativasRequest iniciativa = new IniciativasRequest();
		ObjetivosRequest objetivo = new ObjetivosRequest();
		AccionesRequest accion = new AccionesRequest();
		MetasRequest meta = new MetasRequest();
		CentroCostosRequest costo = new CentroCostosRequest();
		TipoGastoRequest tipoGasto = new TipoGastoRequest();
		PresupuestosRequest presupuesto = new PresupuestosRequest();

		try {

			altaForm.validacionPortafolio();

			if (altaForm.isErrorAdicional()) {
				LOGGER.info("# ALTA PORTAFILIO - ERROR EN DATOS DE ENTRADA - ERROR:{}", altaForm.getMsg());
				altaForm.setMsg("Revisar los datos requeridos!");
				altaForm.setLerrorAdicional(UtileriaGeneral.generaLista(altaForm.getNomComponente()));

			} else {
				

					estatusPortafolio.setId(Integer.parseInt(altaForm.getEstatusPortafolio()));

					altaPortafolioRequest.setId(0);
					altaPortafolioRequest.setClavePortafolio(altaForm.getClavePortafolio());
					altaPortafolioRequest.setDescripcion(altaForm.getDescripcionPortafolio());
					altaPortafolioRequest.setClaveBP(altaForm.getClaveBPPortafolio());
					altaPortafolioRequest.setEstatus(estatusPortafolio);

					idPortafolio = portafolio.altaPortafolio(altaPortafolioRequest);
					
					LOGGER.info(" DATOS OBTENIDOS ALTA PORTAFOLIO - CLAVEPORTAFOLIO:{}, DESCRIPCIONPORTAFOLIO:{}, ESTATUSPORTAFOLIO:{}, BPPORTAFOLIO:{} - RESULTADO - IDPORTAFOLIO:{}",
							altaForm.getClavePortafolio(), altaForm.getDescripcionPortafolio(), altaForm.getEstatusPortafolio(),
							altaForm.getClaveBPPortafolio(), idPortafolio);

					if (idPortafolio != null) {
											

						bp.setId(Integer.parseInt(altaForm.getProyBP()));
						portafolioReq.setId(Integer.parseInt(idPortafolio));
						estatus.setId(Integer.parseInt(altaForm.getProyestatus()));
						circuito.setId(Integer.parseInt(altaForm.getProycircuito()));
						iniciativa.setId(Integer.parseInt(altaForm.getProyiniciativa()));
						objetivo.setId(Integer.parseInt(altaForm.getProyobjetivo()));
						accion.setId(Integer.parseInt(altaForm.getProyaccion()));
						meta.setId(Integer.parseInt(altaForm.getProymeta()));
						costo.setId(Integer.parseInt(altaForm.getProycostos()));
						tipoGasto.setId(Integer.parseInt(altaForm.getProygasto()));
						presupuesto.setId(Integer.parseInt(altaForm.getProypresupuesto()));

						altaProyectoRequest.setId(0);
						altaProyectoRequest.setDescripcion(altaForm.getProyDescripcion());
						altaProyectoRequest.setFechaRequerida(Integer.parseInt(altaForm.getProyfecha()));
						altaProyectoRequest.setFechaMaxTermino(Integer.parseInt(altaForm.getProyfechaMaxima()));
						altaProyectoRequest.setRecursos(altaForm.getProyRecursos());
						altaProyectoRequest.setCostoProyecto(Float.parseFloat(altaForm.getProycosto()));
						altaProyectoRequest.setBp(bp);
						altaProyectoRequest.setEstatus(estatus);
						altaProyectoRequest.setPortafolio(portafolioReq);
						altaProyectoRequest.setClaveProyecto(altaForm.getProyclaveProyecto());
						altaProyectoRequest.setCircuito(circuito);
						altaProyectoRequest.setIniciativa(iniciativa);
						altaProyectoRequest.setObjetivo(objetivo);
						altaProyectoRequest.setAccion(accion);
						altaProyectoRequest.setMeta(meta);
						altaProyectoRequest.setCosto(costo);
						altaProyectoRequest.setTipoGasto(tipoGasto);
						altaProyectoRequest.setPresupuesto(presupuesto);

						respuestaAlta =  portafolio.altaProyecto(altaProyectoRequest);
						
						LOGGER.info(" DATOS OBTENIDOS - ALTA PROYECTO - DESCRIPCION:{}, RECURSOS:{}, CLAVE:{}, BP:{}, COSTO:{}, FECHA:{} FECHAMAXIMA:{}, ESTATUS:{}, PORTAFOLIO:{}, CIRCUITOS:{}, INICIATIVA:{} OBJETIVO:{}, ACCION:{}, META:{}, COSTOS:{}, GASTO:{}, PRESUPUESTO:{} - RESULTADO - CODRESPUESTA:{}",
								 altaForm.getProyDescripcion(), altaForm.getProyRecursos(),
								altaForm.getProyclaveProyecto(), altaForm.getProyBP(), altaForm.getProycosto(),
								altaForm.getProyfecha(), altaForm.getProyfechaMaxima(), altaForm.getProyestatus(),
								portafolioReq, altaForm.getProycircuito(), altaForm.getProyiniciativa(),
								altaForm.getProyobjetivo(), altaForm.getProyaccion(), altaForm.getProymeta(),
								altaForm.getProycostos(), altaForm.getProygasto(), altaForm.getProypresupuesto(), respuestaAlta);
					} else {
						altaForm.setErrorAdicional(true);
						msg = "No se pudo realizar la operación.";
						altaForm.setMsg(msg);
					}

					if (respuestaAlta.equals("200")) {
						msg = "EL REGISTRO SE REALIZO CORRECTAMENTE!";
						altaForm.setMsg(msg);
						
						altaForm.setIdPortafolio( UtileriaGeneral.generaClavePortafolio(portafolio.consultaIdPortafolio()));
						altaForm.setIdProyecto( UtileriaGeneral.generaClaveProyecto(portafolio.consultaIdProyecto()));
						

					} else {
						altaForm.setErrorAdicional(true);
						msg = "No se pudo realizar la operación.";
						altaForm.setMsg(msg);

					}				
			}
			
			LOGGER.info("# ALTA PORTAFOLIO ");

		} catch (Exception e) {
			LOGGER.error("# ERROR  - ALTA PORTAFOLIO  - MENSAJE:{}", e.toString());
			throw new Exception();

		}

		return altaForm;

	}

	/******************************************************************* 
	 * DETALLE: VISTA PORTAFOLIO (ALTA PORTAFOLIO)
	 * PARA LLENAR LA VISTA  CONSULTA LOS SIGUIENTES CATALOGOS:
	 *    - ESTATUS, CIRCUITOS, INICIATIVAS, OBJETIVOS, ACCIONES, 
	 *    - METAS CENTROCOSTOS, TIPOGASTO, PRESUPUESTO, BP
	 * DE LA VISTA SE ENVIAN LOS PARAMETROS: proyDescripcion, proyId
	 * REST METODO USADO: (consultaCatalogo);
	 *******************************************************************/
	
	@RequestMapping(value = "/altaproyectos", method = RequestMethod.POST)
	public String altaProyecto(Model model, @RequestParam String proyDescripcion, String proyId) throws Exception {

		List<EstatusResponse> lestatus = new ArrayList<EstatusResponse>();
		List<CircuitosResponse> lcircuitos = new ArrayList<CircuitosResponse>();
		List<IniciativasResponse> liniciativas = new ArrayList<IniciativasResponse>();
		List<ObjetivosResponse> lobjetivos = new ArrayList<ObjetivosResponse>();
		List<AccionesResponse> lacciones = new ArrayList<AccionesResponse>();
		List<MetasResponse> lmetas = new ArrayList<MetasResponse>();
		List<CentroCostosResponse> lcostos = new ArrayList<CentroCostosResponse>();
		List<TipoGastoResponse> ltipoGastos = new ArrayList<TipoGastoResponse>();
		List<PresupuestosResponse> lpresupuestos = new ArrayList<PresupuestosResponse>();
		List<BPResponse> LBP = new ArrayList<BPResponse>();

		String vistaRetorno = null;
		String idSecPortafolio = null;
		String idSecProyecto = null;

		try {

			LOGGER.info(" DATOS OBTENIDOS ALTA PROYECTOS - IDPROYECTO:{},  DESCRIPCION:{}, ", proyId, proyDescripcion);

			lestatus = portafolio.consultaEstatus();
			lcircuitos = portafolio.consultaCircuitos();
			liniciativas = portafolio.consultaIniciativas();
			lobjetivos = portafolio.consultaObjetivos();
			lacciones = portafolio.consultaAcciones();
			lmetas = portafolio.consultaMetas();
			lcostos = portafolio.consultaCostos();
			ltipoGastos = portafolio.consultaTipoGasto();
			lpresupuestos = portafolio.consultaPresupuesto();
			LBP = portafolio.consultaBP();

			model.addAttribute("claveProyecto", UtileriaGeneral.generaClaveProyecto(portafolio.consultaIdProyecto()));
			model.addAttribute("LBP", LBP);
			model.addAttribute("lestatus", lestatus);
			model.addAttribute("descPortafolio", proyDescripcion);
			model.addAttribute("idPortafolio", proyId);
			model.addAttribute("lcircuitos", lcircuitos);
			model.addAttribute("liniciativas", liniciativas);
			model.addAttribute("lobjetivos", lobjetivos);
			model.addAttribute("lacciones", lacciones);
			model.addAttribute("lmetas", lmetas);
			model.addAttribute("lcostos", lcostos);
			model.addAttribute("ltipoGastos", ltipoGastos);
			model.addAttribute("lpresupuestos", lpresupuestos);

			vistaRetorno = "view_portafolio/altaProyecto";
			LOGGER.info("# PORTAFOLIO  - VISTA (ALTA PROYECTO) ");

		} catch (Exception e) {
			LOGGER.error("# ERROR - LOGIN  - MENSAJE:{}", e.toString());
			throw new Exception();

		}

		return vistaRetorno;

	}
	
	/******************************************************************* 
	 * DETALLE: CONTROLADOR QUE HACE LA INSERCION DE UN PLAN INVERSION/PROYECTO.
	 * USA METODO AJAX UBICADO EN la carpeta: JS
	 *             con el nombre: altaProyecto.js
	 * LOS PARAMETROS VIENEN DEL METODO AJAX
	 * REST METODOS USADOS: (insertaProyecto);
	 ********************************************************************/

	@RequestMapping(value = "/altaPlanInversion", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody AltaProyectoForm altaPlan(@RequestBody AltaProyectoForm altaForm, Model model)
			throws Exception {

		String respuestaAlta = null;
		String msg = null;
		AltaProyectoRequest altaProyectoRequest = new AltaProyectoRequest();
		BPRequest bp = new BPRequest();
		EstatusRequest estatus = new EstatusRequest();
		PortafoliosRequest portafolioReq = new PortafoliosRequest();
		CircuitosRequest circuito = new CircuitosRequest();
		IniciativasRequest iniciativa = new IniciativasRequest();
		ObjetivosRequest objetivo = new ObjetivosRequest();
		AccionesRequest accion = new AccionesRequest();
		MetasRequest meta = new MetasRequest();
		CentroCostosRequest costo = new CentroCostosRequest();
		TipoGastoRequest tipoGasto = new TipoGastoRequest();
		PresupuestosRequest presupuesto = new PresupuestosRequest();


		try {

			LOGGER.info(
					" DATOS OBTENIDOS :  DESCRIPCION:{}, RECURSOS:{}, CLAVE:{}, BP:{}, COSTO:{}, FECHA:{} FECHAMAXIMA:{}, ESTATUS:{}, PORTAFOLIO:{}, CIRCUITOS:{}, INICIATIVA:{} OBJETIVO:{}, ACCION:{}, META:{}, COSTOS:{}, GASTO:{}, PRESUPUESTO:{}",
					altaForm.getProyDescripcion(), altaForm.getProyRecursos(), altaForm.getProyclaveProyecto(),
					altaForm.getProyBP(), altaForm.getProycosto(), altaForm.getProyfecha(),
					altaForm.getProyfechaMaxima(), altaForm.getProyestatus(), altaForm.getProyportafolio(),
					altaForm.getProycircuito(), altaForm.getProyiniciativa(), altaForm.getProyobjetivo(),
					altaForm.getProyaccion(), altaForm.getProymeta(), altaForm.getProycostos(), altaForm.getProygasto(),
					altaForm.getProypresupuesto());

			altaForm.validacion();

			if (altaForm.isErrorAdicional()) {
				LOGGER.info("# ALTA PROYECTO - ERROR EN DATOS DE ENTRADA - ERROR:{}", altaForm.getMsg());
				altaForm.setMsg(altaForm.getMsg());
				altaForm.setLerrorAdicional(UtileriaGeneral.generaLista(altaForm.getNomComponente()));

			} else {

				bp.setId(Integer.parseInt(altaForm.getProyBP()));
				estatus.setId(Integer.parseInt(altaForm.getProyestatus()));
				portafolioReq.setId(Integer.parseInt(altaForm.getProyportafolio()));
				circuito.setId(Integer.parseInt(altaForm.getProycircuito()));
				iniciativa.setId(Integer.parseInt(altaForm.getProyiniciativa()));
				objetivo.setId(Integer.parseInt(altaForm.getProyobjetivo()));
				accion.setId(Integer.parseInt(altaForm.getProyaccion()));
				meta.setId(Integer.parseInt(altaForm.getProymeta()));
				costo.setId(Integer.parseInt(altaForm.getProycostos()));
				tipoGasto.setId(Integer.parseInt(altaForm.getProygasto()));
				presupuesto.setId(Integer.parseInt(altaForm.getProypresupuesto()));

				altaProyectoRequest.setId(0);
				altaProyectoRequest.setDescripcion(altaForm.getProyDescripcion());
				altaProyectoRequest.setFechaRequerida(Integer.parseInt(altaForm.getProyfecha()));
				altaProyectoRequest.setFechaMaxTermino(Integer.parseInt(altaForm.getProyfechaMaxima()));
				altaProyectoRequest.setRecursos(altaForm.getProyRecursos());
				altaProyectoRequest.setCostoProyecto(Float.parseFloat(altaForm.getProycosto()));
				altaProyectoRequest.setBp(bp);
				altaProyectoRequest.setEstatus(estatus);
				altaProyectoRequest.setPortafolio(portafolioReq);
				altaProyectoRequest.setClaveProyecto(altaForm.getProyclaveProyecto());
				altaProyectoRequest.setCircuito(circuito);
				altaProyectoRequest.setIniciativa(iniciativa);
				altaProyectoRequest.setObjetivo(objetivo);
				altaProyectoRequest.setAccion(accion);
				altaProyectoRequest.setMeta(meta);
				altaProyectoRequest.setCosto(costo);
				altaProyectoRequest.setTipoGasto(tipoGasto);
				altaProyectoRequest.setPresupuesto(presupuesto);

				respuestaAlta = portafolio.altaProyecto(altaProyectoRequest);

				if (respuestaAlta.equals("200")) {
					msg = "Se dio de alta el proyecto correctamente.";
					altaForm.setMsg(msg);

				} else {
					msg = "No se dio de alta el proyecto correctamente.";
					altaForm.setMsg(msg);

				}

			}

			LOGGER.info("# PORTAFOLIO  - VISTA (ALTA PROYECTO) ");

		} catch (Exception e) {
			LOGGER.error("# ERROR - PORTAFOLIO  - MENSAJE:{}", e.toString());
			throw new Exception();

		}

		return altaForm;

	}
	
	/******************************************************************* 
	 * DETALLE: CONTROLADOR QUE MUESTRA LA VISTA DE REGISTRO DE AVANCE
	 * CONSUME: CONSULTA PORTAFOLIOS Y CONSULTA PROYECTOS.
	 ********************************************************************/
	@GetMapping(value = { "/registroAvance" })
	public String registroAvances(Model model) throws Exception {
		String vistaRetorno = null;
		List<ProyectosResponse> lProyectos = new ArrayList<ProyectosResponse>();
		List<PortafoliosResponse> lportafolios = new ArrayList<PortafoliosResponse>();
		List<RegistroAvance> lregistro = new ArrayList<RegistroAvance>();

		try {
			
			lportafolios = portafolio.consultaPortafolios();
			lProyectos = portafolio.consultaProyectos();
			lregistro = portafolio.consultaRegistroAvance();

			model.addAttribute("lportafolios", lportafolios);
			model.addAttribute("lplanes", lProyectos);
			model.addAttribute("lregistro", lregistro);
			
			
			vistaRetorno = "view_portafolio/registroAvances";
			
			LOGGER.info("# PORTAFOLIO  - VISTA (REGISTRO DE AVANCES ) ");

		} catch (Exception e) {
			LOGGER.error("# ERROR - REGISTRO DE AVANCES  - MENSAJE:{}", e.toString());
			throw new Exception();

		}

		return vistaRetorno;

	}

}
