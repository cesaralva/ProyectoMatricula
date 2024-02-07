package service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Matricula;
import service.MatriculaService;
import util.Conexion;
import util.Fecha;

public class MatriculaServiceImpl implements MatriculaService{
   
	Fecha fech = new Fecha();

	@Override
	public Matricula getMatricula(int id) {
		Matricula matri = null;
		Connection cn=null;
		PreparedStatement psmt = null;
		ResultSet res= null;
		try {
			cn= Conexion.getConexion();
			String query = "SELECT * FROM Matricula WHERE numMatricula=?";
			psmt = cn.prepareStatement(query);
			psmt.setInt(1, id);
			res = psmt.executeQuery();
			if(res.next()) {
				matri = new Matricula();
				matri.setNumMatricula(res.getInt("numMatricula"));
				matri.setCodAlumno(res.getInt("idAlumno"));
				matri.setCodCurso(res.getInt("codCurso"));
				matri.setFecha(res.getDate("fecha"));
				matri.setHora(res.getString("hora"));
				matri.setEstado(res.getInt("estado"));
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
		// TODO Auto-generated method stub
		return matri;
	}

	@Override
	public List<Matricula> listMatricula() {
		List<Matricula> listMatricula = new ArrayList<>();
		Connection cn = null;
		PreparedStatement psmt = null;
		ResultSet rs= null;
		try {
			cn= Conexion.getConexion();
			String query = "SELECT * FROM Matricula";
			psmt=cn.prepareStatement(query);
			rs=psmt.executeQuery();
			while(rs.next()) {
				Matricula mat = new Matricula();
				mat.setNumMatricula(rs.getInt("numMatricula"));
				mat.setCodAlumno(rs.getInt("idAlumno"));
				mat.setCodCurso(rs.getInt("codCurso"));
				mat.setFecha(rs.getDate("fecha"));
				mat.setHora(rs.getString("hora"));
				mat.setEstado(rs.getInt("estado"));
				
				listMatricula.add(mat);
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
		return listMatricula;
	}

	@Override
	public int crearMatricula(Matricula m) {
		int value = 0;
		Connection cn=null;
		PreparedStatement psmt = null;
		try {
			cn = Conexion.getConexion();
			String query = "INSERT INTO Matricula (idAlumno,codCurso,fecha,hora,estado) VALUES (?,?,?,?,?)";
			psmt=cn.prepareStatement(query);
			psmt.setInt(1, m.getCodAlumno());
			psmt.setInt(2, m.getCodCurso());
			psmt.setDate(3, m.getFecha());
			psmt.setString(4, m.getHora());
			psmt.setInt(5, m.getEstado());
			
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

	@Override
	public int actualizarMatricula(Matricula m) {
		int value = 0;
		PreparedStatement psmt = null;
		Connection cn = null;
		try {
			cn = Conexion.getConexion();
			String query ="UPDATE proyectomatricula.Matricula "
			+ "SET idAlumno=?, codCurso =?, fecha=?, hora=?, estado=? "
		    + "WHERE numMatricula=?";
			psmt = cn.prepareStatement(query);
			psmt.setInt(1, m.getCodAlumno());
			psmt.setInt(2, m.getCodCurso());
			psmt.setDate(3, m.getFecha());
			psmt.setString(4, m.getHora());
			psmt.setInt(5, m.getEstado());
			psmt.setInt(6, m.getNumMatricula());

			value = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al Actualizar mi king");
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
	public int eliminarMatricula(int id) {
		int value =0;
		Connection cn= null;
		PreparedStatement psmt = null;
		try {
			cn = Conexion.getConexion();
			String query = "DELETE FROM Matricula WHERE numMatricula=?";
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
	@Override
	public Matricula buscarPorAlumnoYCurso(int idAlumno, int codCurso) {
	    Connection cn = null;
	    PreparedStatement psmt = null;
	    ResultSet rs = null;
	    Matricula matricula = null;

	    try {
	        cn = Conexion.getConexion();
	        String query = "SELECT * FROM Matricula WHERE idAlumno = ? AND codCurso = ?";
	        psmt = cn.prepareStatement(query);
	        psmt.setInt(1, idAlumno);
	        psmt.setInt(2, codCurso);
	        rs = psmt.executeQuery();

	        if (rs.next()) {
	            matricula = new Matricula();
	            matricula.setCodAlumno(rs.getInt("idAlumno"));
	            matricula.setCodCurso(rs.getInt("codCurso"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	try {
				if(cn!=null) cn.close();
				if(psmt!=null) psmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				
			}
	    }

	    return matricula;
	}

}
