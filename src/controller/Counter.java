
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
    
    public boolean registrarCliente(Cliente pCliente){
        if (!this.expedienteClientes.containsKey(pCliente.getCedula())){
        }
        return false;
    }


    
//    /**
//     * Función para registrar un cliente al counter
//     * @param pCliente cliente que se va a registrar
//     * @return boolean que indica si se agregó o no el cliente
//     */
//    public boolean registrarCliente(Cliente pCliente){
//       
//        for (int i = 0; i < clientes.size(); i++) {
//            Casillero get = casilleros.get(i);
//            if (get.equals(pCliente)) {
//                    return false;
//            }
//        }
//        
//        this.clientes.addCliente(pCliente);
//        return true;
//    }
        
    
   
}
