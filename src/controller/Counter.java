package controller;

import model.Cliente;
import model.Articulo;
import model.Paquete;
import model.Revista;
import model.Sobre;
import model.GestorCasilleros;
import model.GestorClientes;
import model.ManejoCorreos;
import model.BCCRClient;

import java.util.ArrayList;
import model.TContenidoSobre;
import model.TTemaRevista;
import model.TTipoSobre;

/**
 *
 * @author gabriel
 */
public class Counter {
    private String nombre;
    private String cedulaJuridica;
    private String direccion;
    private GestorClientes gestorClientes;
    private GestorCasilleros gestorCasilleros;
    private ManejoCorreos correos;
    private BCCRClient webBanco;
    
    /**
     * Constructor de la clase counter
     * @param pNombre nombre del counter
     * @param pCedula cédula jurídica
     * @param pDireccion dirección del counter
     * @param pCantidadCasilleros número de casilleros que va a tener el counter
     */
    public Counter(String pNombre, String pCedula, String pDireccion, int pCantidadCasilleros){
        this.nombre = pNombre;
        this.cedulaJuridica = pCedula;
        this.direccion = pDireccion;
        this.gestorClientes = new GestorClientes();
        this.gestorCasilleros = new GestorCasilleros(pCantidadCasilleros);
        this.correos = ManejoCorreos.getInstance();
        this.webBanco = BCCRClient.getInstance();
    }
    
    /* ***************************************************************************************************
       ********************************** Administración de Clientes *************************************
       *************************************************************************************************** */
    
    /**
     * Función para registrar un cliente al counter. Recibe info de la gui y lo pasa al gestor de clientes
     * Asigna casillero al cliente
     * @param pCedula cédula del cliente a modificar
     * @param pNombre nombre del cliente
     * @param pCorreo correo del cliente
     * @param pTelefono número de teléfono del cliente
     * @param pDireccion dirección del cliente
     * @param pSexo sexo del cliente
     * @param pDia día de nacimiento del cliente
     * @param pMes mes de nacimiento del cliente
     * @param pAnno año de nacimiento del cliente
     * @return número de casillero asignado. Si no se logra ingresar, retorna un 0
     */
    public int registrarCliente(String pCedula, String pNombre, String pCorreo, String pTelefono, String pDireccion, String pSexo, int pDia, int pMes, int pAnno){
        if (this.gestorClientes.registrarCliente(pCedula, pNombre, pCorreo, pTelefono, pDireccion, pSexo, pDia, pMes, pAnno)){
            return this.gestorCasilleros.asignarCasillero(this.gestorClientes.getCliente(pCedula));
        }
        return 0;
    }
    
    /**
     * Función para modificar los datos de un cliente al counter. Recibe info de la gui y lo pasa al gestor de clientes
     * @param pCedula cédula del cliente a modificar
     * @param pNombre nombre del cliente
     * @param pCorreo correo del cliente
     * @param pTelefono número de teléfono del cliente
     * @param pDireccion dirección del cliente
     * @param pSexo sexo del cliente
     * @param pDia día de nacimiento del cliente
     * @param pMes mes de nacimiento del cliente
     * @param pAnno año de nacimiento del cliente
     * @return número de casillero del cliente. Si no logra modificar, retorna un 0
     */
    public int modificarCliente(String pCedula, String pNombre, String pCorreo, String pTelefono, String pDireccion, String pSexo, int pDia, int pMes, int pAnno){
        if (this.gestorClientes.existeCliente(pCedula)){
            return this.gestorClientes.modificarCliente(pCedula, pNombre, pCorreo, pTelefono, pDireccion, pSexo, pDia, pMes, pAnno);
        }
        return 0;
    }
    
    /**
     * Función para consultar la información de un cliente
     * @param pCedula número de cédula del cliente a consultar
     * @return String con la información del cliente
     */
    public String consultarCliente(String pCedula){
        if (this.gestorClientes.existeCliente(pCedula)){
            String str = this.gestorClientes.getCliente(pCedula).toString();
            str += "Artículos pendientes:\n";
            str += this.gestorCasilleros.getContenidoCasillero(this.gestorClientes.getCliente(pCedula).getNumeroCasillero());
            return str;
        }
        return "No existe cliente con esa cédula";
    }
    
    /**
     * Función para eliminar un cliente del sistema. Verifica que el casillero del cliente esté vacío y lo desocupa
     * @param pCedula número de cédula del cliente a eliminar
     * @return String con mensaje de éxito o fallo
     */
    public String eliminarCliente(String pCedula){
        if (this.gestorClientes.existeCliente(pCedula)){
            int numCasillero = this.gestorClientes.getCliente(pCedula).getNumeroCasillero();
            if (this.gestorCasilleros.liberarCasillero(numCasillero)){
                this.gestorClientes.eliminarCliente(pCedula);
                return "Cliente eliminado con éxito";
            }
            return "Para eliminar cliente, debe retirar los artículos pendientes primero";
        }
        return "No existe cliente con esa cédula";
    }
    
    public ArrayList<Cliente> consultarClientes(){
        return this.gestorClientes.consultarClientes();
    }
    
    /* ***************************************************************************************************
       ********************************** Administración de Artículos ************************************
       *************************************************************************************************** */
    
