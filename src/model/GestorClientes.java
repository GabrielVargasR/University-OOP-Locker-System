package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

/**
 *
 * @author Gabriel
 */
public class GestorClientes {
    private HashMap<String, Cliente> expedienteClientes;
    
    public GestorClientes(){
        this.expedienteClientes = new HashMap<String, Cliente>();
    }
    
    public Cliente getCliente(String pCedula){
        return this.expedienteClientes.get(pCedula);
    }
    
    public boolean existeCliente(String pCedula){
        return this.expedienteClientes.containsKey(pCedula);
    }
    
    public boolean registrarCliente(String pCedula, String pNombre, String pCorreo, String pTelefono, String pDireccion, String pSexo, int pDia, int pMes, int pAnno){
        
        if (!this.expedienteClientes.containsKey(pCedula)){
            Date fechaNacimiento = new Date(pDia, (pMes-1), (pAnno-1900));
            Cliente clienteNuevo = new Cliente(pCedula, pNombre, pCorreo, pTelefono, pDireccion, pSexo, fechaNacimiento);
            this.expedienteClientes.put(pCedula, clienteNuevo);
            return true;
        }
        return false;
    }
    
    public int modificarCliente(String pCedula, String pNombre, String pCorreo, String pTelefono, String pDireccion, String pSexo, int pDia, int pMes, int pAnno){
        Cliente cliente = this.expedienteClientes.get(pCedula);
        cliente.setNombre(pNombre);
        cliente.setCorreo(pCorreo);
        cliente.setTelefono(pTelefono);
        cliente.setDireccion(pDireccion);
        cliente.setSexo(pSexo);
        cliente.setFechaNacimiento(pDia, pMes, pAnno);
        return cliente.getNumeroCasillero();
    }
    
    public void eliminarCliente(String pCedula){
        Cliente cliente = this.expedienteClientes.get(pCedula);
        this.expedienteClientes.remove(pCedula, cliente);
    }
    
    public ArrayList<Cliente> consultarClientes(){
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        clientes.addAll(this.expedienteClientes.values());
        return clientes;
    }
    
    public static void main(String[] args){
        GestorClientes gc = new GestorClientes();
        gc.registrarCliente("117560590", "Gabriel", "gabriel.vargasr99@gmail.com", "12121212", "sdsw", "Masculino", 1999, 9, 29);
        System.out.println(gc.getCliente("117560590").toString());
    }
}
