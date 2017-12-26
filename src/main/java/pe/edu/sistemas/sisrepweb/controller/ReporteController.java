package pe.edu.sistemas.sisrepweb.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import pe.edu.sistemas.sisrepweb.model.DocentePeriodo;
import pe.edu.sistemas.sisrepweb.service.AsistenciaService;


@Controller
public class ReporteController {
	
	@Autowired
	public AsistenciaService asistenciaService;
	
	@Autowired
	ApplicationContext applicationContext;
	
	@GetMapping("/reporte")
	public ModelAndView reportePDFAsistencia(){
		JasperReportsPdfView view = new JasperReportsPdfView();
		view.setUrl("classpath:/reportes/ReporteAsistencia.jrxml");
		view.setApplicationContext(applicationContext);
		view.setReportDataKey("datasource");
		DocentePeriodo docPer = new DocentePeriodo();
		docPer.setCodigoDocente("0A1610");
		docPer.setPeriodoNombre("2017-1");
		docPer.setInicioFecha("2017-04-20");
		docPer.setFinFecha("2017-06-14");
		
		docPer = asistenciaService.generarDocentePeriodo(docPer);
		
		Map<String,Object> params = new HashMap<>();
		params.put("datasource", docPer.getListaRegistroAsistencia());
		params.put("nombreDocente", docPer.getNombreDocente());
		params.put("codigoDocente", docPer.getCodigoDocente());
		params.put("periodoNombre", docPer.getPeriodoNombre());
		params.put("inicioFecha", docPer.getInicioFecha());
		params.put("finFecha", docPer.getFinFecha());
		params.put("totalHNL", docPer.getTotalHNL());
		return new ModelAndView(view,params);
	}

}
