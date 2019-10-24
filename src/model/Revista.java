package model;

/**
 *
 * @author gabriel
 */
public class Revista extends Articulo{

    private String nombre;
    private boolean catalogo;
    private TTemaRevista tema;

    public Revista(String pDescripcion, Cliente pCliente, String pNombre, boolean pCatalogo, TTemaRevista pTema) {
        super(pDescripcion, pCliente);
        this.nombre = pNombre;
        this.catalogo = pCatalogo;
        this.tema = pTema;
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
