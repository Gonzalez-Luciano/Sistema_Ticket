/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Clases.Tecnico;
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

/**
 *
 * @author ramir
 */
public class TecnicoVista extends JFrame implements interfaces.InterCambioContrasenia{

    private boolean dropdownTicketVisible = false;
    private boolean dropdownPerfilVisible = false;
    private TicketControlador controlador;
    private Usuario usuarioActual;
    private final Color colorAzul = new Color(75, 55, 255);
    private boolean contraseniaIgualDni;

    
    /**
     * Creates new form TecnicoVista
     * @param usuario usuario que inició sesión
     */
    
    public TecnicoVista(Usuario usuario){
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
     public TecnicoVista() {
         //usuarioActual =  new Tecnico("Ramiro","40634178", 101, "123", "activo", 0, 0);
        initComponents();
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
            jLabelBuscarTickets,
            jLabelCerrarSesion,
            jLabelInicio,
            jLabelModificarPerfil,
            jLabelPerfil,
            jLabelTickets,
            jLabelTicketsAsignados
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
        jLabelTickets.setForeground(Color.BLACK);
        jLabelTicketsAsignados.setForeground(Color.BLACK);
        jLabelBuscarTickets.setForeground(Color.BLACK);

        // Resaltar el label seleccionado
        labelSeleccionado.setForeground(colorAzul);

        // Si la selección está en las opciones de Tickets, cambiar color de Tickets
        if (labelSeleccionado == jLabelTicketsAsignados || labelSeleccionado == jLabelBuscarTickets) {
            jLabelTickets.setForeground(colorAzul);
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
        jLabelTickets = new javax.swing.JLabel();
        jPanelTicketOpciones = new javax.swing.JPanel();
        jPanelTicketOpciones.setVisible(false);
        jLabelTicketsAsignados = new javax.swing.JLabel();
        jLabelBuscarTickets = new javax.swing.JLabel();
        jPanelContenido = new javax.swing.JPanel();
        inicioAdminVista = new vistas.InicioAdminVista(usuarioActual.getNombre());
        cambioContraseniaVista = new CambioContraseniaVista(usuarioActual.getDNI(),usuarioActual.getContrasena(),this);
        panelTickets = new PanelTickets(usuarioActual);
        ;
        panelMisTickets = new PanelMisTickets(usuarioActual);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelNavegador.setBackground(new java.awt.Color(220, 220, 220));
        jPanelNavegador.setMaximumSize(new java.awt.Dimension(97, 192));
        jPanelNavegador.setMinimumSize(new java.awt.Dimension(97, 192));
        jPanelNavegador.setPreferredSize(new java.awt.Dimension(97, 192));
        jPanelNavegador.setLayout(new javax.swing.BoxLayout(jPanelNavegador, javax.swing.BoxLayout.Y_AXIS));

        jLabelInicio.setText("Inicio");
        jLabelInicio.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 2, 5));
        jLabelInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelInicio.setMinimumSize(new java.awt.Dimension(40, 121));
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

        jLabelCerrarSesion.setText("Cerrar Sesión");
        jLabelCerrarSesion.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 15, 1, 1));
        jLabelCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCerrarSesionMouseClicked(evt);
            }
        });
        jPanelPerfilOpciones.add(jLabelCerrarSesion);

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

        jPanelContenido.setLayout(new java.awt.CardLayout());
        jPanelContenido.add(inicioAdminVista, "inicioAdminVista");
        jPanelContenido.add(cambioContraseniaVista, "cambioContraseniaVista");
        jPanelContenido.add(panelTickets, "panelTickets");
        jPanelContenido.add(panelMisTickets, "panelMisTickets");

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

    private void jLabelTicketsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTicketsMouseClicked
        if (contraseniaIgualDni) {
            return;
        }
        if (dropdownTicketVisible) {
            cerrarMenu(jPanelTicketOpciones);
        } else {
            abrirMenu(jPanelTicketOpciones);
        }
        cambiarVista("", jLabelTickets);
    }//GEN-LAST:event_jLabelTicketsMouseClicked

    private void jLabelModificarPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelModificarPerfilMouseClicked
        if (contraseniaIgualDni) {
            return;
        }
        cambiarVista("cambioContraseniaVista", jLabelModificarPerfil);
    }//GEN-LAST:event_jLabelModificarPerfilMouseClicked

    private void jLabelTicketsAsignadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTicketsAsignadosMouseClicked
         if (contraseniaIgualDni) {
            return;
        }
         
        panelMisTickets.cargarTickets();
        cambiarVista("panelMisTickets", jLabelTicketsAsignados);
    }//GEN-LAST:event_jLabelTicketsAsignadosMouseClicked

    private void jLabelBuscarTicketsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBuscarTicketsMouseClicked
         if (contraseniaIgualDni) {
            return;
        }
         
        panelTickets.cargarTickets();
        cambiarVista("panelTickets", jLabelBuscarTickets);
    }//GEN-LAST:event_jLabelBuscarTicketsMouseClicked

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
    private vistas.CambioContraseniaVista cambioContraseniaVista;
    private vistas.InicioAdminVista inicioAdminVista;
    private javax.swing.JLabel jLabelBuscarTickets;
    private javax.swing.JLabel jLabelCerrarSesion;
    private javax.swing.JLabel jLabelInicio;
    private javax.swing.JLabel jLabelModificarPerfil;
    private javax.swing.JLabel jLabelPerfil;
    private javax.swing.JLabel jLabelTickets;
    private javax.swing.JLabel jLabelTicketsAsignados;
    private javax.swing.JPanel jPanelContenido;
    private javax.swing.JPanel jPanelNavegador;
    private javax.swing.JPanel jPanelPerfilOpciones;
    private javax.swing.JPanel jPanelTicketOpciones;
    private vistas.PanelMisTickets panelMisTickets;
    private vistas.PanelTickets panelTickets;
    // End of variables declaration//GEN-END:variables
}
