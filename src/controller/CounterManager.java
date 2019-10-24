package controller;

import java.util.Date;

/**
 *
 * @author gabriel
 */
public class CounterManager {
    private Counter counter;
    
    public CounterManager(){
        
    }
    
    public void creaCounter(String pNombre, String pCedula, String pDireccion, int pCantidadCasilleros){
        this.counter = new Counter(pNombre, pCedula, pDireccion, pCantidadCasilleros);
    }
    
    public boolean agregarCliente(String pIdentificador, String pNombre, String pCorreo, String pTelefono, String pDirección, String pSexo, Date pNacimiento){
        
        return false;
    }
    
}
