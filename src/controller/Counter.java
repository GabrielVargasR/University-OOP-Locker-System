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
import java.util.Date;
import model.TContenidoSobre;
import model.TTemaRevista;
import model.TTipoSobre;

/**
 *
 * @author Gabriel
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
     * Función para conseguir un cliente en específico
     * @param pCedula número de cédula del cliente a consultar
     * @return Cliente consultado
     */
    public Cliente getCliente(String pCedula){
        if (this.gestorClientes.existeCliente(pCedula)){
            return this.gestorClientes.getCliente(pCedula);
        } 
        return null;
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
    
    /**
     * Función para consultar todos los clientes registrados
     * @return ArrayList de todos los clientes registrados
     */
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
            Cliente cliente = this.gestorClientes.getCliente(pCedula);
            int numCasillero = cliente.getNumeroCasillero();
            Paquete articulo = new Paquete(pDescripcion, pRemitente, pElectronico, pFragil, pPeso);
            this.gestorCasilleros.recibirPaquete(numCasillero, articulo);
            String subject = "Paquete recibido";
            String contenido = "Ha recibido un nuevo paquete en su casillero\n";
            contenido += articulo.toString() + "\nEnviado por: " + pRemitente;
            this.correos.enviarCorreo(cliente.getCorreo(), subject, contenido);
            if(cliente.incPaquetesRecibidos()){
                String subject2 = "Cambio de nivel";
                String contenido2 = "Felicidades, has pasado a nivel " + cliente.getNivel();
                this.correos.enviarCorreo(cliente.getCorreo(), subject2, contenido2);
            }
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
            Cliente cliente = this.gestorClientes.getCliente(pCedula);
            int numCasillero = cliente.getNumeroCasillero();
            Revista articulo = new Revista(pDescripcion, pRemitente, pNombre, pCatalogo, pTema);
            this.gestorCasilleros.recibirPaquete(numCasillero, articulo);
            String subject = "Paquete recibido";
            String contenido = "Ha recibido uns nueva revista en su casillero\n";
            contenido += articulo.toString() + "\nEnviado por: " + pRemitente;
            this.correos.enviarCorreo(cliente.getCorreo(), subject, contenido);
            if(cliente.incPaquetesRecibidos()){
                String subject2 = "Cambio de nivel";
                String contenido2 = "Felicidades, has pasado a nivel " + cliente.getNivel();
                this.correos.enviarCorreo(cliente.getCorreo(), subject2, contenido2);
            }
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
            Cliente cliente = this.gestorClientes.getCliente(pCedula);
            int numCasillero = cliente.getNumeroCasillero();
            Sobre articulo = new Sobre(pDescripcion, pRemitente, pPeso, pTipo, pContenido);
            this.gestorCasilleros.recibirPaquete(numCasillero, articulo);
            String subject = "Paquete recibido";
            String contenido = "Ha recibido un nuevo sobre en su casillero\n";
            contenido += articulo.toString() + "\nEnviado por: " + pRemitente;
            this.correos.enviarCorreo(cliente.getCorreo(), subject, contenido);
            if(cliente.incPaquetesRecibidos()){
                String subject2 = "Cambio de nivel";
                String contenido2 = "Felicidades, has pasado a nivel " + cliente.getNivel();
                this.correos.enviarCorreo(cliente.getCorreo(), subject2, contenido2);
            }
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
    
    /**
     * Función para calcular el precio total en dolares de los artículos seleccionados
     * @param pArticulosSeleccionados ArrayList de articulos seleccionados en la gui para retirar
     * @param pCedula número de cédula del cliente que está retirando
     * @return precio total de los artículos a retirar
     */
    public double calculaTotalDolares(ArrayList<Articulo> pArticulosSeleccionados, String pCedula){
        double subTotalDolar = 0;
        for (Articulo articulo : pArticulosSeleccionados){
            subTotalDolar += articulo.getImpuestoDolar();
        }
        Cliente cliente = this.gestorClientes.getCliente(pCedula);
        return cliente.pedirDescuento(subTotalDolar);
    }
    
    /**
     * Función para calcular el precio total en colones de los artículos seleccionados
     * @param pArticulosSeleccionados ArrayList de articulos seleccionados en la gui para retirar
     * @param pCedula número de cédula del cliente que está retirando
     * @return precio total de los artículos a retirar
     */
    public double calculaTotalColones(ArrayList<Articulo> pArticulosSeleccionados, String pCedula){
        double tipoCambio = this.compraDivisa();
        double subTotalDolar = 0;
        double subTotalColones = 0;
        for (Articulo articulo : pArticulosSeleccionados){
            subTotalDolar += articulo.getImpuestoDolar();
            subTotalColones += articulo.getImpuestoColones(tipoCambio);
        }
        Cliente cliente = this.gestorClientes.getCliente(pCedula);
        return cliente.pedirDescuento(subTotalColones);
    }
    
    /**
     * Función para retirar los paquetes
     * @param pArticulosSeleccionados ArrayList de articulos seleccionados en la gui para retirar
     * @param pCedula número de cédula del cliente que está retirando
     * @return boolean para indicar si se pudo retirar o no los artículos
     */
    public boolean retirarArticulos(ArrayList<Articulo> pArticulosSeleccionados, String pCedula){
        int numCasillero = this.gestorClientes.getCliente(pCedula).getNumeroCasillero();
        if (this.gestorCasilleros.retirarPaquetes(numCasillero, pArticulosSeleccionados)){
            return true;
        }
       return false;
    }

    /* ****************************************************************************************************
       ************************************ Consultas de Entregables **************************************
       **************************************************************************************************** */
    
    /**
     * Función para determinar si el casillero de un cliente está vacío o no
     * @param pCedula número de cédula del cliente
     * @return boolean para indicar si es†á vacío (false) o no (true)
     */
    public boolean estadoCasillero(String pCedula){
        if (this.gestorClientes.existeCliente(pCedula)){
            int numCasillero = this.gestorClientes.getCliente(pCedula).getNumeroCasillero();
            return this.gestorCasilleros.estadoCasillero(numCasillero);
        }
        return false;
    }
    
    /**
     * Función para determinar si un casillero está vacío o no
     * @param pNumCasillero número de casillero del cliente
     * @return boolean para indicar si es†á vacío (false) o no (true)
     */
    public boolean estadoCasillero(int pNumCasillero){
        return this.gestorCasilleros.estadoCasillero(pNumCasillero);
    }
    
    public void detalleRecibidos(Date pDate){}
    
    public void detalleEntregados(Date pDate){}
    
    public void articulosPendientes(){}
    
    /**
     * Función para obtener la información de pago de un artículo retirado
     * @param pArticulo artículo seleccionado
     * @return String con la información de retiro
     */
    public String detalleRetiro(Articulo pArticulo){
        String str = "Dólares: " + pArticulo.getCalculoImpDolar() + " " + pArticulo.getCalculoImpDolar() + "\n";
        str += "Colones: " + pArticulo.getImpuestoColones(this.ventaDivisa()) + " " + pArticulo.getCalculoImpColones();
        return str;
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
    
    public void enviarCorreo(){}
    
    public ArrayList<Cliente> clientsPendientes(){
        ArrayList<Cliente> listado = new ArrayList<Cliente>();
        for (Cliente cliente : this.gestorClientes.consultarClientes()){
            ArrayList<Articulo> pendientes = this.gestorCasilleros.getArticulosCasillero(cliente.getNumeroCasillero());
            if (!pendientes.isEmpty()){
                listado.add(cliente);
                cliente.setCantidadPendientes(listado.size());
            }
        }
        return listado;
    }
    
    public void resumenContable(Date pDate){}
    
    public static void main(String[] args){
        Counter counter = new Counter("", "", "", 15);
        counter.registrarCliente("117560590", "Gabriel", "gabriel.vargasr99@gmail.com", "12121212", "aaaa", "Masculino", 1999, 9, 29);
        System.out.println(counter.consultarCliente("117560590"));
    }
}
