package mx.axxib.gpi.eml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CargaResponse {

	private	String codRespuesta;
    private	String mensaje;
    

    public String getCodRespuesta() {
		return codRespuesta;
	}
	public void setCodRespuesta(String codRespuesta) {
		this.codRespuesta = codRespuesta;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
