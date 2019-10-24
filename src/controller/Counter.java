
package controller;

import java.util.ArrayList;
import java.util.HashMap;

import model.*;

/**
 *
 * @author gabriel
 */
public class Counter {
    
    private String nombre;
    private String cedulaJuridica;
    private String direccion;
    private ArrayList<Casillero> casilleros;
    private HashMap<Integer, Integer> llaves;
    private HashMap<String, Cliente> expedienteClientes;
    
    /**
     * Constructor de la clase counter
     * @param pNombre nombre del counter
     * @param pCedula cédula jurídica
     * @param pCantidadCasilleros número de casilleros que va a tener el counter
     */
    public Counter(String pNombre, String pCedula, String pDireccion, int pCantidadCasilleros){
        this.nombre = pNombre;
        this.cedulaJuridica = pCedula;
        this.direccion = pDireccion;
        int contador = 1000;
        for (int i = 0; i < pCantidadCasilleros; i++){
            this.casilleros.add(new Casillero());
            llaves.put(contador, i);
            contador++;
        }
    }
    
    /**
     * Función para registrar un cliente al counter
     * @param pCliente cliente que se va a registrar
     * @return boolean que indica si se agregó o no el cliente
     */
    public boolean registrarCliente(Cliente pCliente){
        if (!this.expedienteClientes.containsKey(pCliente.getCedula())){
            expedienteClientes.put(pCliente.getCedula(), pCliente);
            for (Casillero)
        }
        return false;
    }
}
