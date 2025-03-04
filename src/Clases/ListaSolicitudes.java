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

    /**
     * Agrega una solicitud a la lista de solicitudes.
     *
     * @param solicitud La solicitud a agregar a la lista.
     */
    public void agregarSolicitud(Solicitud solicitud) {
        solicitudes.add(solicitud);
    }

    /**
     * Remueve todas las solicitudes de la lista.
     */
    public void removerSolicitudes() {
        solicitudes.clear();
    }

    /**
     * Agrega múltiples solicitudes a la lista.
     *
     * @param solicitudes Lista de solicitudes a agregar.
     */
    public void agregarSolicitudes(List<Solicitud> solicitudes) {
        for (Solicitud solicitud : solicitudes) {
            this.agregarSolicitud(solicitud);
        }
    }

    /**
     * Obtiene todas las solicitudes que tienen un estado específico.
     *
     * @param estado El estado por el cual se desea filtrar las solicitudes.
     * @return Una lista de solicitudes cuyo estado coincide con el estado
     * proporcionado.
     */
    public List<Solicitud> obtenerSolicitudesPorEstado(String estado) {
        List<Solicitud> resultado = new ArrayList<>();
        for (Solicitud solicitud : solicitudes) {
            if (solicitud.getEstado().equalsIgnoreCase(estado)) {
                resultado.add(solicitud);
            }
        }
        return resultado;
    }

    /**
     * Busca una solicitud en la lista por su índice.
     *
     * @param Indice El índice de la solicitud en la lista.
     * @return La solicitud en el índice especificado.
     * @throws IndexOutOfBoundsException Si el índice está fuera de los límites
     * de la lista.
     */
    public Solicitud buscarPorIndice(int Indice) {
        return solicitudes.get(Indice);
    }

    /**
     * Obtiene todas las solicitudes en la lista.
     *
     * @return Una lista con todas las solicitudes.
     */
    public List<Solicitud> obtenerTodasLasSolicitudes() {
        return new ArrayList<>(solicitudes);
    }

}
