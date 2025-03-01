/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import Clases.Mensaje;
import Clases.Tecnico;
import Clases.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ramir
 */
public class TecnicoModelo {

    public void actualizarTecnico(Tecnico tecnico, int marca, int falla) {
        String sql1 = "UPDATE tecnicos SET marcas=? WHERE usuario_id=?";
        String sql2 = "UPDATE tecnicos SET fallas=? WHERE usuario_id=?";
        String sqlSelect = "SELECT * FROM tecnicos WHERE usuario_id=?"; // Consulta para obtener los datos actualizados
        int tecnicoId = tecnico.getLegajo() - 99;

        try (Connection conn = dbConnection.conectar()) {
            // Primera actualización
            try (PreparedStatement stmt1 = conn.prepareStatement(sql1)) {
                stmt1.setInt(1, marca);
                stmt1.setInt(2, tecnicoId);
                stmt1.executeUpdate();
            }

            // Segunda actualización
            try (PreparedStatement stmt2 = conn.prepareStatement(sql2)) {
                stmt2.setInt(1, falla);
                stmt2.setInt(2, tecnicoId);
                stmt2.executeUpdate();
            }

            // Consulta para obtener el técnico actualizado
            try (PreparedStatement stmt3 = conn.prepareStatement(sqlSelect)) {
                stmt3.setInt(1, tecnicoId);
                try (ResultSet rs = stmt3.executeQuery()) {
                    if (rs.next()) {
                        // Actualizamos el objeto `tecnico` con los nuevos valores obtenidos de la base de datos
                        tecnico.setMarcas(rs.getInt("marcas"));
                        tecnico.setFallas(rs.getInt("fallas"));
                        System.out.println("Técnico actualizado correctamente.");
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void bloquearTecnico(Usuario tecnico) {
        String sql = "UPDATE usuarios SET estado='bloqueado' WHERE usuario_id=?;";
        int tecnicoId = tecnico.getLegajo() - 99;
        try (Connection conn = dbConnection.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, tecnicoId);

            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
