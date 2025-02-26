/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Clases.Administrador;
import Clases.Usuario;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author TuKK
 */
public class AdminVista extends javax.swing.JFrame {

    private boolean dropdownTicketVisible = false;
    private boolean dropdownUsuarioVisible = false;
    private boolean dropdownPerfilVisible = false;
    private final Usuario usuarioActual;
    private final Color colorAzul = new Color(75, 55, 255);
    private boolean contraseniaIgualDni;

    /**
     * Creates new form AdminVista
     */
    public AdminVista() {
        this.usuarioActual = new Administrador("Nicolas González", "543423456", 101, "1234", "activo"); // Usuario Demo
        initComponents();
        setTitle("Sistema de Tickets");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }

    public AdminVista(Usuario usuario) {
        this.usuarioActual = usuario;
        initComponents();
        setTitle("Sistema de Tickets");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        forzarCambioContrasenia(usuarioActual.contraseniaIgualDni());
    }

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
            jLabelUsuario, jLabelCrearUsuario, jLabelListaUsuarios, jLabelTicket,
            jLabelListaTickets
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
        jLabelUsuario.setForeground(Color.BLACK);
        jLabelCrearUsuario.setForeground(Color.BLACK);
        jLabelListaUsuarios.setForeground(Color.BLACK);
        jLabelTicket.setForeground(Color.BLACK);
        jLabelListaTickets.setForeground(Color.BLACK);

        // Resaltar el label seleccionado
        labelSeleccionado.setForeground(colorAzul);

        // Si la selección está en las opciones de Tickets, cambiar color de Tickets
        if (labelSeleccionado == jLabelListaTickets) {
            jLabelTicket.setForeground(colorAzul);
        }

