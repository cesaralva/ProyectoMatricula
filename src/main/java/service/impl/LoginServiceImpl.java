package service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Login;
import service.LoginService;
import util.Conexion;

public class LoginServiceImpl implements LoginService {

    @Override
    public Boolean enterLogin(Login login) {
        try (Connection connection = Conexion.getConexion()) {
            String query = "SELECT * FROM usuarios WHERE nombre = ? AND contrasena = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, login.getNombre());
                preparedStatement.setString(2, login.getContranesa());
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return resultSet.next();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    }

