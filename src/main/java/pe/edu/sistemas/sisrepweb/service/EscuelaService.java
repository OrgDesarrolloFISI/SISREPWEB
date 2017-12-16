package pe.edu.sistemas.sisrepweb.service;

import java.util.List;

import pe.edu.sistemas.sisrepweb.domain.Escuela;


public interface EscuelaService {
	
	public abstract List<Escuela> listarEscuelas();
	public abstract Escuela buscarEscuelaPorId(String id);
}
