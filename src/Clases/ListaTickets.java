/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author ramir
 */
public class ListaTickets {

    private List<Ticket> tickets;

    public ListaTickets() {
        this.tickets = new ArrayList<>();
    }

    /**
     * Agrega un ticket a la lista de tickets.
     *
     * @param tkt El ticket a agregar a la lista.
     */
    public void agregarTicket(Ticket tkt) {
        tickets.add(tkt);
    }

    /**
     * Remueve todos los tickets de la lista.
     */
    public void removerTickets() {
        tickets.clear();
    }

    /**
     * Agrega múltiples tickets a la lista.
     *
     * @param tickets Lista de tickets a agregar.
     */
    public void agregarTickets(List<Ticket> tickets) {
        for (Ticket tkt : tickets) {
            this.agregarTicket(tkt);
        }
    }

    /**
     * Filtra los tickets por estado. Si el estado es "Todos", se devuelven
     * todos los tickets.
     *
     * @param estado El estado por el cual se desea filtrar los tickets.
     * @return Una lista de tickets cuyo estado coincide con el estado
     * proporcionado.
     */
    public List<Ticket> filtrarPorEstado(String estado) {
        if ("Todos".equals(estado)) {
            return tickets;
        }
        return tickets.stream()
                .filter(ticket -> ticket.getEstado().equalsIgnoreCase(estado))
                .collect(Collectors.toList());
    }

    /**
     * Obtiene todos los tickets en la lista.
     *
     * @return Una lista con todos los tickets.
     */
    public List<Ticket> obtenerTodos() {
        return new ArrayList<>(tickets);
    }

    /**
     * Busca un ticket en la lista por su índice.
     *
     * @param Indice El índice del ticket en la lista.
     * @return El ticket en el índice especificado.
     * @throws IndexOutOfBoundsException Si el índice está fuera de los límites
     * de la lista.
     */
    public Ticket buscarPorIndice(int Indice) {
        return tickets.get(Indice);
    }

}
