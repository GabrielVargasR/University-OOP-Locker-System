package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

/**
 *
 * @author Gabriel
 */
public class GestorCasilleros {
    private ArrayList<Casillero> casilleros;
    private HashMap<Integer, Integer> llaves; // número de casillero -> número en ArrayList de casilleros
    private ArrayList<Articulo> recibidos;
    private ArrayList<Articulo> retirados;
    
    public GestorCasilleros(int pNumCasilleros){
        this.casilleros = new ArrayList<Casillero>();
        this.llaves = new HashMap<Integer, Integer>();
        this.recibidos = new ArrayList<Articulo>();
        this.retirados = new ArrayList<Articulo>();
        
        int contador = 1000;
        for (int i = 0; i < pNumCasilleros; i++){
            this.casilleros.add(new Casillero(contador));
            this.llaves.put(contador, i);
            contador++;
        }
    }
    
    
    public int asignarCasillero(Cliente pCliente){
        for (Casillero casillero : this.casilleros){
            if (!casillero.isOcupado()){
                pCliente.setNumeroCasillero(casillero.getNumero());
                casillero.ocupar();
                return casillero.getNumero();  
            }
        }
        return 0;
    }
    
    public String getContenidoCasillero(int pNumCasillero){
        Casillero casillero = this.casilleros.get(this.llaves.get(pNumCasillero));
        return casillero.toString();
    }
    
    public ArrayList<Articulo> getArticulosCasillero(int pNumCasillero){
        Casillero casillero = this.casilleros.get(this.llaves.get(pNumCasillero));
        return casillero.getArticulos();
    }
    
    public boolean liberarCasillero(int pNumCasillero){
        Casillero casillero = this.casilleros.get(this.llaves.get(pNumCasillero));
        if (casillero.isEmpty()){
            casillero.desocupar();
            return true;
        }
        return false;
    }
    
    public void recibirPaquete(int pNumCasillero, Articulo pArticulo){
        Casillero casillero = this.casilleros.get(this.llaves.get(pNumCasillero));
        casillero.agregarArticulo(pArticulo);
        this.recibidos.add(pArticulo);
        pArticulo.setFechaRecibido(new Date());
    }
    
    public boolean retirarPaquetes(int pNumCasillero, ArrayList<Articulo> pArticulosSeleccionados){
        Casillero casillero = this.casilleros.get(this.llaves.get(pNumCasillero));
        if (casillero.retirarArticulos(pArticulosSeleccionados)){
            return true;
        }
        return false;
    }
    
    public boolean estadoCasillero(int pNumCasillero){
        if (!this.casilleros.get(this.llaves.get(pNumCasillero)).isEmpty()){
            return true;
        }
        return false;
    }
}
