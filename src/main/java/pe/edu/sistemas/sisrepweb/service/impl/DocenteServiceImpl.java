package pe.edu.sistemas.sisrepweb.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import pe.edu.sistemas.sisrepweb.domain.Docente;
import pe.edu.sistemas.sisrepweb.repository.DocenteRepository;
import pe.edu.sistemas.sisrepweb.service.DocenteService;


@Service
public class DocenteServiceImpl implements DocenteService {
	

	@Autowired
	private DocenteRepository docenteRepository;




	@Override
	public Docente buscarDocentePorCodigoSimple(String codigo) {
		Docente docente = docenteRepository.buscarDocentePorCodigo(codigo);
		return docente;
	}



	@Override
	public String obtenerNombreDocente(String codigoDocente){
		Docente docente = buscarDocentePorCodigoSimple(codigoDocente);
		String 	nombre = docente.getPersona().getPersonaAppaterno() + " " 
						+ docente.getPersona().getPersonaApmaterno() + " "
						+ docente.getPersona().getPersonaNombre();
		return nombre;		
	}
	

	
}
