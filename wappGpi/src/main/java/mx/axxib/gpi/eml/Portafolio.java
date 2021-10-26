package mx.axxib.gpi.eml;


import java.util.List;

public class Portafolio {
	private String idPortafolio;
    private String nombrePortafolio;
    private List<Iniciativa> iniciativas;
    private List<String> columnas;
    
    
    
	public List<String> getColumnas() {
		return columnas;
	}
	public void setColumnas(List<String> columnas) {
		this.columnas = columnas;
	}
	public String getIdPortafolio() {
		return idPortafolio;
	}
	public void setIdPortafolio(String idPortafolio) {
		this.idPortafolio = idPortafolio;
	}
	public String getNombrePortafolio() {
		return nombrePortafolio;
	}
	public void setNombrePortafolio(String nombrePortafolio) {
		this.nombrePortafolio = nombrePortafolio;
	}
	public List<Iniciativa> getIniciativas() {
		return iniciativas;
	}
	public void setIniciativas(List<Iniciativa> iniciativas) {
		this.iniciativas = iniciativas;
	}
}
