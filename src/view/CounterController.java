/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import controller.Counter;

/**
 * FXML Controller class
 *
 * @author Rayforth
 * @author Josué
 */
public class CounterController implements Initializable {
    
    private Counter counter;
    private Pane current;
    
    @FXML
    private Pane ModificarSistema;    
    @FXML
    private Pane panel;
    @FXML
    private Pane PaneRegistrarCliente;
    @FXML
    private Pane PaneConsultarCliente;
    @FXML
    private Pane PaneModificarCliente;
    @FXML
    private Pane PaneEliminarCliente;
    @FXML
    private Pane PaneClientesRegistrados;
    @FXML
    private Pane Sobre;
    @FXML
    private Pane Paquete; 
    @FXML
    private Pane Revista;
    @FXML
    private Pane Retirar; 
    @FXML
    private Pane EstadoCasillero;   
    @FXML
    private Pane ArticulosRecibidosFecha;
    @FXML
    private Pane ArticulosEntregadosFecha;
    @FXML
    private Pane ArticulosPendientesRetirar;
    @FXML
    private Pane RetiroArticulos;
    @FXML
    private Pane CompraDolar;
    @FXML
    private Pane VentaDolar;
    @FXML
    private Pane ClientesPaquetesPendientes;
    @FXML
    private Pane DineroRecaudadoFecha;
    @FXML
    private MenuBar menu;
    @FXML
    private Menu RecepcionArticulos;
    
    //Para creación del counter
    
    @FXML
    private TextField nombreCounter;
    @FXML
    private TextField cedulaCounter;
    @FXML
    private TextField direccionCounter;
    @FXML
    private TextField cantidadCounter;
    @FXML
    private ToggleGroup tgGroup;
    @FXML
    private Button crearCounter;
    @FXML
    private Label mensaje;
    
    
    //Para registro del cliente:
    
    @FXML
    private TextField nombreCliente;
    @FXML
    private TextField cedulaCliente;
    @FXML
    private TextField direccionCorreoCliente;
    @FXML
    private TextField telefonoCliente;
    @FXML
    private Label mensajeRegistroCliente;
    
    //Para consultar cliente
    
    @FXML
    private TextField cedulaClienteConsulta;
    @FXML
    private Label mensajeConsultaCliente;
    
    //Para modificar cliente
    
    @FXML
    private TextField cedulaModifica ;
    @FXML
    private Label mensajeModifica;
    @FXML
    private Pane paneCambiarDatosCliente;
    
    //Para eliminar cliente 
    @FXML
    private TextField clienteAEliminar;
    @FXML
    private Label mensajeEliminado;
    
    //Para revista 
    @FXML
    private TextField remitenteRevista;
    @FXML
    private TextField descripcionRevista;
    @FXML
    private TextField nombreRevista;
    @FXML
    private Label mensajeRevista;
    
     //Para sobre
    @FXML
    private TextField remitenteSobre;
    @FXML
    private TextField descripcionSobre;
    @FXML
    private TextField pesoSobre;
    @FXML
    private Label mensajeSobre;
     
    //Para Paquete
    @FXML
    private TextField remitentePaquete;
    @FXML
    private TextField descripcionPaquete;
    @FXML
    private TextField pesoPaquete;
    @FXML
    private Label mensajePaquete;
    
    //Para retirar paquete
    @FXML
    private TextField identificacionRetirar;
    
    @FXML
    private Label mensajeRetirar;
    
    //Para consulta de estado de casillero
    @FXML
    private TextField consulaNumeroCasillero;
    @FXML
    private TextField consulaNumeroCliente;
    @FXML
    private Label mensajeEstadoCasillero;
    
    //Para Articulos recibios por una fecha
    @FXML
    private ChoiceBox diaArticulosRecibidos;
    @FXML
    private ChoiceBox mesArticulosRecibidos;
    @FXML
    private ChoiceBox anioArticulosRecibidos;
    
    //Para modificar opciones
    @FXML
    private TextField modificarCantidad;
    @FXML
    private TextField porcentaje;
    @FXML
    private Label mensajeModificar;
    @FXML
    private ImageView Imagen;
    
    /**
     * Metodo que realiza la actualizacion de ventanas
     * @param pPane es el pane que va actualizar
     */
    private void refresh(Pane pPane){
        if(current != null){
            current.setVisible(false);
            current = pPane;
            pPane.setVisible(true);
        }else{
            current=pPane;
            pPane.setVisible(true);
        }
    }
    
