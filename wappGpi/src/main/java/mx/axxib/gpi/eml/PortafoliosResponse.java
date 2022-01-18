package mx.axxib.gpi.eml;

public class PortafoliosResponse {
	
	private Integer id;
	private String descripcion;
	private String fechaAlta;
	private EstatusResponse estatus;
	private String claveBP;
	private String clavePortafolio;
	
	
	
	public String getClavePortafolio() {
		return clavePortafolio;
	}
	public void setClavePortafolio(String clavePortafolio) {
		this.clavePortafolio = clavePortafolio;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public EstatusResponse getEstatus() {
		return estatus;
	}
	public void setEstatus(EstatusResponse estatus) {
		this.estatus = estatus;
	}
	public String getClaveBP() {
		return claveBP;
	}
	public void setClaveBP(String claveBP) {
		this.claveBP = claveBP;
	}
	
	
	

	

}
