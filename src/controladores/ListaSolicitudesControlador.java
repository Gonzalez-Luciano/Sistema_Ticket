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

    public List<Solicitud> obtenerTodasLasSolicitudes() {
        return solicitudModelo.obtenerTodasLasSolicitudes();
    }
    
    public List<Solicitud> obtenerSolicitudesTecnico(Usuario usuario){
        return solicitudModelo.obtenerSolicitudesTecnico(usuario);
    }
}
