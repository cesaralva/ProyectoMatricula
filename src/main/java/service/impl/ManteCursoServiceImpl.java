package service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Curso;
import service.ManteCursoService;
import util.Conexion;

public class ManteCursoServiceImpl implements ManteCursoService{

	@Override
	public Curso getCurso(int codCurso) {
		
		Curso curso = null;
		Connection cn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			cn = Conexion.getConexion();
			String query = "select * from Curso where codCurso = ?";
			psmt = cn.prepareStatement(query);
			psmt.setInt(1, codCurso);
			rs = psmt.executeQuery();
			if(rs.next()) {
				curso = new Curso();
				curso.setCodCurso(rs.getInt("codCurso"));
				curso.setNomCurso(rs.getString("nomCurso"));
				curso.setCiclo(rs.getInt("ciclo"));
				curso.setCreditCurso(rs.getInt("creditCurso"));
				curso.setHorasCurso(rs.getInt("horasdeCurso"));
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
		
		return curso;
	}

	@Override
	public List<Curso> LisCurso() {
		
		List<Curso> listCurso = new ArrayList<>();
		Connection cn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			cn = Conexion.getConexion();
			String query = "select * from Curso";
			psmt = cn.prepareStatement(query);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Curso curso = new Curso();
				curso.setCodCurso(rs.getInt("codCurso"));
				curso.setNomCurso(rs.getString("nomCurso"));
				curso.setCiclo(rs.getInt("ciclo"));
				curso.setCreditCurso(rs.getInt("creditCurso"));
				curso.setHorasCurso(rs.getInt("horasdeCurso"));
				listCurso.add(curso);
				
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
		return listCurso;
	}

	@Override
	public int createCurso(Curso curso) {
		int value = 0;
		Connection cn = null;
		PreparedStatement psmt = null;
		
		try {
			cn = Conexion.getConexion();
			String query = "insert into Curso values(?,?,?,?,?)";
			psmt = cn.prepareStatement(query);
			
			psmt.setInt(1, curso.getCodCurso());
			psmt.setString(2, curso.getNomCurso());
			psmt.setInt(3, curso.getCiclo());
			psmt.setInt(4, curso.getCreditCurso());
			psmt.setInt(5, curso.getHorasCurso());
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
	public int upDateCurso(Curso curso) {
		int value = 0;
		Connection cn = null;
		PreparedStatement psmt = null;
		
		try {
			cn = Conexion.getConexion();
			String query = "update Curso "
					+ "set nomCurso=?, ciclo=?, creditCurso=?, horasdeCurso=? "
					+ "where codCurso=?";
			psmt = cn.prepareStatement(query);
			
			psmt.setString(1, curso.getNomCurso());
			psmt.setInt(2, curso.getCiclo());
			psmt.setInt(3, curso.getCreditCurso());
			psmt.setInt(4, curso.getHorasCurso());
			psmt.setInt(5, curso.getCodCurso());
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
	public int deleteCurso(int codCurso) {
		int value = 0;
		Connection cn = null;
		PreparedStatement psmt = null;
		
		try {
			cn = Conexion.getConexion();
			String query = "delete from Curso where codCurso=?";
			psmt = cn.prepareStatement(query);
			psmt.setInt(1, codCurso);
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
	public List<Curso> buscarCurso(int codCurso) {
		
		List<Curso> listCurso = new ArrayList<>();
		Connection cn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			cn = Conexion.getConexion();
			String query = "select * from Curso where codCurso = ?";
			psmt = cn.prepareStatement(query);
			psmt.setInt(1, codCurso);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Curso curso = new Curso();
				curso.setCodCurso(rs.getInt("codCurso"));
				curso.setNomCurso(rs.getString("nomCurso"));
				curso.setCiclo(rs.getInt("ciclo"));
				curso.setCreditCurso(rs.getInt("creditCurso"));
				curso.setHorasCurso(rs.getInt("horasdeCurso"));
				listCurso.add(curso);
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
		
		return listCurso;
	}

}
