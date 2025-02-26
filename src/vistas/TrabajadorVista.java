/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Clases.Trabajador;
import Clases.Usuario;
import controladores.TicketControlador;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import interfaces.InterCambioContrasenia;

/**
 *
 * @author TuKK
 */
public class TrabajadorVista extends javax.swing.JFrame implements InterCambioContrasenia{

    private boolean dropdownTicketVisible = false;
    private boolean dropdownPerfilVisible = false;
    private TicketControlador controlador;
    private final Usuario usuarioActual;
    private final Color colorAzul = new Color(75, 55, 255);
    private boolean contraseniaIgualDni;

    /**
     * Creates new form TrabajadorVista
     */
    public TrabajadorVista() {
        usuarioActual =  new Trabajador("Nicolas González", "543423456", 101, "1234", "activo"); // Usuario Demo
        initComponents();
    }

    public TrabajadorVista(Usuario usuario) {
        this.usuarioActual = usuario;
        this.controlador = new TicketControlador(usuario);
        initComponents();
        setTitle("Sistema de Tickets");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        forzarCambioContrasenia(usuarioActual.contraseniaIgualDni());
    }

    @Override
    public void forzarCambioContrasenia(boolean contraseniaIgualDni) {

        if (contraseniaIgualDni) {
            jLabelPerfilMouseClicked(null);
            jLabelModificarPerfilMouseClicked(null);
            this.contraseniaIgualDni = contraseniaIgualDni;
            setHabilitarLabels(false);
        } else {
            this.contraseniaIgualDni = contraseniaIgualDni;
            setHabilitarLabels(true);
        }
    }

    private void setHabilitarLabels(boolean habilitar) {
        JLabel[] labels = {
            jLabelInicio, jLabelPerfil, jLabelModificarPerfil, jLabelCerrarSesion,
            jLabelMisTickets, jLabelCrearTicket,
            jLabelVerMisTickets
        };

        for (JLabel label : labels) {
            label.setEnabled(habilitar);
            label.setCursor(habilitar ? Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)
                    : Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }

    private void cambiarVista(String vista, JLabel labelSeleccionado) {
        CardLayout cl = (CardLayout) jPanelContenido.getLayout();
        cl.show(jPanelContenido, vista);

        // Restablecer el color de todos los labels
        jLabelInicio.setForeground(Color.BLACK);
        jLabelPerfil.setForeground(Color.BLACK);
        jLabelModificarPerfil.setForeground(Color.BLACK);
        jLabelCerrarSesion.setForeground(Color.BLACK);
        jLabelMisTickets.setForeground(Color.BLACK);
        jLabelCrearTicket.setForeground(Color.BLACK);
        jLabelVerMisTickets.setForeground(Color.BLACK);

        // Resaltar el label seleccionado
        labelSeleccionado.setForeground(colorAzul);

        // Si la selección está en las opciones de Tickets, cambiar color de Tickets
        if (labelSeleccionado == jLabelCrearTicket || labelSeleccionado == jLabelVerMisTickets) {
            jLabelMisTickets.setForeground(colorAzul);
        }

        // Si la selección está en las opciones de Perfil, cambiar color de Perfil
        if (labelSeleccionado == jLabelModificarPerfil || labelSeleccionado == jLabelCerrarSesion) {
            jLabelPerfil.setForeground(colorAzul);
        }
    }

    private void abrirMenu(JPanel panelSeleccionado) {
        if (panelSeleccionado == jPanelTicketOpciones) {
            dropdownTicketVisible = true;
        }

        if (panelSeleccionado == jPanelPerfilOpciones) {
            dropdownPerfilVisible = true;
        }

        panelSeleccionado.setVisible(true);
        panelSeleccionado.setSize(panelSeleccionado.getWidth(), 0); // Inicia desde 0
        Timer timer = new Timer(10, new ActionListener() {
            int height = 0;
            int maxHeight = 40; // Tamaño del menu

            @Override
            public void actionPerformed(ActionEvent e) {
                if (height < maxHeight) {
                    height += 5; //  Velocidad de animacion
                    panelSeleccionado.setSize(panelSeleccionado.getWidth(), height);
                    panelSeleccionado.repaint();
                } else {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.start();
    }

    private void cerrarMenu(JPanel panelSeleccionado) {
        if (panelSeleccionado == jPanelTicketOpciones) {
            dropdownTicketVisible = false;
        }

        if (panelSeleccionado == jPanelPerfilOpciones) {
            dropdownPerfilVisible = false;
        }
        Timer timer = new Timer(10, new ActionListener() {
            int height = panelSeleccionado.getHeight();

            @Override
            public void actionPerformed(ActionEvent e) {
                if (height > 0) {
                    height -= 5; // Velocidad de animacion
                    panelSeleccionado.setSize(panelSeleccionado.getWidth(), height);
                    panelSeleccionado.repaint();
                } else {
                    panelSeleccionado.setVisible(false); // Ocultar después de la animación
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.start();
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
        jPanelPerfilOpciones.setVisible(false);
        jLabelModificarPerfil = new javax.swing.JLabel();
        jLabelCerrarSesion = new javax.swing.JLabel();
        jLabelMisTickets = new javax.swing.JLabel();
        jPanelTicketOpciones = new javax.swing.JPanel();
        jPanelTicketOpciones.setVisible(false);
        jLabelCrearTicket = new javax.swing.JLabel();
        jLabelVerMisTickets = new javax.swing.JLabel();
        jPanelContenido = new javax.swing.JPanel();
        inicioAdminVista = new vistas.InicioAdminVista(usuarioActual.getNombre());
        cambioContraseniaVista = new CambioContraseniaVista(usuarioActual.getDNI(),usuarioActual.getContrasena(),this);
        panelTickets = new PanelTickets(usuarioActual);
        ;
        generarTicket = new GenerarTicket(controlador);
        ;

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelNavegador.setBackground(new java.awt.Color(220, 220, 220));
        jPanelNavegador.setLayout(new javax.swing.BoxLayout(jPanelNavegador, javax.swing.BoxLayout.Y_AXIS));

        jLabelInicio.setText("Inicio");
        jLabelInicio.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 2, 5));
        jLabelInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelInicio.setForeground(colorAzul);
        jLabelInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelInicioMouseClicked(evt);
            }
        });
        jPanelNavegador.add(jLabelInicio);

        jLabelPerfil.setText("Perfil");
        jLabelPerfil.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 2, 5));
        jLabelPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPerfilMouseClicked(evt);
            }
        });
        jPanelNavegador.add(jLabelPerfil);

