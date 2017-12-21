package pe.edu.sistemas.sisrepweb.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.sistemas.sisrepweb.SisrepwebApplicationTests;
import pe.edu.sistemas.sisrepweb.component.AsistenciaConverter;
import pe.edu.sistemas.sisrepweb.component.DateHandler;
import pe.edu.sistemas.sisrepweb.domain.Asistencia;
import pe.edu.sistemas.sisrepweb.domain.Docente;
import pe.edu.sistemas.sisrepweb.domain.HorarioClase;
import pe.edu.sistemas.sisrepweb.model.AsistenciaModel;
import pe.edu.sistemas.sisrepweb.model.DocentePeriodo;
import pe.edu.sistemas.sisrepweb.model.RegistroAsistencia;
import pe.edu.sistemas.sisrepweb.repository.AsistenciaRepository;
import pe.edu.sistemas.sisrepweb.service.AsistenciaService;
import pe.edu.sistemas.sisrepweb.service.DocenteService;
import pe.edu.sistemas.sisrepweb.service.HorarioClaseService;

@Service
public class AsistenciaServiceImpl implements AsistenciaService {
	
	protected final Log logger = LogFactory.getLog(AsistenciaServiceImpl.class);

	@Autowired
	private AsistenciaRepository asistenciaRepository;
	
	@Autowired
	private AsistenciaConverter asistenciaConverter;
	
	@Autowired
	private DateHandler dateHandler;
	
	@Autowired
	private HorarioClaseService horarioClaseService;
	
	
	@Override
	public DocentePeriodo generarDocentePeriodo(DocentePeriodo dp){
		DocentePeriodo dpr = dp;
		RegistroAsistencia rat;
		DateTime inicio,fin,fechasistencia, fechaguardada;
		inicio = new DateTime(dp.getInicioFecha());
		fin = new DateTime(dp.getFinFecha());
		List<RegistroAsistencia> lra = new ArrayList<>();
		List<RegistroAsistencia> lraf = new ArrayList<>();
		List<HorarioClase> horarios = horarioClaseService.obtenerHorarioCursos(dp.getCodigoDocente(), dp.getPeriodoNombre());
		
		List<String> ls;
		
		for(HorarioClase hc: horarios){
			
			//Obtener todas las fechas y guardarlas
			ls = dateHandler.obtenerListaDeFechas(dp.getInicioFecha(), dp.getFinFecha(), hc.getDia());
			
			for(RegistroAsistencia raf: lra){
				logger.info("VACIO: " + raf.toString());
			}
			
			lra = guardarFechasAsistencia(ls, dp, hc);
			
			for(RegistroAsistencia raq: lra)
				logger.info("LRA:" + raq.toString());
			
			for(Asistencia a: hc.getAsistencias()){
				
				fechasistencia = dateHandler.convertirDateADateTime(a.getAsistenciaFecha());
				
				if((fechasistencia.isAfter(inicio)&&fechasistencia.isBefore(fin))||fechasistencia.equals(inicio)||fechasistencia.equals(fin)){
					
					for(RegistroAsistencia ra: lra){
						fechaguardada = new DateTime(ra.getFecha());
						
						if(fechasistencia.equals(fechaguardada)){
							ra.setMarcaEnt(dateHandler.obtenerHora(a.getAsistenciaHoraIngreso()));
							ra.setMarcaSal(dateHandler.obtenerHora(a.getAsistenciaHoraSalida()));
						}else{
							ra.setHoraNL(dateHandler.obtenerDiferenciaDeHoras(hc.getHoraInicio(),hc.getHoraFin()));
						}
						lraf.add(ra);
					}
				}
				
			}
		
			lra.clear();
		}
		
		dpr.setRegistroAsistencia(lraf);
		return dpr;
	}
	
	
	
	public List<RegistroAsistencia> guardarFechasAsistencia(List<String> ls, DocentePeriodo dp, HorarioClase hc){
		List<RegistroAsistencia> ra = new ArrayList<>();
		RegistroAsistencia  temp = null;
		
		for(String s: ls){
			temp = new RegistroAsistencia();
			
			temp.setEscuela(hc.getGrupo().getCursoPeriodo().getCursoConjunto().getCursoBase().getPlan().getEscuela().getEscuelaNombre());
			temp.setCurso(hc.getGrupo().getCursoPeriodo().getCursoPeriodoNombre());
			temp.setNroGrupo(Integer.toString(hc.getGrupo().getGrupoNumero()));
			temp.setTipo(hc.getHorarioClaseTipo());
			temp.setHoraInicio(dateHandler.obtenerHora(hc.getHoraInicio()));
			temp.setHoraFin(dateHandler.obtenerHora(hc.getHoraFin()));
			temp.setFecha(s);
			ra.add(temp);
		}
		
		return ra;
	}



	@Override
	public List<Asistencia> obtenerAsistenciasxHorarioClase(Integer idHorarioClase) {
		List<Asistencia> la = asistenciaRepository.obtenerAsistenciasxHorarioClase(idHorarioClase);
		return la;
	}
	
	


	
	

	
}
