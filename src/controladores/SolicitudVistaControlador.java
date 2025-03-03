/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Clases.Mensaje;
import javax.swing.JOptionPane;
import modelos.SolicitudModelo;
import vistas.SolicitarVista;
import vistas.SolicitudVista;

/**
 *
 * @author TuKK
 */
public class SolicitudVistaControlador {

    private SolicitudModelo solicitudModelo;
    private SolicitudVista vista;
    private SolicitarVista solicitarVista;
    
    public SolicitudVistaControlador(SolicitudVista vista) {
        this.vista = vista;
        this.solicitudModelo = new SolicitudModelo();
    }
    
    public SolicitudVistaControlador(SolicitarVista vista){
        this.solicitarVista = vista;
        this.solicitudModelo = new SolicitudModelo();
    }

    public void actualizarEstadoSolicitud(int idSolicitud, String nuevoEstado) {
        try {
            solicitudModelo.actualizarEstadoSolicitud(idSolicitud, nuevoEstado);
            
        } catch (Exception e) {
            vista.mostrarMensaje(e.getMessage(), "⚠ Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    public void crearSolicitud(int ticketId, int tecnicoId){
        int tecnico_Id=tecnicoId-99;

        if(solicitudModelo.crearSolicitud(ticketId,tecnico_Id))
            solicitarVista.mostrarMensaje("Su solicutud ha sido creada", "Solicitud creada con éxito!", JOptionPane.INFORMATION_MESSAGE);
         
        else
            solicitarVista.mostrarMensaje("Error al crear la solicitud!", "⚠ Error", JOptionPane.ERROR_MESSAGE);
    }       
}