    /**
     * Función para enviar un artículo de tipo Paquete a un cliente
     * @param pCedula número de cédula del cliente a quien se desea enviar el artículo
     * @param pDescripcion descripción del artículo
     * @param pRemitente nombre de quien envía el paquete
     * @param pElectronico indica si el contenido del paquete es electrónico
     * @param pFragil indica si el contenido del paquete es frágil
     * @param pPeso peso del paquete
     * @return boolean para indicar si se envió o no el paquete
     */
    public boolean enviarArticulo(String pCedula, String pDescripcion, String pRemitente, boolean pElectronico, boolean pFragil, double pPeso){
        if (this.gestorClientes.existeCliente(pCedula)){
            int numCasillero = this.gestorClientes.getCliente(pCedula).getNumeroCasillero();
            Paquete articulo = new Paquete(pDescripcion, pRemitente, pElectronico, pFragil, pPeso);
            this.gestorCasilleros.recibirPaquete(numCasillero, articulo);
            String subject = "Paquete recibido";
            String contenido = "Ha recibido un nuevo paquete en su casillero\n";
            contenido += articulo.toString() + "\nEnviado por: " + pRemitente;
            this.correos.enviarCorreo(this.gestorClientes.getCliente(pCedula).getCorreo(), subject, contenido);
            return true;
        }
        return false;
    }
    
    /**
     * Función para enviar un artículo de tipo Revista a un cliente
     * @param pCedula número de cédula del cliente a quien se desea enviar el artículo
     * @param pDescripcion descripción del artículo
     * @param pRemitente nombre de quien envía el paquete
     * @param pNombre nombre de la revista
     * @param pCatalogo boolean para indicar si la revista es parte de un catálogo o no
     * @param pTema categoría de la revista
     * @return boolean para indicar si se envió o no el paquete
     */
    public boolean enviarArticulo(String pCedula, String pDescripcion, String pRemitente, String pNombre, boolean pCatalogo, TTemaRevista pTema){
        if (this.gestorClientes.existeCliente(pCedula)){
            int numCasillero = this.gestorClientes.getCliente(pCedula).getNumeroCasillero();
            Revista articulo = new Revista(pDescripcion, pRemitente, pNombre, pCatalogo, pTema);
            this.gestorCasilleros.recibirPaquete(numCasillero, articulo);
            String subject = "Paquete recibido";
            String contenido = "Ha recibido uns nueva revista en su casillero\n";
            contenido += articulo.toString() + "\nEnviado por: " + pRemitente;
            this.correos.enviarCorreo(this.gestorClientes.getCliente(pCedula).getCorreo(), subject, contenido);
            return true;
        }
        return false;
    }
    
    /**
     * Función para enviar un artículo de tipo Sobre a un cliente
     * @param pCedula número de cédula del cliente a quien se desea enviar el artículo
     * @param pDescripcion descripción del artículo
     * @param pRemitente nombre de quien envía el paquete
     * @param pPeso peso del contenido del sobre
     * @param pTipo tipo de sobre
     * @param pContenido contenido del sobre
     * @return boolean para indicar si se envió o no el paquete
     */
    public boolean enviarArticulo(String pCedula, String pDescripcion, String pRemitente, double pPeso, TTipoSobre pTipo, TContenidoSobre pContenido){
        if (this.gestorClientes.existeCliente(pCedula)){
            int numCasillero = this.gestorClientes.getCliente(pCedula).getNumeroCasillero();
            Sobre articulo = new Sobre(pDescripcion, pRemitente, pPeso, pTipo, pContenido);
            this.gestorCasilleros.recibirPaquete(numCasillero, articulo);
            String subject = "Paquete recibido";
            String contenido = "Ha recibido un nuevo sobre en su casillero\n";
            contenido += articulo.toString() + "\nEnviado por: " + pRemitente;
            this.correos.enviarCorreo(this.gestorClientes.getCliente(pCedula).getCorreo(), subject, contenido);
            return true;
        }
        return false;
    }
    
    /**
     * Función para conseguir los artículos del casillero de un cliente en específico
     * @param pCedula número de cédula del dueño del casillero a consultar
     * @return ArrayList con los artículos en el casillero del cliente. Retorna null sin no se encuentra el cliente
     */
    public ArrayList<Articulo> getArticulosPendientes(String pCedula){
        if (this.gestorClientes.existeCliente(pCedula)){
            int numCasillero = this.gestorClientes.getCliente(pCedula).getNumeroCasillero();
            return this.gestorCasilleros.getArticulosCasillero(numCasillero);
        } 
        return null;
    }
    
    public boolean retirarArticulos(ArrayList<Articulo> pArticulosSeleccionados){
        return false;
    }
    
    
    
    
    /* ****************************************************************************************************
       ************************************ Consultas de Divisas ******************************************
       **************************************************************************************************** */
    
    public double compraDivisa(){
       return this.webBanco.getCompra();
    }
    
    public double ventaDivisa(){
        return this.webBanco.getVenta();
    }
    
    /* ****************************************************************************************************
        ****************************************** Generales ***********************************************
        **************************************************************************************************** */    
    
//    public ArrayList<Cliente> pendientes(){
//        ArrayList<Cliente> listado = new ArrayList<Cliente>();
//        
//        for (String cedula : this.expedienteClientes.keySet()){
//            Cliente cliente = this.expedienteClientes.get(cedula);
//            int llave = this.llaves.get(cliente.getNumeroCasillero());
//            if (!this.casilleros.get(llave).getArticulos().isEmpty()){
//                listado.add(cliente);
//            }
//        }
//        return listado;
//    }
}
