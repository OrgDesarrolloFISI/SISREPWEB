package pe.edu.sistemas.sisrepweb.model;

import java.util.Date;


public class AsistenciaModel implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idasistencia;
	private Integer idHorarioClase;
	private Date asistenciaHoraIngreso;
	private Date asistenciaHoraSalida;
	private String asistenciaTema;
	private Date asistenciaFecha;
	private String asistenciaObservacion;
	private String asistenciaTipoMarca;
	private Integer motivoIdmotivo;

	public AsistenciaModel() {
	}

	public AsistenciaModel(Integer idasistencia, Integer idHorarioClase, Date asistenciaHoraIngreso, Date asistenciaHoraSalida,
			String asistenciaTema, Date asistenciaFecha, String asistenciaObservacion, String asistenciaTipoMarca,
			Integer motivoIdmotivo) {
		this.idasistencia = idasistencia;
		this.idHorarioClase = idHorarioClase;
		this.asistenciaHoraIngreso = asistenciaHoraIngreso;
		this.asistenciaHoraSalida = asistenciaHoraSalida;
		this.asistenciaTema = asistenciaTema;
		this.asistenciaFecha = asistenciaFecha;
		this.asistenciaObservacion = asistenciaObservacion;
		this.asistenciaTipoMarca = asistenciaTipoMarca;
		this.motivoIdmotivo = motivoIdmotivo;
	}

	public Integer getIdasistencia() {
		return this.idasistencia;
	}

	public void setIdasistencia(Integer idasistencia) {
		this.idasistencia = idasistencia;
	}

	public Integer getIdHorarioClase() {
		return this.idHorarioClase;
	}

	public void setIdHorarioClase(Integer idHorarioClase) {
		this.idHorarioClase = idHorarioClase;
	}

	public Date getAsistenciaHoraIngreso() {
		return this.asistenciaHoraIngreso;
	}

	public void setAsistenciaHoraIngreso(Date asistenciaHoraIngreso) {
		this.asistenciaHoraIngreso = asistenciaHoraIngreso;
	}

	public Date getAsistenciaHoraSalida() {
		return this.asistenciaHoraSalida;
	}

	public void setAsistenciaHoraSalida(Date asistenciaHoraSalida) {
		this.asistenciaHoraSalida = asistenciaHoraSalida;
	}

	public String getAsistenciaTema() {
		return this.asistenciaTema;
	}

	public void setAsistenciaTema(String asistenciaTema) {
		this.asistenciaTema = asistenciaTema;
	}

	public Date getAsistenciaFecha() {
		return this.asistenciaFecha;
	}

	public void setAsistenciaFecha(Date asistenciaFecha) {
		this.asistenciaFecha = asistenciaFecha;
	}

	public String getAsistenciaObservacion() {
		return this.asistenciaObservacion;
	}

	public void setAsistenciaObservacion(String asistenciaObservacion) {
		this.asistenciaObservacion = asistenciaObservacion;
	}

	public String getAsistenciaTipoMarca() {
		return this.asistenciaTipoMarca;
	}

	public void setAsistenciaTipoMarca(String asistenciaTipoMarca) {
		this.asistenciaTipoMarca = asistenciaTipoMarca;
	}

	public Integer getMotivoIdmotivo() {
		return this.motivoIdmotivo;
	}

	public void setMotivoIdmotivo(Integer motivoIdmotivo) {
		this.motivoIdmotivo = motivoIdmotivo;
	}

	@Override
	public String toString() {
		return "Asistencia [idasistencia=" + idasistencia
				+ ", asistenciaHoraIngreso=" + asistenciaHoraIngreso + ", asistenciaHoraSalida=" + asistenciaHoraSalida
				+ ", asistenciaTema=" + asistenciaTema + ", asistenciaFecha=" + asistenciaFecha
				+ ", asistenciaObservacion=" + asistenciaObservacion + ", asistenciaTipoMarca=" + asistenciaTipoMarca
				+ ", motivoIdmotivo=" + motivoIdmotivo + "]";
	}

	
}
