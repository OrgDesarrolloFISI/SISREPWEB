package pe.edu.sistemas.sisrepweb.service;

import java.util.List;

import pe.edu.sistemas.sisrepweb.domain.Docente;
import pe.edu.sistemas.sisrepweb.model.DocenteModel;


public interface DocenteService {
	
	public abstract List<DocenteModel> listarDocentes();
	public abstract DocenteModel buscarDocentePorId(String id);
	public abstract DocenteModel buscarDocentePorCodigo(String codigo);
	public abstract List<DocenteModel> buscarDocentesPorCodigoParcial(String codigo);
	Docente buscarDocentePorCodigoSimple(String codigo);
	
}
