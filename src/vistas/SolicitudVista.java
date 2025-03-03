/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Clases.Ticket;
import Clases.TicketDatosVista;
import Clases.Usuario;
import controladores.SolicitudVistaControlador;
import controladores.TecnicoControlador;
import controladores.TicketControlador;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author TuKK
 */
public class SolicitudVista extends TicketDatosVista {

    private ListaSolicitudesVista listaVista;
    private int solicitudId;
    private Ticket ticketObtenido;
    private SolicitudVistaControlador controladorSolicitud;

    public SolicitudVista(JFrame jFrame, int solicitudId, ListaSolicitudesVista listaVista, Ticket ticket) {
        super(jFrame, "Solicitud " + solicitudId, listaVista.getControlador());
        this.solicitudId = solicitudId;
        this.ticketObtenido = ticket;
        this.listaVista = listaVista;
        this.controladorSolicitud = new SolicitudVistaControlador(this);
        initComponents();
        setFrame();
    }

    public SolicitudVista(JFrame jFrame, int solicitudId, TicketControlador controlador, Ticket ticket) {
        super(jFrame, "Solicitud " + solicitudId, controlador);
        this.solicitudId = solicitudId;
        this.ticketObtenido = ticket;
        this.controladorSolicitud = new SolicitudVistaControlador(this);
        initComponents();
        setFrame();
    }

    @Override
    public Ticket getTicket() {
        return ticketObtenido;
    }

    @Override
    public void setTicket(Ticket ticket) {
        this.ticketObtenido = ticket;
    }

    @Override
    public String getDescripcion() {
        return descripcion.getText();
    }

    @Override
    public void setDescripcion(String description) {
        descripcion.setText(description);
    }

    @Override
    public String getEstado() {
        return estado.getText();
    }

    @Override
    public void setEstado(String status) {
        estado.setText(status);
    }

    @Override
    public String getTitulo() {
        return titulo.getText();
    }

    @Override
    public void setTitulo(String title) {
        titulo.setText(title);
    }

    @Override
    public void mostrarMensaje(String mensaje, String titulo, int tipoMensaje) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, tipoMensaje);
    }

    @Override
    public String getTecnico() {
        return nombreTecnico.getText();
    }

    @Override
    public void setTecnico(String tecnico) {
        nombreTecnico.setText(tecnico);
    }

    @Override
    public void setId(int id) {
        if (id < 10) {
            soliId.setText("0000" + id);
        } else {
            if (id < 100) {
                soliId.setText("000" + id);
            } else {
                if (id < 1000) {
                    soliId.setText("00" + id);
                } else {
                    if (id < 10000) {
                        soliId.setText("0" + id);
                    } else {
                        soliId.setText("" + id);
                    }
                }
            }
        }
    }

    @Override
    public void setFrame() {
        setId(solicitudId);
        setTitulo(ticketObtenido.getTitulo());
        setDescripcion(ticketObtenido.getDescripcion());
        setTecnico(ticketObtenido.getTecnico().getNombre());
        if (listaVista == null) {
            getBtnReabrirTicket().setEnabled(false);
            getBtnReabrirTicket().setContentAreaFilled(false);
        }
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
        solicitudIDTitulo = new javax.swing.JLabel();
        BtnCerrar = new javax.swing.JButton();
        titulo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        soliId = new javax.swing.JLabel();
        ticketEstadoTitulo = new javax.swing.JLabel();
        estado = new javax.swing.JLabel();
        BtnReabrirTicket = new javax.swing.JButton();
        nombreTecnicoTitulo = new javax.swing.JLabel();
        nombreTecnico = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(600, 400));

        solicitudIDTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        solicitudIDTitulo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        solicitudIDTitulo.setText("Solicitud - ");

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

        soliId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        soliId.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        soliId.setText("00001");

        ticketEstadoTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ticketEstadoTitulo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ticketEstadoTitulo.setText("Estado: ");

        estado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        estado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        estado.setText("Pendiente");

        BtnReabrirTicket.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BtnReabrirTicket.setText("Reabrir");
        BtnReabrirTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReabrirTicketActionPerformed(evt);
            }
        });

        nombreTecnicoTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nombreTecnicoTitulo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nombreTecnicoTitulo.setText("A pedido de:");

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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ticketEstadoTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreTecnicoTitulo, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(solicitudIDTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(soliId, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(BtnReabrirTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                            .addComponent(solicitudIDTitulo)
                            .addComponent(soliId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnReabrirTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    public JButton getBtnReabrirTicket() {
        return BtnReabrirTicket;
    }


    private void BtnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCerrarActionPerformed
        if (listaVista != null) {
            listaVista.cargarSolicitudes();
        }
        this.dispose();
    }//GEN-LAST:event_BtnCerrarActionPerformed

    private void BtnReabrirTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReabrirTicketActionPerformed
        try {
            controlador.reabrirTicket(ticketObtenido);
            controladorSolicitud.actualizarEstadoSolicitud(solicitudId, "aprobado");
            if (listaVista != null) {
                listaVista.cargarSolicitudes();
            }
            this.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_BtnReabrirTicketActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCerrar;
    private javax.swing.JButton BtnReabrirTicket;
    private javax.swing.JTextArea descripcion;
    private javax.swing.JLabel estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel nombreTecnico;
    private javax.swing.JLabel nombreTecnicoTitulo;
    private javax.swing.JLabel soliId;
    private javax.swing.JLabel solicitudIDTitulo;
    private javax.swing.JLabel ticketEstadoTitulo;
    private javax.swing.JTextField titulo;
    // End of variables declaration//GEN-END:variables

}
