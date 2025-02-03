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
public class Trabajador extends Usuario {

    public Trabajador(String nombre, String dni, String contrasena) {
        super(nombre, dni, "trabajador", contrasena);
    }

    public Trabajador(String nombre, String dni, int legajo, String contrasena, String estado) {
        super(nombre, dni, legajo, "trabajador", contrasena, estado);
    }

}
