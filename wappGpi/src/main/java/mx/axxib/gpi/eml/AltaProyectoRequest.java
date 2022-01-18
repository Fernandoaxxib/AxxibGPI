package mx.axxib.gpi.eml;

import java.util.Date;
import java.util.List;

public class AltaProyectoRequest {
		
	private int id;
    private String descripcion;
    private int fechaRequerida;
    private int fechaMaxTermino;
    private String recursos;
    private Float costoProyecto;
    private BPRequest bp;
    private EstatusRequest estatus;
    private PortafoliosRequest portafolio;
    private Date fechaCreacion;
    private Date fechaUltModif;
    private String claveProyecto;
    private CircuitosRequest circuito;
    private IniciativasRequest iniciativa;
    private ObjetivosRequest objetivo;
    private AccionesRequest accion;
    private MetasRequest meta;
    private CentroCostosRequest costo;
    private TipoGastoRequest tipoGasto;
    private PresupuestosRequest presupuesto;
    
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
	public BPRequest getBp() {
		return bp;
	}
	public void setBp(BPRequest bp) {
		this.bp = bp;
	}
	public EstatusRequest getEstatus() {
		return estatus;
	}
	public void setEstatus(EstatusRequest estatus) {
		this.estatus = estatus;
	}
	public PortafoliosRequest getPortafolio() {
		return portafolio;
	}
	public void setPortafolio(PortafoliosRequest portafolio) {
		this.portafolio = portafolio;
	}
	
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Date getFechaUltModif() {
		return fechaUltModif;
	}
	public void setFechaUltModif(Date fechaUltModif) {
		this.fechaUltModif = fechaUltModif;
	}
	public String getClaveProyecto() {
		return claveProyecto;
	}
	public void setClaveProyecto(String claveProyecto) {
		this.claveProyecto = claveProyecto;
	}
	public CircuitosRequest getCircuito() {
		return circuito;
	}
	public void setCircuito(CircuitosRequest circuito) {
		this.circuito = circuito;
	}
	public IniciativasRequest getIniciativa() {
		return iniciativa;
	}
	public void setIniciativa(IniciativasRequest iniciativa) {
		this.iniciativa = iniciativa;
	}
	public ObjetivosRequest getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(ObjetivosRequest objetivo) {
		this.objetivo = objetivo;
	}
	public AccionesRequest getAccion() {
		return accion;
	}
	public void setAccion(AccionesRequest accion) {
		this.accion = accion;
	}
	public MetasRequest getMeta() {
		return meta;
	}
	public void setMeta(MetasRequest meta) {
		this.meta = meta;
	}
	public CentroCostosRequest getCosto() {
		return costo;
	}
	public void setCosto(CentroCostosRequest costo) {
		this.costo = costo;
	}
	public TipoGastoRequest getTipoGasto() {
		return tipoGasto;
	}
	public void setTipoGasto(TipoGastoRequest tipoGasto) {
		this.tipoGasto = tipoGasto;
	}
	public PresupuestosRequest getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(PresupuestosRequest presupuesto) {
		this.presupuesto = presupuesto;
	}
    
	
	
    
	

}
