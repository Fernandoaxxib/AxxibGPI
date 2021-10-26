package mx.axxib.gpi.eml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReporteResponse {

	
	private Integer codRespuesta;
	private String mensaje;
	private Reporte reporte;
	
	public Integer getCodRespuesta() {
		return codRespuesta;
	}
	public void setCodRespuesta(Integer codRespuesta) {
		this.codRespuesta = codRespuesta;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Reporte getReporte() {
		return reporte;
	}
	public void setReporte(Reporte reporte) {
		this.reporte = reporte;
	}	
	
}
