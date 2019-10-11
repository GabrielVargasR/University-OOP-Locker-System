/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Rayforth
 */
public class Paquete {

    private boolean electronico;
    private boolean fragil;
    private int peso;

    public Paquete(boolean electronico, boolean fragil, int peso) {
        this.electronico = electronico;
        this.fragil = fragil;
        this.peso = peso;
    }

    public boolean isElectronico() {
        return electronico;
    }

    public void setElectronico(boolean electronico) {
        this.electronico = electronico;
    }

    public boolean isFragil() {
        return fragil;
    }

    public void setFragil(boolean fragil) {
        this.fragil = fragil;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    
    



}
