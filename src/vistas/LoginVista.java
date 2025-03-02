/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Clases.FiltroAlfanumerico;
import Clases.FiltroNumerico;
import controladores.LoginControlador;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author TuKK
 */
public class LoginVista extends javax.swing.JFrame {

    private LoginControlador controlador;

    /**
     * Creates new form LoginVista
     */
    public LoginVista() {
        controlador = new LoginControlador(this);
        initComponents();
        setTitle("Sistema Ticket");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public String getDNI() {
        return jTextFieldDNI.getText();
    }

    public void setDNI(String dni) {
        ((AbstractDocument) jTextFieldDNI.getDocument()).setDocumentFilter(null);
        jTextFieldDNI.setText(dni);
        ((AbstractDocument) jTextFieldDNI.getDocument()).setDocumentFilter(new FiltroNumerico());
    }

    public char[] getPass() {
        return jPasswordField.getPassword();
    }

    public void setPass(String pass) {
        jPasswordField.setText(pass);
    }

    public void mostrarMensaje(String mensaje, String titulo, int tipoMensaje) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, tipoMensaje);
    }

    public void setRespuesta(String res) {
        jLabelRespuesta.setText(res);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelDNI = new javax.swing.JLabel();
        jLabelPass = new javax.swing.JLabel();
        jButtonConectarse = new javax.swing.JButton();
        jTextFieldDNI = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jLabelLogo = new javax.swing.JLabel();
        jLabelEyeOpen = new javax.swing.JLabel();
        jLabelEyeHide = new javax.swing.JLabel();
        jButtonSalir = new javax.swing.JButton();
        jLabelRespuesta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabelDNI.setText("Ingresar D.N.I.");

        jLabelPass.setText("Ingresar contraseña");

        jButtonConectarse.setText("Conectarse");
        jButtonConectarse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonConectarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConectarseActionPerformed(evt);
            }
        });

        ((AbstractDocument) jTextFieldDNI.getDocument()).setDocumentFilter(new FiltroNumerico()); //Ingreso el filtro Alfanumerico
        jTextFieldDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDNIActionPerformed(evt);
            }
        });

        ((AbstractDocument) jPasswordField.getDocument()).setDocumentFilter(new FiltroAlfanumerico(60)); //Inicio el filtro Alfanumerico para la contraseña

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logo.png"))); // NOI18N

        jLabelEyeOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eye-open.png"))); // NOI18N
        jLabelEyeOpen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelEyeOpen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEyeOpenMouseClicked(evt);
            }
        });

        jLabelEyeHide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eye-hide.png"))); // NOI18N
        jLabelEyeHide.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelEyeHide.setVisible(false);
        jLabelEyeHide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEyeHideMouseClicked(evt);
            }
        });

        jButtonSalir.setText("Salir");
        jButtonSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonSalirMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButtonSalirMouseReleased(evt);
            }
        });
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPass)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelDNI)
                                .addComponent(jTextFieldDNI, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabelLogo)
                                    .addGap(72, 72, 72))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelEyeHide)
                            .addComponent(jLabelEyeOpen))))
                .addContainerGap(87, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonConectarse, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(189, 189, 189))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jButtonSalir)
                        .addGap(37, 37, 37))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabelEyeHide, jLabelEyeOpen});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jLabelLogo)
                .addGap(18, 18, 18)
                .addComponent(jLabelDNI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPasswordField)
                    .addComponent(jLabelEyeOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelEyeHide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addComponent(jButtonConectarse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelRespuesta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonSalir))
                .addGap(11, 11, 11))
        );

        jButtonSalir.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDNIActionPerformed

    private void jButtonConectarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConectarseActionPerformed
        controlador.conectarUsuario();
    }//GEN-LAST:event_jButtonConectarseActionPerformed

    private void jLabelEyeOpenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEyeOpenMouseClicked
        //Oculto ojo abierto
        jLabelEyeOpen.setVisible(false);
        //Muestro ojo cerrado
        jLabelEyeHide.setVisible(true);
        //Muestro contraseña
        jPasswordField.setEchoChar((char) 0);
    }//GEN-LAST:event_jLabelEyeOpenMouseClicked

    private void jLabelEyeHideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEyeHideMouseClicked
        //Oculto ojo cerrado
        jLabelEyeHide.setVisible(false);
        //Muestro ojo abierto
        jLabelEyeOpen.setVisible(true);
        //Oculto contraseña
        jPasswordField.setEchoChar('•');
    }//GEN-LAST:event_jLabelEyeHideMouseClicked

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        int resultado = JOptionPane.showConfirmDialog(this, "¿Esta seguro de querer salir?", "Salir", JOptionPane.YES_NO_OPTION);
        // Selecciono Si
        if (resultado == 0) {
            System.exit(0);
        }

    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonSalirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSalirMousePressed
        jButtonSalir.setForeground(Color.RED);
    }//GEN-LAST:event_jButtonSalirMousePressed

    private void jButtonSalirMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSalirMouseReleased
        jButtonSalir.setForeground(Color.BLACK);
    }//GEN-LAST:event_jButtonSalirMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConectarse;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabelDNI;
    private javax.swing.JLabel jLabelEyeHide;
    private javax.swing.JLabel jLabelEyeOpen;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelPass;
    private javax.swing.JLabel jLabelRespuesta;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextFieldDNI;
    // End of variables declaration//GEN-END:variables
}
