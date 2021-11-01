package mx.axxib.gpi.eml;


import java.util.List;

public class Portafolio {
	private String idPortafolio;   
    private List<Iniciativa> iniciativas;
    private List<String> columnas;
    private List<AccionEstrategica> acciones;
    private Double portafolioTotal;
        
    
	public Double getPortafolioTotal() {
		return portafolioTotal;
	}
	public void setPortafolioTotal(Double portafolioTotal) {
		this.portafolioTotal = portafolioTotal;
	}
	public List<AccionEstrategica> getAcciones() {
		return acciones;
	}
	public void setAcciones(List<AccionEstrategica> acciones) {
		this.acciones = acciones;
	}
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
	public List<Iniciativa> getIniciativas() {
		return iniciativas;
	}
	public void setIniciativas(List<Iniciativa> iniciativas) {
		this.iniciativas = iniciativas;
	}
}
