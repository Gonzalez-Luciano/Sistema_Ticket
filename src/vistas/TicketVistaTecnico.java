/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;


import Clases.Ticket;
import Clases.Usuario;
import controladores.TicketControlador;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame; 
import javax.swing.JOptionPane;
        
/**
 *
 * @author ramir
 */
public class TicketVistaTecnico extends javax.swing.JDialog {

    /**
     * Creates new form TicketVistaTecnico
     */
    public TicketVistaTecnico() {
        initComponents();
    }
    
    private Ticket ticket;
    private TicketControlador controlador;
    private PanelTickets panel;
    private PanelMisTickets panelM;
    private Color colorFondo = new Color(240,240,240);
    
    
    public TicketVistaTecnico(JFrame jFrame, Usuario usuario, PanelTickets panel, Ticket ticket){
        super(jFrame, "Ticket "+ticket.getTicket_id(), true);
        setSize(600,400);
        initComponents();
        this.panel = panel;
        controlador = new TicketControlador();
        this.ticket = ticket; 
        setTicket();
    }
    
    public TicketVistaTecnico(JFrame jFrame, Usuario usuario, PanelMisTickets panelM, Ticket ticket){
        super(jFrame, "Ticket "+ticket.getTicket_id(), true);
        setSize(600,400);
        initComponents();
        this.panelM = panelM;
        controlador = new TicketControlador();
        this.ticket = ticket; 
        setTicket();
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
        BtnResolver = new javax.swing.JButton();
        BtnTomarTicket = new javax.swing.JButton();
        nombreTecnicoTitulo = new javax.swing.JLabel();
        nombreTecnico = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(600, 400));

        ticketIDTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ticketIDTitulo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ticketIDTitulo.setText("Ticket - ");

        BtnCerrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BtnCerrar.setText("Cerrar");
        BtnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCerrarActionPerformed(evt);
            }
        });

        titulo.setEditable(false);
        titulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        titulo.setText("Esto es una muestra");
        titulo.setBorder(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Título");

        jScrollPane.setBorder(null);

        descripcion.setEditable(false);
        descripcion.setBackground(new java.awt.Color(240, 240, 240));
        descripcion.setColumns(20);
        descripcion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        descripcion.setLineWrap(true);
        descripcion.setRows(5);
        descripcion.setText("Lorem ipsum dolor sit, amet consectetur adipisicing elit. Est tempore eaque libero ullam aut nulla explicabo aliquam animi perspiciatis suscipit, accusamus nobis nesciunt officiis voluptatum. Cumque libero incidunt officia laboriosam?");
        descripcion.setWrapStyleWord(true);
        descripcion.setBorder(null);
        jScrollPane.setViewportView(descripcion);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

        BtnResolver.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BtnResolver.setText("Resuelto");
        BtnResolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnResolverActionPerformed(evt);
            }
        });

        BtnTomarTicket.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BtnTomarTicket.setText("Tomar Ticket");
        BtnTomarTicket.setFocusPainted(false);
        BtnTomarTicket.setFocusable(false);
        BtnTomarTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTomarTicketActionPerformed(evt);
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
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                            .addComponent(titulo))
                        .addContainerGap(99, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ticketEstadoTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nombreTecnicoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(ticketIDTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ticketId, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(BtnResolver, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnTomarTicket)
                .addGap(185, 185, 185)
                .addComponent(BtnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ticketIDTitulo)
                            .addComponent(ticketId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ticketEstadoTitulo)
                            .addComponent(estado))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreTecnicoTitulo)
                            .addComponent(nombreTecnico))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnTomarTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnResolver, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
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

    private void BtnResolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnResolverActionPerformed
        //controlador.cerrarTicket(ticket);
    }//GEN-LAST:event_BtnResolverActionPerformed

    private void BtnTomarTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTomarTicketActionPerformed
        //controlador.reabrirTicket(ticket);
    }//GEN-LAST:event_BtnTomarTicketActionPerformed

    public JButton getBtnTomarTicket() {
        return BtnTomarTicket;
    }

    public JButton getBtnResolver() {
        return BtnResolver;
    }

    
    
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
        if(true){
            if("Atendido".equals(ticket.getEstado())){
                getBtnResolver().setEnabled(true);
                getBtnResolver().setContentAreaFilled(true);
                getBtnResolver().setForeground(java.awt.Color.BLACK);
                getBtnTomarTicket().setEnabled(false);
                getBtnTomarTicket().setContentAreaFilled(false);
                getBtnTomarTicket().setForeground(colorFondo);
            }else{
                getBtnResolver().setEnabled(false);
                getBtnResolver().setContentAreaFilled(false);
                getBtnResolver().setForeground(colorFondo);
                getBtnTomarTicket().setEnabled(true);
                getBtnTomarTicket().setContentAreaFilled(true);
                getBtnTomarTicket().setForeground(java.awt.Color.BLACK);
            }
        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCerrar;
    private javax.swing.JButton BtnResolver;
    private javax.swing.JButton BtnTomarTicket;
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
