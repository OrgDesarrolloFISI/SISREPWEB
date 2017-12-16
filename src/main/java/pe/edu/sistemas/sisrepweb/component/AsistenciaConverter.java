package pe.edu.sistemas.sisrepweb.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.sistemas.sisrepweb.domain.Asistencia;
import pe.edu.sistemas.sisrepweb.model.AsistenciaModel;
import pe.edu.sistemas.sisrepweb.service.HorarioClaseService;


@Component
public class AsistenciaConverter {
	
	@Autowired
	private HorarioClaseService horarioClaseService;
	
	private static final Log LOG =LogFactory.getLog(AsistenciaConverter.class);
	
	public Asistencia convertirAsistenciaModelAAsistencia(AsistenciaModel asistenciaModel) {
		Asistencia asistencia = new Asistencia();
		asistencia.setAsistenciaFecha(asistenciaModel.getAsistenciaFecha());
		asistencia.setAsistenciaHoraIngreso(asistenciaModel.getAsistenciaHoraIngreso());
		asistencia.setAsistenciaHoraSalida(asistenciaModel.getAsistenciaHoraSalida());
		asistencia.setAsistenciaObservacion(asistenciaModel.getAsistenciaObservacion());
		asistencia.setAsistenciaTema(asistenciaModel.getAsistenciaTema());
		asistencia.setAsistenciaTipoMarca(asistenciaModel.getAsistenciaTipoMarca());
		asistencia.setHorarioClase(horarioClaseService.buscarHorarioClasePorId(asistenciaModel.getIdHorarioClase().toString()));
		return asistencia;
	}
	
	public AsistenciaModel convertirAsistenciaAAsistenciaModel(Asistencia asistencia) {
		AsistenciaModel asistenciaModel = new AsistenciaModel();
		asistenciaModel.setAsistenciaFecha(asistencia.getAsistenciaFecha());
		asistenciaModel.setAsistenciaHoraIngreso(asistencia.getAsistenciaHoraIngreso());
		asistenciaModel.setAsistenciaHoraSalida(asistencia.getAsistenciaHoraSalida());
		asistenciaModel.setAsistenciaObservacion(asistencia.getAsistenciaObservacion());
		asistenciaModel.setAsistenciaTema(asistencia.getAsistenciaTema());
		asistenciaModel.setAsistenciaTipoMarca(asistencia.getAsistenciaTipoMarca());
		asistenciaModel.setIdasistencia(asistencia.getIdasistencia());
		asistenciaModel.setMotivoIdmotivo(asistencia.getMotivoIdmotivo());
		asistenciaModel.setIdHorarioClase(asistencia.getHorarioClase().getIdhorarioClase());
		
		return asistenciaModel;
	}
	
	
}
