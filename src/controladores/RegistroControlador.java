/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Clases.Administrador;
import Clases.Mensaje;
import Clases.Tecnico;
import Clases.Trabajador;
import Clases.Usuario;
import excepciones.UsuarioException;
import javax.swing.JOptionPane;
import modelos.UsuarioModelo;
import vistas.RegistroVista;

public class RegistroControlador {

    private UsuarioModelo modelo;
    private RegistroVista vista;

    public RegistroControlador(RegistroVista vista) {
        this.modelo = new UsuarioModelo();
        this.vista = vista;
    }

    public void registrarUsuario() {
        try {
            String nombre = vista.getNombre().trim();
            String dni = vista.getDNI().trim();
            String tipo = vista.getTipo().trim();

            // Seccion de validaciones INCOMPETAS!!!
            if (nombre.isEmpty() || tipo.isEmpty() || dni.isEmpty()) {
                throw new UsuarioException("Por favor, completa todos los campos.");
            }

            // Revisar si es un numero entero
            Integer.parseInt(dni);

            if (dni.length() < 7 || dni.length() > 8) {
                throw new UsuarioException("Por favor, ingrese un dni valido");
            }
            ///--------------------------------------------------------------------------

            // Mensaje de confirmación con advertencia si es administrador
            String mensajeConfirmacion = "¿Está seguro de registrar a este usuario como " + tipo + "?";
            if (tipo.equalsIgnoreCase("administrador")) {
                mensajeConfirmacion += "\n⚠ **Este usuario NO podrá ser bloqueado.**";
            }

            int opcion = JOptionPane.showConfirmDialog(
                    null,
                    mensajeConfirmacion,
                    "Confirmar registro",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (opcion != JOptionPane.YES_OPTION) {
                return; // Se cancela el registro si elige "No"
            }

            Usuario usuario = crearUsuario(nombre, dni, tipo);
            Mensaje mensaje = modelo.crearUsuario(usuario);

            vista.setNombre("");
            vista.setDNI("");
            vista.setTipo(0);

            switch (mensaje) {
                case EXITO:
                    vista.mostrarMensaje("Usuario registrado con éxito.\nSe estableció el D.N.I como contraseña inicial.", "Usuario registrado", JOptionPane.PLAIN_MESSAGE);
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

    private Usuario crearUsuario(String nombre, String dni, String tipo) throws UsuarioException {
        switch (tipo) {
            case "Trabajador":
                return new Trabajador(nombre, dni, dni);
            case "Tecnico":
                return new Tecnico(nombre, dni, dni);
            case "Administrador":
                return new Administrador(nombre, dni, dni);
            default:
                throw new UsuarioException("Tipo de usuario no válido.");
        }
    }
}