    /**
     * Metodo que muestra la ventana de modificar el sistema
     * @param event action que va a realizar
     */
    @FXML
    private void mostrarModificarSistema(ActionEvent event){
        refresh(ModificarSistema);   
    }
    
    /**
     * Metodo que quita la ventana principal 
     * @param event action a realizar
     */
    @FXML
    private void quitarPaneCounter(){
        panel.setVisible(false);
        menu.setVisible(true);
        Imagen.setVisible(true);
        
    }
    
    /**
     * Metodo que muestra la ventana de Registrar un Cliente
     * @param e Action a realizar
     */
    @FXML
    private void mostrarPaneRegistarCliente(ActionEvent e){
        refresh(PaneRegistrarCliente);    
    }
    
    /**
     * Metodo que muestra la ventana de Consultar un Cliente
     * @param e Action a realizar
     */
    @FXML
    private void mostrarPaneConsultarCliente(ActionEvent e){
        refresh(PaneConsultarCliente);    
    }
    
    /**
     * Metodo que muestra la ventana de Modificar un Cliente
     * @param e Action a realizar
     */
    @FXML
    private void mostrarPaneModificarCliente(ActionEvent e){
        refresh(PaneModificarCliente);    
    }

    /**
     * Metodo que muestra la ventana de Eliminar un Cliente
     * @param e Action a realizar
     */
    @FXML
    private void mostrarPaneEliminarCliente(ActionEvent e){
        refresh(PaneEliminarCliente);    
    }
    
    /**
     * Metodo que muestra la ventana deClientes Registrados
     * @param e Action a realizar
     */
    @FXML
    private void mostrarPaneClientesRegistrados(ActionEvent e){
        refresh(PaneClientesRegistrados);    
    }
    
    /**
     * Metodo que muestra la ventana de Sobre
     * @param e Action a realizar
     */
    @FXML
    private void mostrarSobre(ActionEvent e){
        refresh(Sobre);    
    }
    
    /**
     * Metodo que muestra la ventana de Paquete
     * @param e Action a realizar
     */
    @FXML
    private void mostrarPaquete(ActionEvent e){
        refresh(Paquete);    
    }
    
    /**
     * Metodo que muestra la ventana de Revista
     * @param e Action a realizar
     */
    @FXML
    private void mostrarRevista(ActionEvent e){
        refresh(Revista);    
    }
    
    /**
     * Metodo que muestra la ventana de Retirar
     * @param e Action a realizar
     */
    @FXML
    private void mostrarRetirar(ActionEvent e){
        refresh(Retirar);    
    }
    
    /**
     * Metodo que muestra la ventana de Estado del casillero
     * @param e Action a realizar
     */
    @FXML
    private void mostrarEstadoCasillero(ActionEvent e){
        refresh(EstadoCasillero);    
    }
    
    /**
     * Metodo que muestra la ventana de Articulos recibidos en una fecha
     * @param e Action a realizar
     */
    @FXML
    private void mostrarArticulosRecibidosFecha(ActionEvent e){
        refresh(ArticulosRecibidosFecha);    
    }
    
    /**
     * Metodo que muestra la ventana de Articulos entregados en una fecha
     * @param e Action a realizar
     */
    @FXML
    private void mostrarArticulosEntregadosFecha(ActionEvent e){
        refresh(ArticulosEntregadosFecha);    
    }
    
    /**
     * Metodo que muestra la ventana de Articulos pendientes de retirar
     * @param e Action a realizar
     */
    @FXML
    private void mostrarArticulosPendientesRetirar(ActionEvent e){
        refresh(ArticulosPendientesRetirar);    
    }
    
    /**
     * Metodo que muestra la ventana de retiro de alticulos
     * @param e Action a realizar
     */
    @FXML
    private void mostrarRetiroArticulos(ActionEvent e){
        refresh(RetiroArticulos);    
    }
    
    /**
     * Metodo que muestra la ventana de Compra del dolar
     * @param e Action a realizar
     */
    @FXML
    private void mostrarCompraDolar(ActionEvent e){
        refresh(CompraDolar);    
    }
    
    /**
     * Metodo que muestra la ventana de Venta del dolar
     * @param e Action a realizar
     */
    @FXML
    private void mostrarVentaDolar(ActionEvent e){
        refresh(VentaDolar);    
    }
    
