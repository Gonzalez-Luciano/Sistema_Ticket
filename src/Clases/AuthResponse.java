/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author TuKK
 */
public class AuthResponse {

    private Usuario usuario;
    private Mensaje mensaje;

    public AuthResponse(Usuario usuario, Mensaje mensaje) {
        this.usuario = usuario;
        this.mensaje = mensaje;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Mensaje getMensaje() {
        return mensaje;
    }
}
