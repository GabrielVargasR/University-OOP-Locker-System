
package model;

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

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Casillero other = (Casillero) obj;
        if (this.numero != other.numero) {
            return false;
        }
        return true;
    }
}
