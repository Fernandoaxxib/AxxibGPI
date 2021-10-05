package mx.axxib.gpi.ctrll;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CargaReporte {

	@GetMapping(value = { "/carga", "/carga" })
	public String carga(Model model) {
		return "view_carga/cargaReporte";
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("action") String action,
			Model model) {

		String msg = "";
		String error = "";
		if (!file.isEmpty()) {
			try {
				String nombre = file.getOriginalFilename();
				boolean valido = false;
				
				if (action.contains("Operaciones")) {
					if(nombre.toUpperCase().equals("BP_OPERACIONES.XLSX")) {
						valido = true;
					} else {
						error = "El archivo para Operaciones debe llamarse BP_OPERACIONES.XLSX";
					}
				} else if (action.contains("Inversiones")) {
					if(nombre.toUpperCase().equals("BP_INVERSIONES.XLSX")) {
						valido = true;
					} else {
						error = "El archivo para Inversiones debe llamarse BP_INVERSIONES.XLSX";
					}
				} else if (action.contains("Comercial")) {
					if(nombre.toUpperCase().equals("BP_COMERCIAL.XLSX")) {
						valido = true;
					} else {
						error = "El archivo para Comercial debe llamarse BP_COMERCIAL.XLSX";
					}
				} else if (action.contains("Administración")) {
					if(nombre.toUpperCase().equals("BP_ADMINISTRACION.XLSX")) {
						valido = true;
					} else {
						error = "El archivo para Administración debe llamarse BP_ADMINISTRACION.XLSX";
					}
				}
				
				if (valido) {
					
					byte[] bytes = file.getBytes();

					/*
					 * File serverFile = new File("C:\\Reportes" + File.separator +
					 * file.getOriginalFilename()); BufferedOutputStream stream = new
					 * BufferedOutputStream( new FileOutputStream(serverFile)); stream.write(bytes);
					 * stream.close();
					 */

					msg = "Archivo cargado correctamente";
				} 
			} catch (Exception e) {
				error = "Se produjo un error inesperado";
			}
		} else {
			error = "Debe elegir un archivo";
		}

		model.addAttribute("mensaje", msg);
		model.addAttribute("error", error);
		return "view_carga/cargaReporte";

	}

}
