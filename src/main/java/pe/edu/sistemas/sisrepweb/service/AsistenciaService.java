package pe.edu.sistemas.sisrepweb.service;


import java.util.List;

import pe.edu.sistemas.sisrepweb.domain.Asistencia;
import pe.edu.sistemas.sisrepweb.model.DocentePeriodo;


public interface AsistenciaService {


	DocentePeriodo generarDocentePeriodo(DocentePeriodo dp);
	List<Asistencia> obtenerAsistenciasxHorarioClase( Integer idHorarioClase);
}
