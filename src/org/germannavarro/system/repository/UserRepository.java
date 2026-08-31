/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.germannavarro.system.repository;

/**
 *
 * @author RM20
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import org.germannavarro.system.config.ConexionDB;
import org.germannavarro.system.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

    Connection conn = ConexionDB.getInstanciaConexionDB().getConnection();

    public boolean crearUsuario(User usuario) {
        try {
            CallableStatement cs = conn.prepareCall("{call sp_create_users(?, ?, ?, ?, ?)}");
            cs.setString(1, usuario.getNombre());
            cs.setString(2, usuario.getApellido());
            cs.setString(3, usuario.getEmail());
            cs.setString(4, usuario.getNombreUsuario());
            cs.setString(5, usuario.getPasscode());

            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e.getMessage());
            return false;
        }
    }

    public User busquedaUser(String nombreUsuario) {

        try {
            CallableStatement cs = conn.prepareCall("{call sp_search_user(?)}");
            cs.setString(1, nombreUsuario);
            ResultSet resultado = cs.executeQuery();
            if (resultado.next()) {

                String idUser = resultado.getString("id_user");
                String user = resultado.getString("user");
                String password = resultado.getString("password");

                User usuarioEncontrado = new User(idUser, user, password);
                usuarioEncontrado.setNombre(resultado.getString("name"));
                usuarioEncontrado.setApellido(resultado.getString("lastname"));

                return usuarioEncontrado;
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar el usuario: " + e.getMessage());
        }

        return null;

    }

}
