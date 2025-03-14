/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Clases.ListaSolicitudes;
import Clases.ListaTickets;
import Clases.Solicitud;
import Clases.Ticket;
import Clases.TicketDatosVista;
import Clases.Usuario;
import controladores.ListaSolicitudesControlador;
import controladores.TicketControlador;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ramir
 */
public class PanelMisTickets extends javax.swing.JPanel {

    private Usuario usuario;
    private TicketControlador controlador;
    private ListaTickets listaCompleta;
    private ListaTickets listaAtendidos;
    private ListaSolicitudes listaSolicitudes;
    private ListaSolicitudes listaSolicitudesFiltrada;
    private Set<Integer> ticketsConSolicitud;
    int filaListaTicketSeleccionada;
    private ListaSolicitudesControlador listaSolicitudescontrolador;

    /**
     * Creates new form PanelMisTickets
     */
    public PanelMisTickets() {
        return;  // Llama al otro constructor con un usuario por defecto
    }

    /**
     * Creates new form PanelTickets
     *
     * @param usuario Se la vista
     */
    public PanelMisTickets(Usuario usuario) {
        this.usuario = usuario;
        this.controlador = new TicketControlador();
        this.listaCompleta = new ListaTickets();
        this.listaAtendidos = new ListaTickets();
        this.listaSolicitudes = new ListaSolicitudes();
        this.listaSolicitudesFiltrada = new ListaSolicitudes();
        this.listaSolicitudescontrolador = new ListaSolicitudesControlador();
        this.ticketsConSolicitud = new HashSet<>();
        initComponents();
        cargarSolicitudes();
        cargarTickets();
        

    }

    public void cargarTickets() {
        try {
            if (controlador == null) {
                System.err.println("Error: listaUsuariosControlador es null. No se pueden cargar los usuarios.");
                return;
            }

            // Obtener la lista desde el controlador
            List<Ticket> tickets = controlador.buscarTickets(usuario);
            List<Solicitud> solicitudes = listaSolicitudesFiltrada.obtenerTodasLasSolicitudes();
            if (tickets == null) {
                System.err.println("Error: La lista de usuarios obtenida es null.");
                return;
            }

            // Reiniciar listas
            listaCompleta.removerTickets();
            listaAtendidos.removerTickets();

            // Almacenar usuarios en las listas
            listaCompleta.agregarTickets(tickets);

            // Crear un conjunto con los IDs de los tickets con solicitud de reapertura
            ticketsConSolicitud = solicitudes.stream()
                    .map(solicitud -> solicitud.getTicket().getTicket_id())
                    .collect(Collectors.toSet());

            // Filtrar los tickets atendidos que no tienen solicitud de reapertura
            List<Ticket> ticketsFiltrados = listaCompleta.filtrarPorEstado("Atendido").stream()
                    .filter(tkt -> !ticketsConSolicitud.contains(tkt.getTicket_id()))
                    .collect(Collectors.toList());

            // Agregar los tickets filtrados a la lista de atendidos
            listaAtendidos.agregarTickets(ticketsFiltrados);

            DefaultTableModel modelo = (DefaultTableModel) tablaTickets.getModel();
            modelo.setRowCount(0); // Limpiar la tabla

            for (Ticket tkt : listaAtendidos.obtenerTodos()) {
                if (tkt != null) {
                    modelo.addRow(new Object[]{
                        tkt.getTicket_id(),
                        tkt.getTitulo(),
                        tkt.getInformador().getNombre()
                    });
                }
            }

        } catch (Exception e) {
            System.err.println("Error inesperado al cargar usuarios: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void reiniciarLista() {
        DefaultTableModel modelo = (DefaultTableModel) tablaTickets.getModel();
        listaAtendidos.removerTickets();
        List<Solicitud> solicitudes = listaSolicitudesFiltrada.obtenerTodasLasSolicitudes();
        ticketsConSolicitud = solicitudes.stream()
                .map(solicitud -> solicitud.getTicket().getTicket_id())
                .collect(Collectors.toSet());

        // Filtrar los tickets atendidos que no tienen solicitud de reapertura
        List<Ticket> ticketsFiltrados = listaCompleta.filtrarPorEstado("Atendido").stream()
                .filter(tkt -> !ticketsConSolicitud.contains(tkt.getTicket_id()))
                .collect(Collectors.toList());

        // Agregar los tickets filtrados a la lista de atendidos
        listaAtendidos.agregarTickets(ticketsFiltrados);
        listaAtendidos.agregarTickets(listaCompleta.filtrarPorEstado("Atendido"));
        modelo.setRowCount(0); // Limpiar la tabla
        for (Ticket tkt : listaAtendidos.obtenerTodos()) {
            if (tkt != null) {
                modelo.addRow(new Object[]{
                    tkt.getTicket_id(),
                    tkt.getTitulo(),
                    tkt.getInformador().getNombre()
                });
            }
        }

    }

    public void mostrarMensaje(String mensaje, String titulo, int tipoMensaje) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, tipoMensaje);
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTickets = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BtnReapertura = new javax.swing.JButton();
        BtnAbrir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaSolicitudes = new javax.swing.JTable();

        jPanel1.setPreferredSize(new java.awt.Dimension(690, 500));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Estado:");

        tablaTickets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "N° Ticket", "Titulo", "Solicitado por"
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
        for (int i = 0; i < tablaTickets.getColumnModel().getColumnCount(); i++) {
            tablaTickets.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        tablaTickets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaTicketsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaTickets);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Atendido");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Asignados a mí");

