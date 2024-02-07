package util;

import java.sql.Connection;



public class ProbarBD {
	public static void main(String [] args) {
		Connection cn = Conexion.getConexion();
		try {
			if(cn!=null) {
				System.out.println("Conexion creada");
			}else {
				System.out.println("No hay conexion");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				cn.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

}
