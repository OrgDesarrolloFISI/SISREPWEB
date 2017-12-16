package pe.edu.sistemas.sisrepweb.model;
// Generated 27/03/2017 05:07:29 PM by Hibernate Tools 4.3.1.Final


public class DocenteModel {

	private Integer iddocente;
	private Integer idPersona;
	private String docenteClave;
	private String docenteGrupoOcupacional;
	private String docenteNivel;
	private String docenteObservacionTiempoServicio;
	private String docenteObservacionLimiteEdad;
	private String docenteObservacionOtros;
	private String docenteDocumentos;
	private int docenteRegular;
	private Short claseIdclase;
	private Short categoriaDocenteIdecategoriaDocente;
	private Integer docenteDepartamentoAcademico;
	private Integer historialServicioIdhistorialServicio;
	
	public DocenteModel(){
	}
	
	public DocenteModel(Integer iddocente, Integer idPersona, String docenteClave, String docenteGrupoOcupacional,
			String docenteNivel, String docenteObservacionTiempoServicio, String docenteObservacionLimiteEdad,
			String docenteObservacionOtros, String docenteDocumentos, int docenteRegular, Short claseIdclase,
			Short categoriaDocenteIdecategoriaDocente, Integer docenteDepartamentoAcademico,
			Integer historialServicioIdhistorialServicio) {
		super();
		this.iddocente = iddocente;
		this.idPersona = idPersona;
		this.docenteClave = docenteClave;
		this.docenteGrupoOcupacional = docenteGrupoOcupacional;
		this.docenteNivel = docenteNivel;
		this.docenteObservacionTiempoServicio = docenteObservacionTiempoServicio;
		this.docenteObservacionLimiteEdad = docenteObservacionLimiteEdad;
		this.docenteObservacionOtros = docenteObservacionOtros;
		this.docenteDocumentos = docenteDocumentos;
		this.docenteRegular = docenteRegular;
		this.claseIdclase = claseIdclase;
		this.categoriaDocenteIdecategoriaDocente = categoriaDocenteIdecategoriaDocente;
		this.docenteDepartamentoAcademico = docenteDepartamentoAcademico;
		this.historialServicioIdhistorialServicio = historialServicioIdhistorialServicio;
	}


	public Integer getIddocente() {
		return iddocente;
	}


	public void setIddocente(Integer iddocente) {
		this.iddocente = iddocente;
	}


	public Integer getIdPersona() {
		return idPersona;
	}


	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}


	public String getDocenteClave() {
		return docenteClave;
	}


	public void setDocenteClave(String docenteClave) {
		this.docenteClave = docenteClave;
	}


	public String getDocenteGrupoOcupacional() {
		return docenteGrupoOcupacional;
	}


	public void setDocenteGrupoOcupacional(String docenteGrupoOcupacional) {
		this.docenteGrupoOcupacional = docenteGrupoOcupacional;
	}


	public String getDocenteNivel() {
		return docenteNivel;
	}


	public void setDocenteNivel(String docenteNivel) {
		this.docenteNivel = docenteNivel;
	}


	public String getDocenteObservacionTiempoServicio() {
		return docenteObservacionTiempoServicio;
	}


	public void setDocenteObservacionTiempoServicio(String docenteObservacionTiempoServicio) {
		this.docenteObservacionTiempoServicio = docenteObservacionTiempoServicio;
	}


	public String getDocenteObservacionLimiteEdad() {
		return docenteObservacionLimiteEdad;
	}


	public void setDocenteObservacionLimiteEdad(String docenteObservacionLimiteEdad) {
		this.docenteObservacionLimiteEdad = docenteObservacionLimiteEdad;
	}


	public String getDocenteObservacionOtros() {
		return docenteObservacionOtros;
	}


	public void setDocenteObservacionOtros(String docenteObservacionOtros) {
		this.docenteObservacionOtros = docenteObservacionOtros;
	}


	public String getDocenteDocumentos() {
		return docenteDocumentos;
	}


	public void setDocenteDocumentos(String docenteDocumentos) {
		this.docenteDocumentos = docenteDocumentos;
	}


	public int getDocenteRegular() {
		return docenteRegular;
	}


	public void setDocenteRegular(int docenteRegular) {
		this.docenteRegular = docenteRegular;
	}


	public Short getClaseIdclase() {
		return claseIdclase;
	}


	public void setClaseIdclase(Short claseIdclase) {
		this.claseIdclase = claseIdclase;
	}


	public Short getCategoriaDocenteIdecategoriaDocente() {
		return categoriaDocenteIdecategoriaDocente;
	}


	public void setCategoriaDocenteIdecategoriaDocente(Short categoriaDocenteIdecategoriaDocente) {
		this.categoriaDocenteIdecategoriaDocente = categoriaDocenteIdecategoriaDocente;
	}


	public Integer getDocenteDepartamentoAcademico() {
		return docenteDepartamentoAcademico;
	}


	public void setDocenteDepartamentoAcademico(Integer docenteDepartamentoAcademico) {
		this.docenteDepartamentoAcademico = docenteDepartamentoAcademico;
	}


	public Integer getHistorialServicioIdhistorialServicio() {
		return historialServicioIdhistorialServicio;
	}


	public void setHistorialServicioIdhistorialServicio(Integer historialServicioIdhistorialServicio) {
		this.historialServicioIdhistorialServicio = historialServicioIdhistorialServicio;
	}

	
	
}