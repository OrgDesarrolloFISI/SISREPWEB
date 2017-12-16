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
	
	/*@Autowired
	private HorarioClaseConverter horarioClaseConverter;
	*/

	

	@Override
	public HorarioClase añadirHorarioClase(HorarioClase horarioClase) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HorarioClase buscarHorarioClasePorId(String id) {
		HorarioClase horarioClase = horarioClaseRepository.getOne(id);
		return horarioClase;
	}

	@Override
	public Integer ConvertirIntegerDeHorarioClaseDoc(HorarioClase a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HorarioClase> listarHorarioClases() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

	
}
