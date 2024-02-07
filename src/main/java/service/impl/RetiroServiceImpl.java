package service.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Retiro;
import service.RetiroService;
import util.Conexion;


public class RetiroServiceImpl implements RetiroService{

	@Override
	public Retiro getRetiro(int numRetiro) {
		Retiro retiro = null;
		Connection cn=null;
		PreparedStatement psmt = null;
		ResultSet reset= null;
		System.out.println("getRetiro"+numRetiro);
		try {
			cn= Conexion.getConexion();
			String query = "SELECT * FROM retiro WHERE numRetiro=?";
			psmt = cn.prepareStatement(query);
			psmt.setInt(1, numRetiro);
			reset = psmt.executeQuery();
			if (reset.next()) {
				retiro = new Retiro();
				retiro.setNumRetiro(reset.getInt("numRetiro"));
				retiro.setNumMatricula(reset.getInt("numMatricula"));
				retiro.setFecha(reset.getDate("fecha"));
				retiro.setHora(reset.getString("hora"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {//cerrar luego de abrir
				if(cn != null) cn.close();
				if(psmt != null) psmt.close();
				if(reset != null) reset.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}		
		return retiro;
	}

	@Override
	public int crearRetiro(Retiro retiro) {
		int value = 0;
		Connection cn = null;
		PreparedStatement psmt = null;
		try {
			cn = Conexion.getConexion();
			String query = "INSERT INTO proyectomatricula.retiro" +
				"(numMatricula,fecha,hora) VALUES(?, ?, ?)";
			psmt = cn.prepareStatement(query);
			//psmt.setInt(1, retiro.getNumRetiro());
			psmt.setInt(1, retiro.getNumMatricula());
			psmt.setDate(2, retiro.getFecha());
			psmt.setString(3, retiro.getHora());
			value = psmt.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
			value=0;
		} finally {
			try { 
				if(cn != null) cn.close();
				if(psmt != null) psmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
		}
	}
		return value;
	}

	
	
	@Override
	public List<Retiro> listRetiro() {
		List<Retiro> listRetiro = new ArrayList<>();
		Connection cn=null;
		PreparedStatement psmt = null;
		ResultSet reset= null;
		try {
			cn = Conexion.getConexion();
			String query = "Select * from retiro";
			psmt = cn.prepareStatement(query);
			reset = psmt.executeQuery();
			while(reset.next()) {
				Retiro retiro = new Retiro();
				retiro.setNumRetiro(reset.getInt("numRetiro"));
				retiro.setNumMatricula(reset.getInt("numMatricula"));
				retiro.setFecha(reset.getDate("fecha"));
				retiro.setHora(reset.getString("hora"));
				listRetiro.add(retiro);
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {//cerrar luego de abrir
				if(cn != null) cn.close();
				if(psmt != null) psmt.close();
				if(reset != null) reset.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}		
		return listRetiro;
		}

	@Override
	public int actualizarRetiro(Retiro retiro) {
		int value=0;
		Connection cn = null;
		PreparedStatement psmt = null;
		try {
			cn = Conexion.getConexion();
			String query = "UPDATE proyectomatricula.retiro " + 
					"SET numMatricula=?, fecha=?, hora=? " +
					"WHERE numRetiro=?";
			psmt = cn.prepareStatement(query);
			
			psmt.setInt(1, retiro.getNumMatricula());
			psmt.setDate(2, retiro.getFecha());
			psmt.setString(3, retiro.getHora());
			psmt.setInt(4, retiro.getNumRetiro());
			value = psmt.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { 
				if(cn != null) cn.close();
				if(psmt != null) psmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
		}
	}
		return value;
	}
	
	
	
	/*@Override
		public int retirarMatricula(int id) {
		int value=0;
		Connection cn=null;
		PreparedStatement psmt = null;
		try {
			cn = MySQLConexion.getConexion();
			String query =  "DELETE FROM proyectomatricula.retiro" +
					"WHERE numRetiro=?";
			psmt = cn.prepareStatement(query);
			psmt.setInt(1,id);
			value = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { 
				if(cn != null) cn.close();
				if(psmt != null) psmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return value;
	}
*/










}
