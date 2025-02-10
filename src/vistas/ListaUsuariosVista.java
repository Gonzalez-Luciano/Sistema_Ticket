/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Clases.Administrador;
import Clases.FiltroNumerico;
import Clases.ListaUsuarios;
import Clases.Tecnico;
import Clases.Usuario;
import controladores.ListaUsuariosControlador;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author TuKK
 */
public class ListaUsuariosVista extends javax.swing.JPanel {

    private ListaUsuariosControlador listaUsuariosControlador;
    private ListaUsuarios listaUsuarios;
    private ListaUsuarios filtrados;
    private Usuario usuarioActual; // Usuario logeado que excluimos de la lista

    /**
     * Creates new form ListaUsuariosVista
     */
    public ListaUsuariosVista() {
        initComponents();
        this.listaUsuariosControlador = new ListaUsuariosControlador();
        this.listaUsuarios = new ListaUsuarios();
        this.filtrados = new ListaUsuarios();
        this.usuarioActual = new Administrador("Pepe", "543423456", 101, "1234", "Activo");
        cargarUsuarios();
    }

    public void setDNI(String dni) {
        if (jTextFieldDNI != null) {
            ((AbstractDocument) jTextFieldDNI.getDocument()).setDocumentFilter(null);
            jTextFieldDNI.setText(dni);
            ((AbstractDocument) jTextFieldDNI.getDocument()).setDocumentFilter(new FiltroNumerico());
        }

    }

    public void setLegajo(String legajo) {
        if (jTextFieldLegajo != null) {
            ((AbstractDocument) jTextFieldLegajo.getDocument()).setDocumentFilter(null);
            jTextFieldLegajo.setText(legajo);
            ((AbstractDocument) jTextFieldLegajo.getDocument()).setDocumentFilter(new FiltroNumerico());
        }
    }

    public void setNombre(String nombre) {
        this.jTextFieldNombre.setText(nombre);
    }

    public void cambiarEntry(String textField) {
        CardLayout cl = (CardLayout) jPanelOpcionesTexto.getLayout();
        cl.show(jPanelOpcionesTexto, textField);
        //Eliminar filtros existentes
        setNombre("");
        setDNI("");
        setLegajo("");

    }

