package service;

import java.util.List;

import model.Matricula;
import model.Registro;

public interface RegistroService {
		
	public Registro getRegistro(int id);
	public List<Registro> listRegistro();
	public Boolean crearRegistro(Registro reg);
	public Boolean actualizarRegistro(Registro reg);
	public Boolean eliminarRegistro(int id);
}
