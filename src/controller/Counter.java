
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
    private HashMap<Integer, Integer> llaves; // número de casillero -> número en ArrayList de casilleros
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
            this.casilleros.add(new Casillero(contador));
            llaves.put(contador, i);
            contador++;
        }
    }
    
    // ****************************** Administración de Clientes *****************************************
    
    /**
     * Función para registrar un cliente al counter
     * @param pCliente cliente que se va a registrar
     * @return boolean que indica si se agregó o no el cliente
     */
    public boolean registrarCliente(Cliente pCliente){
        if (!this.expedienteClientes.containsKey(pCliente.getCedula())){
            expedienteClientes.put(pCliente.getCedula(), pCliente);
            for (Casillero casillero : this.casilleros){
                if (!casillero.isOcupado()){
                    pCliente.setNumeroCasillero(casillero.getNumero());
                    casillero.ocupar();
                    break;
                }
            }
        }
        return false;
    }
    
    public void modificarCliente(String pCedula, String pNombre, String pCorreo, String pTelefono, String pDireccion, String pSexo, int diaN, int mesN, int annoN){
        if (this.expedienteClientes.containsKey(pCedula)){
            Cliente cliente = this.expedienteClientes.get(pCedula);
            cliente.setNombre(pNombre);
            cliente.setCorreo(pCorreo);
            cliente.setTelefono(pTelefono);
            cliente.setDireccion(pDireccion);
            cliente.setSexo(pSexo);
            cliente.setFechaNacimiento(diaN, mesN, annoN);
        }
    }
    
    // ****************************** Administración de Articulos *****************************************
    
    /**
     * Función para obtener los artículos pendientes de un cliente
     * @param pCedula cédula del cliente a consultar
     * @return lista de artículos pendientes
     */
    public ArrayList<Articulo> articulosPendientes(int pCedula){
         if (this.expedienteClientes.containsKey(pCedula)){
            int numCasillero = this.expedienteClientes.get(pCedula).getNumeroCasillero();
            int llave = this.llaves.get(numCasillero);
            return this.casilleros.get(llave).getArticulos();
        }
        return null;
    }
    
    /**
     * Función para enviar un artículo a un cliente existente
     * @param pArticulo articulo a enviar
     * @param pCedula cédula del cliente que recibe el artículo
     * @return boolean que indica si se envió el artículo con éxito
     */
    public boolean enviarArticulo(Articulo pArticulo, int pCedula){
        if (this.expedienteClientes.containsKey(pCedula)){
            int numCasillero = this.expedienteClientes.get(pCedula).getNumeroCasillero();
            int llave = this.llaves.get(numCasillero);
            this.casilleros.get(llave).agregarArticulo(pArticulo);
            // enviar correo
            return true;
        }
        return false;
    }
    
    /**
     * Función para retirar una serie de artículos del casillero del cliente consultado
     * @param pArticulos lista de artículos a retirar
     * @param pCedula identificador del cliente
     * @return
     */
    public boolean retirarArticulos(ArrayList<Articulo> pArticulos, int pCedula){
        if (this.expedienteClientes.containsKey(pCedula)){
            
        }
        return false;
    }
    
    
    
    
}
