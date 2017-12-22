package pe.edu.sistemas.sisrepweb.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.sistemas.sisrepweb.model.DocentePeriodo;
import pe.edu.sistemas.sisrepweb.service.AsistenciaService;

@Controller
public class AsistenciaController {

	protected final Log logger = LogFactory.getLog(AsistenciaController.class);
	@Autowired
	public AsistenciaService asistenciaService;
	
	@GetMapping("/jsonDP")
	public @ResponseBody DocentePeriodo JSONDocentePeriodo(){
		
		
		
		DocentePeriodo dp,dp2;
		dp = new DocentePeriodo();
		
		dp.setCodigoDocente("0A1610");
		dp.setPeriodoNombre("2017-1");
		dp.setInicioFecha("2017-03-20");
		dp.setFinFecha("2017-07-14");
		Boolean valido = asistenciaService.validarDocenteyPeriodo(dp.getCodigoDocente(), dp.getPeriodoNombre());
		if(valido)
			dp2 = asistenciaService.generarDocentePeriodo(dp);
		else{
			dp2 = dp;
			dp2.setNombreDocente("NO EXISTE");
		}
		
		return dp2;
		
	}
	
	@GetMapping("/jsonDPFinal")
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
