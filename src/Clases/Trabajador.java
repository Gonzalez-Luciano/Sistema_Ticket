/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.dbConnection;

/**
 *
 * @author TuKK
 */
public class Trabajador extends Usuario {

    public Trabajador(String nombre, String dni, String contrasena) {
        super(nombre, dni, "trabajador", contrasena);
    }

    public Trabajador(String nombre, String dni, int legajo, String contrasena, String estado) {
        super(nombre, dni, legajo, "trabajador", contrasena, estado);
    }

    public static AuthResponse obtenerTrabajador(int id) {
        String sql = "SELECT u.* "
                + " FROM usuarios u "
                + " WHERE u.usuario_id = ?";

        try (Connection conn = dbConnection.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            //El usuario no se encontro
            if (!rs.next()) {
                return new AuthResponse(null, Mensaje.USUARIO_NO_ENCONTRADO);
            }

            String tipo = rs.getString("tipo");

            //El usuario no es de tipo TRABAJADOR
            if(!tipo.toLowerCase().equals("trabajador")){
                return new AuthResponse(null, Mensaje.TIPO_DE_USUARIO_INVALIDO);
            }
        
            Usuario usuario = new Trabajador(rs.getString("nombre"), rs.getString("dni"), rs.getInt("legajo"), 
                    rs.getString("contrasena"), rs.getString("estado"));
            
            return new AuthResponse(usuario, Mensaje.EXITO);
            
        } catch (SQLException e) {
            e.printStackTrace();
            return new AuthResponse(null, Mensaje.ERROR_CONEXION);
        }
    }
}
