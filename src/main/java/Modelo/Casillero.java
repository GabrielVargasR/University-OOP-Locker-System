
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Casillero {
    
    private int numero;
    private ArrayList<Articulo> contenidos;

    public Casillero(int numero, ArrayList<Articulo> contenidos) {
        this.numero = numero;
        this.contenidos = contenidos;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public ArrayList<Articulo> getContenidos() {
        return contenidos;
    }
    
    public void setContenidos(ArrayList<Articulo> contenidos) {
        this.contenidos = contenidos;
    }
    
}
