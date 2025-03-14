/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Clases.ListaSolicitudes;
import Clases.Solicitud;
import Clases.Ticket;
import Clases.TicketDatosVista;
import Clases.Usuario;
import controladores.ListaSolicitudesControlador;
import controladores.TicketControlador;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TuKK
 */
public class ListaSolicitudesVista extends javax.swing.JPanel {

    private ListaSolicitudesControlador listaSolicitudescontrolador;
    private ListaSolicitudes listaSolicitudes;
    private ListaSolicitudes listaSolicitudesFiltradas;
    private TicketControlador controladorTicket;
    private Usuario usuarioObtenido;

    public ListaSolicitudesVista() {
        return;
    }

    public ListaSolicitudesVista(Usuario usuario) {
        this.usuarioObtenido = usuario;
        this.listaSolicitudescontrolador = new ListaSolicitudesControlador();
        this.listaSolicitudes = new ListaSolicitudes();
        this.listaSolicitudesFiltradas = new ListaSolicitudes();
        this.controladorTicket = new TicketControlador(usuarioObtenido);
        initComponents();
        cargarSolicitudes();
    }

    public void cargarSolicitudes() {
        try {
            if (listaSolicitudescontrolador == null) {
                System.err.println("Error: listaUsuariosControlador es null. No se pueden cargar los usuarios.");
                return;
            }

            // Obtener la lista desde el controlador
            List<Solicitud> solicitudes = listaSolicitudescontrolador.obtenerTodasLasSolicitudes();
            if (solicitudes == null) {
                System.err.println("Error: La lista de usuarios obtenida es null.");
                return;
            }

            // Reiniciar listas
            listaSolicitudes.removerSolicitudes();
            listaSolicitudesFiltradas.removerSolicitudes();

            // Almacenar usuarios en las listas
            listaSolicitudes.agregarSolicitudes(solicitudes);
            listaSolicitudesFiltradas.agregarSolicitudes(listaSolicitudes.obtenerSolicitudesPorEstado("pendiente"));

            DefaultTableModel modelo = (DefaultTableModel) tablaSolicitudes.getModel();
            modelo.setRowCount(0); // Limpiar la tabla

            for (Solicitud solicitud : listaSolicitudesFiltradas.obtenerTodasLasSolicitudes()) {
                if (solicitud != null) {
                    modelo.addRow(new Object[]{
                        solicitud.getTicket().getTicket_id(),
                        solicitud.getTecnico().getNombre(),
                        solicitud.getEstado()});
                }
            }

        } catch (Exception e) {
            System.err.println("Error inesperado al cargar usuarios: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void reiniciarLista() {
        DefaultTableModel modelo = (DefaultTableModel) tablaSolicitudes.getModel();
        modelo.setRowCount(0); // Limpiar la tabla

        for (Solicitud solicitud : listaSolicitudes.obtenerSolicitudesPorEstado("pendiente")) {
            if (solicitud != null) {
                modelo.addRow(new Object[]{
                    solicitud.getTicket().getTicket_id(),
                    solicitud.getTecnico().getNombre(),
                    solicitud.getEstado()});
            }
        }
    }

    public TicketControlador getControlador() {
        return controladorTicket;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaSolicitudes = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        tablaSolicitudes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "N° Ticket", "Solicitado por", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        // Aplica el renderer a todas las columnas
        for (int i = 0; i < tablaSolicitudes.getColumnModel().getColumnCount(); i++) {
            tablaSolicitudes.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        tablaSolicitudes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaSolicitudesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaSolicitudes);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Solicitudes de Reapertura");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel4)
                .addGap(65, 401, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tablaSolicitudesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaSolicitudesMouseClicked
        int filaSeleccionada = tablaSolicitudes.getSelectedRow();

        if (filaSeleccionada != -1) { // Verifica que haya una fila seleccionada

            Solicitud solicitud = listaSolicitudesFiltradas.buscarPorIndice(filaSeleccionada);
            TicketDatosVista dialog;

            dialog = new SolicitudVista((JFrame) SwingUtilities.getWindowAncestor(this), solicitud.getIdSolicitudReapertura(), this, solicitud.getTicket());
            dialog.setSize(800, 500);
            dialog.setLocationRelativeTo(this); // Centrar el diálogo
            dialog.setVisible(true);

        } else {
            System.out.println(filaSeleccionada);
        }
    }//GEN-LAST:event_tablaSolicitudesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaSolicitudes;
    // End of variables declaration//GEN-END:variables
}
