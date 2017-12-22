package pe.edu.sistemas.sisrepweb.model;

public class RegistroAsistencia {
	
	String escuela;
	String curso;
	int nroGrupo;
	String tipo;
	String horaInicio;	
	String horaFin;
	String marcaEnt;
	String marcaSal;
	String fecha;
	int horaNL;
	
	public RegistroAsistencia(){
		
	}
	
	public RegistroAsistencia(String escuela, String curso, int nroGrupo, String tipo, String horaInicio,
			String horaFin, String marcaEnt, String marcaSal, String fecha, int horaNL) {
		super();
		this.escuela = escuela;
		this.curso = curso;
		this.nroGrupo = nroGrupo;
		this.tipo = tipo;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.marcaEnt = marcaEnt;
		this.marcaSal = marcaSal;
		this.fecha = fecha;
		this.horaNL = horaNL;
	}

	public String getEscuela() {
		return escuela;
	}

	public void setEscuela(String escuela) {
		this.escuela = escuela;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getNroGrupo() {
		return nroGrupo;
	}

	public void setNroGrupo(int nroGrupo) {
		this.nroGrupo = nroGrupo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	public String getMarcaEnt() {
		return marcaEnt;
	}

	public void setMarcaEnt(String marcaEnt) {
		this.marcaEnt = marcaEnt;
	}

	public String getMarcaSal() {
		return marcaSal;
	}

	public void setMarcaSal(String marcaSal) {
		this.marcaSal = marcaSal;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getHoraNL() {
		return horaNL;
	}

	public void setHoraNL(int horaNL) {
		this.horaNL = horaNL;
	}

}
