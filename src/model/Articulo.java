package model;

import java.util.UUID;
import java.util.Date;

/**
 *
 * @author gabriel
 */
public class Articulo {

    protected UUID id;
    private boolean retirado; // retirado o no
    private final String descripcion;
    private final String remitente;
    private double impuestoColones;
    private String calculoImpCol;
    protected double impuestoDolar;
    protected String calculoImpDolar;
    private Date fechaRecibido;
    private Date fechaRetirado;

    public Articulo(String pDescripcion, String pRemitente) {
        this.id = UUID.randomUUID();
        this.retirado = false;
        this.descripcion = pDescripcion;
        this.remitente = pRemitente;
        this.impuestoColones = 0;
        this.calculoImpCol = "";
        this.impuestoDolar = 0;
        this.calculoImpDolar = "";
        
    }

    public UUID getId() {
        return this.id;
    }

    public boolean isRetirado() {
        return this.retirado;
    }

    public void retirar() {
        this.retirado = true;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public String getRemitente(){
        return this.remitente;
    }
    
    public double getImpuestoColones(double pTipoCambio){
        this.impuestoColones = this.impuestoDolar * pTipoCambio;
        this.calculoImpCol += this.impuestoDolar + " x " + pTipoCambio;
        return this.impuestoColones;
    }
    
    public String getCalculoImpColones(){
        return this.calculoImpCol;
    }
    
    public String getCalculoImpDolar(){
        return this.calculoImpDolar;
    }
    
    public double getImpuestoDolar(){
        return this.impuestoDolar;
    }

    public Date getFechaRecibido() {
        return this.fechaRecibido;
    }

    public void setFechaRecibido(Date pFechaRecibido) {
        this.fechaRecibido = pFechaRecibido;
    }

    public Date getFechaRetirado() {
        return this.fechaRetirado;
    }

    public void setFechaRetirado(Date pFechaRetirado) {
        this.fechaRetirado = pFechaRetirado;
    }
    
    
}
