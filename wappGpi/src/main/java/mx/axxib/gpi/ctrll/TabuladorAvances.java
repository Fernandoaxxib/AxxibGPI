package mx.axxib.gpi.ctrll;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import mx.axxib.gpi.eml.Avance;
import mx.axxib.gpi.eml.Portafolio;
import mx.axxib.gpi.eml.Registro;

@Controller
public class TabuladorAvances {

	@RequestMapping(value = "/tab", method = RequestMethod.POST)
	public String carga2(@RequestParam String idPortafolio, Model model) {
		String s = idPortafolio;
		String portafolio = null;

		switch (s) {
		case "1": {
			portafolio = "BP OPERACIONES";
			break;
		}
		case "2": {
			portafolio = "BP INVERSIONES";
			break;
		}
		case "3": {
			portafolio = "BP COMERCIAL";
			break;
		}
		case "4": {
			portafolio = "BP ADMINISTRACIÓN Y FINANZAS";
			break;
		}
		default: {
			portafolio = "";
			break;
		}
		}

		model.addAttribute("idPortafolio",idPortafolio);
		model.addAttribute("portafolio",portafolio);
		return "view_tabulador/tabuladorAvances";
	}

	@RequestMapping(value = "/tabulador", method = RequestMethod.POST)
	public String tabulador(@RequestParam String portafolio,@RequestParam String idPortafolio, Model model) {
		Portafolio portafol= new Portafolio();
				
		portafol.setColumnas(getColumnas());
		portafol.setIdPortafolio(idPortafolio);
		portafol.setNombrePortafolio(portafolio);
		portafol.setListaRegistros(cargarDatos());
		
		model.addAttribute("portafolio",portafolio);
		model.addAttribute("portafol",portafol);
		
		return "view_tabulador/tabuladorAvances";
	}
	
