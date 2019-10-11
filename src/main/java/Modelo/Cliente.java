/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Cliente {
    
    private String cedula;
    private String nombre;
    private String direccion;
    private String telefono;
    private String sexo;
    private Date fechaNacimiento;
    private int numeroCasillero;
    
    // Falta collection(articulos)

    public Cliente(String cedula, String nombre, String direccion, String telefono, String sexo, Date fechaNacimiento, int numeroCasillero) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroCasillero = numeroCasillero;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getNumeroCasillero() {
        return numeroCasillero;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setNumeroCasillero(int numeroCasillero) {
        this.numeroCasillero = numeroCasillero;
    }
    
    public boolean agregarCarrito(){
        return false;
    }

    @Override
    public String toString() {
        return "Cliente{" + "cedula=" + cedula + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", sexo=" + sexo + ", fechaNacimiento=" + fechaNacimiento + ", numeroCasillero=" + numeroCasillero + '}';
    }
    
}
