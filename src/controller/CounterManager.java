package controller;

import java.util.Date;
import model.Cliente;

/**
 *
 * @author gabriel
 */
public class CounterManager {
    private CounterManager singleton;
    private Counter counter;
    
    private CounterManager(){}
    
    public CounterManager getInstance(){
        if (this.singleton == null){
            this.singleton = new CounterManager();
        }
        return this.singleton;
    }
    
    public void creaCounter(String pNombre, String pCedula, String pDireccion, int pCantidadCasilleros){
        this.counter = new Counter(pNombre, pCedula, pDireccion, pCantidadCasilleros);
    }
    
    public boolean agregarCliente(String pCedula, String pNombre, String pCorreo, String pTelefono, String pDireccion, String pSexo, int diaN, int mesN, int annoN){
        Date fechaNacimiento = new Date(annoN, mesN, diaN);
        Cliente clienteNuevo = new Cliente(pCedula, pNombre, pCorreo, pTelefono, pDireccion, pSexo, fechaNacimiento);
        
        if (counter.registrarCliente(clienteNuevo)){
            return true;
        }
        return false;
    }
    
    public boolean enviarArticulo(){
        return false;
    }
    
}
