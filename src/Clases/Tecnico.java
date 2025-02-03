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
public class Tecnico extends Usuario {

    private int fallas;
    private int marcas;

    public Tecnico(String nombre, String dni, String contrasena) {
        super(nombre, dni, "tecnico", contrasena);
    }

    public Tecnico(String nombre, String dni, int legajo, String contrasena, String estado, int fallas, int marcas) {
        super(nombre, dni, legajo, "tecnico", contrasena, estado);
        this.fallas = fallas;
        this.marcas = marcas;
    }

    public int getFallas() {
        return fallas;
    }

    public void setFallas(int fallas) {
        this.fallas = fallas;
    }

    public int getMarcas() {
        return marcas;
    }

    public void setMarcas(int marcas) {
        this.marcas = marcas;
    }

}
