package mx.axxib.gpi.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AltaPortafolioForm {
	
	private String clavePortafolio;	
	private String claveBPPortafolio;
	private String descripcionPortafolio;
	private String bpPortafolio;
	private String estatusPortafolio;
	
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
	private boolean numerosError = false;	
	private boolean textoEror = false;	
	private boolean caracterError = false;
	private String msg = null;
	private String nomComponente=null;
	private String msgComponente = null;
	private List<String> lerrorAdicional;
	
	private List<String> lmsgObjetos;
	
	
	String idProyecto=null;
	String idPortafolio = null;
	
	Pattern valtexto = Pattern.compile(
			"\\/+|\\)+|\\(+|\\¿+|\\?+|\\°+|\\¬+|\\|+|\\!+|\\#+|\\$+|\\%+|\\&+|\\+|\\=+|\\’+|\\¡+|\\++|\\*+|\\~+|\\[+|\\]|\\{+|\\}+|\\^+|\\<+|\\>+|\\\"");
	
	Pattern patronTexto = Pattern.compile("[a-zA-ZñÑ\\s]*$");
	
	public AltaPortafolioForm() {
		this.msg = "";
		this.nomComponente="";
		this.msgComponente ="";
	}
	
			
	
	
	
	/**
	 * Valida datos de ingreso para dar de alta un portafolio
	 * 
	 * @detalle Elimina espacios en cadenas: 'clavePortafolio', 'claveBPPortafolio','descripcionPortafolio'
	 *          Valida que los datos ingresado no tengan caracteres especiales.
	 *          Valida que los datos ingresados no sean numeros.
	 *  @return Regresa un mensaje (msg) indicando la descripcion del error
	 *          Regresa el nombre del id (nomComponente) y  de la caja de texto del JSP (revisar altaPortafolio.js)
	 *          EJEMPLO: 'portClave-1-Agregar Clave Portafolio'
	 *          DONDE:
	 *          portClave --> NOMBRE DEL ID DEL COMPONENTE EN LA JSP
	 *                  1 --> NUMERO DEL ID DEL COMPONENETE QUE MOSTRARA EL MENSAJE EN LA JSP
	 *         Agregar Clave Portafolio  --> MENSAJE QUE MOSTRA LA ALERTA.       
	 */
	
    public void validacionPortafolio() {
    	
    
		if (this.clavePortafolio == null || this.clavePortafolio.trim() == "" || this.clavePortafolio.trim().length() == 0) {
			this.errorAdicional = true;
			this.msg += " Agregar la clave del portafolio";
			this.nomComponente += "portClave-1-Agregar Clave Portafolio,";
		} else {			
			Matcher match = valtexto.matcher(this.clavePortafolio);
			if (match.find()) {
				this.errorAdicional = true;
				this.msg += " No debe tener caracteres especiales";
				this.nomComponente += "portClave-1-No ingresar caracteres,";
				

			} else {
					this.clavePortafolio = this.clavePortafolio.trim();
				

			}
		}
		
		if (this.claveBPPortafolio == null || this.claveBPPortafolio.trim() == "" || this.claveBPPortafolio.trim().length() == 0) {
			this.errorAdicional = true;
			this.msg += " Agregar la clave BP del portafolio";
			this.nomComponente += "portClaveBP-2-Agregar Clave BP,";
			this.msgComponente += "Agregar Clave,";
		} else {			
			Matcher match = valtexto.matcher(this.claveBPPortafolio);
			if (match.find()) {
				this.errorAdicional = true;
				this.msg += " No debe tener caracteres especiales";
				this.nomComponente += "portClaveBP-2-No ingresar caracteres,";				

			} else {
					this.claveBPPortafolio = this.claveBPPortafolio.trim();
				}			
		}
			
			
		
		
		if (this.descripcionPortafolio == null || this.descripcionPortafolio.trim() == "" || this.descripcionPortafolio.trim().length() == 0) {
			this.errorAdicional = true;
			this.msg += " Agregar descripción del Portafolio";
			this.nomComponente += "portDescripcion-3-Agregar Descripción del Portafolio,";
		} else {
						
			Matcher match = valtexto.matcher(this.descripcionPortafolio);
			if (match.find()) {
				this.errorAdicional = true;
				this.msg += " No debe tener caracteres especiales";
				this.nomComponente += "portDescripcion-3-No ingresar caracteres,";				

			} else {
					this.descripcionPortafolio = this.descripcionPortafolio.trim();
				
			}
		}
		   
		
		if (this.proyclaveProyecto == null || this.proyclaveProyecto.trim() == "" || this.proyclaveProyecto.trim().length() == 0) {
			this.errorAdicional = true;
			this.msg += " Agregar clave del proyecto";
			this.nomComponente += "portClaveProy-0-Agregar Clave Proyecto,";
		} else {
			Matcher match = valtexto.matcher(this.proyclaveProyecto);
			if (match.find()) {
				this.errorAdicional = true;
				this.msg += " Clave Proyecto: No debe tener caracteres especiales";
				this.nomComponente += "portClaveProy-0-No agregar caracteres especiales,";

			} else {
				this.proyclaveProyecto = this.proyclaveProyecto.trim();
				
			}
		}
		
		
		
		if(this.proycosto == null ||  this.proycosto == "" || this.proycosto.trim().length() == 0 ) {
			this.errorAdicional = true;
			this.msg = " Agregar costo del proyecto";
			this.nomComponente += "portCostoProy-1-Agregar Costo del Proyecto,";
		}else {
			
					this.proycosto = this.proycosto.trim();	
			
		}
			
		
		if(this.proyfecha == null ||  this.proyfecha == "" || this.proyfecha.trim().length() == 0 ) {
			this.errorAdicional = true;
			this.msg = " Agregar fecha del proyecto";
			this.nomComponente += "portPeriodoProy-2-Agregar Periodo Requerido,";
		}else {
			
			Matcher match = valtexto.matcher(this.proyfecha);
			if (match.find()) {
				this.errorAdicional = true;
				this.msg = "Fecha Requerida: Ingresar solo números";
				this.nomComponente += "portPeriodoProy-2-Ingresar solo números,";

			} else {
				if( this.proyfecha.matches("[0-9]*") ) {
					this.proyfecha = this.proyfecha.trim();
					
				}
				else {
					this.errorAdicional = true;
					this.msg ="Fecha Requerida: Ingresar solo números";
					this.nomComponente += "portPeriodoProy-2-Ingresar solo números,";
					
				}

			}
			
		}
		
				
		
		if(this.proyfechaMaxima == null ||  this.proyfechaMaxima == "" || this.proyfechaMaxima.trim().length() == 0 ) {
			this.errorAdicional = true;
			this.msg = " Agregar fecha del proyecto";
			this.nomComponente += "portPeriodoMaxProy-3-Agregar Periodo Máximo,";
		}else {
			
			Matcher match = valtexto.matcher(this.proyfechaMaxima);
			if (match.find()) {
				this.errorAdicional = true;
				this.msg = " Fecha Máxima: Ingresar solo números";
				this.nomComponente += "portPeriodoMaxProy-3-Ingresar solo números,";

			} else {
				if( this.proyfechaMaxima.matches("[0-9]*") ) {
					this.proyfechaMaxima = this.proyfechaMaxima.trim();
					
				}
				else {
					this.errorAdicional = true;
					this.msg ="Fecha Máxima: Ingresar solo números";
					this.nomComponente += "portPeriodoMaxProy-3-Ingresar solo números,";
					
				}

			}
			
		}
				
		
		if (this.proyDescripcion == null || this.proyDescripcion.trim() == "" || this.proyDescripcion.trim().length() == 0) {
			this.errorAdicional = true;
			this.msg += " Agregar la descripción del proyecto";
			this.nomComponente += "portDescripProy-4-Agregar Descripción Proyecto,";
		} else {			
			
			Matcher match = valtexto.matcher(this.proyDescripcion);
			if (match.find()) {
				this.errorAdicional = true;
				this.msg += " Descripción: No debe tener caracteres especiales";
				this.nomComponente += "portDescripProy-4-No agregar caracteres especiales,";

			} else {
				this.proyDescripcion = this.proyDescripcion.trim();
			}
		}
		
		
		if (this.proyRecursos == null || this.proyRecursos.trim() == "" || this.proyRecursos.trim().length() == 0) {
			this.errorAdicional = true;
			this.msg += " Agregar recursos del proyecto";
			this.nomComponente += "portRecProy-5-Agregar Recurso del Proyecto,";
		} else {
			
			Matcher match = valtexto.matcher(this.proyRecursos);
			if (match.find()) {
				this.errorAdicional = true;
				this.msg += " No debe tener caracteres especiales";
				this.nomComponente += "portRecProy-5-No ingresar caracteres,";	
				

			} else {
				Matcher validarnombre = patronTexto.matcher(this.proyRecursos);
				if (validarnombre.matches()) {
					this.proyRecursos = this.proyRecursos.trim();
				} else {
					this.errorAdicional = true;
					this.msg += " No ingresar numeros ";
					this.nomComponente += "portRecProy-5-No ingresar numeros,";
				}

			}
			
		}
		
		

}
	
	public void validacionProyecto() {
		
		if (this.proyDescripcion == null || this.proyDescripcion.trim() == "" || this.proyDescripcion.trim().length() == 0) {
			this.errorAdicional = true;
			this.msg += " Agregar la descripción del proyecto";
			this.nomComponente += "portClaveProy,";
		} else {
			Matcher match = valtexto.matcher(this.proyDescripcion);
			if (match.find()) {
				this.errorAdicional = true;
				this.msg += " Descripción: No debe tener caracteres especiales";

			} else {
				this.proyDescripcion = this.proyDescripcion.trim();
			}
		}
		
		if (this.proyRecursos == null || this.proyRecursos.trim() == "" || this.proyRecursos.trim().length() == 0) {
			this.errorAdicional = true;
			this.msg += " Agregar recursos del proyecto";
		} else {
			Matcher match = valtexto.matcher(this.proyRecursos);
			if (match.find()) {
				this.errorAdicional = true;
				this.msg += " Recursos: No debe tener caracteres especiales";

			} else {
				this.proyRecursos = this.proyRecursos.trim();
			}
		}
		
		if (this.proyclaveProyecto == null || this.proyclaveProyecto.trim() == "" || this.proyclaveProyecto.trim().length() == 0) {
			this.errorAdicional = true;
			this.msg += " Agregar clave del proyecto";
		} else {
			Matcher match = valtexto.matcher(this.proyclaveProyecto);
			if (match.find()) {
				this.errorAdicional = true;
				this.msg += " Clave Proyecto: No debe tener caracteres especiales";

			} else {
				this.proyclaveProyecto = this.proyclaveProyecto.trim();
			}
		}
		
		
		if(this.proycosto == null ||  this.proycosto == "" || this.proycosto.trim().length() == 0 ) {
			this.errorAdicional = true;
			this.msg = " Agregar costo del proyecto";
		}else {
			
			Matcher match = valtexto.matcher(this.proycosto);
			if (match.find()) {
				this.errorAdicional = true;
				this.msg = "Costo Proyecto: Ingresar solo números";

			} else {
				if( this.proycosto.matches("[0-9]*") ) {
					this.proycosto = this.proycosto.trim();
					
				}
				else {
					this.errorAdicional = true;
					this.msg ="Costo Proyecto: Ingresar solo números";
					
				}

			}
			
		}
			
		
		if(this.proyfecha == null ||  this.proyfecha == "" || this.proyfecha.trim().length() == 0 ) {
			this.errorAdicional = true;
			this.msg = " Agregar fecha del proyecto";
		}else {
			
			Matcher match = valtexto.matcher(this.proyfecha);
			if (match.find()) {
				this.errorAdicional = true;
				this.msg = "Fecha Requerida: Ingresar solo números";

			} else {
				if( this.proyfecha.matches("[0-9]*") ) {
					this.proyfecha = this.proyfecha.trim();
					
				}
				else {
					this.errorAdicional = true;
					this.msg ="Fecha Requerida: Ingresar solo números";
					
				}

			}
			
		}
		
				
		
		if(this.proyfechaMaxima == null ||  this.proyfechaMaxima == "" || this.proyfechaMaxima.trim().length() == 0 ) {
			this.errorAdicional = true;
			this.msg = " Agregar fecha del proyecto";
		}else {
			
			Matcher match = valtexto.matcher(this.proyfechaMaxima);
			if (match.find()) {
				this.errorAdicional = true;
				this.msg = " Fecha Máxima: Ingresar solo números";

			} else {
				if( this.proyfechaMaxima.matches("[0-9]*") ) {
					this.proyfechaMaxima = this.proyfechaMaxima.trim();
					
				}
				else {
					this.errorAdicional = true;
					this.msg ="Fecha Máxima: Ingresar solo números";
					
				}

			}
			
		}
		
 }

	
	public String getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getIdPortafolio() {
		return idPortafolio;
	}

	public void setIdPortafolio(String idPortafolio) {
		this.idPortafolio = idPortafolio;
	}
	
	
	public boolean isTextoEror() {
		return textoEror;
	}

	public void setTextoEror(boolean textoEror) {
		this.textoEror = textoEror;
	}

	public boolean isNumerosError() {
		return numerosError;
	}

	public void setNumerosError(boolean numerosError) {
		this.numerosError = numerosError;
	}

	public boolean isCaracterError() {
		return caracterError;
	}

	public void setCaracterError(boolean caracterError) {
		this.caracterError = caracterError;
	}

	

	public String getMsgComponente() {
		return msgComponente;
	}

	public void setMsgComponente(String msgComponente) {
		this.msgComponente = msgComponente;
	}

	public String getNomComponente() {
		return nomComponente;
	}


	public void setNomComponente(String nomComponente) {
		this.nomComponente = nomComponente;
	}

    

	public List<String> getLmsgObjetos() {
		return lmsgObjetos;
	}

	public void setLmsgObjetos(List<String> lmsgObjetos) {
		this.lmsgObjetos = lmsgObjetos;
	}

	public List<String> getLerrorAdicional() {
		return lerrorAdicional;
	}

	public void setLerrorAdicional(List<String> lerrorAdicional) {
		this.lerrorAdicional = lerrorAdicional;
	}

	public String getClaveBPPortafolio() {
		return claveBPPortafolio;
	}

	public void setClaveBPPortafolio(String claveBPPortafolio) {
		this.claveBPPortafolio = claveBPPortafolio;
	}

	public String getClavePortafolio() {
		return clavePortafolio;
	}

	public void setClavePortafolio(String clavePortafolio) {
		this.clavePortafolio = clavePortafolio;
	}
	public String getDescripcionPortafolio() {
		return descripcionPortafolio;
	}

	public void setDescripcionPortafolio(String descripcionPortafolio) {
		this.descripcionPortafolio = descripcionPortafolio;
	}

	public String getBpPortafolio() {
		return bpPortafolio;
	}

	public void setBpPortafolio(String bpPortafolio) {
		this.bpPortafolio = bpPortafolio;
	}





	public String getEstatusPortafolio() {
		return estatusPortafolio;
	}





	public void setEstatusPortafolio(String estatusPortafolio) {
		this.estatusPortafolio = estatusPortafolio;
	}





	public Pattern getValtexto() {
		return valtexto;
	}





	public void setValtexto(Pattern valtexto) {
		this.valtexto = valtexto;
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
