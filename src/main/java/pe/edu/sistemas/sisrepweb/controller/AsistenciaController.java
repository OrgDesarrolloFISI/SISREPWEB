package pe.edu.sistemas.sisrepweb.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.sistemas.sisrepweb.model.DocentePeriodo;
import pe.edu.sistemas.sisrepweb.service.AsistenciaService;

@Controller
public class AsistenciaController {

	protected final Log logger = LogFactory.getLog(AsistenciaController.class);
	@Autowired
	public AsistenciaService asistenciaService;
	
	@PostMapping("/jsonDP")
	public @ResponseBody DocentePeriodo JSONDocentePeriodo(@RequestBody DocentePeriodo docenteperiodo ){		
		DocentePeriodo dpfinal = null;		
		Boolean valido = asistenciaService.validarDocenteyPeriodo(docenteperiodo.getCodigoDocente(), docenteperiodo.getPeriodoNombre());		
		if(valido)
			dpfinal = asistenciaService.generarDocentePeriodo(docenteperiodo);
		else{
			dpfinal = docenteperiodo;
			dpfinal.setNombreDocente("NO EXISTE");
		}		
		return dpfinal;
	}
	
	
}
