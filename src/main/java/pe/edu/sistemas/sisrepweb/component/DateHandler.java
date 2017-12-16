package pe.edu.sistemas.sisrepweb.component;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

@Component
public class DateHandler {

	public DateTime obtenerPrimeraFecha(String fechaInicioConsulta, int diaInicioCurso){
		DateTime primeraFecha = new DateTime(fechaInicioConsulta);
		int diaDeLaSemana = primeraFecha.getDayOfWeek();
		int extra = 0;
		if(diaInicioCurso < diaDeLaSemana)
			extra = extra + 7 + diaInicioCurso -  diaDeLaSemana;
		else
			if(diaInicioCurso > diaDeLaSemana)
				extra =extra  + diaInicioCurso - diaDeLaSemana;
		
		primeraFecha = primeraFecha.plusDays(extra);
		return primeraFecha;
	}
	
	public List<DateTime> obtenerListaDeFechas(String fechaInicioConsulta, String fechFinConsulta, int diaInicioCurso){
		ArrayList<DateTime> listaFechas = new ArrayList<>();
		DateTime primeraFecha = obtenerPrimeraFecha(fechaInicioConsulta, diaInicioCurso);
		DateTime ultimaFechaConsulta = new DateTime(fechFinConsulta);
		
		while(primeraFecha.isBefore(ultimaFechaConsulta) || primeraFecha.equals(ultimaFechaConsulta)){						
			listaFechas.add(primeraFecha);
			primeraFecha = primeraFecha.plusDays(7);
		}
	
		return listaFechas;
	}
	
}
