/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import controladores.TicketControlador;
import javax.swing.JFrame;

/**
 *
 * @author ramir
 */
public abstract class TicketDatosVista extends javax.swing.JDialog {

    protected TicketControlador controlador;

    public TicketDatosVista(JFrame jFrame, String text, TicketControlador controlador) {
        super(jFrame, text, true);
        this.controlador = controlador;
        this.controlador.setVistaTicket(this);
    }

    public abstract Ticket getTicket();

    public abstract void setTicket(Ticket ticket);

    public abstract String getDescripcion();

    public abstract void setDescripcion(String description);

    public abstract String getEstado();

    public abstract void setEstado(String status);

    public abstract String getTitulo();

    public abstract void setTitulo(String title);

    public abstract void mostrarMensaje(String mensaje, String titulo, int tipoMensaje);

    public abstract String getTecnico();

    public abstract void setTecnico(String tecnico);

    public abstract void setFrame();

    public abstract void setId(int id);
}
