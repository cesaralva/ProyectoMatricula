package service;

import java.util.List;

import model.Matricula;

public interface MatriculaService {
	public Matricula getMatricula(int id);
	public List<Matricula> listMatricula();
	public int crearMatricula(Matricula m);
	public int actualizarMatricula(Matricula m);
	public int eliminarMatricula(int id);
	public Matricula buscarPorAlumnoYCurso(int idAlumno, int codCurso);
}
