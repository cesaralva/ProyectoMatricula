package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	public static Connection getConexion() {
		Connection cn= null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			String url = "jdbc:mysql://localhost:3306/proyectomatricula?useSSL=false&useTimezone=true&serverTimezone=UTC";
			String usr ="root";
			String pws ="cesar123";
			//String pws ="L4zaro85_sql";
			cn= DriverManager.getConnection(url,usr,pws);
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cn;
	}

}
