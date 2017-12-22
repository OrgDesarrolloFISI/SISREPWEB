package pe.edu.sistemas.sisrepweb.model;

import java.util.List;

public class DocentePeriodo {

	private String codigoDocente;
	private String nombreDocente;
	private String periodoNombre;
	private String inicioFecha;
	private String finFecha;
	private int totalHNL;
	List<RegistroAsistencia> listaRegistroAsistencia;
	
	public DocentePeriodo(){}
	
	public DocentePeriodo(String codigoDocente, String nombreDocente, String periodoNombre, String inicioFecha,
			String finFecha, List<RegistroAsistencia> registroAsistencia) {
		super();
		this.codigoDocente = codigoDocente;
		this.nombreDocente = nombreDocente;
		this.periodoNombre = periodoNombre;
		this.inicioFecha = inicioFecha;
		this.finFecha = finFecha;
		this.listaRegistroAsistencia = registroAsistencia;
	}

	public String getCodigoDocente() {
		return codigoDocente;
	}

	public void setCodigoDocente(String codigoDocente) {
		this.codigoDocente = codigoDocente;
	}

	public String getNombreDocente() {
		return nombreDocente;
	}

	public void setNombreDocente(String nombreDocente) {
		this.nombreDocente = nombreDocente;
	}

	public String getPeriodoNombre() {
		return periodoNombre;
	}

	public void setPeriodoNombre(String periodoNombre) {
		this.periodoNombre = periodoNombre;
	}

	public String getInicioFecha() {
		return inicioFecha;
	}

	public void setInicioFecha(String inicioFecha) {
		this.inicioFecha = inicioFecha;
	}

	public String getFinFecha() {
		return finFecha;
	}

	public void setFinFecha(String finFecha) {
		this.finFecha = finFecha;
	}

	public List<RegistroAsistencia> getListaRegistroAsistencia() {
		return listaRegistroAsistencia;
	}

	public void setListaRegistroAsistencia(List<RegistroAsistencia> registroAsistencia) {
		this.listaRegistroAsistencia = registroAsistencia;
	}
	
	

	public int getTotalHNL() {
		return totalHNL;
	}

	public void setTotalHNL(int totalHNL) {
		this.totalHNL = totalHNL;
	}

	@Override
	public String toString() {
		return "DocentePeriodo [codigoDocente=" + codigoDocente + ", nombreDocente=" + nombreDocente
				+ ", periodoNombre=" + periodoNombre + ", inicioFecha=" + inicioFecha + ", finFecha=" + finFecha
				+ ", totalHNL=" + totalHNL + "]";
	}

	
	
	
}
