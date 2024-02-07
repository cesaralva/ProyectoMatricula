package service;

import java.util.List;

import model.Retiro;

public interface RetiroService {
	public Retiro getRetiro (int numRetiro);
	public List<Retiro> listRetiro ();
	public int crearRetiro(Retiro r);
	public int actualizarRetiro (Retiro retiro);
	//public int retirarRetiro( int numRetiro);
}