        jPanelPerfilOpciones.setBackground(new java.awt.Color(220, 220, 220));
        jPanelPerfilOpciones.setLayout(new javax.swing.BoxLayout(jPanelPerfilOpciones, javax.swing.BoxLayout.Y_AXIS));

        jLabelModificarPerfil.setText("Modificar perfil");
        jLabelModificarPerfil.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 15, 1, 1));
        jLabelModificarPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelModificarPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelModificarPerfilMouseClicked(evt);
            }
        });
        jPanelPerfilOpciones.add(jLabelModificarPerfil);

        jLabelCerrarSesion.setText("Cerrar sesion");
        jLabelCerrarSesion.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 15, 1, 1));
        jLabelCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCerrarSesionMouseClicked(evt);
            }
        });
        jPanelPerfilOpciones.add(jLabelCerrarSesion);

        jPanelNavegador.add(jPanelPerfilOpciones);

        jLabelMisTickets.setText("Mis Tickets");
        jLabelMisTickets.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 2, 5));
        jLabelMisTickets.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMisTickets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMisTicketsMouseClicked(evt);
            }
        });
        jPanelNavegador.add(jLabelMisTickets);

        jPanelTicketOpciones.setBackground(new java.awt.Color(220, 220, 220));
        jPanelTicketOpciones.setLayout(new javax.swing.BoxLayout(jPanelTicketOpciones, javax.swing.BoxLayout.Y_AXIS));

        jLabelCrearTicket.setText("Crear Ticket");
        jLabelCrearTicket.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 15, 1, 1));
        jLabelCrearTicket.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelCrearTicket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCrearTicketMouseClicked(evt);
            }
        });
        jPanelTicketOpciones.add(jLabelCrearTicket);

        jLabelVerMisTickets.setText("Mis Tickets");
        jLabelVerMisTickets.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 15, 1, 1));
        jLabelVerMisTickets.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelVerMisTickets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelVerMisTicketsMouseClicked(evt);
            }
        });
        jPanelTicketOpciones.add(jLabelVerMisTickets);

        jPanelNavegador.add(jPanelTicketOpciones);

        getContentPane().add(jPanelNavegador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 500));

        jPanelContenido.setLayout(new java.awt.CardLayout());
        jPanelContenido.add(inicioAdminVista, "inicioAdminVista");
        jPanelContenido.add(cambioContraseniaVista, "cambioContraseniaVista");
        jPanelContenido.add(panelTickets, "panelTickets");
        jPanelContenido.add(generarTicket, "generarTicket");

        getContentPane().add(jPanelContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 680, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelInicioMouseClicked
        if (contraseniaIgualDni) {
            return;
        }
        cambiarVista("inicioAdminVista", jLabelInicio);
    }//GEN-LAST:event_jLabelInicioMouseClicked

    private void jLabelPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPerfilMouseClicked
        if (contraseniaIgualDni) {
            return;
        }
        if (dropdownPerfilVisible) {
            cerrarMenu(jPanelPerfilOpciones);
        } else {
            abrirMenu(jPanelPerfilOpciones);
        }
        cambiarVista("", jLabelPerfil);
    }//GEN-LAST:event_jLabelPerfilMouseClicked

    private void jLabelModificarPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelModificarPerfilMouseClicked
        if (contraseniaIgualDni) {
            return;
        }
        cambiarVista("cambioContraseniaVista", jLabelModificarPerfil);
    }//GEN-LAST:event_jLabelModificarPerfilMouseClicked

    private void jLabelCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCerrarSesionMouseClicked
        if (contraseniaIgualDni) {
            return;
        }
        cambiarVista("", jLabelCerrarSesion);
        int resultado = JOptionPane.showConfirmDialog(this, "¿Estas seguro de querer salir?", "Salir", JOptionPane.OK_CANCEL_OPTION);
        if (resultado == 0) {
            new LoginVista();
            this.dispose();
        }
    }//GEN-LAST:event_jLabelCerrarSesionMouseClicked

    private void jLabelMisTicketsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMisTicketsMouseClicked
        if (contraseniaIgualDni) {
            return;
        }
        if (dropdownTicketVisible) {
            cerrarMenu(jPanelTicketOpciones);
        } else {
            abrirMenu(jPanelTicketOpciones);
        }
        cambiarVista("", jLabelMisTickets);
    }//GEN-LAST:event_jLabelMisTicketsMouseClicked

    private void jLabelCrearTicketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCrearTicketMouseClicked
        if (contraseniaIgualDni) {
            return;
        }
        cambiarVista("generarTicket", jLabelCrearTicket);
    }//GEN-LAST:event_jLabelCrearTicketMouseClicked

    private void jLabelVerMisTicketsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVerMisTicketsMouseClicked
         if (contraseniaIgualDni) {
            return;
        }
         
        panelTickets.cargarTickets();
        cambiarVista("panelTickets", jLabelVerMisTickets);
    }//GEN-LAST:event_jLabelVerMisTicketsMouseClicked

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
            java.util.logging.Logger.getLogger(TrabajadorVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrabajadorVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrabajadorVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrabajadorVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrabajadorVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private vistas.CambioContraseniaVista cambioContraseniaVista;
    private vistas.GenerarTicket generarTicket;
    private vistas.InicioAdminVista inicioAdminVista;
    private javax.swing.JLabel jLabelCerrarSesion;
    private javax.swing.JLabel jLabelCrearTicket;
    private javax.swing.JLabel jLabelInicio;
    private javax.swing.JLabel jLabelMisTickets;
    private javax.swing.JLabel jLabelModificarPerfil;
    private javax.swing.JLabel jLabelPerfil;
    private javax.swing.JLabel jLabelVerMisTickets;
    private javax.swing.JPanel jPanelContenido;
    private javax.swing.JPanel jPanelNavegador;
    private javax.swing.JPanel jPanelPerfilOpciones;
    private javax.swing.JPanel jPanelTicketOpciones;
    private vistas.PanelTickets panelTickets;
    // End of variables declaration//GEN-END:variables
}
