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

    /**
     * Agrega un usuario a la lista de usuarios.
     *
     * @param usuario El usuario a agregar a la lista.
     */
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    /**
     * Remueve todos los usuarios de la lista.
     */
    public void removerUsuarios() {
        usuarios.clear();
    }

    /**
     * Agrega múltiples usuarios a la lista.
     *
     * @param usuarios Lista de usuarios a agregar.
     */
    public void agregarUsuarios(List<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            this.agregarUsuario(usuario);
        }
    }

    /**
     * Busca un usuario en la lista por su índice.
     *
     * @param Indice El índice del usuario en la lista.
     * @return El usuario en el índice especificado.
     * @throws IndexOutOfBoundsException Si el índice está fuera de los límites
     * de la lista.
     */
    public Usuario buscarPorIndice(int Indice) {
        return usuarios.get(Indice);
    }

    /**
     * Filtra los usuarios por nombre, realizando una búsqueda insensible a
     * mayúsculas y minúsculas.
     *
     * @param nombre El nombre que se desea buscar.
     * @return Una lista de usuarios cuyos nombres contienen la cadena
     * proporcionada.
     */
    public List<Usuario> filtrarPorNombre(String nombre) {
        return usuarios.stream()
                .filter(u -> u.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Filtra los usuarios por tipo.
     *
     * @param tipo El tipo de usuario para filtrar.
     * @return Una lista de usuarios cuyo tipo coincide con el tipo
     * proporcionado.
     */
    public List<Usuario> filtrarPorTipo(String tipo) {
        return usuarios.stream()
                .filter(u -> u.getTipo().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }

    /**
     * Filtra los usuarios por legajo, buscando coincidencias parciales.
     *
     * @param legajo El legajo que se desea buscar.
     * @return Una lista de usuarios cuyo legajo contiene la cadena
     * proporcionada.
     */
    public List<Usuario> filtrarPorLegajo(String legajo) {
        return usuarios.stream()
                .filter(u -> String.valueOf(u.getLegajo()).contains(legajo)) // Buscar coincidencias parciales
                .collect(Collectors.toList());
    }

    /**
     * Filtra los usuarios por DNI, buscando coincidencias parciales.
     *
     * @param dni El DNI que se desea buscar.
     * @return Una lista de usuarios cuyo DNI contiene la cadena proporcionada.
     */
    public List<Usuario> filtrarPorDNI(String dni) {
        return usuarios.stream()
                .filter(u -> String.valueOf(u.getDNI()).contains(dni)) // Buscar coincidencias parciales
                .collect(Collectors.toList());
    }

    /**
     * Obtiene todos los usuarios en la lista.
     *
     * @return Una lista con todos los usuarios.
     */
    public List<Usuario> obtenerTodos() {
        return new ArrayList<>(usuarios);
    }

}
