package pe.edu.sistemas.sisrepweb.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.sistemas.sisrepweb.model.DocentePeriodo;
import pe.edu.sistemas.sisrepweb.model.RegistroAsistencia;

@Controller
public class PageController {
	
	protected final Log logger = LogFactory.getLog(PageController.class);

	
	@ModelAttribute("listaPeriodo")
	public List<String> listaPeriodo(){
		List<String> listaPeriodos = new ArrayList<String>();
		listaPeriodos.add("2017-II");
		listaPeriodos.add("2017-I");
		listaPeriodos.add("2016-II");
		listaPeriodos.add("2016-I");	
		return listaPeriodos;
	}
	
	@ModelAttribute("fechaInicio")
	public Date fechaInicio(){
		SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaInicio = null;
		try {
			fechaInicio = formatoDeFecha.parse("2017-08-14");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return fechaInicio;
		
	}
	
	@ModelAttribute("fechaFin")
	public Date fechaFin(){
		SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaFin = null;
		try {
			fechaFin = formatoDeFecha.parse("2017-12-07");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return fechaFin;
	}
	
	@GetMapping("/getFechaPeriodo/{nombre}")
	public @ResponseBody() List<String> getFechaPeriodo(@PathVariable(name="nombre",required=true) String periodo){
		List<String> fechas = new ArrayList<String>();
		switch(periodo){
			case "2016-I": fechas.add("2015-03-23");fechas.add("2015-07-17");break;
			case "2016-II": fechas.add("2016-08-15");fechas.add("2016-12-10");break;
			case "2017-I": fechas.add("2017-03-20");fechas.add("2017-07-14");break;
			case "2017-II": fechas.add("2017-08-14");fechas.add("2017-12-07");break;
		}
		return fechas;
	}
	
	@PostMapping("/jsonDP")
	public @ResponseBody DocentePeriodo getDocentePeriodo(@RequestBody DocentePeriodo docentePeriodo){
		List<RegistroAsistencia> listaRegAsis= new ArrayList<RegistroAsistencia>();
		listaRegAsis.add(new RegistroAsistencia("Sistemas","MiCurso",3,"Teoria","08:00","10:00","08:00","10:00","2017-21-21",2));
		listaRegAsis.add(new RegistroAsistencia("Software","MiCurso2",3,"Teoria","08:00","10:00","08:00","10:00","2017-21-21",2));
		listaRegAsis.add(new RegistroAsistencia("Sistemas","MiCurso3",3,"Teoria","08:00","10:00","08:00","10:00","2017-21-21",2));
		docentePeriodo.setNombreDocente("existe");
		docentePeriodo.setListaRegistroAsistencia(listaRegAsis);
		return docentePeriodo;
	}
	
	@GetMapping("/index")
	public String index(){
		logger.info("Se ingreso a index");
		return "index";
	}
	
	@GetMapping("/layout")
	public String layout(){
		logger.info("Se ingreso a layout");
		return "fragments/layout";
	}
	
	@GetMapping("/plain-page")
	public String plainPage(){
		logger.info("Se ingreso a plain-page");
		return "plain-page";
	}
	
	@GetMapping("/form")
	public String form(){
		logger.info("Se ingreso a form");
		return "form";
	}
	
	@GetMapping("/formAdv")
	public String formAdv(){
		logger.info("Se ingreso a formAdv");
		return "formAdv";
	}
	
	@GetMapping("/tables_dynamic")
	public String tables(){
		logger.info("Se ingreso a tables_dynamic");
		return "tables_dynamic";
	}
	
	@GetMapping("/pricing-tables")
	public String pricing(){
		logger.info("Se ingreso a pricing-tables");
		return "pricing-tables";
	}
	
	
	
}

