package model;

import java.sql.Date;

public class Matricula {
	//ATRIBUTOS PRIVADOS
		private Integer numMatricula;
		private Integer codAlumno;
		private Integer codCurso;
		private Date fecha;
		private String hora;
		private int estado;
		//CONSTRUCTORES
		public Matricula () {	
		}
		public Matricula(Integer numMatricula, Integer codAlumno, Integer codCurso, Date fecha, String hora,
				int estado) {
			super();
			this.numMatricula = numMatricula;
			this.codAlumno = codAlumno;
			this.codCurso = codCurso;
			this.fecha = fecha;
			this.hora = hora;
			this.estado = estado;
		}
		public Integer getNumMatricula() {
			return numMatricula;
		}
		public void setNumMatricula(Integer numMatricula) {
			this.numMatricula = numMatricula;
		}
		public Integer getCodAlumno() {
			return codAlumno;
		}
		public void setCodAlumno(Integer codAlumno) {
			this.codAlumno = codAlumno;
		}
		public Integer getCodCurso() {
			return codCurso;
		}
		public void setCodCurso(Integer codCurso) {
			this.codCurso = codCurso;
		}
		public Date getFecha() {
			return fecha;
		}
		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}
		public String getHora() {
			return hora;
		}
		public void setHora(String hora) {
			this.hora = hora;
		}
		public int getEstado() {
			return estado;
		}
		public void setEstado(int estado) {
			this.estado = estado;
		}
		
}
