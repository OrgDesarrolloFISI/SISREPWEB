package pe.edu.sistemas.sisrepweb.service;

import java.util.List;

import pe.edu.sistemas.sisrepweb.model.AsistenciaModel;


public interface AsistenciaService {
	
	public abstract List<AsistenciaModel> listarAsistencias();
	public abstract List<AsistenciaModel> listarAsistenciasEspecificas();
	
}
