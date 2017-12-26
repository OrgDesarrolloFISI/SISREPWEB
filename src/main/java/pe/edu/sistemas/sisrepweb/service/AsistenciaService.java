package pe.edu.sistemas.sisrepweb.service;


import java.util.List;

import pe.edu.sistemas.sisrepweb.domain.HorarioClase;
import pe.edu.sistemas.sisrepweb.model.DocentePeriodo;
import pe.edu.sistemas.sisrepweb.model.RegistroAsistencia;


public interface AsistenciaService {

	DocentePeriodo generarRegistroAsistenciaDeDocente(DocentePeriodo dp);
	DocentePeriodo generarDocentePeriodo(DocentePeriodo dp);
	List<RegistroAsistencia> guardarFechasAsistencia(List<String> ls, HorarioClase hc);
	Boolean validarDocenteyPeriodo(String codigoDocente, String periodoNombre);
}
