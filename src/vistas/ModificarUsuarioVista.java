/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Clases.Tecnico;
import Clases.Usuario;
import controladores.ModificarUsuarioControlador;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author TuKK
 */
public class ModificarUsuarioVista extends JDialog {

    private Usuario usuarioSelecionado;
    private ModificarUsuarioControlador controlador;
    private ListaUsuariosVista listaUsuariosVista; //Para actualizar la lista

    /**
     * Creates new form ModificarUsuario
     */
    public ModificarUsuarioVista(JFrame parent, Usuario usuarioSelecionado, ListaUsuariosVista listaUsuariosVista) {
        super(parent, "Modificar Usuario", true);
        this.usuarioSelecionado = usuarioSelecionado;
        this.controlador = new ModificarUsuarioControlador(this);
        this.listaUsuariosVista = listaUsuariosVista;
        initComponents();
        cargarTextosYVistas();
        iniciarBotones();
    }

    public void cargarTextosYVistas() {
        // Carga los textos con datos del Usuario
        jTextFieldNombre.setText(usuarioSelecionado.getNombre());
        jTextFieldDNI.setText(usuarioSelecionado.getDNI());
        jTextFieldLegajo.setText(usuarioSelecionado.getLegajo() + "");
        jTextFieldEstado.setText(usuarioSelecionado.getEstado());

        //Si es tecnico Muestra el jPanelDatosTecnicos y carga datos del mismo en los textos
        if (usuarioSelecionado instanceof Tecnico) {
            Tecnico tecnico = (Tecnico) usuarioSelecionado; // Hago el cast a Tecnico para usar metodos
            jPanelDatosTecnicos.setVisible(true);
            jTextFieldMarcas.setText(tecnico.getMarcas() + "");
            jTextFieldFallas.setText(tecnico.getFallas() + "");
        }
    }

