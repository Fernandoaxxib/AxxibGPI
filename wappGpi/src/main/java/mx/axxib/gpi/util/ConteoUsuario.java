package mx.axxib.gpi.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class ConteoUsuario {
	private static final Logger LOGGER = LogManager.getLogger(ConteoUsuario.class);

	

	public static void crearRemplazar(String datoUsuario, String valorAnterior, String nuevoValor) {

		FileReader fr = null;
		BufferedReader br = null;
		String registroUsuario = null;
		boolean usuarioEncontrado = false;
		File file = null;
		String ruta = "C:\\UsuariosAcceso\\usuariosConteoAcceso.txt";


		try {

			try {

				file = new File(ruta);
				fr = new FileReader(file);
				br = new BufferedReader(fr);

				while ((registroUsuario = br.readLine()) != null)
					if (registroUsuario.toUpperCase().trim().contains(datoUsuario.toUpperCase())) {

						usuarioEncontrado = true;

						break;

					}

			} catch (Exception e) {
				e.printStackTrace();
				LOGGER.error("# ERROR EN LECUTA DE CONTEO USUARIO - ERROR - MENSAJE:{}", e.toString());
			} finally {

				try {
					if (null != fr) {
						fr.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
					LOGGER.error("# ERROR EN LECTURA DE CONTEO USUARIO - ERROR - MENSAJE:{}", e2.toString());
				}
			}

			if (usuarioEncontrado) {

				BufferedReader fileReader = new BufferedReader(new FileReader(ruta));
				StringBuffer inputBuffer = new StringBuffer();
				String line;

				while ((line = fileReader.readLine()) != null) {
					inputBuffer.append(line);
					inputBuffer.append('\n');
				}

				fileReader.close();
				String inputStr = inputBuffer.toString();

				inputStr = inputStr.replace(datoUsuario + valorAnterior, datoUsuario + nuevoValor);

				FileOutputStream fileOut = new FileOutputStream(ruta);
				fileOut.write(inputStr.getBytes());
				fileOut.close();
				
				 LOGGER.info("# ARCHIVO ACTUALIZA USUARIO -   USUARIOFINAL :{}", inputStr.getBytes());

			} else {

				FileWriter fw = new FileWriter(file, true);
				BufferedWriter bw = new BufferedWriter(fw);

				bw.write(datoUsuario + "1" + "\n");
				bw.close();
				
				 LOGGER.info("# ARCHIVO ACTUALIZA USUARIO -   USUARIOFINAL :{}", datoUsuario + "1");
			}

		} catch (Exception e) {
			LOGGER.error("# ERROR EN EL ARCHIVO DE CONTEO USUARIO - ERROR - MENSAJE:{}", e.toString());
		}
	}
	
	

}
