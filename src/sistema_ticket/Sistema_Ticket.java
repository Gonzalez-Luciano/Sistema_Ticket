/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_ticket;

import vistas.CambioContrasenia;
import vistas.GenerarTicket;

/**
 *
 * @author TuKK
 */
public class Sistema_Ticket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        CambioContrasenia a = new CambioContrasenia("44335769");
        GenerarTicket a = new GenerarTicket();
        a.setVisible(true);
        a.setLocationRelativeTo(null);
        /** Test para modificación de contraseña
         * UsuarioModelo us = new UsuarioModelo();
         * us.modificarContrasenia("44335769", "1234", "12345");
        */
        
        //Inicialización de la vista Login
        /**
         * try { UIManager.setLookAndFeel(new FlatLightLaf()); } catch
         * (UnsupportedLookAndFeelException ex) { System.err.println("Error al
         * inicializar FlatLaf: " + ex.getMessage()); }
         * SwingUtilities.invokeLater(() -> new loginVista());
         */
    }

}
