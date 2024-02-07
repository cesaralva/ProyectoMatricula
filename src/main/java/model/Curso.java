package model;

public class Curso {
	
	Integer codCurso;
	 String nomCurso;
	Integer ciclo;
	Integer creditCurso;
	Integer horasCurso;
	
	public Curso() {
		
	}

	public Curso(Integer codCurso, String nomCurso, Integer ciclo, Integer creditCurso, Integer horasCurso) {
		super();
		this.codCurso = codCurso;
		this.nomCurso = nomCurso;
		this.ciclo = ciclo;
		this.creditCurso = creditCurso;
		this.horasCurso = horasCurso;
	}

	public Integer getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(Integer codCurso) {
		this.codCurso = codCurso;
	}

	public String getNomCurso() {
		return nomCurso;
	}

	public void setNomCurso(String nomCurso) {
		this.nomCurso = nomCurso;
	}

	public Integer getCiclo() {
		return ciclo;
	}

	public void setCiclo(Integer ciclo) {
		this.ciclo = ciclo;
	}

	public Integer getCreditCurso() {
		return creditCurso;
	}

	public void setCreditCurso(Integer creditCurso) {
		this.creditCurso = creditCurso;
	}

	public Integer getHorasCurso() {
		return horasCurso;
	}

	public void setHorasCurso(Integer horasCurso) {
		this.horasCurso = horasCurso;
	}
	
	
	
	
	
	
	
		

}
