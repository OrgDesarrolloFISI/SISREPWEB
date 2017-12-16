package pe.edu.sistemas.sisrepweb.service;

import java.util.List;

import pe.edu.sistemas.sisrepweb.domain.Periodo;


public interface PeriodoService {
	
	public abstract List<Periodo> listarPeriodos();
	public abstract Periodo buscarUltimoPeriodo();
}
