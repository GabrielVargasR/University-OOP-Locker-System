package model;

import java.util.UUID;

/**
 *
 * @author gabriel
 */
public class Articulo {

    protected UUID id;
    protected boolean entregado; // retirado o no
    protected String descripcion;
    protected Cliente remitente;
    protected double impuesto;

    public Articulo(String pDescripcion, Cliente pCliente) {
        this.id = UUID.randomUUID();
        this.entregado = false;
        this.descripcion = pDescripcion;
        this.remitente = pCliente;
        this.impuesto = 0;
    }

    public UUID getId() {
        return this.id;
    }

    public boolean getEstado() {
        return this.entregado;
    }

    public void entregado() {
        this.entregado = true;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public Cliente getRemitente(){
        return this.remitente;
    }
    
    public double getImpuesto(){
        return this.impuesto;
    }
}
