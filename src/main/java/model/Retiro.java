package model;

import java.sql.Date;

public class Retiro {
	//ATRIBUTOS
	private Integer numRetiro;
	private Integer numMatricula;
	private Date fecha;
	private String hora;
	//CONTRSUCTORS
	public Retiro() {
		//super();
	}
	public Retiro(Integer numRetiro, Integer numMatricula, Date fecha, String hora) {
		super();
		this.numRetiro = numRetiro;
		this.numMatricula = numMatricula;
		this.fecha = fecha;
		this.hora = hora;
	}
	//GET SET
	public Integer getNumRetiro() {
		return numRetiro;
	}
	public void setNumRetiro(Integer numRetiro) {
		this.numRetiro = numRetiro;
	}
	public Integer getNumMatricula() {
		return numMatricula;
	}
	public void setNumMatricula(Integer numMatricula) {
		this.numMatricula = numMatricula;
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
}
