package pe.edu.sistemas.sisrepweb.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import pe.edu.sistemas.sisrepweb.model.DocentePeriodo;
import pe.edu.sistemas.sisrepweb.service.AsistenciaService;

@Controller
public class AsistenciaController {

	protected final Log logger = LogFactory.getLog(AsistenciaController.class);
	
	@Autowired
	public AsistenciaService asistenciaService;
	
	@Autowired
	public JasperReportsPdfView jasperReportsPdfView;
	
	DocentePeriodo dpfinal;
	
	@PostMapping("/jsonDP")
	public @ResponseBody DocentePeriodo JSONDocentePeriodo(@RequestBody DocentePeriodo docenteperiodo ){	
		
		Boolean valido = asistenciaService.validarDocenteyPeriodo(docenteperiodo.getCodigoDocente(), docenteperiodo.getPeriodoNombre());		
		if(valido)
			dpfinal = asistenciaService.generarDocentePeriodo(docenteperiodo);
		else{
			dpfinal = docenteperiodo;
			dpfinal.setNombreDocente("NO EXISTE");
		}		
		return dpfinal;
	}
	
	@GetMapping("/reporteAsistencias")
	public ModelAndView reportePDFAsistencia(){
		Map<String,Object> params = new HashMap<>();
		params.put("datasource", dpfinal.getListaRegistroAsistencia());
		params.put("nombreDocente", dpfinal.getNombreDocente());
		params.put("codigoDocente", dpfinal.getCodigoDocente());
		params.put("periodoNombre", dpfinal.getPeriodoNombre());
		params.put("inicioFecha", dpfinal.getInicioFecha());
		params.put("finFecha", dpfinal.getFinFecha());
		params.put("totalHNL", dpfinal.getTotalHNL());
		return new ModelAndView(jasperReportsPdfView,params);
	}
	
}
