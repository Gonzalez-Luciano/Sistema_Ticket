/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import Clases.Mensaje;
import Clases.Solicitud;
import Clases.Tecnico;
import Clases.Ticket;
import Clases.Usuario;
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

    public Mensaje actualizarEstadoSolicitud(int idSolicitud, String nuevoEstado) {
        String query = "UPDATE solicitudes_reapertura SET estado = ? WHERE id_solicitud_reapertura = ?";
        try (Connection conn = dbConnection.conectar(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nuevoEstado);
            stmt.setInt(2, idSolicitud);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0 ? Mensaje.EXITO : Mensaje.ERROR;

        } catch (SQLException e) {
            e.printStackTrace();
            return Mensaje.ERROR;
        } catch (Exception e) {
            e.printStackTrace();
            return Mensaje.ERROR;
        }
    }

    public List<Solicitud> obtenerTodasLasSolicitudes() {
        List<Solicitud> solicitudes = new ArrayList<>();
        String query = "SELECT s.id_solicitud_reapertura ,s.estado, s.tecnico_id, "
                + "tk.ticket_id, tk.titulo, tk.descripcion, tk.estado AS estado_ticket "
                + "FROM solicitudes_reapertura s "
                + "JOIN tickets tk ON s.ticket_id = tk.ticket_id";

        try (Connection conn = dbConnection.conectar();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                // Crear el objeto Tecnico

                Tecnico tecnico =  (Tecnico) Tecnico.obtenerTecnico(rs.getInt("tecnico_id")).getUsuario();

                // Crear el objeto Ticket
                Ticket ticket = new Ticket(
                        rs.getInt("ticket_id"),
                        rs.getString("titulo"),
                        rs.getString("descripcion"),
                        rs.getString("estado_ticket"),
                        null,
                        tecnico,
                        null
                );
                // Crear el objeto Solicitud con el ticket y el técnico
                Solicitud solicitud = new Solicitud(
                        rs.getInt("id_solicitud_reapertura"),
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
    
    
    public List<Solicitud> obtenerSolicitudesTecnico(Usuario usuario){
        List<Solicitud> solicitudes = new ArrayList<>();
        String query = "SELECT s.id_solicitud_reapertura ,s.estado, s.tecnico_id, "
                + "tk.ticket_id, tk.titulo, tk.descripcion, tk.estado AS estado_ticket "
                + "FROM solicitudes_reapertura s "
                + "JOIN tickets tk ON s.ticket_id = tk.ticket_id "
                + "WHERE s.tecnico_id=? ;";
        int aux = usuario.getLegajo()-99;
        try (Connection conn = dbConnection.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){
            
            stmt.setInt(1,aux);
            if(stmt.execute()){
                try(ResultSet rs = stmt.getResultSet()){
                    while (rs.next()) {
                        Tecnico tecnico =  (Tecnico) Tecnico.obtenerTecnico(rs.getInt("tecnico_id")).getUsuario();

                        // Crear el objeto Ticket
                        Ticket ticket = new Ticket(
                                rs.getInt("ticket_id"),
                                rs.getString("titulo"),
                                rs.getString("descripcion"),
                                rs.getString("estado_ticket"),
                                null,
                                tecnico,
                                null
                        );
                        // Crear el objeto Solicitud con el ticket y el técnico
                        Solicitud solicitud = new Solicitud(
                                rs.getInt("id_solicitud_reapertura"),
                                ticket,
                                tecnico,
                                rs.getString("estado")
                        );

                        solicitudes.add(solicitud);
                    }
                }
            }
            
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return solicitudes;        
    }
        
}            
        
        
        

    

