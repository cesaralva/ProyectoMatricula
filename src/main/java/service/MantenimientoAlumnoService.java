package service;

import java.util.List;

import model.Alumno;

public interface MantenimientoAlumnoService {
	
	public Alumno getAlumno(int idAlumno);
	public List<Alumno> listAlumno();
	public int crearAlumno(Alumno alumno);
	public int upDateAlumno(Alumno alumno);
	public int deleteAlumno(int idAlumno);
	public List<Alumno> buscarAlumno(String dni);

}