        // Si la selección está en las opciones de Usuarios, cambiar color de Usuarios
        if (labelSeleccionado == jLabelCrearUsuario || labelSeleccionado == jLabelListaUsuarios) {
            jLabelUsuario.setForeground(colorAzul);
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
        if (panelSeleccionado == jPanelUsuarioOpciones) {
            dropdownUsuarioVisible = true;
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
        if (panelSeleccionado == jPanelUsuarioOpciones) {
            dropdownUsuarioVisible = false;
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
        jLabelUsuario = new javax.swing.JLabel();
        jPanelUsuarioOpciones = new javax.swing.JPanel();
        jPanelUsuarioOpciones.setVisible(false);
        jLabelCrearUsuario = new javax.swing.JLabel();
        jLabelListaUsuarios = new javax.swing.JLabel();
        jLabelTicket = new javax.swing.JLabel();
        jPanelTicketOpciones = new javax.swing.JPanel();
        jPanelTicketOpciones.setVisible(false);
        jLabelListaTickets = new javax.swing.JLabel();
        jPanelContenido = new javax.swing.JPanel();
        inicioAdminVista = new vistas.InicioAdminVista(usuarioActual.getNombre());
        registroVista = new vistas.RegistroVista();
        registroVista.setVisible(false);
        listaUsuariosVista = new vistas.ListaUsuariosVista(usuarioActual);
        cambioContraseniaVista = new CambioContraseniaVista(usuarioActual.getDNI(),usuarioActual.getContrasena(),this);
        panelTickets = new PanelTickets(usuarioActual);
        ;

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
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

        jLabelUsuario.setText("Usuarios");
        jLabelUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 2, 5));
        jLabelUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelUsuarioMouseClicked(evt);
            }
        });
        jPanelNavegador.add(jLabelUsuario);

        jPanelUsuarioOpciones.setBackground(new java.awt.Color(220, 220, 220));
        jPanelUsuarioOpciones.setLayout(new javax.swing.BoxLayout(jPanelUsuarioOpciones, javax.swing.BoxLayout.Y_AXIS));

        jLabelCrearUsuario.setText("Crear usuario");
        jLabelCrearUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 15, 1, 1));
        jLabelCrearUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelCrearUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCrearUsuarioMouseClicked(evt);
            }
        });
        jPanelUsuarioOpciones.add(jLabelCrearUsuario);

        jLabelListaUsuarios.setText("Lista de Usuarios");
        jLabelListaUsuarios.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 15, 1, 1));
        jLabelListaUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelListaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelListaUsuariosMouseClicked(evt);
            }
        });
        jPanelUsuarioOpciones.add(jLabelListaUsuarios);

        jPanelNavegador.add(jPanelUsuarioOpciones);

        jLabelTicket.setText("Tickets");
        jLabelTicket.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 2, 5));
        jLabelTicket.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelTicket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelTicketMouseClicked(evt);
            }
        });
        jPanelNavegador.add(jLabelTicket);

        jPanelTicketOpciones.setBackground(new java.awt.Color(220, 220, 220));
        jPanelTicketOpciones.setLayout(new javax.swing.BoxLayout(jPanelTicketOpciones, javax.swing.BoxLayout.Y_AXIS));

        jLabelListaTickets.setText("Lista de Tickets");
        jLabelListaTickets.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 15, 1, 1));
        jLabelListaTickets.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelListaTickets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelListaTicketsMouseClicked(evt);
            }
        });
        jPanelTicketOpciones.add(jLabelListaTickets);

        jPanelNavegador.add(jPanelTicketOpciones);

        getContentPane().add(jPanelNavegador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 500));

        jPanelContenido.setLayout(new java.awt.CardLayout());
        jPanelContenido.add(inicioAdminVista, "inicioAdminVista");

        registroVista.setName("registroVista"); // NOI18N
        jPanelContenido.add(registroVista, "registroVista");
        jPanelContenido.add(listaUsuariosVista, "listaUsuariosVista");
        jPanelContenido.add(cambioContraseniaVista, "cambioContraseniaVista");
        jPanelContenido.add(panelTickets, "panelTickets");

        getContentPane().add(jPanelContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 680, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelCrearUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCrearUsuarioMouseClicked
        if (contraseniaIgualDni) {
            return;
        }
        cambiarVista("registroVista", jLabelCrearUsuario);
    }//GEN-LAST:event_jLabelCrearUsuarioMouseClicked

    private void jLabelInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelInicioMouseClicked
        if (contraseniaIgualDni) {
            return;
        }
        cambiarVista("inicioAdminVista", jLabelInicio);
    }//GEN-LAST:event_jLabelInicioMouseClicked

    private void jLabelTicketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTicketMouseClicked
        if (contraseniaIgualDni) {
            return;
        }
        if (dropdownTicketVisible) {
            cerrarMenu(jPanelTicketOpciones);
        } else {
            abrirMenu(jPanelTicketOpciones);
        }
        cambiarVista("", jLabelTicket);
    }//GEN-LAST:event_jLabelTicketMouseClicked

    private void jLabelListaTicketsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelListaTicketsMouseClicked
        if (contraseniaIgualDni) {
            return;
        }
        cambiarVista("panelTickets", jLabelListaTickets);
    }//GEN-LAST:event_jLabelListaTicketsMouseClicked

    private void jLabelUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelUsuarioMouseClicked
        if (contraseniaIgualDni) {
            return;
        }
        if (dropdownUsuarioVisible) {
            cerrarMenu(jPanelUsuarioOpciones);
        } else {
            abrirMenu(jPanelUsuarioOpciones);
        }
        cambiarVista("", jLabelUsuario);
    }//GEN-LAST:event_jLabelUsuarioMouseClicked

    private void jLabelListaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelListaUsuariosMouseClicked
        if (contraseniaIgualDni) {
            return;
        }
        cambiarVista("listaUsuariosVista", jLabelListaUsuarios);
        listaUsuariosVista.cargarUsuarios();
    }//GEN-LAST:event_jLabelListaUsuariosMouseClicked

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

    private void jLabelModificarPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelModificarPerfilMouseClicked
        if (contraseniaIgualDni) {
            return;
        }
        cambiarVista("cambioContraseniaVista", jLabelModificarPerfil);
    }//GEN-LAST:event_jLabelModificarPerfilMouseClicked

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
            java.util.logging.Logger.getLogger(AdminVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private vistas.CambioContraseniaVista cambioContraseniaVista;
    private vistas.InicioAdminVista inicioAdminVista;
    private javax.swing.JLabel jLabelCerrarSesion;
    private javax.swing.JLabel jLabelCrearUsuario;
    private javax.swing.JLabel jLabelInicio;
    private javax.swing.JLabel jLabelListaTickets;
    private javax.swing.JLabel jLabelListaUsuarios;
    private javax.swing.JLabel jLabelModificarPerfil;
    private javax.swing.JLabel jLabelPerfil;
    private javax.swing.JLabel jLabelTicket;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanelContenido;
    private javax.swing.JPanel jPanelNavegador;
    private javax.swing.JPanel jPanelPerfilOpciones;
    private javax.swing.JPanel jPanelTicketOpciones;
    private javax.swing.JPanel jPanelUsuarioOpciones;
    private vistas.ListaUsuariosVista listaUsuariosVista;
    private vistas.PanelTickets panelTickets;
    private vistas.RegistroVista registroVista;
    // End of variables declaration//GEN-END:variables
}
