
package model;

import java.util.ArrayList;

/**
 *
 * @author Gabriel
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
    
    public boolean retirarArticulos(ArrayList<Articulo> pArticulos){
        if (this.contenidos.removeAll(pArticulos)){
            return true;
        }
        return false;
    }
    
    public boolean isEmpty(){
        return this.contenidos.isEmpty();
    }
    
    @Override
    public String toString(){
        if (!this.contenidos.isEmpty()){
            String str = "";
            for (Articulo art : this.contenidos){
                str += "- " + art.getDescripcion() + " ID: " + art.getId().toString() + "\n";
            }
            return str;
        }
        return "Casillero vacío, no hay artículos pendientes";
    }

  
}
