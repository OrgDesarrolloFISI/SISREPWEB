package pe.edu.sistemas.sisrepweb.service;

import java.util.List;

import pe.edu.sistemas.sisrepweb.domain.HorarioClase;


public interface GrupoService {
	
	public abstract List<HorarioClase> listarHorarioClases();
	public abstract HorarioClase añadirHorarioClase(HorarioClase horarioClase);
	public abstract HorarioClase buscarHorarioClasePorId(String id);
	public abstract Integer ConvertirIntegerDeHorarioClaseDoc(HorarioClase h);
}
