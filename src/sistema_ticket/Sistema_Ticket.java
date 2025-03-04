/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_ticket;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.SwingUtilities;
import modelos.UsuarioModelo;
import vistas.LoginVista;
import vistas.RegistrarAdminVista;

/**
 *
 * @author TuKK
 */
public class Sistema_Ticket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Inicialización de la vista Login con FlatLaf
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Error al inicializar FlatLaf: " + ex.getMessage());
        }

        SwingUtilities.invokeLater(() -> {
            UsuarioModelo modeloUsuario = new UsuarioModelo();

            if (!modeloUsuario.existeAdmin()) {
                // Si no hay administrador, abrir la ventana de registro y esperar hasta que se cierre
                RegistrarAdminVista registrarAdminVista = new RegistrarAdminVista();
                registrarAdminVista.setVisible(true);

                // Esperar hasta que se cierre la ventana de registro
                registrarAdminVista.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent e) {
                        // Luego de cerrar la ventana de registro, abrir LoginVista
                        new LoginVista();
                    }
                });
            } else {
                // Si ya existe un administrador, abrir directamente la ventana de login
                new LoginVista();
            }
        });
    }

}
