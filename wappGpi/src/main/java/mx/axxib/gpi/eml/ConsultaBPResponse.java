package mx.axxib.gpi.eml;

import java.util.List;

public class ConsultaBPResponse {
	
	private String codRespuesta;
	private List<BPResponse> lista;	
	private String token;
	private String mensaje;
	
	public String getCodRespuesta() {
		return codRespuesta;
	}
	public void setCodRespuesta(String codRespuesta) {
		this.codRespuesta = codRespuesta;
	}	
	
	public List<BPResponse> getLista() {
		return lista;
	}
	public void setLista(List<BPResponse> lista) {
		this.lista = lista;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
		
	

}
