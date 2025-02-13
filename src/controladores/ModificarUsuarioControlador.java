/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Clases.Mensaje;
import Clases.Usuario;
import excepciones.UsuarioException;
import javax.swing.JOptionPane;
import modelos.UsuarioModelo;
import vistas.ModificarUsuarioVista;

/**
 *
 * @author TuKK
 */
public class ModificarUsuarioControlador {

    private UsuarioModelo modelo;
    private ModificarUsuarioVista vista;

    public ModificarUsuarioControlador(ModificarUsuarioVista vista) {
        this.modelo = new UsuarioModelo();;
        this.vista = vista;
    }

    public void reiniciarContrasenia(Usuario usuario) {
        try {
            Mensaje mensaje = modelo.reiniciarContrasenia(usuario);
            switch (mensaje) {
                case EXITO:
                    vista.mostrarMensaje("Usuario reiniciado con éxito.\nSe estableció el D.N.I como contraseña.", "Usuario reiniciado", JOptionPane.PLAIN_MESSAGE);
                    break;
                default:
                    throw new UsuarioException("Error al reiniciar el usuario.");

            }

        } catch (UsuarioException e) {
            vista.mostrarMensaje(e.getMessage(), "⚠ Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            vista.mostrarMensaje("❌ Se produjo un error inesperado, Comuníquese con el administrador: \n" + e.getMessage(), "⚠ Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // Para depuración en consola
        }
    }

    public void cambiarEstado(Usuario usuario, String estadoNuevo) {
        try {
            Mensaje mensaje = modelo.cambiarEstado(usuario, estadoNuevo);
            switch (mensaje) {
                case EXITO:
                    vista.mostrarMensaje(estadoNuevo.equals("activo") ? "Usuario se ha desbloqueado con éxito." : "Usuario se ha bloqueado con éxito.", estadoNuevo.equals("activo") ? "Usuario desbloqueado" : "Usuario bloqueado", JOptionPane.PLAIN_MESSAGE);
                    break;
                default:
                    throw new UsuarioException(estadoNuevo.equals("activo") ? "Error al desbloquear el usuario." : "Error al bloquear el usuario.");

            }

        } catch (UsuarioException e) {
            vista.mostrarMensaje(e.getMessage(), "⚠ Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            vista.mostrarMensaje("❌ Se produjo un error inesperado, Comuníquese con el administrador: \n" + e.getMessage(), "⚠ Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // Para depuración en consola
        }
    }
}
