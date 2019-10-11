/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Rayforth
 */
public class Revista {

    private String nombre;
    private boolean catalogo;
    private TTemaRevista tema;

    public Revista(String nombre, boolean catalogo, TTemaRevista tema) {
        this.nombre = nombre;
        this.catalogo = catalogo;
        this.tema = tema;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isCatalogo() {
        return catalogo;
    }

    public void setCatalogo(boolean catalogo) {
        this.catalogo = catalogo;
    }

    public TTemaRevista getTema() {
        return tema;
    }

    public void setTema(TTemaRevista tema) {
        this.tema = tema;
    }
    
}
