/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

/**
 *
 * @author ramir
 */

import Clases.ListaTickets;
import Clases.Usuario;
import Clases.Ticket;
import controladores.TicketControlador;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;

import javax.swing.table.DefaultTableModel;

public class PanelTickets extends javax.swing.JPanel {

    private TicketControlador controlador;
    private Usuario usuario;
    private ListaTickets listaCompleta;
    private ListaTickets listaFiltrada;

    public PanelTickets() {
        return;  // Llama al otro constructor con un usuario por defecto
    }
    
   
    
    /**
     * Creates new form PanelTickets
     * @param usuario Se la vista
     */
    public PanelTickets(Usuario usuario) {
        this.usuario = usuario;
        this.controlador = new TicketControlador();
        this.listaCompleta = new ListaTickets();
        this.listaFiltrada = new ListaTickets();
        initComponents();
        cargarTickets();
        setFiltro(usuario.getTipo());
        
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        filtro = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTickets = new javax.swing.JTable();

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("N° Ticket");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Solicitado por");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Atendido por");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Estado");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addGap(48, 48, 48)
                .addComponent(jLabel4)
                .addGap(61, 61, 61)
                .addComponent(jLabel5)
                .addGap(83, 83, 83)
                .addComponent(jLabel6)
                .addContainerGap(210, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setMinimumSize(new java.awt.Dimension(487, 423));
        setPreferredSize(new java.awt.Dimension(690, 500));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        filtro.setEditor(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Estado:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Filtro");

        tablaTickets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N° Ticket", "Solicitado por", "Atendido por", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnBuscar)
                .addGap(51, 51, 51))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(38, 38, 38)
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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tablaTickets.getModel();
        listaFiltrada.removerTickets();
        listaFiltrada.agregarTickets(listaCompleta.filtrarPorEstado(getFiltro()));
        modelo.setRowCount(0); // Limpiar la tabla

            for (Ticket tkt : listaFiltrada.obtenerTodos()) {
                if (tkt != null) {
                    modelo.addRow(new Object[]{
                        tkt.getTicket_id(),
                        tkt.getInformador().getNombre(),
                        tkt.getTecnico()!= null ? tkt.getTecnico().getNombre(): "Sin Asignar",
                        tkt.getEstado()
                    });
                }
            }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tablaTicketsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTicketsMouseClicked
        int filaSeleccionada = tablaTickets.getSelectedRow();
        
        if (filaSeleccionada != -1) { // Verifica que haya una fila seleccionada

            Ticket ticket = listaFiltrada.buscarPorIndice(filaSeleccionada);

            TicketVistaTrabajador dialog = new TicketVistaTrabajador((JFrame) SwingUtilities.getWindowAncestor(this), usuario, this, ticket);
            dialog.setSize(800, 500);
            dialog.setLocationRelativeTo(this); // Centrar el diálogo
            dialog.setVisible(true);

        }else{
            System.out.println(filaSeleccionada);
        }
    }//GEN-LAST:event_tablaTicketsMouseClicked


    public String getFiltro() {
        /*String[] opciones = {"No Atendido","Atendido","Reabierto","Resuelto","Todos","Finalizado"};
        int index = filtro.getSelectedIndex();*/
        return filtro.getSelectedItem().toString();
    }

    public void setFiltro(String tipo) {
        String[] opciones = {"No Atendido","Atendido","Reabierto","Resuelto","Todos","Finalizado"};
        if(tipo.equals("administrador")){
            for(String op : opciones){
                filtro.addItem(op);
            }
            filtro.setSelectedIndex(4);
        }else{
            if(tipo.equals("trabajador")){
                for(int i=0;i<5;i++){
                    filtro.addItem(opciones[i]);
                }
                filtro.setSelectedIndex(4);
            }else{
                filtro.addItem(opciones[0]);
                filtro.addItem(opciones[2]);
                filtro.addItem(opciones[4]);
                filtro.setSelectedIndex(2);
            }  
        }
    }
    
    
    
    public void cargarTickets() {
        try {
            if (controlador == null) {
                System.err.println("Error: listaUsuariosControlador es null. No se pueden cargar los usuarios.");
                return;
            }

            // Obtener la lista desde el controlador
            List<Ticket> tickets = controlador.buscarTickets(usuario);
            
            if (tickets == null) {
                System.err.println("Error: La lista de usuarios obtenida es null.");
                return;
            }

            // Reiniciar listas
            listaCompleta.removerTickets();
            listaFiltrada.removerTickets();

            // Almacenar usuarios en las listas
            listaCompleta.agregarTickets(tickets);
            listaFiltrada.agregarTickets(tickets);
            
            DefaultTableModel modelo = (DefaultTableModel) tablaTickets.getModel();
            modelo.setRowCount(0); // Limpiar la tabla

            
            for (Ticket tkt : listaCompleta.obtenerTodos()) {
                if (tkt != null) {
                    modelo.addRow(new Object[]{
                        tkt.getTicket_id(),
                        tkt.getInformador().getNombre(),
                        tkt.getTecnico()!= null ? tkt.getTecnico().getNombre(): "Sin Asignar",
                        tkt.getEstado()
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
        modelo.setRowCount(0); // Limpiar la tabla
        
        for (Ticket tkt : listaCompleta.obtenerTodos()) {
                if (tkt != null) {
                    modelo.addRow(new Object[]{
                        tkt.getTicket_id(),
                        tkt.getInformador().getNombre(),
                        tkt.getTecnico()!= null ? tkt.getTecnico().getNombre(): "Sin Asignar",
                        tkt.getEstado()
                    });
                }
            }
    }
    
    public void mostrarMensaje(String mensaje, String titulo, int tipoMensaje){
        JOptionPane.showMessageDialog(null, mensaje, titulo, tipoMensaje);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> filtro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaTickets;
    // End of variables declaration//GEN-END:variables
}
