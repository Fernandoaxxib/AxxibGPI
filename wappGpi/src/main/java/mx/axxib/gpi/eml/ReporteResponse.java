package mx.axxib.gpi.eml;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReporteResponse {

	
	private Integer codRespuesta;
	private String mensaje;
	private List<Reporte> reporte;	
	
	
	
	public List<Reporte> getReporte() {
		return reporte;
	}
	public void setReporte(List<Reporte> reporte) {
		this.reporte = reporte;
	}
	
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
}
