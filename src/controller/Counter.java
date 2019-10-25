
package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    private ArrayList<Articulo> recibidos;
    private ArrayList<Articulo> retirados;
    
    /**
     * Constructor de la clase counter
     * @param pNombre nombre del counter
     * @param pCedula cédula jurídica
     * @param pDireccion dirección del counter
     * @param pCantidadCasilleros número de casilleros que va a tener el counter
     */
    public Counter(String pNombre, String pCedula, String pDireccion, int pCantidadCasilleros){
        this.nombre = pNombre;
        this.cedulaJuridica = pCedula;
        this.direccion = pDireccion;
        this.casilleros = new ArrayList<Casillero>();
        this.llaves = new HashMap<Integer, Integer>();
        this.expedienteClientes = new HashMap<String, Cliente>();
        this.recibidos = new ArrayList<Articulo>();
        this.retirados = new ArrayList<Articulo>();
        
        int contador = 1000;
        for (int i = 0; i < pCantidadCasilleros; i++){
            this.casilleros.add(new Casillero(contador));
            this.llaves.put(contador, i);
            contador++;
        }
    }
    /* ***************************************************************************************************
       ********************************** Administración de Clientes *************************************
       *************************************************************************************************** */
    
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
            return true;
        }
        return false;
    }
    
    /**
     * Función para modificar a un cliente especificado
     * Recoge todos los campos de entrada de la info del cliente
     * @param pCedula cédula del cliente a modificar
     * @param pNombre nombre del cliente
     * @param pCorreo correo del cliente
     * @param pTelefono número de teléfono del cliente
     * @param pDireccion dirección del cliente
     * @param pSexo sexo del cliente
     * @param pDiaN día de nacimiento del cliente
     * @param pMesN mes de nacimiento del cliente
     * @param pAnnoN año de nacimiento del cliente
     * @return boolean para señalar si se pudo modificar el cliente o no
     */
    public boolean modificarCliente(String pCedula, String pNombre, String pCorreo, String pTelefono, String pDireccion, String pSexo, int pDiaN, int pMesN, int pAnnoN){
        if (this.expedienteClientes.containsKey(pCedula)){
            Cliente cliente = this.expedienteClientes.get(pCedula);
            cliente.setNombre(pNombre);
            cliente.setCorreo(pCorreo);
            cliente.setTelefono(pTelefono);
            cliente.setDireccion(pDireccion);
            cliente.setSexo(pSexo);
            cliente.setFechaNacimiento(pDiaN, pMesN, pAnnoN);
            return true;
        }
        return false;
    }
    
    /**
     * Función para consultar un cliente del expediente
     * @param pCedula número de cédula del cliente a consultar
     * @return String con la información del cliente o un mensaje indicando que no se encontró el cliente
     */
    public String consultarCliente(String pCedula){
        if (this.expedienteClientes.containsKey(pCedula)){
            String str = this.expedienteClientes.get(pCedula).toString();
            str += "Artículos pendientes:\n";
            
            int numCasillero = this.expedienteClientes.get(pCedula).getNumeroCasillero();
            int llave = this.llaves.get(numCasillero);
            
            for (Articulo art : casilleros.get(llave).getArticulos()){
                str += "- " + art.getDescripcion() + " ID: " + art.getId().toString() + "\n";
            }
            return str;
        }
        return "No se encontró el cliente ingresado";
    }
    
    /**
     * Función para eliminar un cliente del expediente
     * Limpia el casillero del cliente, lo marca como desocupado y saca al cliente del expediente
     * @param pCedula núemro de cédula del cliente a eliminar
     * @return boolean indicando si se pudo eliminar el cliente
     */
    public boolean eliminarCliente(String pCedula){
        if (this.expedienteClientes.containsKey(pCedula)){
            Cliente cliente = this.expedienteClientes.get(pCedula);
            int llave = this.llaves.get(cliente.getNumeroCasillero());
            Casillero casillero = this.casilleros.get(llave);
            
            casillero.desocupar(); // marca el casillero como desocupado
            casillero.getArticulos().clear(); // libera el casillero
            this.expedienteClientes.remove(pCedula, cliente); // elimina cliente del expediente
            return true;
        }
        return false;
    }
    
    /**
     * Función para desplegar la información de todos los clientes en el expediente
    */
    public String consultarClientes(){
        return "";
    }
    
    /* ***************************************************************************************************
       ********************************** Administración de Artículos ************************************
       *************************************************************************************************** */
    
    /**
     * Función para obtener los artículos pendientes de un cliente
     * @param pCedula cédula del cliente a consultar
     * @return lista de artículos pendientes
     */
    public ArrayList<Articulo> articulosPendientes(String pCedula){
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
     * @return boolean que indica si se envió el artículo con éxito
     */
    public boolean enviarArticulo(Articulo pArticulo){
        if (expedienteClientes.containsValue(pArticulo.getRemitente())){
            int numeroCasillero = pArticulo.getRemitente().getNumeroCasillero();
            int llave = this.llaves.get(numeroCasillero);
            this.casilleros.get(llave).agregarArticulo(pArticulo);
            // enviar correo a cliente
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
            // marcar como retirado (agrega Date)
            // agregar a retirados
        }
        return false;
    }
    
     /* ****************************************************************************************************
        ********************************** Consultas de Entregables ****************************************
        **************************************************************************************************** */
    
    public boolean consultarEstadoCasillero(String pCedula){
        if (this.expedienteClientes.containsKey(pCedula)){
            int numCasillero = this.expedienteClientes.get(pCedula).getNumeroCasillero();
            int llave = this.llaves.get(numCasillero);
            if (!this.casilleros.get(llave).getArticulos().isEmpty()){
                return true;
            }
        }
        return false;
    }
    
    public boolean consultarEstadoCasillero(int pNumCasillero){
         if (this.llaves.containsKey(pNumCasillero)){
            int llave = this.llaves.get(pNumCasillero);
            if (!this.casilleros.get(llave).getArticulos().isEmpty()){
                return true;
            }
        }
        return false;
    }
    
    public String recibidosEnFecha(){
        String str = "";
        return str;
    }
    
    public String entregadosEnFecha(){
        String str = "";
        return str;
    }
    
     /* ****************************************************************************************************
        ************************************ Consultas de Divisas ******************************************
        **************************************************************************************************** */
    
    public int compraDivisa(){
        return 0;
    }
    
    
    
}
