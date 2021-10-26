package mx.axxib.gpi.eml;

import java.util.List;

public class Iniciativa {


	private Integer id;
	private String iniciativa;
	private Integer RS_INICIATIVA;
	private List<Objetivo> objetivos;
	
	
	
	public Integer getRS_INICIATIVA() {
		return RS_INICIATIVA;
	}
	public void setRS_INICIATIVA(Integer rS_INICIATIVA) {
		RS_INICIATIVA = rS_INICIATIVA;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIniciativa() {
		return iniciativa;
	}
	public void setIniciativa(String iniciativa) {
		this.iniciativa = iniciativa;
	}
	public List<Objetivo> getObjetivos() {
		return objetivos;
	}
	public void setObjetivos(List<Objetivo> objetivos) {
		this.objetivos = objetivos;
	}
	
	
}
