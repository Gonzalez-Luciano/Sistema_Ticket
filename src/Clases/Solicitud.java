/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author TuKK
 */
public class Solicitud {

    private Ticket ticket;
    private Tecnico tecnico;
    private String estado; // Puede ser "pendiente", "aprobado" o "rechazado"

    public Solicitud(Ticket ticket, Tecnico tecnico, String estado) {
        this.ticket = ticket;
        this.tecnico = tecnico;
        this.estado = estado;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        if (estado.equals("pendiente") || estado.equals("aprobado") || estado.equals("rechazado")) {
            this.estado = estado;
        } else {
            throw new IllegalArgumentException("Estado inválido");
        }
    }
}
