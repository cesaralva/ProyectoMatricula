package service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Registro;
import service.RegistroService;
import util.Conexion;

public class RegistroServiceImpl implements RegistroService {

	@Override
	public Registro getRegistro(int id) {
		Registro registro = null;
		try (Connection cn = Conexion.getConexion();
				PreparedStatement psmt = cn.prepareStatement("SELECT * FROM usuarios WHERE id = ?")) {
			psmt.setInt(1, id);
			try (ResultSet rs = psmt.executeQuery()) {
				if (rs.next()) {
					registro = new Registro();
					registro.setId(rs.getLong("id"));
					registro.setNombre(rs.getString("nombre"));
					registro.setContranesa(rs.getString("contrasena"));
					registro.setRol(rs.getString("rol"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registro;
	}

	@Override
	public List<Registro> listRegistro() {
		List<Registro> listRegistro = new ArrayList<>();
		try (Connection cn = Conexion.getConexion();
				PreparedStatement psmt = cn.prepareStatement("SELECT * FROM usuarios");
				ResultSet rs = psmt.executeQuery()) {
			while (rs.next()) {
				Registro registro = new Registro();
				registro.setId(rs.getLong("id"));
				registro.setNombre(rs.getString("nombre"));
				registro.setContranesa(rs.getString("contrasena"));
				registro.setRol(rs.getString("rol"));
				listRegistro.add(registro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listRegistro;
	}

	
	@Override
	public Boolean crearRegistro(Registro reg) {
	    Boolean value = false;
	    Connection cn = null;
	    PreparedStatement psmt = null;
	    try {
	        cn = Conexion.getConexion();
	        cn.setAutoCommit(false);
	        String query = "INSERT INTO proyectomatricula.usuarios (nombre, contrasena, rol, conficontra, permisos_id) VALUES (?, ?, ?, '', null)";

	        psmt = cn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
	        psmt.setString(1, reg.getNombre());
	        psmt.setString(2, reg.getContranesa());
	        psmt.setString(3, reg.getRol());

	        int affectedRows = psmt.executeUpdate();

	        if (affectedRows > 0) {
	            value = true;
	            cn.commit();
	        } else {
	            cn.rollback();
	        }
	    } catch (Exception e) {
	        System.out.println("error: " + e);
	        e.printStackTrace();
	        try {
	            if (cn != null) {
	                cn.rollback();
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    } finally {
	        try {
	            if (cn != null) {
	                cn.setAutoCommit(true);
	                cn.close();
	            }
	            if (psmt != null) {
	                psmt.close();
	            }
	        } catch (Exception e2) {
	            e2.printStackTrace();
	        }
	    }

	    return value;
	}


	@Override
	public Boolean actualizarRegistro(Registro reg) {
		Boolean value = false;
		try (Connection cn = Conexion.getConexion();
				PreparedStatement psmt = cn
						.prepareStatement("UPDATE usuarios SET nombre = ?, contrasena = ?, rol = ? WHERE id = ?")) {
			psmt.setString(1, reg.getNombre());
			psmt.setString(2, reg.getContranesa());
			psmt.setString(3, reg.getRol());
			psmt.setLong(4, reg.getId());
			int executeUpdate = psmt.executeUpdate();
			value = (executeUpdate == 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	@Override
	public Boolean eliminarRegistro(int id) {
		Boolean value = false;
		try (Connection cn = Conexion.getConexion();
				PreparedStatement psmt = cn.prepareStatement("DELETE FROM usuarios WHERE id = ?")) {
			psmt.setInt(1, id);
			int rowsDeleted = psmt.executeUpdate();
			value = (rowsDeleted == 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
}
