package pe.edu.sistemas.sisrepweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.sistemas.sisrepweb.domain.HorarioClase;
import pe.edu.sistemas.sisrepweb.repository.HorarioClaseRepository;
import pe.edu.sistemas.sisrepweb.service.HorarioClaseService;

@Service
public class HorarioClaseServiceImpl implements HorarioClaseService {
	

	@Autowired
	private HorarioClaseRepository horarioClaseRepository;
	
	@Override
	public List<HorarioClase> obtenerHorarioCursos(String codigoDocente, String periodoNombre) {
		List<HorarioClase> horarios = horarioClaseRepository.obtenerHorarioCursos(codigoDocente, periodoNombre);
		return horarios;
	}

	
	

	
}