	public List<Registro> cargarDatos(){		
		List<Registro> registros= new ArrayList<>();
		
        //***************************registros de prueba
		Registro p = new Registro();
		p.setIniciativa("Mejora en la calidad de los servicios via canales digitales y oficinas de atención");
		p.setObjetivo("Contar con una base de información de clientes completa y confiable");
		p.setAccionEstrategica("Campaña acelerada de actualización de datos de contacto (primera fase iniciada)");
		p.setProyecto("Alcanzar datos completos de contacto de teléfono y email de segmento preferente");
		p.setIdPresupuesto(0);
		p.setEsTituloBloque(1);
		p.setOrden(1);
		p.setFechaRequerida("");
		p.setCvesRecursos("");
		p.setCveBp("");
		p.setCostoPpto(Double.valueOf(0));

		Registro p1 = new Registro();
		p1.setIniciativa("Mejora en la calidad de los servicios via canales digitales y oficinas de atención");
		p1.setObjetivo("Contar con una base de información de clientes completa y confiable");
		p1.setAccionEstrategica("Campaña acelerada de actualización de datos de contacto (primera fase iniciada)");
		p1.setProyecto("Investigación de mercado");
		p1.setIdPresupuesto(4);
		p1.setEsTituloBloque(0);
		p1.setOrden(2);
		p1.setEsNormativo(0);
		p1.setFechaRequerida("2022");
		p1.setCvesRecursos("");
		p1.setCveBp("JAM");
		p1.setCostoPpto(Double.valueOf(502700));
		
		Registro p2 = new Registro();
		p2.setIniciativa("Mejora en la calidad de los servicios via canales digitales y oficinas de atención");
		p2.setObjetivo("Contar con una base de información de clientes completa y confiable");
		p2.setAccionEstrategica("Campaña acelerada de actualización de datos de contacto (primera fase iniciada)");
		p2.setProyecto("Licenciamiento Data Science");
		p2.setIdPresupuesto(10);
		p2.setEsTituloBloque(0);
		p2.setOrden(3);
		p2.setEsNormativo(0);
		p2.setFechaRequerida("2022");
		p2.setCvesRecursos("");
		p2.setCveBp("LMM");
		p2.setCostoPpto(Double.valueOf(1200000));
		
		Registro p3 = new Registro();
		p3.setIniciativa("Mejora en la calidad de los servicios via canales digitales y oficinas de atención");
		p3.setObjetivo("Contar con una base de información de clientes completa y confiable");
		p3.setAccionEstrategica("Campaña acelerada de actualización de datos de contacto (primera fase iniciada)");
		p3.setProyecto("Licenciamiento explotación de datos");
		p3.setIdPresupuesto(12);
		p3.setEsTituloBloque(0);
		p3.setOrden(4);
		p3.setEsNormativo(0);
		p3.setFechaRequerida("2021");
		p3.setCvesRecursos("");
		p3.setCveBp("LMM");
		p3.setCostoPpto(Double.valueOf(300000));
		
		Registro p4 = new Registro();
		p4.setIniciativa("Mejora en la calidad de los servicios via canales digitales y oficinas de atención");
		p4.setObjetivo("Contar con una base de información de clientes completa y confiable");
		p4.setAccionEstrategica("Campaña acelerada de actualización de datos de contacto (primera fase iniciada)");
		p4.setProyecto("CDP.- Aplicación auxiliar al CRM");
		p4.setIdPresupuesto(14);
		p4.setEsTituloBloque(0);
		p4.setOrden(5);
		p4.setEsNormativo(0);
		p4.setFechaRequerida("2022");
		p4.setCvesRecursos("");
		p4.setCveBp("LMM");
		p4.setCostoPpto(Double.valueOf(2160000));
		
		Registro p5 = new Registro();
		p5.setIniciativa("Mejora en la calidad de los servicios via canales digitales y oficinas de atención");
		p5.setObjetivo("Contar con una base de información de clientes completa y confiable");
		p5.setAccionEstrategica("Campaña acelerada de actualización de datos de contacto (primera fase iniciada)");
		p5.setProyecto("CMS");
		p5.setIdPresupuesto(15);
		p5.setEsTituloBloque(0);
		p5.setOrden(6);
		p5.setEsNormativo(0);
		p5.setFechaRequerida("2022");
		p5.setCvesRecursos("");
		p5.setCveBp("LMM");
		p5.setCostoPpto(Double.valueOf(1010000));
		
		Registro p6 = new Registro();
		p6.setIniciativa("Mejora en la calidad de los servicios via canales digitales y oficinas de atención");
		p6.setObjetivo("Contar con una base de información de clientes completa y confiable");
		p6.setAccionEstrategica("Campaña acelerada de actualización de datos de contacto (primera fase iniciada)");
		p6.setProyecto("Clientes Prevalidados");
		p6.setIdPresupuesto(18);
		p6.setEsTituloBloque(0);
		p6.setOrden(7);
		p6.setEsNormativo(0);
		p6.setFechaRequerida("2022");
		p6.setCvesRecursos("");
		p6.setCveBp("JAM");
		p6.setCostoPpto(Double.valueOf(70000));
		
		Registro p7 = new Registro();
		p7.setIniciativa("Mejora en la calidad de los servicios via canales digitales y oficinas de atención");
		p7.setObjetivo("Contar con una base de información de clientes completa y confiable");
		p7.setAccionEstrategica("Campaña acelerada de actualización de datos de contacto (primera fase iniciada)");
		p7.setProyecto("Equipo de cómputo para análisis de base de datos");
		p7.setIdPresupuesto(21);
		p7.setEsTituloBloque(0);
		p7.setOrden(8);
		p7.setEsNormativo(0);
		p7.setFechaRequerida("2022");
		p7.setCvesRecursos("");
		p7.setCveBp("LMM");
		p7.setCostoPpto(Double.valueOf(60000));
		
		Registro p8 = new Registro();
		p8.setIniciativa("Mejora en la calidad de los servicios via canales digitales y oficinas de atención");
		p8.setObjetivo("Contar con una base de información de clientes completa y confiable");
		p8.setAccionEstrategica("Campaña acelerada de actualización de datos de contacto (primera fase iniciada)");
		p8.setProyecto("Software para manipulación de bases de datos");
		p8.setIdPresupuesto(22);
		p8.setEsTituloBloque(0);
		p8.setOrden(9);
		p8.setEsNormativo(0);
		p8.setFechaRequerida("2022");
		p8.setCvesRecursos("");
		p8.setCveBp("LMM");
		p8.setCostoPpto(Double.valueOf(10000));
		
		Registro p9 = new Registro();
		p9.setIniciativa("Mejora en la calidad de los servicios via canales digitales y oficinas de atención");
		p9.setObjetivo("Contar con una base de información de clientes completa y confiable");
		p9.setAccionEstrategica("Campaña acelerada de actualización de datos de contacto (primera fase iniciada)");
		p9.setProyecto("CRM Acciones Emergentes");
		p9.setIdPresupuesto(53);
		p9.setEsTituloBloque(0);
		p9.setOrden(10);
		p9.setEsNormativo(0);
		p9.setFechaRequerida("2021");
		p9.setCvesRecursos("");
		p9.setCveBp("GSZ");
		p9.setCostoPpto(Double.valueOf(1600000));
		//**********************************************
		List<Avance> avances= new ArrayList<>();
		Avance a= new Avance();
		a.setIdentificador(0);
		a.setPeriodo("");
		avances.add(a);
		
		List<Avance> avances2= new ArrayList<>();
		Avance a2= new Avance();
		a2.setIdentificador(0);
		a2.setPeriodo("T1(MAR 2022)");
		avances2.add(a2);
		
		List<Avance> avances3= new ArrayList<>();
		Avance a3= new Avance();
		a3.setIdentificador(0);
		a3.setPeriodo("");
		avances3.add(a3);
		
		List<Avance> avances4= new ArrayList<>();
		Avance a41= new Avance();
		a41.setIdentificador(4);
		a41.setPeriodo("T3(JUL 2021)");
		
		Avance a42= new Avance();
		a42.setIdentificador(4);
		a42.setPeriodo("T3(AGS 2021)");
		
		Avance a43= new Avance();
		a43.setIdentificador(0);
		a43.setPeriodo("T3(SEP 2021)");
		
		Avance a44= new Avance();
		a44.setIdentificador(0);
		a44.setPeriodo("T4(OCT 2021)");
		
		Avance a45= new Avance();
		a45.setIdentificador(0);
		a45.setPeriodo("T4(NOV 2021)");
		
		Avance a46= new Avance();
		a46.setIdentificador(0);
		a46.setPeriodo("T4(DIC 2021)");
		
		Avance a47= new Avance();
		a47.setIdentificador(0);
		a47.setPeriodo("");
		
		avances4.add(a41);
		avances4.add(a42);
		avances4.add(a43);
		avances4.add(a44);
		avances4.add(a45);
		avances4.add(a46);
		avances4.add(a47);


		List<Avance> avances7= new ArrayList<>();
		Avance a71= new Avance();
		a71.setIdentificador(0);
		a71.setPeriodo("T1(ENE 2022)");
		
		Avance a72= new Avance();
		a72.setIdentificador(0);
		a72.setPeriodo("T1(FEB 2022)");
		
		
		Avance a73= new Avance();
		a73.setIdentificador(0);
		a73.setPeriodo("T1(MAR 2022)");
		
		
		avances7.add(a71);
		avances7.add(a72);
		avances7.add(a73);
		
		List<Avance> avances8= new ArrayList<>();
		Avance a81= new Avance();
		a81.setIdentificador(0);
		a81.setPeriodo("T1(ENE 2022)");
		
		Avance a82= new Avance();
		a82.setIdentificador(0);
		a82.setPeriodo("T1(FEB 2022)");
		
		
		Avance a83= new Avance();
		a83.setIdentificador(0);
		a83.setPeriodo("T1(MAR 2022)");
		
		
		avances8.add(a81);
		avances8.add(a82);
		avances8.add(a83);
		
		List<Avance> avances9= new ArrayList<>();
		Avance a91= new Avance();
		a91.setIdentificador(1);
		a91.setPeriodo("T3(JUL 2021)");
		
		Avance a92= new Avance();
		a92.setIdentificador(1);
		a92.setPeriodo("T3(AGS 2021)");
		
		
		Avance a93= new Avance();
		a93.setIdentificador(0);
		a93.setPeriodo("T3(SEP 2021)");
		
		Avance a94= new Avance();
		a94.setIdentificador(0);
		a94.setPeriodo("T4(OCT 2021)");
		
		Avance a95= new Avance();
		a95.setIdentificador(0);
		a95.setPeriodo("T4(NOV 2021)");
		
		Avance a96= new Avance();
		a96.setIdentificador(0);
		a96.setPeriodo("T4(DIC 2021)");
		
		
		avances9.add(a91);
		avances9.add(a92);
		avances9.add(a93);
		avances9.add(a94);
		avances9.add(a95);
		avances9.add(a96);
		
		p.setPeriodoAvance(avances);
		p1.setPeriodoAvance(avances2);
		p2.setPeriodoAvance(avances3);
        p3.setPeriodoAvance(avances4);
		p7.setPeriodoAvance(avances7);
		p8.setPeriodoAvance(avances8);
		p9.setPeriodoAvance(avances9);
        
		registros.add(p);
		registros.add(p1);
		registros.add(p2);
		registros.add(p3);
		registros.add(p4);
		registros.add(p5);
		registros.add(p6);
		registros.add(p7);
		registros.add(p8);
		registros.add(p9);
		return registros;
	}
	
	public List<String> getColumnas(){
		List<String> columnas = new ArrayList<>();
		columnas.add("T3(JUL 2021)");
		columnas.add("T3(AGS 2021)");
		columnas.add("T3(SEP 2021)");		
		columnas.add("T4(OCT 2021)");
		columnas.add("T4(NOV 2021)");
		columnas.add("T4(DIC 2021)");
		columnas.add("T1(ENE 2022)");
		columnas.add("T1(FEB 2022)");
		columnas.add("T1(MAR 2022)");
		return columnas;
	}
}