    /**
     * Metodo que muestra la ventana de Clientes con paquetes pendientes
     * @param e Action a realizar
     */
    @FXML
    private void mostrarClientesPaquetesPendientes(ActionEvent e){
        refresh(ClientesPaquetesPendientes);    
    }
    
    /**
     * Metodo que muestra la ventana de Dinero recaudado en una fecha
     * @param e Action a realizar
     */
    @FXML
    private void mostrarDineroRecaudadoFecha(ActionEvent e){
        refresh(DineroRecaudadoFecha);    
    }
    
    /**
     * Método que crea el counter
     * @param e Action event 
     */
    @FXML
    private void crearCounter(ActionEvent e){
        
        refresh(panel);
        mensaje.setVisible(false);
        String nombre = nombreCounter.getText();
        String cedula = cedulaCounter.getText();
        String direccion = direccionCounter.getText();
        String cantidad = cantidadCounter.getText();
        
        if(!validaNombre(nombre)){
            mensaje.setText("El nombre ingresado no es válido");
            mensaje.setVisible(true);
        } else if(!validaCedula(cedula)){
            mensaje.setText("El número de cédula jurídico debe estar compuesto por 10 digitos");
            mensaje.setVisible(true);
        } else if(!validaNumero(cantidad)){
            mensaje.setText("La cantidad de espacios del counter, debe ser un número entero");
            mensaje.setVisible(true);
        } else if(!validaNombre(direccion)){
            mensaje.setText("Se debe ingresar una dirección");
            mensaje.setVisible(true);
        } else{
            int cantidadCasilleros = Integer.parseInt(cantidad);
            this.counter = new Counter(nombre, cedula, direccion, cantidadCasilleros);
            quitarPaneCounter();
        }
    }
    
    /**
     * Método que realiza el registro de un cliente
     * @param e Action Event
     */
    @FXML
    private void registrarCliente(ActionEvent e){
        refresh(PaneRegistrarCliente);
        
        String nombre = nombreCliente.getText();
        String cedula = cedulaCliente.getText();
        String correo = direccionCorreoCliente.getText();
        String telefono = telefonoCliente.getText();
        
        if(!validaNombre(nombre)){
            mensajeRegistroCliente.setText("El nombre ingresado no es válido");
            mensajeRegistroCliente.setVisible(true);
        } else if(!validaCedulaFisica(cedula)){
            mensajeRegistroCliente.setText("El número de cédula fisica debe estar compuesto por 9 digitos, incluyendo los ceros");
            mensajeRegistroCliente.setVisible(true);
        } else if(!validacionCorreo(correo)){
            mensajeRegistroCliente.setText("El correo ingresado no tiene un formato válido");
            mensajeRegistroCliente.setVisible(true);
        } else if(!validacionNumeroTelefono(telefono)){
            mensajeRegistroCliente.setText("El número de telefóno no es válido");
            mensajeRegistroCliente.setVisible(true);
        }//FALTA VALIDAR LA ENTRADA DE GENERO Y FECHA DE NACIMIENTO
        else{
            int numCasillero = this.counter.registrarCliente(nombre, cedula, correo, telefono, "", "", 29, 9, 1999);
            if (numCasillero != 0){
                mensajeRegistroCliente.setText("Cliente registrado con éxito. Se le asignó el casillero número: " + numCasillero);
                nombreCliente.setText("");
                cedulaCliente.setText("");
                direccionCorreoCliente.setText("");
                telefonoCliente.setText("");
                PaneRegistrarCliente.setVisible(false);
            } else{
                mensajeRegistroCliente.setText("Ya hay un cliente registrado con ese número de cédula");
            }
        }
    }
    
    /**
     * Metódo que realiza la consulta de un cliente
     * @param e Action event 
     */
    @FXML
    private void consultarCliente(ActionEvent e){
        refresh(PaneConsultarCliente);
        String cedula = cedulaClienteConsulta.getText();
        
        if(!validaCedula(cedula)){
            mensajeConsultaCliente.setText("El número de cédula es inválido");
            mensajeConsultaCliente.setVisible(true);
            //OJO FALTA VALIDAR QUE EL CLIENTE EXISTA EN EL SISTEMA
        }
        else{
            //Debe de mostrarse el tableview
            
            //OJO   OJO     OJO
            
            
            //OJO   OJO     OJO
            
            
            //OJO   OJO     OJO
        }
    }
    
