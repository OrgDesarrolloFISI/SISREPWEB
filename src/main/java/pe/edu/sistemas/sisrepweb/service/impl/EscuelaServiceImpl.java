package pe.edu.sistemas.sisrepweb.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import pe.edu.sistemas.sisrepweb.domain.Escuela;
import pe.edu.sistemas.sisrepweb.repository.EscuelaRepository;
import pe.edu.sistemas.sisrepweb.service.EscuelaService;


@Service
public class EscuelaServiceImpl implements EscuelaService {
	

	@Autowired
	private EscuelaRepository escuelaRepository;
	


	@Override
	public Escuela buscarEscuelaPorId(String id) {
		Escuela escuela = escuelaRepository.getOne(id);
		return escuela;
	}


	@Override
	public List<Escuela> listarEscuelas() {
		List<Escuela> listaEscuelas = escuelaRepository.findAll();
		return listaEscuelas;
	}


	
	

	
}
