package service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Alumno;
import model.Retiro;
import service.ConsultaRetiroService;
import util.Conexion;

public  class ConsultaRetiroImpl implements ConsultaRetiroService {

	@Override
	public Alumno getAlumno(int id) {
		Alumno alum = null;
		Connection cn=null;
		PreparedStatement psmt = null;
		ResultSet res= null;
		try {
			cn= Conexion.getConexion();
			String query = "SELECT * FROM proyectomatricula.Alumno WHERE idAlumno=?";
			psmt = cn.prepareStatement(query);
			psmt.setInt(1, id);
			res = psmt.executeQuery();
			if(res.next()) {
				alum = new Alumno();
				alum.setIdAlumno(res.getInt("idAlumno"));
				alum.setDniAlumno(res.getString("dniAlumno"));
				alum.setNomAlumno(res.getString("nomAlumno"));
				alum.setEdadAlumno(res.getInt("edadAlumn"));
				alum.setApeAlumno(res.getString("apeAlumno"));
				alum.setCorreoAlumno(res.getString("correoAlumno"));
				alum.setEstado(res.getInt("estado"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(cn != null) cn.close();
				if(psmt != null) psmt.close();
				if(res != null) res.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return alum;
	}

	@Override
	public List<Alumno> listAlumno() {
		List<Alumno> listAlumno= new ArrayList<>();
		Connection cn = null;
		PreparedStatement psmt = null;
		ResultSet rs= null;
		try {
			cn= Conexion.getConexion();
			String query = "SELECT * FROM proyectomatricula.Alumno";
			psmt=cn.prepareStatement(query);
			rs=psmt.executeQuery();
			while(rs.next()) {
				Alumno alum = new Alumno();
				alum = new Alumno();
				alum.setIdAlumno(rs.getInt("idAlumno"));
				alum.setDniAlumno(rs.getString("dniAlumno"));
				alum.setNomAlumno(rs.getString("nomAlumno"));
				alum.setEdadAlumno(rs.getInt("edadAlumn"));
				alum.setApeAlumno(rs.getString("apeAlumno"));
				alum.setCorreoAlumno(rs.getString("correoAlumno"));
				alum.setEstado(rs.getInt("estado"));
				
				listAlumno.add(alum);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al Listar");

		}finally {
			try {
				if(cn!=null) cn.close();
				if(psmt!=null) psmt.close();
				if(rs!=null)rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return listAlumno;
	}

	@Override
	public List<Retiro> listConsultaRetiro(int id) {
		List<Retiro> listRetiro = new ArrayList<>();
		Connection cn = null;
		PreparedStatement psmt = null;
		ResultSet rs= null;
		try {
			cn= Conexion.getConexion();
			String query = "select * from proyectomatricula.Retiro"
					+ "where idAlumno = ?;";
			psmt=cn.prepareStatement(query);
			psmt.setInt(1, id);
			rs=psmt.executeQuery();
			while(rs.next()) {
				Retiro ret = new Retiro();
				ret.setNumRetiro(rs.getInt("numMatricula"));
				ret.setNumMatricula(rs.getInt("nomRetiro"));
				ret.setFecha(rs.getDate("ciclo"));
				ret.setHora(rs.getString("creditCurso"));
							
				
				listRetiro.add(ret);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al Listar");

		}finally {
			try {
				if(cn!=null) cn.close();
				if(psmt!=null) psmt.close();
				if(rs!=null)rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return listRetiro;
	}

	public int crearConsultaRetiro(Retiro r) {
		int value = 0;
		Connection cn=null;
		PreparedStatement psmt = null;
		try {
			cn = Conexion.getConexion();
			String query = "INSERT INTO proyectomatricula.Retiro (numRetiro,numMatricula,fecha,hora) VALUES (?,?,?,?)";
			psmt.setInt(1, r.getNumRetiro());
			psmt.setInt(2, r.getNumMatricula());
			psmt.setDate(3, r.getFecha());
			psmt.setString(4, r.getHora());
						
			value = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return value;
	}

	
	public int actualizarConsultaRetiro(Retiro r) {
		int value = 0;
		PreparedStatement psmt = null;
		Connection cn = null;
		try {
			cn = Conexion.getConexion();
			String query ="UPDATE proyectomatricula.Retiro"
			+ "SET numRetiro =?, numMatricula=?, fecha=?, hora=?";
		    
			psmt = cn.prepareStatement(query);
			psmt.setInt(1, r.getNumRetiro());
			psmt.setInt(2, r.getNumMatricula());
			psmt.setDate(3, r.getFecha());
			psmt.setString(4, r.getHora());
			
			value = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al Actualizar");
		}finally {
			try {
				if(cn != null) cn.close();
				if(psmt != null) psmt.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println("Error al Actualizar y cerrar");
			}
		}
		return value;
	}

	@Override
	public int eliminarConsultaRetiro(int id) {
		int value =0;
		Connection cn= null;
		PreparedStatement psmt = null;
		try {
			cn = Conexion.getConexion();
			String query = "DELETE FROM proyectomatricula.Retiro WHERE idAlumno=?";
			psmt = cn.prepareStatement(query);
			psmt.setInt(1, id);
			value = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al Eliminar");
		}finally {
			try {
				if(cn!=null) cn.close();
				if(psmt!=null) psmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				
			}
		}
		return value;
	}
	
}