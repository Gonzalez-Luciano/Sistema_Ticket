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
import Clases.TicketDatosVista;
import Clases.Trabajador;
import javax.swing.JOptionPane;
import Clases.Usuario;
import excepciones.TecnicoException;
import excepciones.TicketException;
import java.util.List;
import modelos.TicketModelo;
import vistas.GenerarTicket;


public class TicketControlador {
    private TicketModelo modelo;
    private Usuario usuario;
    private GenerarTicket nuevoTicket;
    private TicketDatosVista ticketDatosVista;
    private TecnicoControlador tecnicoControlador;
    
    
    
    public TicketControlador(){
        this.modelo = new TicketModelo();
        this.tecnicoControlador = new TecnicoControlador();
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

    public void setVistaTicket(TicketDatosVista vista){
        this.ticketDatosVista = vista;
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
        if("administrador".equals(usuario.getTipo())){
            tecnicoControlador.agregarMarca(ticket.getTecnico());
        }else{
            tecnicoControlador.agregarFalla(ticket.getTecnico());
        }
        

        Mensaje mensaje = modelo.actualizarEstadoTicket(ticket, "Reabierto", null, ticket.getTecnico());
        try{
            switch(mensaje){
                case EXITO: String msg = "Ticket reabierto con éxito!";
                            ticketDatosVista.mostrarMensaje(msg, "Ticket actualizado", JOptionPane.INFORMATION_MESSAGE);
                            break;
                            
                case ERROR_CONEXION: throw new Exception("Ups! Ha ocurrido un error. Contactese con Sistemas");
                                     
                case ERROR: throw new TicketException("No se ha podido actualizar el ticket");
               
            }
            ticket.setEstado("Reabierto");
            ticket.setTecnico(null);
            
        }catch(TicketException e){
            ticketDatosVista.mostrarMensaje(e.getMessage(), "⚠ Error", JOptionPane.ERROR_MESSAGE);
        }catch(Exception e){
            ticketDatosVista.mostrarMensaje(e.getMessage(), "⚠ Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void cerrarTicket(Ticket ticket){
        tecnicoControlador.evaluarMerito(ticket.getTecnico(), ticket);
        Mensaje mensaje = modelo.actualizarEstadoTicket(ticket, "Finalizado", ticket.getTecnico(), ticket.getTecnicoAnterior());
        try{
            switch(mensaje){
                case EXITO: String msg = "Ticket cerrado!";
                            ticketDatosVista.mostrarMensaje(msg, "Ticket actualizado", JOptionPane.INFORMATION_MESSAGE);
                            break;
                            
                case ERROR_CONEXION: throw new Exception("Ups! Ha ocurrido un error. Contactese con Sistemas");
                                     
                case ERROR: throw new TicketException("No se ha podido actualizar el ticket");
               
            }
            ticketDatosVista.dispose();
            
        }catch(TicketException e){
            ticketDatosVista.mostrarMensaje(e.getMessage(), "⚠ Error", JOptionPane.ERROR_MESSAGE);
        }catch(Exception e){
            ticketDatosVista.mostrarMensaje(e.getMessage(), "⚠ Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Actualiza el estado del ticket de 'No atendido' o 'Reabierto' a 'Atendido'
     * 
     * @param ticket El ticket que va a tomar el técnico
     * @param lista Lista de tickets filtrada
     * @param usuario
    **/
    public void ticketTomado(Ticket ticket, List lista, Usuario usuario){
        Tecnico tecnico = (Tecnico)usuario;
        try{
            if(!tecnicoControlador.tomarTicket(lista)){ //Evalúa si puede tomar el ticket x cantidad
                throw new TecnicoException("Superó la cantidad límite permitida de tickets tomados");
            }
            Mensaje mensaje = modelo.actualizarEstadoTicket(ticket, "Atendido", tecnico, ticket.getTecnico());
            
            switch(mensaje){
                case EXITO: String msg = "Ticket atendido por usted!";
                            
                            ticketDatosVista.mostrarMensaje(msg, "Ticket actualizado", JOptionPane.INFORMATION_MESSAGE);
                            break;
                            
                case ERROR_CONEXION: throw new Exception("Ups! Ha ocurrido un error. Contactese con Sistemas");
                                     
                case ERROR: throw new TicketException("No se ha podido actualizar el ticket");
            }
            
        }catch(TicketException e){
            
            ticketDatosVista.mostrarMensaje(e.getMessage(), "⚠ Error", JOptionPane.ERROR_MESSAGE);
        }catch(TecnicoException e){
            ticketDatosVista.mostrarMensaje(e.getMessage(), "⚠ Error", JOptionPane.ERROR_MESSAGE);
        }catch(Exception e){
            
            ticketDatosVista.mostrarMensaje(e.getMessage(), "⚠ Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public List<Ticket> buscarTickets(Usuario usuario){
        List<Ticket> lista = modelo.obtenerTickets(usuario);       
        
        return lista;
     
    }

    public void Prueba(){
        ticketDatosVista.mostrarMensaje("prueba", "prueba", JOptionPane.ERROR_MESSAGE);
    }
    
    
    
}
