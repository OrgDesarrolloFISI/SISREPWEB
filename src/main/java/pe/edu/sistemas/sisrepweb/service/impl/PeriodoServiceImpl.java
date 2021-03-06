package pe.edu.sistemas.sisrepweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.sistemas.sisrepweb.domain.Periodo;
import pe.edu.sistemas.sisrepweb.repository.PeriodoRepository;
import pe.edu.sistemas.sisrepweb.service.PeriodoService;

@Service
public class PeriodoServiceImpl implements PeriodoService {

	@Autowired
	private PeriodoRepository periodoRepository;
	
	@Override
	public List<Periodo> listarPeriodos() {
		List<Periodo> listaPeriodos = periodoRepository.findAll();
		return listaPeriodos;
	}

	@Override
	public Periodo buscarUltimoPeriodo() {
		List<Periodo> listaPeriodos = periodoRepository.listarPeriodosInverso();
		if(listaPeriodos!=null)
			return listaPeriodos.get(0);
		return null;
	}
	
	@Override
	public Periodo obtenerPeriodoXNombre(String periodoNombre){
		Periodo periodo = periodoRepository.findByperiodoNombre(periodoNombre);
		return periodo;
	}
	

	
	@Override
	public List<String> obtenerNombresPeriodos(List<Periodo> periodos) {
		List<String> nombres = new ArrayList<>();		
		for(int i=periodos.size()-1;i>=0;i--)
			nombres.add(periodos.get(i).getPeriodoNombre());
		return nombres;
	}

}
