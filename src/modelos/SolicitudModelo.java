/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import Clases.Solicitud;
import Clases.Tecnico;
import Clases.Ticket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TuKK
 */
public class SolicitudModelo {

    public boolean crearSolicitud(int ticketId, int tecnicoId) {
        String query = "INSERT INTO solicitudes_reapertura (ticket_id, tecnico_id, estado) VALUES (?, ?, 'pendiente')";
        try (Connection conn = dbConnection.conectar(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, ticketId);
            stmt.setInt(2, tecnicoId);
            return stmt.executeUpdate() > 0; // Devuelve true si la inserción fue exitosa
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarEstadoSolicitud(int idSolicitud, String nuevoEstado) {
        String query = "UPDATE solicitudes_reapertura SET estado = ? WHERE id_solicitud_reapertura = ?";
        try (Connection conn = dbConnection.conectar(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nuevoEstado);
            stmt.setInt(2, idSolicitud);
            return stmt.executeUpdate() > 0; // Devuelve true si la actualización fue exitosa
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Solicitud> obtenerTodasLasSolicitudes() {
        List<Solicitud> solicitudes = new ArrayList<>();
        String query = "SELECT s.estado, "
                + "tk.ticket_id, tk.titulo, tk.descripcion, tk.estado AS estado_ticket, "
                + "u.*, tec.fallas, tec.marcas "
                + "FROM solicitudes_reapertura s "
                + "JOIN tickets tk ON s.ticket_id = tk.ticket_id "
                + "JOIN usuarios u ON s.tecnico_id = u.usuario_id "
                + "LEFT JOIN tecnicos tec ON s.tecnico_id = tec.usuario_id";

        try (Connection conn = dbConnection.conectar();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                // Crear el objeto Ticket
                Ticket ticket = new Ticket(
                        rs.getInt("ticket_id"),
                        rs.getString("titulo"),
                        rs.getString("descripcion"),
                        rs.getString("estado_ticket")
                );

                // Crear el objeto Tecnico
                int fallas = rs.getInt("fallas");
                int marcas = rs.getInt("marcas");

                Tecnico tecnico = new Tecnico(rs.getString("nombre"),
                        rs.getString("dni"), rs.getInt("legajo"),
                        rs.getString("contrasena"), rs.getString("estado"),
                        fallas, marcas);

                // Crear el objeto Solicitud con el ticket y el técnico
                Solicitud solicitud = new Solicitud(
                        ticket,
                        tecnico,
                        rs.getString("estado")
                );

                solicitudes.add(solicitud);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return solicitudes;
    }
}