    /**
     * Método que modifica la información de un cliente
     * @param e 
     */
    @FXML
    private void modificarCliente(ActionEvent e){
        refresh(PaneModificarCliente);
        String cedula = cedulaModifica.getText();
        
        if(!validaCedula(cedula)){
            mensajeModifica.setText("El número de cédula es inválido");
            mensajeModifica.setVisible(true);
        }
        else{
            paneCambiarDatosCliente.setVisible(true);
            
            //FALTA MODIFICAR EL PANE EN EL QUE
            
            //SE VAN A REALIZAR LOS CAMBIOS 
        }
    }
    
    /**
     * Método que modifica la información de un cliente
     * @param e action event
     */
    @FXML
    private void eliminarCliente(ActionEvent e){
        refresh(PaneEliminarCliente);
        String cedula = clienteAEliminar.getText();
        
        if(!validaCedula(cedula)){
            mensajeEliminado.setText("El número de cédula es inválido");
            mensajeEliminado.setVisible(true);
        }
        else{
            //ELIMINARLO DEL SISTEMA, COMO TAL
            mensajeEliminado.setText("Cliente eliminado con éxito");
            mensajeEliminado.setVisible(true);
        }
    }
    /**
     * Método que registra una revista
     * @param e action event
     */
    @FXML
    private void registraRevista(ActionEvent e){
        refresh(Revista);
        String remitente = remitenteRevista.getText();
        String descripcion = descripcionRevista.getText();
        String nombre = nombreRevista.getText();
        
        if(!validaNombre(remitente)){
            mensajeRevista.setText("El nombre de remitente es inválido");
            mensajeRevista.setVisible(true);
        }
        else if (descripcion==null){
            mensajeRevista.setText("Debe de tener una descripción");
            mensajeRevista.setVisible(true);
        }
        else if (!validaNombreNumero(nombre)){
            mensajeRevista.setText("El nombre de revista es inválido");
            mensajeRevista.setVisible(true);
        }
        else{
            Revista.setVisible(false);
        }
    }
    /**
     * Método que registra una revista
     * @param e action event
     */
    @FXML
    private void registraSobre(ActionEvent e){
        refresh(Sobre);
        String remitente = remitenteSobre.getText();
        String descripcion = descripcionSobre.getText();
        String peso = pesoSobre.getText();
        
        if(!validaNombre(remitente)){
            mensajeSobre.setText("El nombre de remitente es inválido");
            mensajeSobre.setVisible(true);
        }
        else if (descripcion==null){
            mensajeSobre.setText("Debe de tener una descripción");
            mensajeSobre.setVisible(true);
        }
        else if (validaNumeroDouble(peso)){
            mensajeSobre.setText("El peso del sobre es inválido, debe ser un dato flotante");
            mensajeSobre.setVisible(true);
        }
        else{
            Sobre.setVisible(false);
        }
    }
    
    /**
     * Método que realiza el registro de un paquete 
     * @param e action event 
     */
    @FXML
    private void registraPaquete(ActionEvent e){
        refresh(Paquete);
        String remitente = remitentePaquete.getText();
        String descripcion = descripcionPaquete.getText();
        String peso = pesoPaquete.getText();
        
        if(!validaNombre(remitente)){
            mensajePaquete.setText("El nombre de remitente es inválido");
            mensajePaquete.setVisible(true);
        }
        else if (descripcion==null){
            mensajePaquete.setText("Debe de tener una descripción");
            mensajePaquete.setVisible(true);
        }
        else if (validaNumeroDouble(peso)){
            mensajePaquete.setText("El peso del sobre es inválido, debe ser un dato flotante");
            mensajePaquete.setVisible(true);
        }
        else{
            Paquete.setVisible(false);
        }
    }
    
   /**
    * Método que realiza el retiro de paquestes
    * @param e action event 
    */
    @FXML
    private void retiraPaquete(ActionEvent e){
        refresh(Retirar);
        
        String cedula = identificacionRetirar.getText();
        
        if (!validaCedulaFisica(cedula)){
            mensajeRetirar.setText("El número de identificación no es válido");
            mensajeRetirar.setVisible(true);
        }
        else{ /// FALTAN ALGUNAS VALIDACIONES Y LA ACCIÓN, COMO TAL
            mensajeRetirar.setText("Paquete retirado");
            mensajeRetirar.setVisible(true);
        }
    }
    
