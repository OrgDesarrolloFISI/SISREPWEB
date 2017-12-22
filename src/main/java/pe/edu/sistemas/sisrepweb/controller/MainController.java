package pe.edu.sistemas.sisrepweb.controller;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import pe.edu.sistemas.sisrepweb.component.DateHandler;
import pe.edu.sistemas.sisrepweb.domain.Periodo;
import pe.edu.sistemas.sisrepweb.service.PeriodoService;

@Controller
public class MainController {
	
	protected final Log logger = LogFactory.getLog(MainController.class);
	@Autowired
	public PeriodoService periodoService;
	
	@Autowired
	public DateHandler dateHandler;

	@ModelAttribute("listaPeriodo")
	public List<String> listaPeriodo(){		
		List<String> periodosnombre = null;		
		List<Periodo> periodos = periodoService.listarPeriodos();		
		periodosnombre = periodoService.obtenerNombresPeriodos(periodos);		
		return periodosnombre;
	}
	
	@ModelAttribute("fechaInicio")
	public Date fechaInicio(){
		//Inicio del ultimo Periodo
		Periodo periodo = periodoService.buscarUltimoPeriodo();
		return  periodo.getPeriodoFechaInicio();
	}
	
	@ModelAttribute("fechaFin")
	public Date fechaFin(){
		//Inicio del ultimo Periodo
		Periodo periodo  = periodoService.buscarUltimoPeriodo();
		return periodo.getPeriodoFechaFin();		
	}
	
	
	@GetMapping("/index")
	public String index(){		
		return "index";
	}
}
