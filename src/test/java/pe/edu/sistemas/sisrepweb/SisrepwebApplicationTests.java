package pe.edu.sistemas.sisrepweb;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.sistemas.sisrepweb.component.DateHandler;
import pe.edu.sistemas.sisrepweb.controller.PageController;
import pe.edu.sistemas.sisrepweb.domain.Asistencia;
import pe.edu.sistemas.sisrepweb.domain.CursoPeriodo;
import pe.edu.sistemas.sisrepweb.domain.Docente;
import pe.edu.sistemas.sisrepweb.domain.Grupo;
import pe.edu.sistemas.sisrepweb.domain.Periodo;
import pe.edu.sistemas.sisrepweb.repository.AsistenciaRepository;
import pe.edu.sistemas.sisrepweb.repository.CursoPeriodoRepository;
import pe.edu.sistemas.sisrepweb.repository.DocenteRepository;
import pe.edu.sistemas.sisrepweb.repository.GrupoRepository;
import pe.edu.sistemas.sisrepweb.service.PeriodoService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SisrepwebApplicationTests {

	protected final Log logger = LogFactory.getLog(SisrepwebApplicationTests.class);
	
	@Autowired
	private DocenteRepository docenteRepository;
	
	@Autowired
	private AsistenciaRepository asistenciaRepository;
	
	@Autowired
	private CursoPeriodoRepository cursoPeriodoRepository;
	
	@Autowired
	private GrupoRepository grupoRepository;
	
	
	@Autowired
	private PeriodoService periodoService;
	
	@Autowired
	private DateHandler dateHandler;
	
	@Test
	@Ignore
	public void contextLoads() {
	}
	
	
	@Test
	@Ignore
	public void pruebaDocenteLike() {
		ArrayList<Docente> docentes = (ArrayList<Docente>) docenteRepository.buscarDocentesPorCodigoParcial("022");
		for(Docente d : docentes){

			System.out.println(d.getPersona().getPersonaCodigo());
		}
			
	}
	
	
	@Test
	@Ignore
	public void pruebaPeriodoUltimo() {
		Periodo periodo = periodoService.buscarUltimoPeriodo();
		System.out.println(periodo.getIdperiodo());	 		
	}
	
	@Test
	@Ignore
	public void pruebaObtenerPrimeraFecha() {
		DateTime fechaInicio = dateHandler.obtenerPrimeraFecha("2017-08-15", 7);
		String solofecha = fechaInicio.toString("yyyy-MM-dd");
		System.out.println(solofecha);
	}
	
	@Test
	@Ignore
	public void pruebaObtenerTodasLasFechas() {
		List<DateTime> listaFechas = dateHandler.obtenerListaDeFechas("2017-12-11", "2018-12-15", 6);
		for(DateTime fecha: listaFechas)
			System.out.println(fecha.toString("yyyy-MM-dd"));
	}
	
	
	@Test
	@Ignore
	public void pruebaObtenerGruposEspecificos() {
		List<Grupo> listaGrupos = grupoRepository.obtenerGruposxDocenteyEscuela("2017-II",24,200);
		//Si se ingresa idEscuela = 201 devuelve cursos de Sistemas
		//Si se ingresa idEscuela = 200 devuelve cursos de Software
		for(Grupo grupo: listaGrupos)
			logger.info(grupo.toString());
	}
	
	@Test
	@Ignore
	public void pruebaObtenerCursosEspecificos() {
		List<CursoPeriodo> listaCursos = cursoPeriodoRepository.obtenerCursosxDocenteyEscuela("2017-II",24,200);
		//Si se ingresa idEscuela = 201 devuelve cursos de Sistemas
		//Si se ingresa idEscuela = 200 devuelve cursos de Software
		for(CursoPeriodo curso: listaCursos)
			logger.info(curso.toString());
	}
	
	@Test
	public void pruebaObtenerAsistenciasEspecificas() {
		

		// de Joda a JDK
		DateTime dt1 = new DateTime("2017-05-04"); 
		DateTime dt2 = new DateTime("2017-06-08");

		Date     date1     = dt1.toDate();
		Date     date2     = dt2.toDate();

		//List<Asistencia> listaAsistencias = asistenciaRepository.obtenerAsistenciasxGrupo(42,1455);
		List<Asistencia> listaAsistencias = asistenciaRepository.obtenerAsistenciasxCurso(42,1455, date1 , date2);
		for(Asistencia asistencia: listaAsistencias)
			logger.info(asistencia.toString());
	}

}
