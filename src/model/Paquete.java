package model;

/**
 *
 * @author gabriel
 */
public class Paquete extends Articulo{

    private boolean electronico;
    private boolean fragil;
    private double peso;

    public Paquete(String pDescripcion, Cliente pCliente, boolean pElectronico, boolean pFragil, double pPeso) {
        super(pDescripcion, pCliente);
        this.electronico = pElectronico;
        this.fragil = pFragil;
        this.peso = pPeso;
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
