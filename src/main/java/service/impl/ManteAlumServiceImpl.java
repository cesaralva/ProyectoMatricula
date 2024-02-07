package service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxCrud.ViewAlgorithm;

import model.Alumno;
import service.MantenimientoAlumnoService;
import util.Conexion;


public class ManteAlumServiceImpl implements MantenimientoAlumnoService {

	@Override
	public Alumno getAlumno(int idAlumno) {
		Alumno alum = null;
		Connection cn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			cn = Conexion.getConexion();
			String query = "SELECT * FROM Alumno WHERE idAlumno = ?";
			psmt =cn.prepareStatement(query);
			psmt.setInt(1, idAlumno);
			rs = psmt.executeQuery();
			if(rs.next()) {
				
				alum = new Alumno();
				alum.setIdAlumno(rs.getInt("idAlumno"));
				alum.setDniAlumno(rs.getString("dniAlumno"));
				alum.setNomAlumno(rs.getString("nomAlumno"));
				alum.setApeAlumno(rs.getString("apeAlumno"));
				alum.setEdadAlumno(rs.getInt("edadAlumn"));
				alum.setCorreoAlumno(rs.getString("correoAlumno"));
				alum.setEstado(rs.getInt("estado"));
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(cn != null)cn.close();
				if(rs != null)rs.close();
				if(psmt != null)psmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return alum;
	}

	@Override
	public List<Alumno> listAlumno() {
			List<Alumno> listAlum = new ArrayList<>();
			Connection cn = null;
			PreparedStatement psmt = null;
			ResultSet rs = null;
			
			try {
				cn = Conexion.getConexion();
				String query = "SELECT * FROM Alumno";
				psmt = cn.prepareStatement(query);
				rs = psmt.executeQuery();
				
				while(rs.next()){
					 Alumno alum = new Alumno();
						alum.setIdAlumno(rs.getInt("idAlumno"));
						alum.setDniAlumno(rs.getString("dniAlumno"));
						alum.setNomAlumno(rs.getString("nomAlumno"));
						alum.setApeAlumno(rs.getString("apeAlumno"));
						alum.setEdadAlumno(rs.getInt("edadAlumn"));
						alum.setCorreoAlumno(rs.getString("correoAlumno"));
						alum.setEstado(rs.getInt("estado")); 
						listAlum.add(alum);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(cn != null)cn.close();
					if(rs != null)rs.close();
					if(psmt != null)psmt.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		return listAlum;
	}

	@Override
	public int crearAlumno(Alumno alumno) {
		int value =0;
		Connection cn = null;
		PreparedStatement psmt = null;
		
		try {
			cn = Conexion.getConexion();
			String query = "INSERT INTO Alumno (dniAlumno ,nomAlumno ,apeAlumno ,edadAlumn ,correoAlumno ,estado)value(?,?,?,?,?,?)";
			psmt = cn.prepareStatement(query);
			
			psmt.setString(1, alumno.getDniAlumno());
			psmt.setString(2, alumno.getNomAlumno());
			psmt.setString(3, alumno.getApeAlumno());
			psmt.setInt(4, alumno.getEdadAlumno());
			psmt.setString(5, alumno.getCorreoAlumno());
			psmt.setInt(6, alumno.getEstado());
			value = psmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(cn != null)cn.close();
				if(psmt != null)psmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return value;
	}

	@Override
	public int upDateAlumno(Alumno alumno) {
		 int value =0;
		 Connection cn = null;
		 PreparedStatement psmt = null;
		 
		 try {
			cn = Conexion.getConexion();
			String query ="update Alumno "
					+ "set dniAlumno=?, nomAlumno=?, apeAlumno=?, edadAlumn=?, correoAlumno=?, estado=? "
					+"where idAlumno=?";
			psmt = cn.prepareStatement(query);
			psmt.setString(1, alumno.getDniAlumno());
			psmt.setString(2, alumno.getNomAlumno());
			psmt.setString(3, alumno.getApeAlumno());
			psmt.setInt(4, alumno.getEdadAlumno());
			psmt.setString(5, alumno.getCorreoAlumno());
			psmt.setInt(6, alumno.getEstado());
			psmt.setInt(7, alumno.getIdAlumno());
			value = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(cn != null)cn.close();
				if(psmt != null)psmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return value;
	}

	@Override
	public int deleteAlumno(int idAlumno) {
		int value = 0;
		Connection cn = null;
		PreparedStatement psmt = null;
		
		try {
			cn = Conexion.getConexion();
			String query ="delete from Alumno where idAlumno=?";
			psmt = cn.prepareStatement(query);
			psmt.setInt(1,idAlumno );
			value = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(cn != null)cn.close();
				if(psmt != null)psmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return value;
	}

	@Override
	public List<Alumno> buscarAlumno(String dni) {
		
		List<Alumno> busAlum =new  ArrayList<>();
		Connection cn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			cn = Conexion.getConexion();
			String query = "SELECT * FROM Alumno WHERE dniAlumno = ?";
			psmt =cn.prepareStatement(query);
			psmt.setString(1, dni);
			rs = psmt.executeQuery();
			while(rs.next()) {
				
				Alumno	alum = new Alumno();
				alum.setIdAlumno(rs.getInt("idAlumno"));
				alum.setDniAlumno(rs.getString("dniAlumno"));
				alum.setNomAlumno(rs.getString("nomAlumno"));
				alum.setApeAlumno(rs.getString("apeAlumno"));
				alum.setEdadAlumno(rs.getInt("edadAlumn"));
				alum.setCorreoAlumno(rs.getString("correoAlumno"));
				alum.setEstado(rs.getInt("estado"));
				busAlum.add(alum);
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(cn != null)cn.close();
				if(rs != null)rs.close();
				if(psmt != null)psmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return busAlum;
		
	}

}
