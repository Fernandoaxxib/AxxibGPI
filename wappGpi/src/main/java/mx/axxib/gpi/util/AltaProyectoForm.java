package mx.axxib.gpi.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AltaProyectoForm {
	
	private String proyDescripcion;
	private String proyRecursos;
	private String proyclaveProyecto;
	private String proyBP;
	private String proycosto; 
	private String proyfecha;
	private String proyfechaMaxima; 
	private String proyestatus; 
	private String proyportafolio; 
	private String proycircuito;
	private String proyiniciativa; 
	private String proyobjetivo;
	private String proyaccion; 
	private String proymeta; 
	private String proycostos; 
	private String proygasto;
	private String proypresupuesto;
	private boolean errorAdicional = false;	
	private String msg;
	private String nomComponente = null;
	private List<String> lerrorAdicional;
	
	
			
	Pattern valtexto = Pattern.compile(
			"\\/+|\\)+|\\(+|\\¿+|\\?+|\\°+|\\¬+|\\|+|\\!+|\\#+|\\$+|\\%+|\\&+|\\+|\\=+|\\’+|\\¡+|\\++|\\*+|\\~+|\\[+|\\]|\\{+|\\}+|\\^+|\\<+|\\>+|\\\"");
	Pattern patronTexto = Pattern.compile("[a-zA-ZñÑ\\s]*$");
	
	public AltaProyectoForm() {
		this.msg = "";
		this.nomComponente = "";
	}
	
	
	public void validacion() {
		
		if (this.proyDescripcion == null || this.proyDescripcion.trim() == "" || this.proyDescripcion.trim().length() == 0) {
			this.errorAdicional = true;
			this.msg += "Agregar la descripción del proyecto";
			this.nomComponente += "proydescripcion-1-Agregar Descripción del Proyecto,";
		} else {
			Matcher match = valtexto.matcher(this.proyDescripcion);
			if (match.find()) {
				this.errorAdicional = true;
				this.msg += " Descripción: No debe tener caracteres especiales";
				this.nomComponente += "proydescripcion-1-No ingresar caracteres especiales,";

			} else {
				this.proyDescripcion = this.proyDescripcion.trim();
			}
		}
		
		if (this.proyRecursos == null || this.proyRecursos.trim() == "" || this.proyRecursos.trim().length() == 0) {
			this.errorAdicional = true;
			this.msg += " Agregar recursos del proyecto";
			this.nomComponente += "proyRecursos-2-Agregar Recursos del Proyecto,";
		} else {
			Matcher match = valtexto.matcher(this.proyRecursos);
			if (match.find()) {
				this.errorAdicional = true;
				this.msg += " Recursos: No debe tener caracteres especiales";
				this.nomComponente += "proyRecursos-2-No ingresar caracteres especiales,";

			} else {
				this.proyRecursos = this.proyRecursos.trim();
			}
		}
		
		if (this.proyclaveProyecto == null || this.proyclaveProyecto.trim() == "" || this.proyclaveProyecto.trim().length() == 0) {
			this.errorAdicional = true;
			this.msg += " Agregar clave del proyecto";
			this.nomComponente += "proyclaveProyecto-3-Agregar Recursos del Proyecto,";
		} else {
			Matcher match = valtexto.matcher(this.proyclaveProyecto);
			if (match.find()) {
				this.errorAdicional = true;
				this.msg += " Clave Proyecto: No debe tener caracteres especiales";
				this.nomComponente += "proyclaveProyecto-3-No debe tener caracteres especiales,";

			} else {
				this.proyclaveProyecto = this.proyclaveProyecto.trim();
			}
		}
		
		
		if(this.proycosto == null ||  this.proycosto == "" || this.proycosto.trim().length() == 0 ) {
			this.errorAdicional = true;
			this.msg = "Agregar costo del proyecto";
			this.nomComponente += "proycosto-4-Agregar Costo del Proyecto,";
		}else {
			
			Matcher match = valtexto.matcher(this.proycosto);
			if (match.find()) {
				this.errorAdicional = true;
				this.msg = "Costo Proyecto: Ingresar solo números";
				this.nomComponente += "proycosto-4-Ingresar solo números,";

			} else {
				if( this.proycosto.matches("[0-9]*") ) {
					this.proycosto = this.proycosto.trim();
					
				}
				else {
					this.errorAdicional = true;
					this.msg ="Costo Proyecto: Ingresar solo números";
					this.nomComponente += "proycosto-4-Ingresar solo números,";
				}

			}
			
		}
			
		
		if(this.proyfecha == null ||  this.proyfecha == "" || this.proyfecha.trim().length() == 0 ) {
			this.errorAdicional = true;
			this.msg = "Agregar fecha del proyecto";
			this.nomComponente += "proyfecha-5-Ingresar Fecha Requerida,";
		}else {
			
			Matcher match = valtexto.matcher(this.proyfecha);
			if (match.find()) {
				this.errorAdicional = true;
				this.msg = "Fecha Requerida: Ingresar solo números";
				this.nomComponente += "proyfecha-5-Ingresar solo números,";

			} else {
				if( this.proyfecha.matches("[0-9]*") ) {
					this.proyfecha = this.proyfecha.trim();
					
				}
				else {
					this.errorAdicional = true;
					this.msg ="Fecha Requerida: Ingresar solo números";
					this.nomComponente += "proyfecha-5-Ingresar solo números,";
					
				}

			}
			
		}
		
				
		
		if(this.proyfechaMaxima == null ||  this.proyfechaMaxima == "" || this.proyfechaMaxima.trim().length() == 0 ) {
			this.errorAdicional = true;
			this.msg = "Agregar fecha del proyecto";
			this.nomComponente += "proyfechaMaxima-6-Ingresar Fecha Máxima Requerida,";
		}else {
			
			Matcher match = valtexto.matcher(this.proyfechaMaxima);
			if (match.find()) {
				this.errorAdicional = true;
				this.msg = "Fecha Máxima: Ingresar solo números";
				this.nomComponente += "proyfechaMaxima-6-Ingresar solo números,";

			} else {
				if( this.proyfechaMaxima.matches("[0-9]*") ) {
					this.proyfechaMaxima = this.proyfechaMaxima.trim();
					
				}
				else {
					this.errorAdicional = true;
					this.msg ="Fecha Máxima: Ingresar solo números";
					this.nomComponente += "proyfechaMaxima-6-Ingresar solo números,";
					
				}

			}
			
		}
		
			

}
	
	
	public String getNomComponente() {
		return nomComponente;
	}


	public void setNomComponente(String nomComponente) {
		this.nomComponente = nomComponente;
	}


	public List<String> getLerrorAdicional() {
		return lerrorAdicional;
	}


	public void setLerrorAdicional(List<String> lerrorAdicional) {
		this.lerrorAdicional = lerrorAdicional;
	}


	public boolean isErrorAdicional() {
		return errorAdicional;
	}
	public void setErrorAdicional(boolean errorAdicional) {
		this.errorAdicional = errorAdicional;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getProyDescripcion() {
		return proyDescripcion;
	}
	public void setProyDescripcion(String proyDescripcion) {
		this.proyDescripcion = proyDescripcion;
	}
	public String getProyRecursos() {
		return proyRecursos;
	}
	public void setProyRecursos(String proyRecursos) {
		this.proyRecursos = proyRecursos;
	}
	public String getProyclaveProyecto() {
		return proyclaveProyecto;
	}
	public void setProyclaveProyecto(String proyclaveProyecto) {
		this.proyclaveProyecto = proyclaveProyecto;
	}
	public String getProyBP() {
		return proyBP;
	}
	public void setProyBP(String proyBP) {
		this.proyBP = proyBP;
	}
	public String getProycosto() {
		return proycosto;
	}
	public void setProycosto(String proycosto) {
		this.proycosto = proycosto;
	}
	public String getProyfecha() {
		return proyfecha;
	}
	public void setProyfecha(String proyfecha) {
		this.proyfecha = proyfecha;
	}
	public String getProyfechaMaxima() {
		return proyfechaMaxima;
	}
	public void setProyfechaMaxima(String proyfechaMaxima) {
		this.proyfechaMaxima = proyfechaMaxima;
	}
	public String getProyestatus() {
		return proyestatus;
	}
	public void setProyestatus(String proyestatus) {
		this.proyestatus = proyestatus;
	}
	public String getProyportafolio() {
		return proyportafolio;
	}
	public void setProyportafolio(String proyportafolio) {
		this.proyportafolio = proyportafolio;
	}
	public String getProycircuito() {
		return proycircuito;
	}
	public void setProycircuito(String proycircuito) {
		this.proycircuito = proycircuito;
	}
	public String getProyiniciativa() {
		return proyiniciativa;
	}
	public void setProyiniciativa(String proyiniciativa) {
		this.proyiniciativa = proyiniciativa;
	}
	public String getProyobjetivo() {
		return proyobjetivo;
	}
	public void setProyobjetivo(String proyobjetivo) {
		this.proyobjetivo = proyobjetivo;
	}
	public String getProyaccion() {
		return proyaccion;
	}
	public void setProyaccion(String proyaccion) {
		this.proyaccion = proyaccion;
	}
	public String getProymeta() {
		return proymeta;
	}
	public void setProymeta(String proymeta) {
		this.proymeta = proymeta;
	}
	public String getProycostos() {
		return proycostos;
	}
	public void setProycostos(String proycostos) {
		this.proycostos = proycostos;
	}
	public String getProygasto() {
		return proygasto;
	}
	public void setProygasto(String proygasto) {
		this.proygasto = proygasto;
	}
	public String getProypresupuesto() {
		return proypresupuesto;
	}
	public void setProypresupuesto(String proypresupuesto) {
		this.proypresupuesto = proypresupuesto;
	}
	
	

}
