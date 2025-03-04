/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Clases.Solicitud;
import Clases.Usuario;
import java.util.List;
import modelos.SolicitudModelo;

/**
 *
 * @author TuKK
 */
public class ListaSolicitudesControlador {
     private SolicitudModelo solicitudModelo;

    public ListaSolicitudesControlador() {
        this.solicitudModelo = new SolicitudModelo();
    }

    /**
     * Obtiene y devuelve todas las solicitudes de reapertura
     * 
     * @return Lista de tipo Solicitud de todas las solicitudes de reapertura
     */
    public List<Solicitud> obtenerTodasLasSolicitudes() {
        return solicitudModelo.obtenerTodasLasSolicitudes();
    }
    
    
    /**
     * Obtiene y devuelve las listas de solicitudes a nombre del técnico
     * 
     * @param usuario Usuario actual que ha generado solicitudes de reapertura
     * @return Lista de tipo Solicitud con las solicitudes de reapertura a su nombre
     */
    public List<Solicitud> obtenerSolicitudesTecnico(Usuario usuario){
        return solicitudModelo.obtenerSolicitudesTecnico(usuario);
    }
}
