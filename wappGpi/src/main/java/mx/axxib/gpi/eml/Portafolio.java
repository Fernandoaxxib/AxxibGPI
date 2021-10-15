package mx.axxib.gpi.eml;


import java.util.List;

public class Portafolio {
    private String idPortafolio;
    private String nombrePortafolio;
    private List<String> columnas;
	private List<Reporte> listaReportes;

	 List<ObjWithAct> objetivos;
	
	private String descripcionIniciativa;
	private String descriponObjetivo1;
	private String descripcionAccion1;
	private String descriponObjetivo2;
	private String descripcionAccion2;
		
	private Integer rowSpanIniciativa1;
	private Integer rowSpanObjetivo1;
	private Integer rowSpanAccion1;
	
	private Integer rowSpanIniciativa2;
	private Integer rowSpanObjetivo2;
	private Integer rowSpanAccion2;
	
	
	
	
	
	
	public List<ObjWithAct> getObjetivos() {
		return objetivos;
	}

	public void setObjetivos(List<ObjWithAct> objetivos) {
		this.objetivos = objetivos;
	}

	public String getDescripcionIniciativa() {
		return descripcionIniciativa;
	}

	public void setDescripcionIniciativa(String descripcionIniciativa) {
		this.descripcionIniciativa = descripcionIniciativa;
	}

	public String getDescriponObjetivo1() {
		return descriponObjetivo1;
	}

	public void setDescriponObjetivo1(String descriponObjetivo1) {
		this.descriponObjetivo1 = descriponObjetivo1;
	}

	public String getDescripcionAccion1() {
		return descripcionAccion1;
	}

	public void setDescripcionAccion1(String descripcionAccion1) {
		this.descripcionAccion1 = descripcionAccion1;
	}

	public String getDescriponObjetivo2() {
		return descriponObjetivo2;
	}

	public void setDescriponObjetivo2(String descriponObjetivo2) {
		this.descriponObjetivo2 = descriponObjetivo2;
	}

	public String getDescripcionAccion2() {
		return descripcionAccion2;
	}

	public void setDescripcionAccion2(String descripcionAccion2) {
		this.descripcionAccion2 = descripcionAccion2;
	}

	public Integer getRowSpanIniciativa1() {
		return rowSpanIniciativa1;
	}

	public void setRowSpanIniciativa1(Integer rowSpanIniciativa1) {
		this.rowSpanIniciativa1 = rowSpanIniciativa1;
	}

	public Integer getRowSpanObjetivo1() {
		return rowSpanObjetivo1;
	}

	public void setRowSpanObjetivo1(Integer rowSpanObjetivo1) {
		this.rowSpanObjetivo1 = rowSpanObjetivo1;
	}

	public Integer getRowSpanAccion1() {
		return rowSpanAccion1;
	}

	public void setRowSpanAccion1(Integer rowSpanAccion1) {
		this.rowSpanAccion1 = rowSpanAccion1;
	}

	public Integer getRowSpanIniciativa2() {
		return rowSpanIniciativa2;
	}

	public void setRowSpanIniciativa2(Integer rowSpanIniciativa2) {
		this.rowSpanIniciativa2 = rowSpanIniciativa2;
	}

	public Integer getRowSpanObjetivo2() {
		return rowSpanObjetivo2;
	}

	public void setRowSpanObjetivo2(Integer rowSpanObjetivo2) {
		this.rowSpanObjetivo2 = rowSpanObjetivo2;
	}

	public Integer getRowSpanAccion2() {
		return rowSpanAccion2;
	}

	public void setRowSpanAccion2(Integer rowSpanAccion2) {
		this.rowSpanAccion2 = rowSpanAccion2;
	}

	public List<String> getColumnas() {
		return columnas;
	}

	public void setColumnas(List<String> columnas) {
		this.columnas = columnas;
	}

	public String getIdPortafolio() {
		return idPortafolio;
	}

	public void setIdPortafolio(String idPortafolio) {
		this.idPortafolio = idPortafolio;
	}

	public String getNombrePortafolio() {
		return nombrePortafolio;
	}

	public void setNombrePortafolio(String nombrePortafolio) {
		this.nombrePortafolio = nombrePortafolio;
	}

	public List<Reporte> getListaReportes() {
		return listaReportes;
	}

	public void setListaReportes(List<Reporte> listaReportes) {
		this.listaReportes = listaReportes;
	}

	
	
}