    public void mostrarMensaje(String mensaje, String titulo, int tipoMensaje) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, tipoMensaje);
    }

    private void cambiarBoton(String boton) {
        //Cambia al boton recibido por parametro
        CardLayout cl = (CardLayout) jPanelBotones.getLayout();
        cl.show(jPanelBotones, boton);
        jPanelBotones.revalidate();
        jPanelBotones.repaint();
    }

    private void iniciarBotones() {
        //Inicia el boton inicial, si es activo se elige el boton Bloquear o viceversa
        if (usuarioSelecionado.getEstado().equals("activo")) {
            cambiarBoton("jButtonBloquearUsuario");
        } else {
            cambiarBoton("jButtonDesbloquearUsuario");
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

        jPanelContenido = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDNI = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldLegajo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldEstado = new javax.swing.JTextField();
        jPanelDatosTecnicos = new javax.swing.JPanel();
        jPanelDatosTecnicos.setVisible(false);
        jLabel5 = new javax.swing.JLabel();
        jTextFieldMarcas = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldFallas = new javax.swing.JTextField();
        jButtonReiniciarUsuario = new javax.swing.JButton();
        jPanelBotones = new javax.swing.JPanel();
        jButtonBloquearUsuario = new javax.swing.JButton();
        jButtonDesbloquearUsuario = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Nombre");
        jLabel1.setToolTipText("");
        jLabel1.setAlignmentX(Component.LEFT_ALIGNMENT);
        jLabel1.setMaximumSize(new java.awt.Dimension(46, 26));

        jTextFieldNombre.setEnabled(false);
        jTextFieldNombre.setMaximumSize(new java.awt.Dimension(400, 2147483647));
        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("D.N.I");

        jTextFieldDNI.setEnabled(false);
        jTextFieldDNI.setMaximumSize(new java.awt.Dimension(400, 2147483647));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Legajo");

        jTextFieldLegajo.setEnabled(false);
        jTextFieldLegajo.setMaximumSize(new java.awt.Dimension(400, 2147483647));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Estado");

        jTextFieldEstado.setEnabled(false);
        jTextFieldEstado.setMaximumSize(new java.awt.Dimension(400, 2147483647));

        jPanelDatosTecnicos.setMaximumSize(new java.awt.Dimension(200, 32767));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Marcas");

        jTextFieldMarcas.setEnabled(false);
        jTextFieldMarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMarcasActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Fallas");

        jTextFieldFallas.setEnabled(false);
        jTextFieldFallas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFallasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDatosTecnicosLayout = new javax.swing.GroupLayout(jPanelDatosTecnicos);
        jPanelDatosTecnicos.setLayout(jPanelDatosTecnicosLayout);
        jPanelDatosTecnicosLayout.setHorizontalGroup(
            jPanelDatosTecnicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosTecnicosLayout.createSequentialGroup()
                .addGroup(jPanelDatosTecnicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatosTecnicosLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jTextFieldFallas, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDatosTecnicosLayout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanelDatosTecnicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDatosTecnicosLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(137, 137, 137))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDatosTecnicosLayout.createSequentialGroup()
                        .addComponent(jTextFieldMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        jPanelDatosTecnicosLayout.setVerticalGroup(
            jPanelDatosTecnicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosTecnicosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanelDatosTecnicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelDatosTecnicosLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDatosTecnicosLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldFallas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelContenidoLayout = new javax.swing.GroupLayout(jPanelContenido);
        jPanelContenido.setLayout(jPanelContenidoLayout);
        jPanelContenidoLayout.setHorizontalGroup(
            jPanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelDatosTecnicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelContenidoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(20, 20, 20))
        );
        jPanelContenidoLayout.setVerticalGroup(
            jPanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContenidoLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jPanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContenidoLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContenidoLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContenidoLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContenidoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelDatosTecnicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        getContentPane().add(jPanelContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        jButtonReiniciarUsuario.setText("Reiniciar Usuario");
        jButtonReiniciarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReiniciarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonReiniciarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 421, -1, 30));

        jPanelBotones.setLayout(new java.awt.CardLayout());

        jButtonBloquearUsuario.setText("Bloquear Usuario");
        jButtonBloquearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBloquearUsuarioActionPerformed(evt);
            }
        });
        jPanelBotones.add(jButtonBloquearUsuario, "jButtonBloquearUsuario");

        jButtonDesbloquearUsuario.setText("Desbloquear usuario");
        jButtonDesbloquearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDesbloquearUsuarioActionPerformed(evt);
            }
        });
        jPanelBotones.add(jButtonDesbloquearUsuario, "jButtonDesbloquearUsuario");

        getContentPane().add(jPanelBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 420, 150, 30));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Datos de usuario");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMarcasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMarcasActionPerformed

    private void jButtonReiniciarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReiniciarUsuarioActionPerformed
        // Formatea el texto para mostrar el Nombre del Usuario
        String mensaje = String.format("¿Estás seguro de querer reiniciar al usuario %s?\nEsto va a reestablecer su contraseña", usuarioSelecionado.getNombre());
        int resultado = JOptionPane.showConfirmDialog(this, mensaje, "Reiniciar Usuario", JOptionPane.OK_CANCEL_OPTION);
        if (resultado == 0) {
            controlador.reiniciarContrasenia(usuarioSelecionado);
        }
    }//GEN-LAST:event_jButtonReiniciarUsuarioActionPerformed

    private void jButtonBloquearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBloquearUsuarioActionPerformed
        String mensaje = String.format("¿Estás seguro de querer bloquear al usuario %s?\nEsto va a evitar que la cuenta se pueda utilizar.", usuarioSelecionado.getNombre());
        int resultado = JOptionPane.showConfirmDialog(this, mensaje, "Bloquear Usuario", JOptionPane.OK_CANCEL_OPTION);
        if (resultado == 0) {
            try {
                controlador.cambiarEstado(usuarioSelecionado, "bloqueado");
                cambiarBoton("jButtonDesbloquearUsuario");
                // Si es Tecnico se reinician las fallas y marcas VISUALMENTE
                if (usuarioSelecionado instanceof Tecnico) {
                    jTextFieldMarcas.setText("0");
                    jTextFieldFallas.setText("0");
                }
                
                listaUsuariosVista.cargarUsuarios();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButtonBloquearUsuarioActionPerformed

    private void jButtonDesbloquearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDesbloquearUsuarioActionPerformed
        String mensaje = String.format("¿Estás seguro de querer desbloquear al usuario %s?\nEsto va a permitir que la cuenta se pueda utilizar nuevamente.", usuarioSelecionado.getNombre());
        int resultado = JOptionPane.showConfirmDialog(this, mensaje, "Desbloquear Usuario", JOptionPane.OK_CANCEL_OPTION);
        if (resultado == 0) {
            try {
                controlador.cambiarEstado(usuarioSelecionado, "activo");
                cambiarBoton("jButtonBloquearUsuario");
                // Si es Tecnico se reinician las fallas y marcas VISUALMENTE
                if (usuarioSelecionado instanceof Tecnico) {
                    jTextFieldMarcas.setText("0");
                    jTextFieldFallas.setText("0");
                }
                
                listaUsuariosVista.cargarUsuarios();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButtonDesbloquearUsuarioActionPerformed

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    private void jTextFieldFallasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFallasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFallasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBloquearUsuario;
    private javax.swing.JButton jButtonDesbloquearUsuario;
    private javax.swing.JButton jButtonReiniciarUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JPanel jPanelContenido;
    private javax.swing.JPanel jPanelDatosTecnicos;
    private javax.swing.JTextField jTextFieldDNI;
    private javax.swing.JTextField jTextFieldEstado;
    private javax.swing.JTextField jTextFieldFallas;
    private javax.swing.JTextField jTextFieldLegajo;
    private javax.swing.JTextField jTextFieldMarcas;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}
