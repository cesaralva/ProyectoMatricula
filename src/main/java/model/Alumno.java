package model;

public class Alumno {

	Integer idAlumno;
	String dniAlumno;
	String nomAlumno;
	String apeAlumno;
	Integer edadAlumno;
	String correoAlumno;
	Integer estado;
	public Alumno() {
		
	}
	public Alumno(Integer idAlumno, String dniAlumno, String nomAlumno, String apeAlumno, Integer edadAlumno,
			String correoAlumno, Integer estado) {
		super();
		this.idAlumno = idAlumno;
		this.dniAlumno = dniAlumno;
		this.nomAlumno = nomAlumno;
		this.apeAlumno = apeAlumno;
		this.edadAlumno = edadAlumno;
		this.correoAlumno = correoAlumno;
		this.estado = estado;
	}
	public Integer getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}
	public String getDniAlumno() {
		return dniAlumno;
	}
	public void setDniAlumno(String dniAlumno) {
		this.dniAlumno = dniAlumno;
	}
	public String getNomAlumno() {
		return nomAlumno;
	}
	public void setNomAlumno(String nomAlumno) {
		this.nomAlumno = nomAlumno;
	}
	public String getApeAlumno() {
		return apeAlumno;
	}
	public void setApeAlumno(String apeAlumno) {
		this.apeAlumno = apeAlumno;
	}
	public Integer getEdadAlumno() {
		return edadAlumno;
	}
	public void setEdadAlumno(Integer edadAlumno) {
		this.edadAlumno = edadAlumno;
	}
	public String getCorreoAlumno() {
		return correoAlumno;
	}
	public void setCorreoAlumno(String correoAlumno) {
		this.correoAlumno = correoAlumno;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
	
	
	
}