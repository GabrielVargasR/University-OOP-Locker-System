package model;

/**
 *
 * @author gabriel
 */
public class Revista extends Articulo{

    private String nombre;
    private boolean catalogo;
    private TTemaRevista tema;

    public Revista(String pDescripcion, String pRemitente, String pNombre, boolean pCatalogo, TTemaRevista pTema) {
        super(pDescripcion, pRemitente);
        this.nombre = pNombre;
        this.catalogo = pCatalogo;
        this.tema = pTema;
        
        if (!this.catalogo){
            super.impuesto = 1;
        }
    }

    public String getNombre() {
        return this.nombre;
    }

    public boolean isCatalogo() {
        return this.catalogo;
    }

    public TTemaRevista getTema() {
        return this.tema;
    }
}
