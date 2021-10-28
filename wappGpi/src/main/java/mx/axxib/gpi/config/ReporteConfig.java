package mx.axxib.gpi.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import mx.axxib.gpi.ctrll.CargaReporte;
import mx.axxib.gpi.eml.ReporteJson;

@Configuration
public class ReporteConfig {
	private static final Logger LOGGER = LogManager.getLogger(ReporteConfig.class);

	private static List<ReporteJson> reportes = null;
	
	public static Environment env;

	public static List<ReporteJson> getReportes() throws Exception{
		if (reportes == null) {
			try {
				
				JSONParser parser = new JSONParser();
				JSONObject obj;

				obj = (JSONObject) parser.parse(new InputStreamReader(
						new FileInputStream(ReporteConfig.env.getProperty("ruta.reportes")), "UTF-8"));

				JSONArray a = (JSONArray) obj.get("Tipos");
				reportes = new ArrayList<ReporteJson>();
				for (Object o : a) {
					JSONObject person = (JSONObject) o;
					ReporteJson rep = new ReporteJson();

					rep.setId((String) person.get("id"));
					rep.setDescripcion((String) person.get("descripcion"));
					rep.setArchivo((String) person.get("archivo"));
					reportes.add(rep);
				}
			} catch (Exception e) {
				LOGGER.error("# ERROR - CARGA DE REPORTES JSON - MENSAJE:{}", e.toString());
				throw e;
			}
		}
		return reportes;
	}
}
