package mx.axxib.gpi.ctrll;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CargaReporte {

	@GetMapping(value = {"/carga", "/carga"})
	public String carga(Model model)  {
		return "view_carga/cargaReporte";
	}
	
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {

		String msg = "";
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				File serverFile = new File("C:\\Reportes"
						+ File.separator + file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				msg = "Cargado correctamente";
			} catch (Exception e) {
				msg = "Su carga ha fallado";
			}
		} else {
			msg = "Debe elegir un archivo";
		}
		
		model.addAttribute("mensaje", msg);
		return "view_carga/cargaReporte";
		
	}
}
