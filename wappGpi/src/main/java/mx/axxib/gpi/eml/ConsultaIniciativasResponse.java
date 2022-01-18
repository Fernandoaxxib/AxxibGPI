package mx.axxib.gpi.eml;

import java.util.List;

public class ConsultaIniciativasResponse {
	
	private String codRespuesta;
	private List<IniciativasResponse> lista;	
	private String token;
	private String mensaje;
	
	public String getCodRespuesta() {
		return codRespuesta;
	}
	public void setCodRespuesta(String codRespuesta) {
		this.codRespuesta = codRespuesta;
	}
	
	
	public List<IniciativasResponse> getLista() {
		return lista;
	}
	public void setLista(List<IniciativasResponse> lista) {
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
