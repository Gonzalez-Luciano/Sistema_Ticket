/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;


import Clases.Tecnico;
import Clases.Ticket;
import Clases.TicketVista;
import Clases.Usuario;
import java.util.List;
import modelos.TecnicoModelo;

/**
 *
 * @author ramir
 */
public class TecnicoControlador {
    

    private TicketControlador tControlador;
    private TecnicoModelo modelo;
    private TicketVista vista;
    
    
    
    public TecnicoControlador(){
        this.modelo = new TecnicoModelo();
    }

    
    public TecnicoControlador(Usuario tecnico, TicketVista vista){
        this();
        this.vista = vista;
    }
    
    
    /**
     * Agrega una marca al tecnico que se le pase
     * 
     * @param usuario Usuario de tipo técnico al que se le agregará la marca
     * 
     */
    public void agregarMarca(Usuario usuario){
      
        Tecnico tecnico = (Tecnico) usuario;
        
        if(tecnico.getMarcas()!=0){
            modelo.actualizarTecnico(usuario, 0, tecnico.getFallas());
            agregarFalla(usuario);
        }else{
            modelo.actualizarTecnico(usuario, tecnico.getMarcas()+1, tecnico.getFallas());
        }
    }
    
    
    /**
     * Agrega una falla al tecnico que se le pase
     * 
     * @param usuario Usuario de tipo técnico al que se le agregará una falla
     */
    public void agregarFalla(Usuario usuario){
     
        Tecnico tecnico = (Tecnico)usuario;
      
        if(tecnico.getFallas()<2){
            modelo.actualizarTecnico(usuario, tecnico.getMarcas(), tecnico.getFallas()+1);
        }else{
            modelo.actualizarTecnico(usuario, 0, 0);
            modelo.bloquearTecnico(usuario);
        }
    }
    
    
    
    public boolean tomarTicket(List lista){
        return lista.size()<3;
    }
    
    public void evaluarMerito(Usuario tecnico, Ticket ticket){
        if(ticket.getTecnicoAnterior()!= null){
            quitarFalla(tecnico);
        }
    }
    
    public void quitarFalla(Usuario usuario){
        Tecnico tecnico = (Tecnico)usuario;
      
        if(tecnico.getFallas()!= 0){
            modelo.actualizarTecnico(usuario, tecnico.getMarcas(), tecnico.getFallas()-1);
        }
    }
    
    
}
