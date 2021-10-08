package mx.axxib.gpi.eml;

import java.util.List;

public class Registro {

	private String iniciativa;
	private String objetivo;
	private String accionEstrategica;		
	private String proyecto;
	private Integer idPresupuesto;
	private Integer esTituloBloque;
	private Integer orden;
	private Integer esNormativo;	
	private String fechaRequerida;	
	private String cveBp;
	private String cvesRecursos;
	private Double costoPpto;
	private String mesAvance;
	private Integer anioAvance;
	private Integer indicador;	
	private List<Avance> periodoAvance;
		
	
	public List<Avance> getPeriodoAvance() {
		return periodoAvance;
	}
	public void setPeriodoAvance(List<Avance> periodoAvance) {
		this.periodoAvance = periodoAvance;
	}
	public String getIniciativa() {
		return iniciativa;
	}
	public void setIniciativa(String iniciativa) {
		this.iniciativa = iniciativa;
	}
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public String getAccionEstrategica() {
		return accionEstrategica;
	}
	public void setAccionEstrategica(String accionEstrategica) {
		this.accionEstrategica = accionEstrategica;
	}
	public String getProyecto() {
		return proyecto;
	}
	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}
	public Integer getIdPresupuesto() {
		return idPresupuesto;
	}
	public void setIdPresupuesto(Integer idPresupuesto) {
		this.idPresupuesto = idPresupuesto;
	}
	public Integer getEsTituloBloque() {
		return esTituloBloque;
	}
	public void setEsTituloBloque(Integer esTituloBloque) {
		this.esTituloBloque = esTituloBloque;
	}
	public Integer getOrden() {
		return orden;
	}
	public void setOrden(Integer orden) {
		this.orden = orden;
	}
	public Integer getEsNormativo() {
		return esNormativo;
	}
	public void setEsNormativo(Integer esNormativo) {
		this.esNormativo = esNormativo;
	}
	public String getFechaRequerida() {
		return fechaRequerida;
	}
	public void setFechaRequerida(String fechaRequerida) {
		this.fechaRequerida = fechaRequerida;
	}
	public String getCveBp() {
		return cveBp;
	}
	public void setCveBp(String cveBp) {
		this.cveBp = cveBp;
	}
	public String getCvesRecursos() {
		return cvesRecursos;
	}
	public void setCvesRecursos(String cvesRecursos) {
		this.cvesRecursos = cvesRecursos;
	}
	public Double getCostoPpto() {
		return costoPpto;
	}
	public void setCostoPpto(Double costoPpto) {
		this.costoPpto = costoPpto;
	}
	public String getMesAvance() {
		return mesAvance;
	}
	public void setMesAvance(String mesAvance) {
		this.mesAvance = mesAvance;
	}
	public Integer getAnioAvance() {
		return anioAvance;
	}
	public void setAnioAvance(Integer anioAvance) {
		this.anioAvance = anioAvance;
	}
	public Integer getIndicador() {
		return indicador;
	}
	public void setIndicador(Integer indicador) {
		this.indicador = indicador;
	}
	
	
}
