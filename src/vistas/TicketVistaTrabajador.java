/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.TicketControlador;
import javax.swing.JOptionPane;
import Clases.Ticket;
import Clases.Usuario;
import javax.swing.JFrame;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author ramir
 */
public class TicketVistaTrabajador extends javax.swing.JDialog {


    /**
     * @return the BtnResuelto
     */
    public javax.swing.JButton getBtnResuelto() {
        return BtnResuelto;
    }

    /**
     * @return the BtnReabrir
     */
    public javax.swing.JButton getBtnReabrir() {
        return BtnReabrir;
    }

    /**
     * Creates new form TicketVistaTrabajador
     */
    private TicketControlador controlador;
    private Ticket ticket;
    private PanelTickets panel;
    
    
    
    public TicketVistaTrabajador(JFrame jFrame, Usuario usuario, PanelTickets panel, Ticket ticket) {
        super(jFrame, "Ticket "+ticket.getTicket_id(), true);
        setSize(600,400);
        initComponents();
        this.panel = panel;
        controlador = new TicketControlador();
        this.ticket = ticket; 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ticketIDTitulo = new javax.swing.JLabel();
        BtnCerrar = new javax.swing.JButton();
        titulo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        ticketId = new javax.swing.JLabel();
        ticketEstadoTitulo = new javax.swing.JLabel();
        estado = new javax.swing.JLabel();
        BtnResuelto = new javax.swing.JButton();
        BtnReabrir = new javax.swing.JButton();
        nombreTecnicoTitulo = new javax.swing.JLabel();
        nombreTecnico = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(600, 400));

        ticketIDTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ticketIDTitulo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ticketIDTitulo.setText("Ticket - ");

