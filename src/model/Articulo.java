package model;

import java.util.UUID;

/**
 *
 * @author Usuario
 */
public class Articulo {

    protected UUID id;
    protected boolean estado;
    protected String descripciones;
    protected Cliente remitente;

    public Articulo(UUID id, boolean estado, String descripciones, Cliente remitente) {
        this.id = id;
        this.estado = estado;
        this.descripciones = descripciones;
        this.remitente = remitente;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getDescripciones() {
        return descripciones;
    }

    public void setDescripciones(String descripciones) {
        this.descripciones = descripciones;
    }

    public Cliente getRemitente() {
        return remitente;
    }

    public void setRemitente(Cliente remitente) {
        this.remitente = remitente;
    }

    @Override
    public String toString() {
        return "Articulo{" + "id=" + id + ", estado=" + estado + ", descripciones=" + descripciones + ", remitente=" + remitente + '}';
    }
    
    
    
}
