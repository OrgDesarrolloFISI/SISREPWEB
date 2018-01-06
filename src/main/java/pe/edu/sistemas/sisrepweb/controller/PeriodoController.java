package pe.edu.sistemas.sisrepweb.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.sistemas.sisrepweb.domain.Periodo;
import pe.edu.sistemas.sisrepweb.service.PeriodoService;

@Controller
public class PeriodoController {
	protected final Log logger = LogFactory.getLog(PeriodoController.class);
	@Autowired 
	public PeriodoService periodoService;
	
	@GetMapping("/getFechaPeriodo/{nombre}")
	public @ResponseBody Periodo getFechaPeriodo(@PathVariable(name ="nombre", required = false) String periodoNombre){		
		Periodo periodo = periodoService.obtenerPeriodoXNombre(periodoNombre);
		return periodo;
	}
}
