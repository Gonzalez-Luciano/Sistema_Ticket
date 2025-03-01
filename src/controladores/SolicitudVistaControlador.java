/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Clases.Mensaje;
import javax.swing.JOptionPane;
import modelos.SolicitudModelo;
import vistas.SolicitudVista;

/**
 *
 * @author TuKK
 */
public class SolicitudVistaControlador {

    private SolicitudModelo solicitudModelo;
    private SolicitudVista vista;
    public SolicitudVistaControlador(SolicitudVista vista) {
        this.vista = vista;
        this.solicitudModelo = new SolicitudModelo();
    }

    public void actualizarEstadoSolicitud(int idSolicitud, String nuevoEstado) {
        try {
            solicitudModelo.actualizarEstadoSolicitud(idSolicitud, nuevoEstado);
            
        } catch (Exception e) {
            vista.mostrarMensaje(e.getMessage(), "⚠ Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}
