/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author TuKK
 */
public class ListaUsuarios {

    private List<Usuario> usuarios;

    public ListaUsuarios() {
        this.usuarios = new ArrayList<>();
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void removerUsuarios() {
        usuarios.clear();
    }

    public void agregarUsuarios(List<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            this.agregarUsuario(usuario);
        }
    }

    public Usuario buscarPorIndice(int Indice) {
        return usuarios.get(Indice);
    }

    public List<Usuario> filtrarPorNombre(String nombre) {
        return usuarios.stream()
                .filter(u -> u.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Usuario> filtrarPorTipo(String tipo) {
        return usuarios.stream()
                .filter(u -> u.getTipo().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }

    public List<Usuario> filtrarPorLegajo(String legajo) {

        return usuarios.stream()
                .filter(u -> String.valueOf(u.getLegajo()).contains(legajo)) // Buscar coincidencias parciales
                .collect(Collectors.toList());
    }

    public List<Usuario> filtrarPorDNI(String dni) {

        return usuarios.stream()
                .filter(u -> String.valueOf(u.getDNI()).contains(dni)) // Buscar coincidencias parciales
                .collect(Collectors.toList());
    }

    public List<Usuario> obtenerTodos() {
        return new ArrayList<>(usuarios);
    }
}
