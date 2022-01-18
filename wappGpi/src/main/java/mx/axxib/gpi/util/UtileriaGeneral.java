package mx.axxib.gpi.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UtileriaGeneral {
	private static final Logger LOGGER = LogManager.getLogger(UtileriaGeneral.class);
	public static  List<String> generaLista(String cadena){
		String[] strArr = null;
		strArr = cadena.split(","); 
		ArrayList<String> list = new ArrayList<String >(Arrays.asList(strArr));	
		return list;
		
	}
	
	public static String generaClavePortafolio (String idPortafolio) {
		String clavePortafolio = null;
		String fechaHora= null;
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		fechaHora = String.valueOf(formatter.format(date)).replace("-", "");
		fechaHora = fechaHora.replace(" ", "");
		clavePortafolio = "PPP"+String.valueOf(fechaHora).replace(":", "")+idPortafolio;
		LOGGER.info("# GENERAR CLAVE PORTAFOLIO - CLAVE:{}", clavePortafolio);
		return clavePortafolio;
	}
	
	public static String generaClaveProyecto (String idProyecto) {
		String claveProyecto = null;
		String fechaHora= null;
		Date date = new Date();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		fechaHora = String.valueOf(formatter.format(date)).replace("-", "");
		fechaHora = fechaHora.replace(" ", "");
		
		claveProyecto = "P"+String.valueOf(fechaHora).replace(":", "")+"_PPI"+idProyecto;
		LOGGER.info("# GENERAR CLAVE PROYECTO - CLAVE:{}", claveProyecto);
		
		return claveProyecto;
	}

}
