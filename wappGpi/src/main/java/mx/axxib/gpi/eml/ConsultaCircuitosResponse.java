package mx.axxib.gpi.eml;

import java.util.List;

public class ConsultaCircuitosResponse {
	
	private String codRespuesta;
	private List<CircuitosResponse> lista;	
	private String token;
	private String mensaje;
	
	public String getCodRespuesta() {
		return codRespuesta;
	}
	public void setCodRespuesta(String codRespuesta) {
		this.codRespuesta = codRespuesta;
	}
	
	
	public List<CircuitosResponse> getLista() {
		return lista;
	}
	public void setLista(List<CircuitosResponse> lista) {
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
