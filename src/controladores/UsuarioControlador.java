/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Clases.Mensaje;
import modelos.UsuarioModelo;

/**
 *
 * @author USUARIO
 */
public class UsuarioControlador {
    
    UsuarioModelo modelo = new UsuarioModelo();
    
    public UsuarioControlador() {
        super();
    }
    
    public Mensaje cambiarContrasenia(String dni, String valorActual, String nuevoValor, String confirmarValor) {
        if(nuevoValor.equals(confirmarValor)) {
            return modelo.modificarContrasenia(dni, valorActual, nuevoValor);
        } else {
            return Mensaje.ERROR_CONFIRMACION_INVALIDA;
        }
    }
}
