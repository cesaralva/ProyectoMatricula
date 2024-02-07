package service;

import java.util.List;

import model.Alumno;
import model.Retiro;

public interface ConsultaRetiroService {
	public Alumno getAlumno(int id);
	public List<Alumno> listAlumno();
	public List<Retiro>listConsultaRetiro(int id);
	public int crearConsultaRetiro(Retiro r);
	public int actualizarConsultaRetiro(Retiro r);
	public int eliminarConsultaRetiro(int id);
	
	
	
}