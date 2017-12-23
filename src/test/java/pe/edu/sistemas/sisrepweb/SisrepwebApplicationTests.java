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
import pe.edu.sistemas.sisrepweb.domain.HorarioClase;
import pe.edu.sistemas.sisrepweb.domain.Periodo;
import pe.edu.sistemas.sisrepweb.model.DocentePeriodo;
import pe.edu.sistemas.sisrepweb.model.RegistroAsistencia;
import pe.edu.sistemas.sisrepweb.repository.AsistenciaRepository;
import pe.edu.sistemas.sisrepweb.repository.CursoPeriodoRepository;
import pe.edu.sistemas.sisrepweb.repository.DocenteRepository;
import pe.edu.sistemas.sisrepweb.repository.GrupoRepository;
import pe.edu.sistemas.sisrepweb.repository.HorarioClaseRepository;
import pe.edu.sistemas.sisrepweb.service.AsistenciaService;
import pe.edu.sistemas.sisrepweb.service.HorarioClaseService;
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
	private AsistenciaService asistenciaService;
	
	@Autowired
	private CursoPeriodoRepository cursoPeriodoRepository;
	
	@Autowired
	private HorarioClaseService horarioClaseService;
	
	@Autowired
	private HorarioClaseRepository horarioClaseRepository;
	
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
		List<String> listaFechas = dateHandler.obtenerListaDeFechas("2017-12-11", "2018-12-15", 6);
		for(String fecha: listaFechas)
			System.out.println(fecha);
	}
	
	
	@Test
	@Ignore
	public void pruebaObtenerGruposEspecificos() {
		List<Grupo> listaGrupos = null ; //grupoRepository.obtenerGruposxDocenteyEscuela("2017-II",24,200);
		//Si se ingresa idEscuela = 201 devuelve cursos de Sistemas
		//Si se ingresa idEscuela = 200 devuelve cursos de Software
		for(Grupo grupo: listaGrupos)
			logger.info(grupo.toString());
	}
	
	@Test
	@Ignore
	public void pruebaObtenerCursosEspecificos() {
		List<CursoPeriodo> listaCursos = null ;//cursoPeriodoRepository.obtenerCursosxDocenteyEscuela("2017-II",24,200);
		//Si se ingresa idEscuela = 201 devuelve cursos de Sistemas
		//Si se ingresa idEscuela = 200 devuelve cursos de Software
		for(CursoPeriodo curso: listaCursos)
			logger.info(curso.toString());
	}
	
	@Test
	@Ignore
	public void pruebaObtenerAsistenciasEspecificas() {
		

		// de Joda a JDK
		DateTime dt1 = new DateTime("2017-05-04"); 
		DateTime dt2 = new DateTime("2017-06-08");

		Date     date1     = dt1.toDate();
		Date     date2     = dt2.toDate();

		//List<Asistencia> listaAsistencias = asistenciaRepository.obtenerAsistenciasxGrupo(42,1455);
		/*List<Asistencia> listaAsistencias = asistenciaRepository.obtenerAsistenciasxDocenteyPeriodo(62,"2017-1", date1 , date2);
		for(Asistencia asistencia: listaAsistencias)
			logger.info(asistencia.toString());*/
	}
	
	@Test
	@Ignore
	public void pruebaArrayList() {
		
		List<Integer> l1 = new ArrayList<>();
		List<String> ls = new ArrayList<>();
		
		l1.add(1);
		l1.add(2);
		
		
		for(Integer s : l1){
			ls = dateHandler.obtenerListaDeFechas("2017-12-11", "2018-02-11", s);
			logger.info(s);
			
			for(String a : ls){
				logger.info(a);
			}
		}
		
		
		}
	
	@Test
	@Ignore
	public void pruebaDocentePeriodo(){
		DocentePeriodo dp,dp2;
		dp = new DocentePeriodo();
		
		dp.setCodigoDocente("0A1610");
		dp.setPeriodoNombre("2017-1");
		dp.setInicioFecha("2017-03-20");
		dp.setFinFecha("2017-07-14");
		
		dp2 = asistenciaService.generarRegistroAsistenciaDeDocente(dp);
		logger.info("DP2:" + dp2.toString());
		List<RegistroAsistencia> lra = dp2.getListaRegistroAsistencia();
		
		for(RegistroAsistencia ra: lra)
			logger.info("ASISTENCIAS-TEST:" + ra.toString());
	}
	
	@Test
	//@Ignore
	public void pruebaAsistenciasXHC(){
		
		List<HorarioClase> hc = horarioClaseRepository.obtenerHorarioCursos("055867", "2014-II");
		for(HorarioClase h: hc)
		{
			logger.info("HC: " + h.getIdhorarioClase() + ":" + h.getDia() + 
					":" + h.getGrupo().getGrupoNumero() + ":" + h.getHorarioClaseTipo()+
					":" + h.getGrupo().getCursoPeriodo().getIdcursoPeriodo()+
					":" + h.getGrupo().getCursoPeriodo().getCursoPeriodoNombre()+
					":" + h.getGrupo().getCursoPeriodo().getCursoConjunto().getCursocCodcomun()+
					":" + h.getGrupo().getCursoPeriodo().getCursoConjunto().getCursocNombre()+
					":" + h.getGrupo().getCursoPeriodo().getCursoConjunto().getCursoBase().getCursobNombre()+
					":" + h.getGrupo().getCursoPeriodo().getCursoConjunto().getCursoBase().getPlan().getPlanNombre());
			
		}
		
		
		
		
	}
}
