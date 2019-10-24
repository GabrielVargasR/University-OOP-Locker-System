
package model;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Casillero {
    
    private boolean ocupado;
    private int numero;
    private ArrayList<Articulo> contenidos;
    
    
    public Casillero(int pNumero){
        this.ocupado = false;
        this.numero = pNumero;
        this.contenidos = new ArrayList<Articulo>();
    }
    
    public boolean isOcupado(){
        return this.ocupado;
    }
    
    public void ocupar(){
        this.ocupado = true;
    }
    
    public void desocupar(){
        this.ocupado = false;
    }
    
    public int getNumero(){
        return this.numero;
    }
    
    public ArrayList<Articulo> getArticulos(){
        return this.contenidos;
    }
    
    public boolean agregarArticulo(Articulo pArticulo){
        if (this.contenidos.add(pArticulo)){
            return true;
        }
        return false;
    }
    
    public boolean retirarArticulo(Articulo pArticulo){
        if (this.contenidos.remove(pArticulo)){
            return true;
        }
        return false;
    }

  
}
