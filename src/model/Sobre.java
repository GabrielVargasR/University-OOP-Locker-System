package model;

import model.TTipoSobre;
import model.TContenidoSobre;


/**
 *
 * @author Gabriel
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
        
        if (this.tipo == TTipoSobre.Aéreo){
            if (this.contenido == TContenidoSobre.ArticuloPequeño){
                super.impuestoDolar = 1;
                super.calculoImpDolar += "Aéreo y Artículo Pequeño: paga $1";
            } else {super.calculoImpDolar += "Aéreo y Documento no paga impuestos";}
        } else{
            if (this.contenido == TContenidoSobre.Documento){
                super.impuestoDolar = 1;
                super.calculoImpDolar += "Manila y Documento : paga $1";
            } else{
                super.impuestoDolar = 2;
                super.calculoImpDolar += "Manila y Artículo Pequeño: paga $2";
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
