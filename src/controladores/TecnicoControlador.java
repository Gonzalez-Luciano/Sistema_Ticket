/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;


import Clases.Tecnico;
import Clases.Ticket;
import Clases.Usuario;
import java.util.List;
import modelos.TecnicoModelo;

/**
 *
 * @author ramir
 */
public class TecnicoControlador {
    

    
    private TecnicoModelo modelo;
    
    
    public TecnicoControlador(){
        this.modelo = new TecnicoModelo();
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
            modelo.actualizarTecnico(tecnico, 0, tecnico.getFallas());
            agregarFalla(tecnico);
        }else{
            modelo.actualizarTecnico(tecnico, tecnico.getMarcas()+1, tecnico.getFallas());
        }
    }
    
    
    /**
     * Agrega una falla al tecnico que se le pase
     * 
     * @param usuario Usuario de tipo técnico al que se le agregará una falla
     */
    public void agregarFalla(Tecnico tecnico){
      
        if(tecnico.getFallas()<3){
            modelo.actualizarTecnico(tecnico, tecnico.getMarcas(), tecnico.getFallas()+1);
        }else{
            modelo.actualizarTecnico(tecnico, 0, 0);
            modelo.bloquearTecnico(tecnico);
        }
    }
    
    
    /**
     * Evalúa si puede tomar tickets
     * 
     * @param lista
     * @return Devuelve true si puede tomar el ticket y false sino
     */
    
    public boolean tomarTicket(List lista){
        return lista.size()<3;
    }
    
    
    
    /**
     * Le quita una falla al técnico si resuelve un ticket Reabierto
     * 
     * @param tecnico
     * @param ticket 
     */
    
    public void evaluarMerito(Usuario tecnico, Ticket ticket){
        if(ticket.getTecnicoAnterior()!= null){
            quitarFalla(tecnico);
        }
    }
    
    /**
     * Quita una falla al técnico si es que tiene alguna
     * 
     * @param usuario 
     */
    
    public void quitarFalla(Usuario usuario){
        Tecnico tecnico = (Tecnico)usuario;
      
        if(tecnico.getFallas()!= 0){
            modelo.actualizarTecnico(tecnico, tecnico.getMarcas(), tecnico.getFallas()-1);
        }
    }
    
    
}
