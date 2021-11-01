package mx.axxib.gpi.eml;

import java.util.List;

public class AccionEstrategica {

	private Integer id;
	private String accionEstrategica;
	private Double total;
	private Integer RS_ACCION;
	private List<Proyecto> proyectos;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccionEstrategica() {
		return accionEstrategica;
	}
	public void setAccionEstrategica(String accionEstrategica) {
		this.accionEstrategica = accionEstrategica;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Integer getRS_ACCION() {
		return RS_ACCION;
	}
	public void setRS_ACCION(Integer rS_ACCION) {
		RS_ACCION = rS_ACCION;
	}
	public List<Proyecto> getProyectos() {
		return proyectos;
	}
	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}
	
	
	
}
