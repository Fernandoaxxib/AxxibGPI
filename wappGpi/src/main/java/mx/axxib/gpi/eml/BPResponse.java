package mx.axxib.gpi.eml;

public class BPResponse {
	
	private int id;
	private String nombre;
	private String correoElectronico;
	private String correoElectronicoJefeInmediato;
	private String bpLider;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public String getCorreoElectronicoJefeInmediato() {
		return correoElectronicoJefeInmediato;
	}
	public void setCorreoElectronicoJefeInmediato(String correoElectronicoJefeInmediato) {
		this.correoElectronicoJefeInmediato = correoElectronicoJefeInmediato;
	}
	public String getBpLider() {
		return bpLider;
	}
	public void setBpLider(String bpLider) {
		this.bpLider = bpLider;
	}
	
	
	
}
