package model;

public class CursoMatricula {
	
	private int numMatricula;
	private String nomCurso;
	private int ciclo;
	private int creditCurso;
	private int horasdeCurso;
	
	public CursoMatricula() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CursoMatricula(int numMatricula, String nomCurso, int ciclo, int creditCurso, int horasdeCurso) {
		super();
		this.numMatricula = numMatricula;
		this.nomCurso = nomCurso;
		this.ciclo = ciclo;
		this.creditCurso = creditCurso;
		this.horasdeCurso = horasdeCurso;
	}

	public int getNumMatricula() {
		return numMatricula;
	}

	public void setNumMatricula(int numMatricula) {
		this.numMatricula = numMatricula;
	}

	public String getNomCurso() {
		return nomCurso;
	}

	public void setNomCurso(String nomCurso) {
		this.nomCurso = nomCurso;
	}

	public int getCiclo() {
		return ciclo;
	}

	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}

	public int getCreditCurso() {
		return creditCurso;
	}

	public void setCreditCurso(int creditCurso) {
		this.creditCurso = creditCurso;
	}

	public int getHorasdeCurso() {
		return horasdeCurso;
	}

	public void setHorasdeCurso(int horasdeCurso) {
		this.horasdeCurso = horasdeCurso;
	}
	
	
	
	
}