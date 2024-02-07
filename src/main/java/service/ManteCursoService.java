package service;

import java.util.List;

import model.Curso;

public interface ManteCursoService {
	
	public Curso getCurso(int codCurso);
	public List<Curso> LisCurso();
	public int createCurso(Curso curso);
	public int upDateCurso(Curso curso);
	public int deleteCurso(int codCurso);
	public List<Curso> buscarCurso(int codCurso);
}
