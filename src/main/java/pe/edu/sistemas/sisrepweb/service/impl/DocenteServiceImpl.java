package pe.edu.sistemas.sisrepweb.service.impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import pe.edu.sistemas.sisrepweb.component.DocenteConverter;
import pe.edu.sistemas.sisrepweb.domain.Docente;
import pe.edu.sistemas.sisrepweb.model.DocenteModel;
import pe.edu.sistemas.sisrepweb.repository.DocenteRepository;
import pe.edu.sistemas.sisrepweb.service.DocenteService;


@Service
public class DocenteServiceImpl implements DocenteService {
	

	@Autowired
	private DocenteRepository docenteRepository;
	
	@Autowired
	private DocenteConverter docenteConverter;
	

	@Override
	public DocenteModel buscarDocentePorId(String id) {
		Docente docente = docenteRepository.getOne(id);
		DocenteModel docenteModel = null;
		if(docente!=null)
			docenteModel = docenteConverter.convertirDocenteADocenteModel(docente);
		return docenteModel;
	}


	@Override
	public List<DocenteModel> listarDocentes() {
		List<Docente> listaDocentes = docenteRepository.findAll();
		List<DocenteModel> listaDocentesModel = new ArrayList<DocenteModel>();
		if(listaDocentes!=null)
			for(Docente docente : listaDocentes){
				listaDocentesModel.add(docenteConverter.convertirDocenteADocenteModel(docente));
			}
		return listaDocentesModel;
	}


	@Override
	public DocenteModel buscarDocentePorCodigo(String codigo) {
		Docente docente = docenteRepository.buscarDocentePorCodigo(codigo);
		DocenteModel docenteModel = null;
		if(docente!=null)
			docenteModel = docenteConverter.convertirDocenteADocenteModel(docente);
		return docenteModel;
	}
	
	@Override
	public Docente buscarDocentePorCodigoSimple(String codigo) {
		Docente docente = docenteRepository.buscarDocentePorCodigo(codigo);
		return docente;
	}


	@Override
	public List<DocenteModel> buscarDocentesPorCodigoParcial(String codigo) {
		List<Docente> listaDocentes = docenteRepository.buscarDocentesPorCodigoParcial(codigo);
		List<DocenteModel> listaDocentesModel = new ArrayList<>();
		if(listaDocentes!=null)
			for(Docente docente : listaDocentes){
				listaDocentesModel.add(docenteConverter.convertirDocenteADocenteModel(docente));
			}
		return listaDocentesModel;
	}

	
	

	
}
