package pe.edu.sistemas.sisrepweb.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.sistemas.sisrepweb.domain.Docente;
import pe.edu.sistemas.sisrepweb.model.DocenteModel;
import pe.edu.sistemas.sisrepweb.service.PersonaService;


@Component
public class DocenteConverter {
	
	@Autowired
	private PersonaService personaService;
	
	private static final Log LOG =LogFactory.getLog(DocenteConverter.class);
	
	public Docente convertirDocenteModelADocente(DocenteModel docenteModel) {
		Docente docente = new Docente();
		docente.setCategoriaDocenteIdecategoriaDocente(docenteModel.getCategoriaDocenteIdecategoriaDocente());
		docente.setClaseIdclase(docenteModel.getClaseIdclase());
		docente.setDocenteClave(docenteModel.getDocenteClave());
		docente.setDocenteDepartamentoAcademico(docenteModel.getDocenteDepartamentoAcademico());
		docente.setDocenteGrupoOcupacional(docenteModel.getDocenteGrupoOcupacional());
		docente.setDocenteNivel(docenteModel.getDocenteNivel());
		docente.setDocenteObservacionLimiteEdad(docenteModel.getDocenteObservacionLimiteEdad());
		docente.setDocenteObservacionOtros(docenteModel.getDocenteObservacionOtros());
		docente.setDocenteObservacionTiempoServicio(docenteModel.getDocenteObservacionTiempoServicio());
		docente.setDocenteRegular(docenteModel.getDocenteRegular());
		docente.setHistorialServicioIdhistorialServicio(docenteModel.getHistorialServicioIdhistorialServicio());
		docente.setIddocente(docenteModel.getIddocente());
		docente.setPersona(personaService.buscarPersonaPorId(docenteModel.getIdPersona().toString()));
		return docente;
	}
	
	public DocenteModel convertirDocenteADocenteModel(Docente docente) {
		DocenteModel docenteModel = new DocenteModel();
		docenteModel.setCategoriaDocenteIdecategoriaDocente(docente.getCategoriaDocenteIdecategoriaDocente());
		docenteModel.setClaseIdclase(docente.getClaseIdclase());
		docenteModel.setDocenteClave(docente.getDocenteClave());
		docenteModel.setDocenteDepartamentoAcademico(docente.getDocenteDepartamentoAcademico());
		docenteModel.setDocenteDocumentos(docente.getDocenteDocumentos());
		docenteModel.setDocenteGrupoOcupacional(docente.getDocenteGrupoOcupacional());
		docenteModel.setDocenteNivel(docente.getDocenteNivel());
		docenteModel.setDocenteObservacionLimiteEdad(docente.getDocenteObservacionLimiteEdad());
		docenteModel.setDocenteObservacionOtros(docente.getDocenteObservacionOtros());
		docenteModel.setDocenteObservacionTiempoServicio(docente.getDocenteObservacionTiempoServicio());
		docenteModel.setDocenteRegular(docente.getDocenteRegular());
		docenteModel.setHistorialServicioIdhistorialServicio(docente.getHistorialServicioIdhistorialServicio());
		docenteModel.setIddocente(docente.getIddocente());
		docenteModel.setIdPersona(docente.getPersona().getIdPersona());
		
		return docenteModel;
	}
	
	
}