        BtnReapertura.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BtnReapertura.setText("Solicitar Reapertura");
        BtnReapertura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnReaperturaMouseClicked(evt);
            }
        });

        BtnAbrir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BtnAbrir.setText("Abrir");
        BtnAbrir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnAbrirMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Solicitudes de Reapertura Pendientes");

        tablaSolicitudes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N° Solicitud", "N° Ticket", "Titulo", "Estado de solicitud"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        for (int i = 0; i < tablaSolicitudes.getColumnModel().getColumnCount(); i++) {
            tablaSolicitudes.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        tablaSolicitudes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaSolicitudesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaSolicitudes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(65, 65, 65))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(BtnReapertura, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnReapertura, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(BtnAbrir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void setFilaSeleccionada(int fila) {
        this.filaListaTicketSeleccionada = fila;
    }

    private int getFilaSeleccionada() {
        return this.filaListaTicketSeleccionada;
    }

    private void tablaTicketsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTicketsMouseClicked
        int filaSeleccionada = tablaTickets.getSelectedRow();

        if (filaSeleccionada != -1) { // Verifica que haya una fila seleccionada
            setFilaSeleccionada(filaSeleccionada);

        } else {
            System.out.println(filaSeleccionada);
        }
    }//GEN-LAST:event_tablaTicketsMouseClicked


    private void BtnReaperturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnReaperturaMouseClicked
        int filaSeleccionada = getFilaSeleccionada();

        if (filaSeleccionada != -1) { // Verifica que haya una fila seleccionada

            Ticket ticket = listaAtendidos.buscarPorIndice(filaSeleccionada);
            List<Solicitud> solicitudes = listaSolicitudesFiltrada.obtenerTodasLasSolicitudes();
            boolean existeSolicitud = true;
            for (Solicitud sol : solicitudes) {
                if (sol.getTicket().getTicket_id() == ticket.getTicket_id() && sol.getEstado().equals("pendiente")) {
                    existeSolicitud = false;
                    break;
                }
            }
            if (existeSolicitud) {
                TicketDatosVista dialog = new SolicitarVista((JFrame) SwingUtilities.getWindowAncestor(this), usuario, this, ticket);
                dialog.setSize(800, 500);
                dialog.setLocationRelativeTo(this); // Centrar el diálogo
                dialog.setVisible(true);
            } else {
                mensajeError("Ya existe una solicitud de reapertura pendiente");
            }
        } else {
            mensajeError("Debe seleccionar una fila para poder abrir");
        }
    }//GEN-LAST:event_BtnReaperturaMouseClicked

    private void BtnAbrirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAbrirMouseClicked
        int filaSeleccionada = getFilaSeleccionada();

        if (filaSeleccionada != -1) { // Verifica que haya una fila seleccionada

            Ticket ticket = listaAtendidos.buscarPorIndice(filaSeleccionada);

            TicketDatosVista dialog = new TicketVistaTecnico((JFrame) SwingUtilities.getWindowAncestor(this), usuario, this, ticket);
            dialog.setSize(800, 500);
            dialog.setLocationRelativeTo(this); // Centrar el diálogo
            dialog.setVisible(true);

        } else {
            mensajeError("Debe seleccionar una fila para poder abrir");
        }
    }//GEN-LAST:event_BtnAbrirMouseClicked

    private void tablaSolicitudesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaSolicitudesMouseClicked
        setFilaSeleccionada(-1);
        int filaSeleccionada = tablaSolicitudes.getSelectedRow();
        if (filaSeleccionada != -1) {
            Solicitud solicitud = listaSolicitudesFiltrada.buscarPorIndice(filaSeleccionada);

            SolicitudVista dialog = new SolicitudVista((JFrame) SwingUtilities.getWindowAncestor(this), solicitud.getIdSolicitudReapertura(), controlador, solicitud.getTicket());
            dialog.setSize(800, 500);
            dialog.setLocationRelativeTo(this); // Centrar el diálogo
            dialog.setVisible(true);
        } else {
            mensajeError("Debe seleccionar una fila para poder abrir");
        }
        reiniciarListaSolicitudes();
    }//GEN-LAST:event_tablaSolicitudesMouseClicked

    public void cargarSolicitudes() {
        try {
            if (listaSolicitudescontrolador == null) {
                System.err.println("Error: listaUsuariosControlador es null. No se pueden cargar los usuarios.");
                return;
            }

            // Obtener la lista desde el controlador
            List<Solicitud> solicitudes = listaSolicitudescontrolador.obtenerSolicitudesTecnico(usuario);
            if (solicitudes == null) {
                System.err.println("Error: La lista de usuarios obtenida es null.");
                return;
            }

            listaSolicitudes.removerSolicitudes();
            listaSolicitudesFiltrada.removerSolicitudes();

            // Almacenar usuarios en las listas
            listaSolicitudes.agregarSolicitudes(solicitudes);
            listaSolicitudesFiltrada.agregarSolicitudes(listaSolicitudes.obtenerSolicitudesPorEstado("pendiente"));

            DefaultTableModel modelo = (DefaultTableModel) tablaSolicitudes.getModel();
            modelo.setRowCount(0); // Limpiar la tabla

            for (Solicitud solicitud : listaSolicitudesFiltrada.obtenerTodasLasSolicitudes()) {
                if (solicitud != null) {
                    modelo.addRow(new Object[]{
                        solicitud.getIdSolicitudReapertura(),
                        solicitud.getTicket().getTicket_id(),
                        solicitud.getTicket().getTitulo(),
                        solicitud.getEstado()
                    });
                }
            }

        } catch (Exception e) {
            System.err.println("Error inesperado al cargar usuarios: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void reiniciarListaSolicitudes() {
        cargarTickets();
    }

    public TicketControlador getControlador() {
        return controlador;
    }

    public void mensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "⚠ Error", JOptionPane.ERROR_MESSAGE);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAbrir;
    private javax.swing.JButton BtnReapertura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaSolicitudes;
    private javax.swing.JTable tablaTickets;
    // End of variables declaration//GEN-END:variables
}
