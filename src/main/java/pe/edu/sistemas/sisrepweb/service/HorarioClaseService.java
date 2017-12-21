package pe.edu.sistemas.sisrepweb.service;

import java.util.List;

import pe.edu.sistemas.sisrepweb.domain.HorarioClase;


public interface HorarioClaseService {
	
	public abstract List<HorarioClase> obtenerHorarioCursos(String codigoDocente, String periodoNombre);
}
