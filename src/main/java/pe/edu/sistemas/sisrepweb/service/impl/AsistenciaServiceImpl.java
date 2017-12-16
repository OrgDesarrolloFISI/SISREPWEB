package pe.edu.sistemas.sisrepweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.sistemas.sisrepweb.component.AsistenciaConverter;
import pe.edu.sistemas.sisrepweb.domain.Asistencia;
import pe.edu.sistemas.sisrepweb.model.AsistenciaModel;
import pe.edu.sistemas.sisrepweb.repository.AsistenciaRepository;
import pe.edu.sistemas.sisrepweb.service.AsistenciaService;

@Service
public class AsistenciaServiceImpl implements AsistenciaService {
	

	@Autowired
	private AsistenciaRepository asistenciaRepository;
	
	@Autowired
	private AsistenciaConverter asistenciaConverter;
	

	@Override
	public List<AsistenciaModel> listarAsistencias() {
		System.out.println("helloooo");
		List<Asistencia> asistencias = (List<Asistencia>) asistenciaRepository.findAll();
		List<AsistenciaModel> asistenciaModel = new ArrayList<AsistenciaModel>();
		for(Asistencia contacto : asistencias) {
			asistenciaModel.add(asistenciaConverter.convertirAsistenciaAAsistenciaModel(contacto));
		}
		return asistenciaModel;
	}


	@Override
	public List<AsistenciaModel> listarAsistenciasEspecificas() {
		// TODO Auto-generated method stub
		return null;
	}


	
	

	
}
