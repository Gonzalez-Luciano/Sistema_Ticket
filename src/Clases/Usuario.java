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
public abstract class Usuario {

    private String nombre;
    private String dni;
    private int legajo;
    private String tipo;
    private String contrasena;
    private String estado;

    public Usuario(String nombre, String dni, String tipo, String contrasena) {
        this.nombre = nombre;
        this.dni = dni;
        this.tipo = tipo;
        this.contrasena = contrasena;
    }

    public Usuario(String nombre, String dni, int legajo, String tipo, String contrasena, String estado) {
        this.nombre = nombre;
        this.dni = dni;
        this.legajo = legajo;
        this.tipo = tipo;
        this.contrasena = contrasena;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDNI() {
        return dni;
    }

    public void setDNI(String dni) {
        this.tipo = dni;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
