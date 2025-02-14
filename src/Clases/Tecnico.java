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
public class Tecnico extends Usuario {

    private int fallas;
    private int marcas;

    public Tecnico(String nombre, String dni, String contrasena) {
        super(nombre, dni, "tecnico", contrasena);
    }

    public Tecnico(String nombre, String dni, int legajo, String contrasena, String estado, int fallas, int marcas) {
        super(nombre, dni, legajo, "tecnico", contrasena, estado);
        this.fallas = fallas;
        this.marcas = marcas;
    }

    public int getFallas() {
        return fallas;
    }

    public void setFallas(int fallas) {
        this.fallas = fallas;
    }

    public int getMarcas() {
        return marcas;
    }

    public void setMarcas(int marcas) {
        this.marcas = marcas;
    }

    public static AuthResponse obtenerTecnico(int id) {
        String sql = "SELECT u.*, t.fallas, t.marcas "
                + "FROM usuarios u "
                + "LEFT JOIN tecnicos t ON u.usuario_id = t.usuario_id "
                + "WHERE u.usuario_id = ?";

        try (Connection conn = dbConnection.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            //El usuario no se encontro
            if (!rs.next()) {
                return new AuthResponse(null, Mensaje.USUARIO_NO_ENCONTRADO);
            }
            String tipo = rs.getString("tipo");
            //El usuario no es de tipo Tecnico
            if (!tipo.toLowerCase().equals("tecnico")) {
                return new AuthResponse(null, Mensaje.TIPO_DE_USUARIO_INVALIDO);
            }
            int fallas = rs.getInt("fallas");
            int marcas = rs.getInt("marcas");

            Usuario usuario = new Tecnico(rs.getString("nombre"), rs.getString("dni"), rs.getInt("legajo"), rs.getString("contrasena"), rs.getString("estado"), fallas, marcas);

            return new AuthResponse(usuario, Mensaje.EXITO);

        } catch (SQLException e) {
            e.printStackTrace();
            return new AuthResponse(null, Mensaje.ERROR_CONEXION);
        }
    }
}
