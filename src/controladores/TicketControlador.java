/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

/**
 *
 * @author ramir
 */




import Clases.Tecnico;
import Clases.Ticket;
import Clases.Mensaje;
import Clases.TicketVista;
import Clases.Trabajador;
import javax.swing.JOptionPane;
import Clases.Usuario;
import excepciones.TicketException;
import java.util.List;
import modelos.TicketModelo;
import vistas.GenerarTicket;
import vistas.TicketVistaTrabajador;

public class TicketControlador {
    private TicketModelo modelo;
    private Usuario usuario;
    private GenerarTicket nuevoTicket;
    private TicketVista ticketVista;
    
    
    
    public TicketControlador(){
        this.modelo = new TicketModelo();
    }
    
    public TicketControlador(Usuario usuario){
        this();
        this.usuario = usuario;  
    }
    
    public TicketControlador(GenerarTicket vista){
        nuevoTicket = vista;
    }
   

    public void setNuevoTicket(GenerarTicket nuevoTicket) {
        this.nuevoTicket = nuevoTicket;
    }

    public void setVistaTicket(TicketVista vista){
        this.ticketVista = vista;
    }
    
    public void crearTicket(){
        try{
            
            if(nuevoTicket.getTitulo().isEmpty() || nuevoTicket.getDescripcion().isEmpty()){
                throw new TicketException("Completa todos los campos para crear un ticket");
            }
            
            Ticket ticket = new Ticket(nuevoTicket.getTitulo(),nuevoTicket.getDescripcion(),(Trabajador)usuario);
            int[] respuesta = modelo.crearTicket(ticket);
  
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
                            ticketVista.mostrarMensaje(msg, "Ticket actualizado", JOptionPane.INFORMATION_MESSAGE);
                            break;
                            
                case ERROR_CONEXION: throw new Exception("Ups! Ha ocurrido un error. Contactese con Sistemas");
                                     
                case ERROR: throw new TicketException("No se ha podido actualizar el ticket");
               
            }
            ticket.setEstado("Reabierto");
            ticket.setTecnico(null);
            
        }catch(TicketException e){
            ticketVista.mostrarMensaje(e.getMessage(), "⚠ Error", JOptionPane.ERROR_MESSAGE);
        }catch(Exception e){
            ticketVista.mostrarMensaje(e.getMessage(), "⚠ Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void cerrarTicket(Ticket ticket){
        //tecnicoControlador.evaluarMerito(ticket);
        Mensaje mensaje = modelo.actualizarEstadoTicket(ticket, "Finalizado", ticket.getTecnico(), ticket.getTecnicoAnterior());
        try{
            switch(mensaje){
                case EXITO: String msg = "Ticket cerrado!";
                            ticketVista.mostrarMensaje(msg, "Ticket actualizado", JOptionPane.INFORMATION_MESSAGE);
                            break;
                            
                case ERROR_CONEXION: throw new Exception("Ups! Ha ocurrido un error. Contactese con Sistemas");
                                     
                case ERROR: throw new TicketException("No se ha podido actualizar el ticket");
               
            }
            //actualizarPanelTickets();
            ticketVista.dispose();
            
        }catch(TicketException e){
            ticketVista.mostrarMensaje(e.getMessage(), "⚠ Error", JOptionPane.ERROR_MESSAGE);
        }catch(Exception e){
            ticketVista.mostrarMensaje(e.getMessage(), "⚠ Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Actualiza el estado del ticket de 'No atendido' o 'Reabierto' a 'Atendido'
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
                            ticketVista.mostrarMensaje(msg, "Ticket actualizado", JOptionPane.INFORMATION_MESSAGE);
                            break;
                            
                case ERROR_CONEXION: throw new Exception("Ups! Ha ocurrido un error. Contactese con Sistemas");
                                     
                case ERROR: throw new TicketException("No se ha podido actualizar el ticket");
            }
        }catch(TicketException e){
            //ticketTecnico.mostrarMensaje(e.getMessage(), "⚠ Error", JOptionPane.ERROR_MESSAGE);
            ticketVista.mostrarMensaje(e.getMessage(), "⚠ Error", JOptionPane.ERROR_MESSAGE);
        }catch(Exception e){
            //ticketTecnico.mostrarMensaje(e.getMessage(), "⚠ Error", JOptionPane.ERROR_MESSAGE);
            ticketVista.mostrarMensaje(e.getMessage(), "⚠ Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public List<Ticket> buscarTickets(Usuario usuario){
        List<Ticket> lista = modelo.obtenerTickets(usuario);       
        
        return lista;
     
    }

    public void Prueba(){
        ticketVista.mostrarMensaje("prueba", "prueba", JOptionPane.ERROR_MESSAGE);
    }
    
}
