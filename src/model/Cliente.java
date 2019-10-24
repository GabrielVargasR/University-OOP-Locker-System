package model;

import java.util.Date;
import model.TNivelCliente;

/**
 *
 * @author gabriel
 */
public class Cliente {
    
    private String cedula;
    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;
    private String sexo;
    private Date fechaNacimiento;
    private int numeroCasillero;
    private TNivelCliente nivel;
    private int paquetesRecibidos;
    

    public Cliente(String pCedula, String pNombre, String pCorreo, String pTelefono, String pDirección, String pSexo, Date pNacimiento) {
        this.cedula = pCedula;
        this.nombre = pNombre;
        this.correo = pCorreo;
        this.telefono = pTelefono;
        this.direccion = pDirección;
        this.sexo = pSexo;
        this.fechaNacimiento = pNacimiento;
        this.nivel = TNivelCliente.Normal;
        this.paquetesRecibidos = 0;
    }

    public String getCedula() {
        return this.cedula;
    }
    
    public void setCedula(String pCedula){
        this.cedula = pCedula;
    }

    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String pNombre){
        this.nombre = pNombre;
    }

    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String pCorreo){
        this.correo = pCorreo;
    }

    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String pTelefono){
        this.telefono = pTelefono;
    }

    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String pDireccion){
        this.direccion = pDireccion;
    }

    public String getSexo() {
        return this.sexo;
    }
    
    public void setSexo(String pSexo){
        this.sexo = pSexo;
    }

    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(int pDia, int pMes, int pAnno){
        this.fechaNacimiento.setDate(pDia);
        this.fechaNacimiento.setMonth(pMes);
        this.fechaNacimiento.setYear(pAnno);
    }

    public int getNumeroCasillero() {
        return this.numeroCasillero;
    }

    public void setNumeroCasillero(int pNumeroCasillero) {
        this.numeroCasillero = pNumeroCasillero;
    }
    
    public TNivelCliente getNivel(){
        return this.nivel;
    }
    
    public void incPaquetesRecibidos(){
        this.paquetesRecibidos++;
        if (this.paquetesRecibidos > 10 && this.nivel != TNivelCliente.Plata){
                this.nivel = TNivelCliente.Plata;
        } else if (this.paquetesRecibidos > 20 && this.nivel != TNivelCliente.Oro){
            this.nivel = TNivelCliente.Oro;
        }
    }
}
