package pe.edu.sistemas.sisrepweb.component;

import java.util.ArrayList;
import java.util.Date;
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
	
	public List<String> obtenerListaDeFechas(String fechaInicioConsulta, String fechFinConsulta, Integer diaInicioCurso){
		ArrayList<DateTime> listaFechas = new ArrayList<>();
		DateTime primeraFecha = obtenerPrimeraFecha(fechaInicioConsulta, diaInicioCurso);
		DateTime ultimaFechaConsulta = new DateTime(fechFinConsulta);
		
		while(primeraFecha.isBefore(ultimaFechaConsulta) || primeraFecha.equals(ultimaFechaConsulta)){						
			listaFechas.add(primeraFecha);
			primeraFecha = primeraFecha.plusDays(7);
		}
		List<String> ls = convertirListDTAString(listaFechas);
		return ls;
	}
	
	public Date convertirDateTimeADate(DateTime dt){
		Date d =  dt.toDate();
		return d;
	}
	
	public DateTime convertirDateADateTime(Date d){
		DateTime dt = new DateTime(d);
		return dt;
	}
	
	public Date convertirStringADate(String s){
		DateTime dt = new DateTime(s);
		Date d = convertirDateTimeADate(dt);
		return d;
	}
	
	public String convertirDateAString(Date d){
		DateTime dt = new DateTime(d);
		String s = dt.toString("yyyy-MM-dd");
		return s;
	}
	
	public List<Date> convertirListDTADate(List<DateTime> ldt){
		List<Date> ld = new ArrayList<>();
		for(DateTime dt: ldt){
			ld.add(convertirDateTimeADate(dt));
		}
		return ld;
	}
	
	public List<String> convertirListDTAString(List<DateTime> ldt){
		List<String> ls = new ArrayList<>();
		for(DateTime dt: ldt){
			ls.add(dt.toString("yyyy-MM-dd"));
		}
		return ls;
	}
	String str = String.format("%04d", 9);
	public String obtenerHora(Date d) {
		String h = String.format("%02d", d.getHours()) + ":" + 
					String.format("%02d", d.getMinutes()) + ":" + 
					String.format("%02d", d.getSeconds()); 
		return h;
	}

	public int obtenerDiferenciaDeHoras(Date horaInicio, Date horaFin) {
		int h = horaFin.getHours() - horaInicio.getHours();
		return h;
	}
	
}
