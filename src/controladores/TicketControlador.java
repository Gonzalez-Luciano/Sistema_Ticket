/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

/**
 *
 * @author ramir
 */

/*
import Clases .Administrador;
import Clases.Usuario;
*/
import Clases.Tecnico;
import excepciones.TicketException; 
import Clases.Mensaje;
import Clases.Ticket;
import Clases.Trabajador;
import javax.swing.JOptionPane;
import modelos.TicketModelo;
import vistas.GenerarTicket;
import vistas.TicketVistaTrabajador;


public class TicketControlador {
    private TicketModelo modelo;
    private GenerarTicket nuevoTicket;
    private TicketVistaTrabajador ticketTrabajador;
    private Trabajador usuario;
    //private TecnicoControlador tecnicoControlador;
    
    public TicketControlador(){
        super();
    }
    
    public void crearTicket(){
        try{
            //usuario = (Trabajador) Sesion.getUsuarioActual();
            usuario  = new Trabajador("","","");
            Ticket ticket = new Ticket(nuevoTicket.getTitulo(),nuevoTicket.getDescripcion(),usuario);
            int[] respuesta = new int[2];
            respuesta = modelo.crearTicket(ticket);
            nuevoTicket.setTitulo("");
            nuevoTicket.setDescripcion("");
            
            switch(Mensaje.values()[respuesta[0]]){
                case EXITO:   String mensaje = "Ticket "+respuesta[1]+" creado con éxito!";
                              nuevoTicket.mostrarMensaje(mensaje, "Ticket creado", JOptionPane.INFORMATION_MESSAGE);
                              break;
                              
                case ERROR: if(respuesta[1]==0){
                                throw new TicketException("No se pudo crear el ticket correctamente");
                            }else{
                                throw new TicketException("SQLException error");
                            }
            }
        }catch(TicketException e){
            nuevoTicket.mostrarMensaje(e.getMessage(),"⚠ Error", JOptionPane.ERROR_MESSAGE);
        }catch(Exception e){
            nuevoTicket.mostrarMensaje(e.getMessage(),"⚠ Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    /**
    * Permite setear los atributos de TicketVistaTrabajador
    * 
    * @param ticket 
    * Es entregado desde la lista de TicketModelo.obtenerTickets() 
    **/
    public void verTicket(Ticket ticket){
        
        ticketTrabajador = new TicketVistaTrabajador(ticket);
        ticketTrabajador.setTicket();
        ticketTrabajador.setVisible(true);
        //actualizarPanelTickets();
    }
    
    public void reabrirTicket(Ticket ticket){
        /*if("administrador".equals(Sesion.getUsuario().getTipo())){
            tecnicoControlador.agregarMarca(ticket.getTecnico());
        }else{
            tecnicoControlador.agregarFalla(ticket.getTecnico());
        }*/
        //tecnicoControlador.evaluarSancion(ticket);
        Mensaje mensaje = modelo.actualizarEstadoTicket(ticket, "Reabierto", null, ticket.getTecnico());
        try{
            switch(mensaje){
                case EXITO: String msg = "Ticket reabierto con éxito!";
                            ticketTrabajador.mostrarMensaje(msg, "Ticket actualizado", JOptionPane.INFORMATION_MESSAGE);
                            break;
                            
                case ERROR_CONEXION: throw new Exception("Ups! Ha ocurrido un error. Contactese con Sistemas");
                                     
                case ERROR: throw new TicketException("No se ha podido actualizar el ticket");
               
            }
            ticket.setEstado("Reabierto");
            ticket.setTecnico(null);
            ticketTrabajador.dispose();
            verTicket(ticket);
            
        }catch(TicketException e){
            ticketTrabajador.mostrarMensaje(e.getMessage(), "⚠ Error", JOptionPane.ERROR_MESSAGE);
        }catch(Exception e){
            ticketTrabajador.mostrarMensaje(e.getMessage(), "⚠ Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void cerrarTicket(Ticket ticket){
        //tecnicoControlador.evaluarMerito(ticket);
        Mensaje mensaje = modelo.actualizarEstadoTicket(ticket, "Finalizado", ticket.getTecnico(), ticket.getTecnicoAnterior());
        try{
            switch(mensaje){
                case EXITO: String msg = "Ticket cerrado!";
                            ticketTrabajador.mostrarMensaje(msg, "Ticket actualizado", JOptionPane.INFORMATION_MESSAGE);
                            break;
                            
                case ERROR_CONEXION: throw new Exception("Ups! Ha ocurrido un error. Contactese con Sistemas");
                                     
                case ERROR: throw new TicketException("No se ha podido actualizar el ticket");
               
            }
            //actualizarPanelTickets();
            ticketTrabajador.dispose();
            
        }catch(TicketException e){
            ticketTrabajador.mostrarMensaje(e.getMessage(), "⚠ Error", JOptionPane.ERROR_MESSAGE);
        }catch(Exception e){
            ticketTrabajador.mostrarMensaje(e.getMessage(), "⚠ Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Actualiza el estad del ticket de 'No atendido' o 'Reabierto' a 'Atendido'
     * 
     * @param ticket El ticket que va a tomar el técnico
     * @param tecnico El usuario del técnico que lo toma
    **/
    public void ticketTomado(Ticket ticket, Tecnico tecnico){
        Mensaje mensaje = modelo.actualizarEstadoTicket(ticket, "Atendido", tecnico, ticket.getTecnico());
        try{
            switch(mensaje){
                case EXITO: String msg = "Ticket atendido por usted!";
                            //ticketTecnico.mostrarMensaje(msg, "Ticket actualizado", JOptionPane.INFORMATION_MESSAGE);
                            ticketTrabajador.mostrarMensaje(msg, "Ticket actualizado", JOptionPane.INFORMATION_MESSAGE);
                            break;
                            
                case ERROR_CONEXION: throw new Exception("Ups! Ha ocurrido un error. Contactese con Sistemas");
                                     
                case ERROR: throw new TicketException("No se ha podido actualizar el ticket");
            }
        }catch(TicketException e){
            //ticketTecnico.mostrarMensaje(e.getMessage(), "⚠ Error", JOptionPane.ERROR_MESSAGE);
            ticketTrabajador.mostrarMensaje(e.getMessage(), "⚠ Error", JOptionPane.ERROR_MESSAGE);
        }catch(Exception e){
            //ticketTecnico.mostrarMensaje(e.getMessage(), "⚠ Error", JOptionPane.ERROR_MESSAGE);
            ticketTrabajador.mostrarMensaje(e.getMessage(), "⚠ Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
