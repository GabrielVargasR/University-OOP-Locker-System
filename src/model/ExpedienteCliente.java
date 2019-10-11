

package model;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ExpedienteCliente {
    
    private ArrayList<Cliente> clientes;

    public ExpedienteCliente(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    public void addCliente(Cliente pCliente) {
        this.clientes.add(pCliente);
    }
    
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    
    
    public int size(){
        return this.clientes.size();
    }
    
    public void setNuevoCliente(Cliente pCliente){
        this.clientes.add(pCliente);
    }
    
    public Cliente getClienteEspecifico(String pCedula){
        for (int i = 0; i < clientes.size(); i++) {
            Cliente get = clientes.get(i);
               if (get.getCedula().equals(pCedula)){
                   return get;
               }
        }
        return null;
    }

    void setClientes(Cliente pCliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

