package mx.axxib.gpi.eml;

public class Presupuesto {

	private Integer id;
	private String presupuesto;
	
	public Presupuesto() {}
	
	public Presupuesto(Integer id, String presupuesto) {
		super();
		this.id = id;
		this.presupuesto = presupuesto;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(String presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	
}
