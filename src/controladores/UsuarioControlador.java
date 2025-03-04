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
    
    /**
     * Modifica la contraseña y retorna un mensaje según si se logró cambiar la contraseña. 
     * 
     * @param dni DNI del usuario que va cambiar la contraseña
     * @param valorActual Los datos del input valorActual
     * @param nuevoValor Los datos del input nuevoValor
     * @param confirmarValor Los datos del input confirmarValor
     * @return Retorna un mensaje según si se logró cambiar la contraseña
     */
    
    public Mensaje cambiarContrasenia(String dni, String valorActual, String nuevoValor, String confirmarValor) {
       
        if((valorActual == null || valorActual.isEmpty()) ||
                (nuevoValor == null || nuevoValor.isEmpty()) ||
                (confirmarValor == null || confirmarValor.isEmpty())) {
            return Mensaje.ERROR_DATO_INCORRECTO;
        }
        
        if(nuevoValor.compareTo(confirmarValor) != 0) {
            return Mensaje.ERROR_CONFIRMACION_INVALIDA;
        }
        
        if(valorActual.compareTo(nuevoValor) != 0) {
            return modelo.modificarContrasenia(dni, valorActual, nuevoValor);
        } else {
            return Mensaje.ERROR_CONTRASENIA_REPETIDA;
        }
    }
}
