/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Clases.Usuario;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author ramir
 */
public class TecnicoVista extends JFrame {

    private Usuario usuarioActual;
    private final Color colorAzul = new Color(75, 55, 255);
    
    /**
     * Creates new form TecnicoVista
     */
    public TecnicoVista() {
        initComponents();
        setTitle("Sistema de Tickets");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
    public TecnicoVista(Usuario usuario){
        usuarioActual = usuario;
        initComponents();
        setTitle("Sistema de Tickets");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelNavegador = new javax.swing.JPanel();
        jLabelInicio = new javax.swing.JLabel();
        jLabelPerfil = new javax.swing.JLabel();
        jPanelPerfilOpciones = new javax.swing.JPanel();
        jLabelModificarPerfil = new javax.swing.JLabel();
        jLabelCerrarSesión = new javax.swing.JLabel();
        jLabelTickets = new javax.swing.JLabel();
        jPanelTicketOpciones = new javax.swing.JPanel();
        jLabelTicketsAsignados = new javax.swing.JLabel();
        jLabelBuscarTickets = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelNavegador.setBackground(new java.awt.Color(220, 220, 220));
        jPanelNavegador.setMaximumSize(new java.awt.Dimension(97, 192));
        jPanelNavegador.setMinimumSize(new java.awt.Dimension(97, 192));
        jPanelNavegador.setPreferredSize(new java.awt.Dimension(97, 192));
        jPanelNavegador.setLayout(new javax.swing.BoxLayout(jPanelNavegador, javax.swing.BoxLayout.Y_AXIS));

        jLabelInicio.setText("Inicio");
        jLabelInicio.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 2, 5));
        jLabelInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelInicio.setMaximumSize(new java.awt.Dimension(40, 21));
        jLabelInicio.setMinimumSize(new java.awt.Dimension(40, 121));
        jLabelInicio.setPreferredSize(new java.awt.Dimension(40, 21));
        jLabelInicio.setForeground(colorAzul);
        jLabelInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelInicioMouseClicked(evt);
            }
        });
        jPanelNavegador.add(jLabelInicio);

        jLabelPerfil.setText("Perfil");
        jLabelPerfil.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 2, 5));
        jLabelPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPerfilMouseClicked(evt);
            }
        });
        jPanelNavegador.add(jLabelPerfil);

        jPanelPerfilOpciones.setBackground(new java.awt.Color(220, 220, 220));
        jPanelPerfilOpciones.setPreferredSize(new java.awt.Dimension(120, 120));
        jPanelPerfilOpciones.setLayout(new javax.swing.BoxLayout(jPanelPerfilOpciones, javax.swing.BoxLayout.Y_AXIS));

        jLabelModificarPerfil.setText("Modificar Perfil");
        jLabelModificarPerfil.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 15, 1, 1));
        jLabelModificarPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelModificarPerfilMouseClicked(evt);
            }
        });
        jPanelPerfilOpciones.add(jLabelModificarPerfil);

        jLabelCerrarSesión.setText("Cerrar Sesión");
        jLabelCerrarSesión.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 15, 1, 1));
        jLabelCerrarSesión.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCerrarSesiónMouseClicked(evt);
            }
        });
        jPanelPerfilOpciones.add(jLabelCerrarSesión);

        jPanelNavegador.add(jPanelPerfilOpciones);

        jLabelTickets.setText("Tickets");
        jLabelTickets.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 2, 5));
        jLabelTickets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelTicketsMouseClicked(evt);
            }
        });
        jPanelNavegador.add(jLabelTickets);

        jPanelTicketOpciones.setBackground(new java.awt.Color(220, 220, 220));
        jPanelTicketOpciones.setLayout(new javax.swing.BoxLayout(jPanelTicketOpciones, javax.swing.BoxLayout.Y_AXIS));

        jLabelTicketsAsignados.setText("Asignados a mí");
        jLabelTicketsAsignados.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 15, 1, 1));
        jLabelTicketsAsignados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelTicketsAsignadosMouseClicked(evt);
            }
        });
        jPanelTicketOpciones.add(jLabelTicketsAsignados);

        jLabelBuscarTickets.setText("Buscar Tickets");
        jLabelBuscarTickets.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 15, 1, 1));
        jLabelBuscarTickets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBuscarTicketsMouseClicked(evt);
            }
        });
        jPanelTicketOpciones.add(jLabelBuscarTickets);

        jPanelNavegador.add(jPanelTicketOpciones);

        getContentPane().add(jPanelNavegador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelInicioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelInicioMouseClicked

    private void jLabelPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPerfilMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelPerfilMouseClicked

    private void jLabelTicketsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTicketsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelTicketsMouseClicked

    private void jLabelModificarPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelModificarPerfilMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelModificarPerfilMouseClicked

    private void jLabelTicketsAsignadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTicketsAsignadosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelTicketsAsignadosMouseClicked

    private void jLabelBuscarTicketsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBuscarTicketsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelBuscarTicketsMouseClicked

    private void jLabelCerrarSesiónMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCerrarSesiónMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelCerrarSesiónMouseClicked

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
            java.util.logging.Logger.getLogger(TecnicoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TecnicoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TecnicoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TecnicoVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TecnicoVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelBuscarTickets;
    private javax.swing.JLabel jLabelCerrarSesión;
    private javax.swing.JLabel jLabelInicio;
    private javax.swing.JLabel jLabelModificarPerfil;
    private javax.swing.JLabel jLabelPerfil;
    private javax.swing.JLabel jLabelTickets;
    private javax.swing.JLabel jLabelTicketsAsignados;
    private javax.swing.JPanel jPanelNavegador;
    private javax.swing.JPanel jPanelPerfilOpciones;
    private javax.swing.JPanel jPanelTicketOpciones;
    // End of variables declaration//GEN-END:variables
}
