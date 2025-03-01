/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TuKK
 */
public class ListaSolicitudes {

    private List<Solicitud> solicitudes;

    public ListaSolicitudes() {
        this.solicitudes = new ArrayList<>();
    }

    public void agregarSolicitud(Solicitud solicitud) {
        solicitudes.add(solicitud);
    }
    
    public void removerSolicitudes() {
        solicitudes.clear();
    }
    
    public void agregarSolicitudes(List<Solicitud> solicitudes) {
        for (Solicitud solicitud : solicitudes) {
            this.agregarSolicitud(solicitud);
        }
    }
    
    public List<Solicitud> obtenerSolicitudesPorEstado(String estado) {
        List<Solicitud> resultado = new ArrayList<>();
        for (Solicitud solicitud : solicitudes) {
            if (solicitud.getEstado().equalsIgnoreCase(estado)) {
                resultado.add(solicitud);
            }
        }
        return resultado;
    }
    
    public Solicitud buscarPorIndice(int Indice) {
        return solicitudes.get(Indice);
    }

    public List<Solicitud> obtenerTodasLasSolicitudes() {
        return new ArrayList<>(solicitudes);
    }
}