        BtnCerrar.setText("Cerrar");
        BtnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCerrarActionPerformed(evt);
            }
        });

        titulo.setEditable(false);
        titulo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        titulo.setText("Esto es una muestra");
        titulo.setBorder(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Título");

        jScrollPane.setBorder(null);

        descripcion.setEditable(false);
        descripcion.setBackground(new java.awt.Color(240, 240, 240));
        descripcion.setColumns(20);
        descripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        descripcion.setLineWrap(true);
        descripcion.setRows(5);
        descripcion.setText("Lorem ipsum dolor sit, amet consectetur adipisicing elit. Est tempore eaque libero ullam aut nulla explicabo aliquam animi perspiciatis suscipit, accusamus nobis nesciunt officiis voluptatum. Cumque libero incidunt officia laboriosam?");
        descripcion.setWrapStyleWord(true);
        descripcion.setBorder(null);
        jScrollPane.setViewportView(descripcion);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Descripción");

        ticketId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ticketId.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ticketId.setText("00001");

        ticketEstadoTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ticketEstadoTitulo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ticketEstadoTitulo.setText("Estado: ");

        estado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        estado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        estado.setText("No Atendido");

        BtnResuelto.setForeground(new java.awt.Color(240, 240, 240));
        BtnResuelto.setText("Resuelto");
        BtnResuelto.setContentAreaFilled(false);
        BtnResuelto.setEnabled(false);
        BtnResuelto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnResueltoActionPerformed(evt);
            }
        });

        BtnReabrir.setForeground(new java.awt.Color(240, 240, 240));
        BtnReabrir.setText("No Resuelto");
        BtnReabrir.setContentAreaFilled(false);
        BtnReabrir.setEnabled(false);
        BtnReabrir.setFocusPainted(false);
        BtnReabrir.setFocusable(false);
        BtnReabrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReabrirActionPerformed(evt);
            }
        });

        nombreTecnicoTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nombreTecnicoTitulo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nombreTecnicoTitulo.setText("A cargo de:");

        nombreTecnico.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nombreTecnico.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nombreTecnico.setText("Sin Asignar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(BtnResuelto)
                        .addGap(26, 26, 26)
                        .addComponent(BtnCerrar)
                        .addGap(27, 27, 27)
                        .addComponent(BtnReabrir)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jScrollPane)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ticketIDTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ticketId, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)
                        .addComponent(nombreTecnicoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(ticketEstadoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nombreTecnico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(estado, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                .addContainerGap(212, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ticketEstadoTitulo)
                    .addComponent(estado))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ticketIDTitulo)
                    .addComponent(ticketId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreTecnicoTitulo)
                    .addComponent(nombreTecnico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCerrar)
                    .addComponent(BtnResuelto)
                    .addComponent(BtnReabrir))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCerrarActionPerformed
        panel.reiniciarLista();
        this.dispose();
    }//GEN-LAST:event_BtnCerrarActionPerformed

    private void BtnResueltoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnResueltoActionPerformed
        controlador.cerrarTicket(ticket);
    }//GEN-LAST:event_BtnResueltoActionPerformed

    private void BtnReabrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReabrirActionPerformed
        controlador.reabrirTicket(ticket);
    }//GEN-LAST:event_BtnReabrirActionPerformed

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    
    public String getDescripcion() {
        return descripcion.getText();
    }
    
    public void setDescripcion(String description) {
        descripcion.setText(description);
    }

    public String getEstado() {
        return estado.getText();
    }

    public void setEstado(String status) {
        estado.setText(status);
    }

    public String getTicketId() {
        return ticketId.getText();
    }

    public void setTicketId(int ticket_id) {
        if(ticket_id<10){
            ticketId.setText("0000"+ticket_id);
        }else{
            if(ticket_id<100){
                ticketId.setText("000"+ticket_id);
            }else{
                if(ticket_id<1000){
                    ticketId.setText("00"+ticket_id);
                }else{if (ticket_id<10000) {
                        ticketId.setText("0"+ticket_id);
                    }else{
                        ticketId.setText(""+ticket_id);
                    }
                }
            }
        }
    }

    public String getTitulo() {
        return titulo.getText();
    }

    public void setTitulo(String title) {
        titulo.setText(title);
    }

    public void mostrarMensaje(String mensaje, String titulo, int tipoMensaje){
        JOptionPane.showMessageDialog(null, mensaje, titulo, tipoMensaje);
    }
    
    public String getTecnico(){
        return nombreTecnico.getText();
    }
    
    public void setTecnico(String tecnico){
        nombreTecnico.setText(tecnico);
    }
    
    
    public void setTicket(){
        setTicketId(ticket.getTicket_id());
        setEstado(ticket.getEstado());
        setTitulo(ticket.getTitulo());
        setDescripcion(ticket.getDescripcion());
        if(ticket.getTecnico()== null)
            setTecnico("Sin Asignar");
        else 
            setTecnico(ticket.getTecnico().getNombre());
        if("Resuelto".equals(ticket.getEstado())){
            getBtnResuelto().setEnabled(true);
            getBtnResuelto().setContentAreaFilled(true);
            getBtnResuelto().setForeground(java.awt.Color.BLACK);
            getBtnReabrir().setEnabled(true);
            getBtnReabrir().setContentAreaFilled(true);
            getBtnReabrir().setForeground(java.awt.Color.BLACK);
        }else{
            getBtnResuelto().setEnabled(false);
            getBtnResuelto().setContentAreaFilled(false);
            getBtnResuelto().setForeground(java.awt.Color.getHSBColor(0, 0, (float) 0.94));
            getBtnReabrir().setEnabled(false);
            getBtnReabrir().setContentAreaFilled(false);
            getBtnReabrir().setForeground(java.awt.Color.getHSBColor(0, 0, (float) 0.94));
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCerrar;
    private javax.swing.JButton BtnReabrir;
    private javax.swing.JButton BtnResuelto;
    private javax.swing.JTextArea descripcion;
    private javax.swing.JLabel estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel nombreTecnico;
    private javax.swing.JLabel nombreTecnicoTitulo;
    private javax.swing.JLabel ticketEstadoTitulo;
    private javax.swing.JLabel ticketIDTitulo;
    private javax.swing.JLabel ticketId;
    private javax.swing.JTextField titulo;
    // End of variables declaration//GEN-END:variables
}
