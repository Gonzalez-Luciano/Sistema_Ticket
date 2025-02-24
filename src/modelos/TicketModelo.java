/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import Clases.Trabajador;
import Clases.Tecnico;
import Clases.Ticket;
import Clases.Mensaje;
import Clases.Usuario;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author ramir
 */
public class TicketModelo {
    
    /**
    * Crea un ticket en la Base de Datos
    *     
    * @param ticket         El objeto que se rescata de la visual
    * @return   Devuelve un arreglo de enteros: 
    * [0] : El index del mensaje
    * [1] : El número de ticket / 0 si no se afectó ninguna fila / -1 SQLException
    **/
    public int[] crearTicket(Ticket ticket){
        String query = "CALL crearTicket(?,?,?,?);";
        int[] resultado = new int[2];
        try (   Connection conn = dbConnection.conectar();
                CallableStatement stmt = conn.prepareCall(query)){
            
            stmt.setString(1, ticket.getTitulo());
            stmt.setString(2, ticket.getDescripcion());
            stmt.setInt(3,ticket.getInformador().getLegajo());
            stmt.registerOutParameter(4, Types.INTEGER);
            int rowsAffected = stmt.executeUpdate();
            if( rowsAffected > 0) {
                int numeroTicket = stmt.getInt(4);
                resultado[0] = Mensaje.valueOf("EXITO").ordinal();
                resultado[1] = numeroTicket;
            }
            else{
                resultado[0] = Mensaje.valueOf("ERROR").ordinal();
                resultado[1] = 0;
            }
            return resultado;
        } catch (SQLException e){
            e.printStackTrace();
            resultado[0] = Mensaje.valueOf("ERROR").ordinal();
            resultado[1] = -1;
            return resultado;
        } 
    }
    
    
    /**
    * Actualiza el estado de un ticket
    * 
    * @param ticket             El ticket que se actualizará
    * @param estado             El estado que tomará el ticket
    * @param tecnico            El tecnico que tendrá el ticket al actualizarse
    * @param tecnicoAnterior    El tecnico que tenía el tecnico al actualizarse
     * @return  Devuelve un mensaje de EXITO o ERROR segun se pueda actualizar o no
    **/
    public Mensaje actualizarEstadoTicket(Ticket ticket, String estado, Tecnico tecnico, Tecnico tecnicoAnterior){
            String query = "CALL actualizarEstadoTicket(?,?,?,?);";
            
            try (   Connection conn = dbConnection.conectar();
                    CallableStatement stmt = conn.prepareCall(query)){
                stmt.setInt(1,ticket.getTicket_id());
                stmt.setString(2,estado);
                if(tecnico != null) {
                    stmt.setInt(3,tecnico.getLegajo());
                }
                else{
                    stmt.setNull(3, java.sql.Types.INTEGER);
                }
                if(tecnicoAnterior != null){
                    stmt.setInt(4,tecnicoAnterior.getLegajo());
                }else{
                    stmt.setNull(4, java.sql.Types.INTEGER);
                }
                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0 ? Mensaje.EXITO : Mensaje.ERROR;
                    
            }catch (SQLException e){
                e.printStackTrace();
                return Mensaje.ERROR_CONEXION;
            }
    }
    
    
    /**
     * Genera una lista con los tickets segun quien lo solicita
     * 
     * @param estado        El estado del ticket que se espera obtener
     * @param solicitante   El usuario que está logueado
     * @return  Devuelve una lista de tipo Ticket
     **/
    
    public List<Ticket> obtenerTickets(String estado, Usuario solicitante){
        List<Ticket> tickets = new ArrayList<>();
        
        try (Connection conn = dbConnection.conectar();
            PreparedStatement stmt = prepararConsulta(conn,estado, solicitante)){        
            
            if(stmt != null){
                boolean tieneResultado = stmt.execute();
                if(tieneResultado){
                    try(ResultSet rs = stmt.getResultSet()){
                        while(rs.next()){
                            Ticket ticket = new Ticket(
                            rs.getInt("ticket_id"),
                            rs.getString("titulo"),
                            rs.getString("descripcion"),
                            rs.getString("estado"),
                            (Trabajador) Trabajador.obtenerTrabajador(rs.getInt("trabajador_id")).getUsuario(),
                            (Tecnico) Tecnico.obtenerTecnico(rs.getInt("tecnico_id")).getUsuario(),
                            (Tecnico) Tecnico.obtenerTecnico(rs.getInt("tecnico_anterior_id")).getUsuario());
                            
                            tickets.add(ticket);
                        }
                    }
                }
            }else{
                throw new Exception("Null Statement");
            }
        }catch( SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return tickets;
    }
    
    private PreparedStatement prepararConsulta(Connection conn, String estado, Usuario solicitante) throws SQLException{
        String query;
        PreparedStatement stmt = null;
        int aux = solicitante.getLegajo() -99;
        
        if("administrador".equals(solicitante.getTipo())){
                switch (estado){
                    case "Todos": query = "SELECT * FROM tickets ORDER BY ticket_id DESC;";
                                  break;
                    case "No atendido":
                    case "Atendido" :
                    case "Resuelto" :
                    case "Finalizado" :
                    case "Reabierto" : query = "SELECT * FROM tickets WHERE estado = ? ORDER BY ticket_id DESC;";
                                       stmt = conn.prepareStatement(query);
                                       stmt.setString(1,estado);
                                       return stmt;
                    default : query = "SELECT * FROM tickets ORDER BY ticket_id DESC;";
                              break;                   
                }
                stmt = conn.prepareStatement(query);
        }else{ 
            if("tecnico".equals(solicitante.getTipo())){
                if("No atendido".equals(estado) || "Reabierto".equals(estado)){
                    query = "SELECT * FROM tickets WHERE estado = ? ORDER BY ticket_id DESC;";
                    stmt.setString(1,estado);
                    stmt = conn.prepareStatement(query);
                }else{
                    query = "SELECT * FROM tickets WHERE tecnico_id = ? AND estado = ? ORDER BY ticket_id DESC;";
                    stmt = conn.prepareStatement(query);
                    stmt.setInt(1,aux);
                    stmt.setString(2,estado);   
                    }
            }
            //En este punto, es un trabajador quien pide la consulta
            else{
                switch (estado){
                    case "Todos": query = "SELECT * FROM tickets WHERE trabajador_id = ? AND estado <> 'Finalizado' ORDER BY ticket_id DESC;";
                                  stmt = conn.prepareStatement(query);                                  
                                  stmt.setInt(1,aux);
                                  break;
                                  
                    case "No atendido":
                    case "Atendido" :
                    case "Resuelto" :
                    case "Reabierto" : query = "SELECT * FROM tickets WHERE trabajador_id = ? AND estado = ? ORDER BY ticket_id DESC;";
                                       stmt = conn.prepareStatement(query);;
                                       stmt.setInt(1,aux);
                                       stmt.setString(2,estado);
                                       break;
                                       
                    default : query = "SELECT * FROM tickets WHERE trabajador_id = ? AND estado <> 'Finalizado' ORDER BY ticket_id DESC;";
                              stmt = conn.prepareStatement(query);                                  
                              stmt.setInt(1,aux);
                              break;
                }
            }
        }
        return stmt;
    }
}
    
