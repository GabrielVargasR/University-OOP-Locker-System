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
    

    public Sobre(String pDescripcion, String pRemitente, double pPeso, TTipoSobre pTipo, TContenidoSobre pContenido){
        super(pDescripcion, pRemitente);
        this.peso = pPeso;
        this.tipo = pTipo;
        this.contenido = pContenido;
        
        if (this.tipo == TTipoSobre.Aéreo && this.contenido == TContenidoSobre.ArticuloPequeño){
            super.impuesto = 1;
        } else{
            if (this.contenido == TContenidoSobre.Documento){
                super.impuesto = 1;
            } else{
                super.impuesto = 2;
            }
        }
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
