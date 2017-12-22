package pe.edu.sistemas.sisrepweb.service;

import pe.edu.sistemas.sisrepweb.domain.Docente;


public interface DocenteService {
	
	Docente buscarDocentePorCodigoSimple(String codigo);
	String obtenerNombreDocente(String codigoDocente);
	
}
