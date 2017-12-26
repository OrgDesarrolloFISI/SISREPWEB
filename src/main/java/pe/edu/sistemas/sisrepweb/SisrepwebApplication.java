package pe.edu.sistemas.sisrepweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

@SpringBootApplication
public class SisrepwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SisrepwebApplication.class, args);
	}
	
	@Bean
	public JasperReportsPdfView getPlantillaPDF() {
	  JasperReportsPdfView view = new JasperReportsPdfView();
	  view.setUrl("classpath:/reportes/ReporteAsistencia.jrxml");
	  view.setReportDataKey("datasource");
	  return view;
	}
}
