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

    public void agregarTicket(Ticket tkt) {
        tickets.add(tkt);
    }

    public void removerTickets() {
        tickets.clear();
    }

    public void agregarTickets(List<Ticket> tickets) {
        for (Ticket tkt : tickets) {
            this.agregarTicket(tkt);
        }
    }
    
    public List<Ticket> filtrarPorEstado(String estado) {
        if("Todos".equals(estado)){
            return tickets;
        }
        return tickets.stream()
                      .filter(ticket -> ticket.getEstado().equalsIgnoreCase(estado))
                      .collect(Collectors.toList());
    }
    
    public List<Ticket> obtenerTodos() {
        return new ArrayList<>(tickets);
    }
    
    public Ticket buscarPorIndice(int Indice) {
        return tickets.get(Indice);
    }
    
    
}
