package model;

/**
 *
 * @author gabriel
 */
public class Paquete extends Articulo{

    private boolean electronico;
    private boolean fragil;
    private double peso;

    public Paquete(String pDescripcion, String pRemitente, boolean pElectronico, boolean pFragil, double pPeso) {
        super(pDescripcion, pRemitente);
        this.electronico = pElectronico;
        this.fragil = pFragil;
        this.peso = pPeso;
        
        double imp = this.peso * 0.02;
        if (electronico){
            imp += 2;
        } 
        if (fragil){
            imp += 2;
        }
        super.impuesto = imp;
    }

    public boolean isElectronico() {
        return this.electronico;
    }

    public boolean isFragil() {
        return this.fragil;
    }

    public double getPeso() {
        return this.peso;
    }
}
