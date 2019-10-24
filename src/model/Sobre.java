package model;

import model.TTipoSobre;
import model.TContenidoSobre;


/**
 *
 * @author gabriel
 */
public class Sobre extends Articulo {

    private double peso;
    private TTipoSobre tipo;
    private TContenidoSobre contenido;
    

    public Sobre(String pDescripcion, Cliente pCliente, double pPeso, TTipoSobre pTipo, TContenidoSobre pContenido){
        super(pDescripcion, pCliente);
        this.peso = pPeso;
        this.tipo = pTipo;
        this.contenido = pContenido;
    }
    
    public double getPeso(){
        return this.peso;
    }
    
    public TTipoSobre getTipo(){
        return this.tipo;
    }
    
    public TContenidoSobre getContenido(){
        return this.contenido;
    }
}
