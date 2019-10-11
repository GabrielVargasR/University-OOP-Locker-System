
package controller;

import java.util.ArrayList;

import model.*;

/**
 *
 * @author Usuario
 */
public class Counter {

    private ArrayList<Casillero> casilleros;
    private ArrayList<Articulo> historialVendidos;
    private ExpedienteCliente clientes;

    public Counter(ArrayList<Casillero> casilleros, ArrayList<Articulo> historialVendidos, ExpedienteCliente clientes) {
        this.casilleros = casilleros;
        this.historialVendidos = historialVendidos;
        this.clientes = clientes;
    }

    public ArrayList<Casillero> getCasilleros() {
        return casilleros;
    }

    public void setCasilleros(ArrayList<Casillero> casilleros) {
        this.casilleros = casilleros;
    }

    public ArrayList<Articulo> getHistorialVendidos() {
        return historialVendidos;
    }

    public void setHistorialVendidos(ArrayList<Articulo> historialVendidos) {
        this.historialVendidos = historialVendidos;
    }

    public ExpedienteCliente getClientes() {
        return clientes;
    }

    public void setClientes(ExpedienteCliente clientes) {
        this.clientes = clientes;
    }
    
    public boolean registrarCliente(Cliente pCliente){
       
        for (int i = 0; i < clientes.size(); i++) {
            Casillero get = casilleros.get(i);
            if (get.equals(pCliente)) {
                    return false;
            }
        }
        
        this.clientes.addCliente(pCliente);
        return true;
    }
        
    
   
}
