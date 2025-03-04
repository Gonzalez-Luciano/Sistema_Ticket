/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Clases.Administrador;
import Clases.Mensaje;
import Clases.Usuario;
import excepciones.UsuarioException;
import javax.swing.JOptionPane;
import modelos.UsuarioModelo;
import vistas.RegistrarAdminVista;

/**
 *
 * @author TuKK
 */
public class RegistrarAdminControlador {

    private UsuarioModelo modelo;
    private RegistrarAdminVista vista;

    public RegistrarAdminControlador(RegistrarAdminVista vista) {
        this.modelo = new UsuarioModelo();
        this.vista = vista;
    }

    public void registrarUsuario() {
        try {
            String nombre = vista.getNombre().trim();
            String dni = vista.getDNI().trim();

            // Seccion de validaciones INCOMPETAS!!!
            if (nombre.isEmpty() || dni.isEmpty()) {
                throw new UsuarioException("Por favor, completa todos los campos.");
            }

            // Revisar si es un numero entero
            Integer.parseInt(dni);

            if (dni.length() < 7 || dni.length() > 8) {
                throw new UsuarioException("Por favor, ingrese un dni valido");
            }
            ///--------------------------------------------------------------------------

            Usuario usuario = new Administrador(nombre, dni, dni);
            Mensaje mensaje = modelo.crearUsuario(usuario);

            vista.setNombre("");
            vista.setDNI("");

            switch (mensaje) {
                case EXITO:
                    vista.mostrarMensaje("Usuario registrado con éxito.\nSe estableció el D.N.I como contraseña inicial.", "Usuario registrado", JOptionPane.PLAIN_MESSAGE);
                    vista.dispose();
                    break;
                case ERROR_DNI_REPETIDO:
                    throw new UsuarioException("El DNI ya está registrado");
                default:
                    throw new UsuarioException("Error al registrar el usuario.");

            }

        } catch (UsuarioException e) {
            vista.mostrarMensaje(e.getMessage(), "⚠ Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("Por favor, ingrese un dni valido", "⚠ Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            vista.mostrarMensaje("❌ Se produjo un error inesperado, Comuníquese con el administrador: \n" + e.getMessage(), "⚠ Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // Para depuración en consola
        }
    }

}
