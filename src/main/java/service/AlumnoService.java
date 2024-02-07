package service;

import java.util.List;

import model.Alumno;
import model.CursoMatricula;

public interface AlumnoService {
	public Alumno getAlumno(int id);
	public List<Alumno> listAlumno();
	public List<CursoMatricula> listCursoMatricula(int id);
	public int crearAlumno(Alumno a);
	public int actualizarAlumno(Alumno a);
	public int eliminarAlumno(int id);
	
	
}