    /**
     * Método que realiza la consulta de estado del casillero
     * @param e action event 
     */
    @FXML
    private void consultaEstado(ActionEvent e){
        refresh(EstadoCasillero);
        String numeroCliente = consulaNumeroCliente.getText();
        String numeroCasillero = consulaNumeroCasillero.getText();
        
        if(!validaNumero(numeroCliente) || !validaNumero(numeroCasillero)){
            mensajeEstadoCasillero.setText("El valor ingresado no es correcto");
            mensajeEstadoCasillero.setVisible(true);
        }
        else{
            //mensajeEstadoCasillero.setText(// TEXTO REFERENTE AL ESTADO DEL CASILLERO);
        }
    }
    
    /**
     * Método que muestra los articulos recibidos en una fecha determinada
     * @param e action event
     */
    @FXML
    private void articulosRecibidosFecha(ActionEvent e){
        refresh(ArticulosRecibidosFecha);
        Object dia= diaArticulosRecibidos.getValue();
        
    }
    
    /**
     * Metodo para modificar la cantidad y procentaje para subir de nivel
     * @param e action event
     */
    @FXML
    private void modificarParametros(ActionEvent e){
        refresh(ModificarSistema);
        
        String cantidad = modificarCantidad.getText();
        String porcentajeParaSubirNivel = porcentaje.getText();
        
        if (!validaNumero(cantidad)){
            mensajeModificar.setText("La cantidad ingresada no es correcta");
            mensajeModificar.setVisible(true);
        }
        else if (!validaNumero(porcentajeParaSubirNivel)){
                mensajeModificar.setText("El porcentaje ingresado no es correcto");
                mensajeModificar.setVisible(true);
        }
        else{
            ModificarSistema.setVisible(false);
        }
 
    }
      
    // ****************************************************************************
    // ********************* Métodos de validaciones ******************************
    
    /**
     * Metodo que valida un nombre 
     * @param nombre resibe un nombre de tipo string y ve si es correcto
     * @return true si es correcto y false si no
     */
    static boolean validaNombre (String nombre) {
      String regex = "^[A-Za-z\\s]+$";
      return nombre.matches(regex);
    }
    
    /**
     * Metodo que valida un nombre admitiendo numeros en él 
     * @param nombre resibe un nombre de tipo string y ve si es correcto
     * @return true si es correcto y false si no
     */
    static boolean validaNombreNumero (String nombre) {
      String regex = "/^[A-Za-z0-9\\s]+$/g";
      return nombre.matches(regex);
    }
    /**
     * Metodo que valida si una cédula juridica es correcta
     * @param cédula resibe una cedula de tipo string y ve si es correcta o no
     * @return true si es correcta de lo contrario retorna false
     */
    static boolean validaCedula (String cedula){
        String regex = "[0-9]{10}";
        return cedula.matches(regex);
    }
    
    /**
     * Metodo que valida si una cédula fisica es correcta
     * @param cédula resibe una cedula de tipo string y ve si es correcta o no
     * @return true si es correcta de lo contrario retorna false
     */
    static boolean validaCedulaFisica (String cedula){
        String regex = "[0-9]{9}";
        return cedula.matches(regex);
    }
    
    /**
     * Metodo que valida si un número esta correcto
     * @param numero resibe un numero de tipo string y ve si es correcto o no
     * @return true si el correcto o false si no
     */
    static boolean validaNumero (String numero){
        String regex = "[0-9]+";
        return numero.matches(regex);
    }
    
    /**
     * Metodo que valida si un número es double
     * @param numero resibe un numero de tipo string y ve si es correcto o no
     * @return true si el correcto o false si no
     */
    static boolean validaNumeroDouble (String numero){
        String regex = "^[0-9]+([,][0-9]+)?$";
        return numero.matches(regex);
    }
    
    
    
    /**
    * Método que realiza la validación de un correo electrónico
    * @param email Direcciòn de correo electrónico que se va a validar
    * @return true si el email es válido, false de no lo contrario
    */  
    static boolean validacionCorreo(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
    
    /**
    * Método que realiza la validación de un número telefónico
    * @param numero String que contiene números que representan un telefono{
    * @return true si el número es válido, false en caso contrario
    */
   static boolean validacionNumeroTelefono (String numero){
       String regex="[0-9]{8}";
       return numero.matches(regex);
   }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
}
