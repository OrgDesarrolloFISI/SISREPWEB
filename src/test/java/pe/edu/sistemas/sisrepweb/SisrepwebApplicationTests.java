package pe.edu.sistemas.sisrepweb;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.sistemas.sisrepweb.component.DateHandler;
import pe.edu.sistemas.sisrepweb.domain.Docente;
import pe.edu.sistemas.sisrepweb.domain.Periodo;
import pe.edu.sistemas.sisrepweb.repository.DocenteRepository;
import pe.edu.sistemas.sisrepweb.service.PeriodoService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SisrepwebApplicationTests {

	
	@Autowired
	private DocenteRepository docenteRepository;
	
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
	public void pruebaObtenerTodasLasFechas() {
		List<DateTime> listaFechas = dateHandler.obtenerListaDeFechas("2017-12-11", "2018-12-15", 6);
		for(DateTime fecha: listaFechas)
			System.out.println(fecha.toString("yyyy-MM-dd"));
	}
	
	

}