    public void cargarUsuarios() {
        try {
            if (listaUsuariosControlador == null) {
                System.err.println("Error: listaUsuariosControlador es null. No se pueden cargar los usuarios.");
                return;
            }

            if (usuarioActual == null) {
                System.err.println("Error: usuarioActual es null. No se pueden obtener los usuarios.");
                return;
            }

            // Obtener la lista desde el controlador
            List<Usuario> usuarios = listaUsuariosControlador.obtenerTodosLosUsuarios(usuarioActual);
            if (usuarios == null) {
                System.err.println("Error: La lista de usuarios obtenida es null.");
                return;
            }

            // Reiniciar listas
            listaUsuarios.removerUsuarios();
            filtrados.removerUsuarios();

            // Almacenar usuarios en las listas
            listaUsuarios.agregarUsuarios(usuarios);
            filtrados.agregarUsuarios(usuarios);

            DefaultTableModel modelo = (DefaultTableModel) tablaUsuarios.getModel();
            modelo.setRowCount(0); // Limpiar la tabla

            for (Usuario usuario : listaUsuarios.obtenerTodos()) {
                if (usuario != null) {
                    modelo.addRow(new Object[]{
                        usuario.getNombre(),
                        usuario.getTipo(),
                        usuario.getDNI(),
                        usuario.getLegajo(),
                        usuario.getEstado()
                    });
                }
            }

        } catch (Exception e) {
            System.err.println("Error inesperado al cargar usuarios: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void reiniciarLista() {
        DefaultTableModel modelo = (DefaultTableModel) tablaUsuarios.getModel();
        modelo.setRowCount(0); // Limpiar la tabla

        for (Usuario usuario : listaUsuarios.obtenerTodos()) {
            modelo.addRow(new Object[]{
                usuario.getNombre(),
                usuario.getTipo(),
                usuario.getDNI(),
                usuario.getLegajo(),
                usuario.getEstado()
            });
        }
    }

    private void actualizarTablaFiltrada(List<Usuario> usuarios) {
        if (usuarios == null) {
            System.out.println("Error: la lista filtrada es null");
            return;
        }

        DefaultTableModel modelo = (DefaultTableModel) tablaUsuarios.getModel();
        modelo.setRowCount(0);

        for (Usuario usuario : usuarios) {
            if (usuario != null) {
                modelo.addRow(new Object[]{
                    usuario.getNombre(),
                    usuario.getTipo(),
                    usuario.getDNI(),
                    usuario.getLegajo(),
                    usuario.getEstado()
                });
            }
        }
    }

    private void buscarPorNombre() {
        String nombre = jTextFieldNombre.getText();
        filtrados.removerUsuarios();
        filtrados.agregarUsuarios(listaUsuarios.filtrarPorNombre(nombre));
        List<Usuario> usuarios = filtrados.obtenerTodos();
        actualizarTablaFiltrada(usuarios);
    }

    private void buscarPorDni() {
        String dni = jTextFieldDNI.getText();
        filtrados.removerUsuarios();
        filtrados.agregarUsuarios(listaUsuarios.filtrarPorDNI(dni));
        List<Usuario> usuarios = filtrados.obtenerTodos();
        actualizarTablaFiltrada(usuarios);
    }

    private void buscarPorLegajo() {
        String legajo = jTextFieldLegajo.getText();
        filtrados.removerUsuarios();
        filtrados.agregarUsuarios(listaUsuarios.filtrarPorLegajo(legajo));
        List<Usuario> usuarios = filtrados.obtenerTodos();
        actualizarTablaFiltrada(usuarios);
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
        jPanelOpcionesTexto = new javax.swing.JPanel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldDNI = new javax.swing.JTextField();
        ((AbstractDocument) jTextFieldDNI.getDocument()).setDocumentFilter(new FiltroNumerico());
        jTextFieldLegajo = new javax.swing.JTextField();
        ((AbstractDocument) jTextFieldLegajo.getDocument()).setDocumentFilter(new FiltroNumerico());
        jComboBoxFiltro = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();

        jPanelOpcionesTexto.setLayout(new java.awt.CardLayout());

        jTextFieldNombre.setMargin(new java.awt.Insets(0, 0, 1, 0));
        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });
        jTextFieldNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNombreKeyTyped(evt);
            }
        });
        jPanelOpcionesTexto.add(jTextFieldNombre, "Nombre");

        jTextFieldDNI.setText("DNI");
        jTextFieldDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDNIActionPerformed(evt);
            }
        });
        jTextFieldDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDNIKeyTyped(evt);
            }
        });
        jPanelOpcionesTexto.add(jTextFieldDNI, "D.N.I");

        jTextFieldLegajo.setText("Legajo");
        jTextFieldLegajo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldLegajoKeyTyped(evt);
            }
        });
        jPanelOpcionesTexto.add(jTextFieldLegajo, "Legajo");

        jComboBoxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "D.N.I", "Legajo" }));
        jComboBoxFiltro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxFiltroItemStateChanged(evt);
            }
        });

        jLabel1.setText("Filtrar por: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelOpcionesTexto, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addGap(318, 318, 318))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanelOpcionesTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(15, 15, 15))
        );

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Tipo", "D.N.I", "Legajo", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        // Aplica el renderer a todas las columnas
        for (int i = 0; i < tablaUsuarios.getColumnModel().getColumnCount(); i++) {
            tablaUsuarios.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        tablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaUsuarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    private void jTextFieldDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDNIActionPerformed

    private void jComboBoxFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxFiltroItemStateChanged
        cambiarEntry(jComboBoxFiltro.getSelectedItem().toString());
        reiniciarLista();
    }//GEN-LAST:event_jComboBoxFiltroItemStateChanged

    private void jTextFieldNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombreKeyTyped
        SwingUtilities.invokeLater(() -> buscarPorNombre());
    }//GEN-LAST:event_jTextFieldNombreKeyTyped

    private void jTextFieldDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDNIKeyTyped
        SwingUtilities.invokeLater(() -> buscarPorDni());
    }//GEN-LAST:event_jTextFieldDNIKeyTyped

    private void jTextFieldLegajoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldLegajoKeyTyped
        SwingUtilities.invokeLater(() -> buscarPorLegajo());
    }//GEN-LAST:event_jTextFieldLegajoKeyTyped

    private void tablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuariosMouseClicked
        Usuario usuario = filtrados.buscarPorIndice(tablaUsuarios.getSelectedRow());
        System.out.println(usuario);
    }//GEN-LAST:event_tablaUsuariosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBoxFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelOpcionesTexto;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldDNI;
    private javax.swing.JTextField jTextFieldLegajo;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTable tablaUsuarios;
    // End of variables declaration//GEN-END:variables
}
