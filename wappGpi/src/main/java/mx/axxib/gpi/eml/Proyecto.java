package mx.axxib.gpi.eml;

import java.util.List;

public class Proyecto {

	private String proyecto;
	private Presupuesto presupuesto;
	private Boolean tituloBloque;
	private Integer orden;
	private Boolean normativo;
	private String fechaRequerida;
	private Bp bp;
	private Interventor interventor;
	private Double costoPpto;
	private List<Periodos> periodos;
	
	
	
	public String getProyecto() {
		return proyecto;
	}
	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}
	public Presupuesto getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(Presupuesto presupuesto) {
		this.presupuesto = presupuesto;
	}
	public Boolean getTituloBloque() {
		return tituloBloque;
	}
	public void setTituloBloque(Boolean tituloBloque) {
		this.tituloBloque = tituloBloque;
	}
	public Integer getOrden() {
		return orden;
	}
	public void setOrden(Integer orden) {
		this.orden = orden;
	}
	public Boolean getNormativo() {
		return normativo;
	}
	public void setNormativo(Boolean normativo) {
		this.normativo = normativo;
	}
	public String getFechaRequerida() {
		return fechaRequerida;
	}
	public void setFechaRequerida(String fechaRequerida) {
		this.fechaRequerida = fechaRequerida;
	}
	public Bp getBp() {
		return bp;
	}
	public void setBp(Bp bp) {
		this.bp = bp;
	}
	public Interventor getInterventor() {
		return interventor;
	}
	public void setInterventor(Interventor interventor) {
		this.interventor = interventor;
	}
	public Double getCostoPpto() {
		return costoPpto;
	}
	public void setCostoPpto(Double costoPpto) {
		this.costoPpto = costoPpto;
	}
	public List<Periodos> getPeriodos() {
		return periodos;
	}
	public void setPeriodos(List<Periodos> periodos) {
		this.periodos = periodos;
	}
	
	
}
