package pe.edu.sistemas.sisrepweb.model;

public class RegistroAsistencia {
	
	private String escuela;
	private String curso;
	private String nroGrupo;
	private String tipo;
	private String horaInicio;
	private String horaFin;
	private String marcaEnt;
	private String marcaSal;
	private String fecha;
	private int horaNL;
	
	public RegistroAsistencia(){
		
	}

	public RegistroAsistencia(String escuela, String curso, String nroGrupo, String tipo, String horaInicio,
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

	public String getNroGrupo() {
		return nroGrupo;
	}

	public void setNroGrupo(String nroGrupo) {
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


	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "RegistroAsistencia [escuela=" + escuela + ", curso=" + curso + ", nroGrupo=" + nroGrupo + ", tipo="
				+ tipo + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", marcaEnt=" + marcaEnt
				+ ", marcaSal=" + marcaSal + ", fecha=" + fecha + ", horaNL=" + horaNL + "]";
	}
	
}
