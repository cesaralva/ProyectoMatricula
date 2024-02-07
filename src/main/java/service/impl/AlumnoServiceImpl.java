package service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Alumno;
import model.CursoMatricula;
import service.AlumnoService;
import util.Conexion;

public class AlumnoServiceImpl implements AlumnoService {

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
	public List<CursoMatricula> listCursoMatricula(int id) {
		List<CursoMatricula> listMatricula = new ArrayList<>();
		Connection cn = null;
		PreparedStatement psmt = null;
		ResultSet rs= null;
		try {
			cn= Conexion.getConexion();
			String query = "select m.numMatricula, c.nomCurso, c.ciclo, c.creditCurso, c.horasdeCurso from proyectomatricula.matricula m inner join "
					+ "proyectomatricula.curso c on m.codCurso = c.codCurso "
					+ "where idAlumno = ?;";
			psmt=cn.prepareStatement(query);
			psmt.setInt(1, id);
			rs=psmt.executeQuery();
			while(rs.next()) {
				CursoMatricula cmat = new CursoMatricula();
				cmat.setNumMatricula(rs.getInt("numMatricula"));
				cmat.setNomCurso(rs.getString("nomCurso"));
				cmat.setCiclo(rs.getInt("ciclo"));
				cmat.setCreditCurso(rs.getInt("creditCurso"));
				cmat.setHorasdeCurso(rs.getInt("horasdeCurso"));
				
				
				listMatricula.add(cmat);
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
	public int crearAlumno(Alumno a) {
		int value = 0;
		Connection cn=null;
		PreparedStatement psmt = null;
		try {
			cn = Conexion.getConexion();
			String query = "INSERT INTO proyectomatricula.Alumno (dniAlumno,nomAlumno,apeAlumno,edadAlumn,correoAlumno,estado) VALUES (?,?,?,?,?,?)";
			psmt.setString(1, a.getDniAlumno());
			psmt.setString(2, a.getNomAlumno());
			psmt.setString(3, a.getApeAlumno());
			psmt.setInt(4, a.getEdadAlumno());
			psmt.setString(5, a.getCorreoAlumno());
			psmt.setInt(6, a.getEstado());
						
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
	public int actualizarAlumno(Alumno a) {
		int value = 0;
		PreparedStatement psmt = null;
		Connection cn = null;
		try {
			cn = Conexion.getConexion();
			String query ="UPDATE proyectomatricula.Alumno"
			+ "SET dniAlumno =?, nomAlumno=?, apeAlumno=?, edadAlumn=?,correoAlumno=?; estado=? "
		    + "WHERE idAlumno=?";
			psmt = cn.prepareStatement(query);
			psmt.setString(1, a.getDniAlumno());
			psmt.setString(2, a.getNomAlumno());
			psmt.setString(3, a.getApeAlumno());
			psmt.setInt(4, a.getEdadAlumno());
			psmt.setString(5, a.getCorreoAlumno());
			psmt.setInt(6, a.getEstado());
			psmt.setInt(7, a.getIdAlumno());

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
	public int eliminarAlumno(int id) {
		int value =0;
		Connection cn= null;
		PreparedStatement psmt = null;
		try {
			cn = Conexion.getConexion();
			String query = "DELETE FROM proyectomatricula.Alumno WHERE idAlumno=?";
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



