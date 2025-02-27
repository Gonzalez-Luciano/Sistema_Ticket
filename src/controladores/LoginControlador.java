/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Clases.Administrador;
import Clases.AuthResponse;
import Clases.Tecnico;
import Clases.Trabajador;
import Clases.Usuario;
import excepciones.UsuarioException;
import javax.swing.JOptionPane;
import modelos.UsuarioModelo;
import vistas.AdminVista;
import vistas.LoginVista;
import vistas.TecnicoVista;
import vistas.TrabajadorVista;

/**
 *
 * @author TuKK
 */
public class LoginControlador {

    private LoginVista vista;
    private UsuarioModelo modelo;

    public LoginControlador(LoginVista vista) {
        this.vista = vista;
        this.modelo = new UsuarioModelo();
    }

    public void conectarUsuario() {
        try {
            String nombreDNI = vista.getNombreDNI(); // Obtener el nombre o DNI
            char[] passwordChars = vista.getPass();  // Obtener la contraseña en char[]

            // Convertir char[] a String
            String password = new String(passwordChars);

            // Validaciones de campos
            if (nombreDNI.isEmpty() || password.isEmpty()) {
                throw new UsuarioException("Por favor, completa todos los campos");
            }

            // Validar usuario con el modelo
            AuthResponse respuesta = modelo.validarUsuario(nombreDNI, password);
            Usuario usuario = respuesta.getUsuario();
            
            // Borrar el contenido del array de contraseña por seguridad y reiniciar inputs
            java.util.Arrays.fill(passwordChars, ' ');
            vista.setNombreDNI("");
            vista.setPass("");

            switch (respuesta.getMensaje()) {
                case EXITO:
                    vista.setRespuesta("Conectando...");
                    if (usuario instanceof Administrador) {
                        new AdminVista(usuario);
                        vista.dispose();
                    } else if (usuario instanceof Tecnico) {
                        new TecnicoVista(usuario);
                        vista.dispose();
                    } else if (usuario instanceof Trabajador) {
                        new TrabajadorVista(usuario);
                        vista.dispose();
                    }
                    
                    break;
                case USUARIO_NO_ENCONTRADO:
                case ERROR_DATO_INCORRECTO:
                    throw new UsuarioException("Los datos ingresados son incorrectos.");
                case ERROR_CONEXION:
                    throw new UsuarioException("Hubo un error a la hora de conectarse, por favor intentelo nuevamente.");
                case BLOQUEADO:
                    throw new UsuarioException("Tu usuario ha sido bloqueado. Por favor, contacta al administrador para más información.");
                default:
                    throw new UsuarioException("Error al intentarse conectar a la cuenta.");
            }

        } catch (UsuarioException e) {
            vista.mostrarMensaje(e.getMessage(), "⚠ Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            vista.mostrarMensaje(e.getMessage(), "⚠ Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
