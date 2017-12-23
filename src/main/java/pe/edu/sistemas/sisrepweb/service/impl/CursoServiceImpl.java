package pe.edu.sistemas.sisrepweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.sistemas.sisrepweb.domain.CursoConjunto;
import pe.edu.sistemas.sisrepweb.repository.CursoConjuntoRepository;
import pe.edu.sistemas.sisrepweb.service.CursoService;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoConjuntoRepository cursoConjuntoRepository;
	
	@Override
	public CursoConjunto obtenerCursoConjuntoXCodComun(int cursoConjuntocodcomun) {
		List<CursoConjunto> listaCursoc = cursoConjuntoRepository.obtenerCursoConjuntoXCodComun(cursoConjuntocodcomun);
		if(listaCursoc!=null)
			return listaCursoc.get(0);
		return null;
	}




	
}
