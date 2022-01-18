package mx.axxib.gpi.eml;

public class AltaPortafolioRequest {
	
	private Integer id;
	private String clavePortafolio;
	private String claveBP;
	private String descripcion;
	private String fechaAlta;
    private EstatusRequest estatus;

    
	public String getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getClavePortafolio() {
		return clavePortafolio;
	}
	public void setClavePortafolio(String clavePortafolio) {
		this.clavePortafolio = clavePortafolio;
	}
	public String getClaveBP() {
		return claveBP;
	}
	public void setClaveBP(String claveBP) {
		this.claveBP = claveBP;
	}
	public EstatusRequest getEstatus() {
		return estatus;
	}
	public void setEstatus(EstatusRequest estatus) {
		this.estatus = estatus;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	

}
