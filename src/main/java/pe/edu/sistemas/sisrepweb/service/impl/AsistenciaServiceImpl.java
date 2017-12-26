package pe.edu.sistemas.sisrepweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.sistemas.sisrepweb.component.DateHandler;
import pe.edu.sistemas.sisrepweb.domain.Asistencia;
import pe.edu.sistemas.sisrepweb.domain.CursoConjunto;
import pe.edu.sistemas.sisrepweb.domain.Docente;
import pe.edu.sistemas.sisrepweb.domain.HorarioClase;
import pe.edu.sistemas.sisrepweb.domain.Periodo;
import pe.edu.sistemas.sisrepweb.model.DocentePeriodo;
import pe.edu.sistemas.sisrepweb.model.RegistroAsistencia;
import pe.edu.sistemas.sisrepweb.service.AsistenciaService;
import pe.edu.sistemas.sisrepweb.service.CursoService;
import pe.edu.sistemas.sisrepweb.service.DocenteService;
import pe.edu.sistemas.sisrepweb.service.HorarioClaseService;
import pe.edu.sistemas.sisrepweb.service.PeriodoService;

@Service
public class AsistenciaServiceImpl implements AsistenciaService {
	
	protected final Log logger = LogFactory.getLog(AsistenciaServiceImpl.class);

	
	@Autowired
	private DateHandler dateHandler;
	
	@Autowired
	private HorarioClaseService horarioClaseService;
	
	@Autowired
	private DocenteService docenteService;
	
	@Autowired
	private PeriodoService periodoService;
	
	@Autowired
	private CursoService cursoService;
	
	
	@Override
	public DocentePeriodo generarRegistroAsistenciaDeDocente(DocentePeriodo dp){
		DocentePeriodo docenteperiodo = dp;
		int totalHNL = 0;
		DateTime inicio,fin,fechasistencia, fechaguardada;
		inicio = new DateTime(dp.getInicioFecha());
		fin = new DateTime(dp.getFinFecha());
		List<RegistroAsistencia> listaRATemporal = null;
		List<RegistroAsistencia> listaRAFinal = new ArrayList<>();
		List<HorarioClase> horarios = horarioClaseService.obtenerHorarioCursos(dp.getCodigoDocente(), dp.getPeriodoNombre());
		
		List<String> listaDeFechas = null;
		
		for(HorarioClase horario: horarios){
			
			//Obtener todas las fechas y guardarlas
			listaDeFechas = dateHandler.obtenerListaDeFechas(dp.getInicioFecha(), dp.getFinFecha(), horario.getDia());
			
			listaRATemporal = guardarFechasAsistencia(listaDeFechas, horario);
			
			for(RegistroAsistencia registroasistencia: listaRATemporal){
				
				fechaguardada = new DateTime(registroasistencia.getFecha());
					
					for(Asistencia asistencia: horario.getAsistencias()){
						fechasistencia = dateHandler.convertirDateADateTime(asistencia.getAsistenciaFecha());
						
						if((fechasistencia.isAfter(inicio)&&fechasistencia.isBefore(fin))||fechasistencia.equals(inicio)
								||fechasistencia.equals(fin)){
						
							if(fechasistencia.equals(fechaguardada)){
								registroasistencia.setMarcaEnt(dateHandler.obtenerHora(asistencia.getAsistenciaHoraIngreso()));
								registroasistencia.setMarcaSal(dateHandler.obtenerHora(asistencia.getAsistenciaHoraSalida()));
								registroasistencia.setHoraNL(0);	
							}
						}
					}
					totalHNL+= registroasistencia.getHoraNL();
					listaRAFinal.add(registroasistencia);
			}
			listaDeFechas.clear();
			listaRATemporal.clear();
		}
		
		docenteperiodo.setTotalHNL(totalHNL);
		docenteperiodo.setListaRegistroAsistencia(listaRAFinal);
		return docenteperiodo;
	}
	
	@Override
	public DocentePeriodo generarDocentePeriodo(DocentePeriodo dp){
		
		DocentePeriodo docenteperiodo = generarRegistroAsistenciaDeDocente(dp);
		docenteperiodo.setNombreDocente(docenteService.obtenerNombreDocente(dp.getCodigoDocente()));
		
		return docenteperiodo;
	}
	
	@Override 
	public Boolean validarDocenteyPeriodo(String codigoDocente, String periodoNombre){
		Boolean valido= false;
		
		Docente docente = docenteService.buscarDocentePorCodigoSimple(codigoDocente);
		Periodo periodo = periodoService.obtenerPeriodoXNombre(periodoNombre);
		
		if(docente!=null&&periodo!=null){
			valido = true;
		}
		
		return valido;
	}
		
	
	@Override
	public List<RegistroAsistencia> guardarFechasAsistencia(List<String> ls, HorarioClase hc){
		List<RegistroAsistencia> ra = new ArrayList<>();
		RegistroAsistencia  temp = null;
		CursoConjunto cursoc = cursoService.obtenerCursoConjuntoXCodComun(hc.getGrupo().getCursoPeriodo().getCursoConjunto().getIdcursoConjunto());
		for(String s: ls){
			temp = new RegistroAsistencia();
			temp.setEscuela(cursoc.getCursoBase().getPlan().getPlanNombre().substring(5));temp.setCurso(hc.getGrupo().getCursoPeriodo().getCursoPeriodoNombre());
			temp.setNroGrupo(Integer.toString(hc.getGrupo().getGrupoNumero()));
			temp.setTipo(hc.getHorarioClaseTipo());
			temp.setHoraInicio(dateHandler.obtenerHora(hc.getHoraInicio()));
			temp.setHoraFin(dateHandler.obtenerHora(hc.getHoraFin()));
			temp.setFecha(s);
			temp.setHoraNL(dateHandler.obtenerDiferenciaDeHoras(hc.getHoraInicio(),hc.getHoraFin()));
			temp.setMarcaEnt("NO MARCO");
			temp.setMarcaSal("NO MARCO");
			ra.add(temp);
		}
		logger.info("[ESCUELA --------> "+temp.getEscuela()+"--------------");
		logger.info("[ID CURSO_CONJUNTO -------> "+hc.getGrupo().getCursoPeriodo().getCursoConjunto().getIdcursoConjunto()); // cursoConjunto incorrecto
		logger.info("[CODIGO COMUN -------> "+hc.getGrupo().getCursoPeriodo().getCursoConjunto().getCursocCodcomun());
		return ra;
	}



	


	
	

	
}
