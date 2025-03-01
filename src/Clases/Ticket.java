
package Clases;

/**
 *
 * @author ramir
 */
public class Ticket {
    
    private int ticket_id;
    private String titulo;
    private String descripcion;
    private String estado;
    private Trabajador informador;
    private Tecnico tecnico;
    private Tecnico tecnicoAnterior;

    public Ticket(int ticket_id, String titulo, String descripcion, String estado, Trabajador trabajador, Tecnico tecnico, Tecnico tecnicoAnterior) {
        this.ticket_id = ticket_id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.informador = trabajador;
        this.tecnico = tecnico;
        this.tecnicoAnterior = tecnicoAnterior;
    }
    
    public Ticket(int ticket_id, String titulo, String descripcion, String estado) {
        this.ticket_id = ticket_id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
    }
    
    public Ticket(String titulo, String descripcion, Trabajador informador){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.informador = informador;
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Trabajador getInformador() {
        return informador;
    }

    public void setInformador(Trabajador informador) {
        this.informador = informador;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }
    
    public Tecnico getTecnicoAnterior() {
        return tecnicoAnterior;
    }

    public void setTecnicoAnterior(Tecnico tecnicoAnterior) {
        this.tecnicoAnterior = tecnicoAnterior;
    }
    
     
    
}
