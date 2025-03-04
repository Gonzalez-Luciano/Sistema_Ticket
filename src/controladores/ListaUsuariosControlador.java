/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Clases.Usuario;
import java.util.List;
import modelos.UsuarioModelo;

/**
 *
 * @author TuKK
 */
public class ListaUsuariosControlador {
     private UsuarioModelo usuarioModelo;

    public ListaUsuariosControlador() {
        this.usuarioModelo = new UsuarioModelo();
    }

    /**
     * Devuelve una lista con todos los usuarios a excepción del indicado por parámetro
     * 
     * @param usuarioNoDeseado Usuario que no se desea que devuelva
     * @return Lista de tipo Usuario con todos los usuarios menos usuarioNoDeseado
     */
    
    public List<Usuario> obtenerTodosLosUsuarios(Usuario usuarioNoDeseado) {
        return usuarioModelo.obtenerTodosLosUsuarios(usuarioNoDeseado);
    }
}
