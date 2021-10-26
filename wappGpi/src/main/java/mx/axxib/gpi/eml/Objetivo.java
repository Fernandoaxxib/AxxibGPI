package mx.axxib.gpi.eml;

import java.util.List;

public class Objetivo {

	private Integer id;
	private String objetivo;
	private Integer RS_OBJETIVO;
	private List<AccionEstrategica> accionesEstrategicas;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public Integer getRS_OBJETIVO() {
		return RS_OBJETIVO;
	}
	public void setRS_OBJETIVO(Integer rS_OBJETIVO) {
		RS_OBJETIVO = rS_OBJETIVO;
	}
	public List<AccionEstrategica> getAccionesEstrategicas() {
		return accionesEstrategicas;
	}
	public void setAccionesEstrategicas(List<AccionEstrategica> accionesEstrategicas) {
		this.accionesEstrategicas = accionesEstrategicas;
	}
	
	
}
