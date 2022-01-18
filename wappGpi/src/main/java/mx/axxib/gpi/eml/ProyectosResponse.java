package mx.axxib.gpi.eml;

import java.util.Date;
import java.util.List;

public class ProyectosResponse {

	private int id;
    private String descripcion;
    private int fechaRequerida;
    private int fechaMaxTermino;
    private String recursos;
    private Float costoProyecto;
    private BPResponse bp;
    private EstatusResponse estatus;
    private PortafoliosResponse portafolio;
    private String fechaCreacion;
    private String fechaUltModif;
    private String claveProyecto;
    private CircuitosResponse circuito;
    private IniciativasResponse iniciativa;
    private ObjetivosResponse objetivo;
    private AccionesResponse accion;
    private MetasResponse meta;
    private CentroCostosResponse costo;
    private TipoGastoResponse tipoGasto;
    private PresupuestosResponse presupuesto;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getFechaRequerida() {
		return fechaRequerida;
	}
	public void setFechaRequerida(int fechaRequerida) {
		this.fechaRequerida = fechaRequerida;
	}
	public int getFechaMaxTermino() {
		return fechaMaxTermino;
	}
	public void setFechaMaxTermino(int fechaMaxTermino) {
		this.fechaMaxTermino = fechaMaxTermino;
	}
	public String getRecursos() {
		return recursos;
	}
	public void setRecursos(String recursos) {
		this.recursos = recursos;
	}
	public Float getCostoProyecto() {
		return costoProyecto;
	}
	public void setCostoProyecto(Float costoProyecto) {
		this.costoProyecto = costoProyecto;
	}
	public BPResponse getBp() {
		return bp;
	}
	public void setBp(BPResponse bp) {
		this.bp = bp;
	}
	public EstatusResponse getEstatus() {
		return estatus;
	}
	public void setEstatus(EstatusResponse estatus) {
		this.estatus = estatus;
	}
	public PortafoliosResponse getPortafolio() {
		return portafolio;
	}
	public void setPortafolio(PortafoliosResponse portafolio) {
		this.portafolio = portafolio;
	}
	
	
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getFechaUltModif() {
		return fechaUltModif;
	}
	public void setFechaUltModif(String fechaUltModif) {
		this.fechaUltModif = fechaUltModif;
	}
	public String getClaveProyecto() {
		return claveProyecto;
	}
	public void setClaveProyecto(String claveProyecto) {
		this.claveProyecto = claveProyecto;
	}
	public CircuitosResponse getCircuito() {
		return circuito;
	}
	public void setCircuito(CircuitosResponse circuito) {
		this.circuito = circuito;
	}
	public IniciativasResponse getIniciativa() {
		return iniciativa;
	}
	public void setIniciativa(IniciativasResponse iniciativa) {
		this.iniciativa = iniciativa;
	}
	public ObjetivosResponse getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(ObjetivosResponse objetivo) {
		this.objetivo = objetivo;
	}
	public AccionesResponse getAccion() {
		return accion;
	}
	public void setAccion(AccionesResponse accion) {
		this.accion = accion;
	}
	public MetasResponse getMeta() {
		return meta;
	}
	public void setMeta(MetasResponse meta) {
		this.meta = meta;
	}
	public CentroCostosResponse getCosto() {
		return costo;
	}
	public void setCosto(CentroCostosResponse costo) {
		this.costo = costo;
	}
	public TipoGastoResponse getTipoGasto() {
		return tipoGasto;
	}
	public void setTipoGasto(TipoGastoResponse tipoGasto) {
		this.tipoGasto = tipoGasto;
	}
	public PresupuestosResponse getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(PresupuestosResponse presupuesto) {
		this.presupuesto = presupuesto;
	}
    
	
}
