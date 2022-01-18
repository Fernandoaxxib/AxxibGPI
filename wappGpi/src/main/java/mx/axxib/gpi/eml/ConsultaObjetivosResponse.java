package mx.axxib.gpi.eml;

import java.util.List;

public class ConsultaObjetivosResponse {
	
	private String codRespuesta;
	private List<ObjetivosResponse> lista;	
	private String token;
	private String mensaje;
	
	public String getCodRespuesta() {
		return codRespuesta;
	}
	public void setCodRespuesta(String codRespuesta) {
		this.codRespuesta = codRespuesta;
	}
	
	
	public List<ObjetivosResponse> getLista() {
		return lista;
	}
	public void setLista(List<ObjetivosResponse> lista) {
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
