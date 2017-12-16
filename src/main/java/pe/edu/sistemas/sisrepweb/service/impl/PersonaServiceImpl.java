package pe.edu.sistemas.sisrepweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.sistemas.sisrepweb.domain.Persona;
import pe.edu.sistemas.sisrepweb.repository.PersonaRepository;
import pe.edu.sistemas.sisrepweb.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {
	

	@Autowired
	private PersonaRepository personaRepository;

	@Override
	public Persona buscarPersonaPorId(String id) {
		Persona persona = personaRepository.getOne(id);
		return persona;
	}



	
	

	
}
