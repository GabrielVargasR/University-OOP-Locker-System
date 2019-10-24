/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Usuario
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
    

    public Cliente(String pCedula, String pNombre, String pCorreo, String pTelefono, String pDirección, String pSexo, Date pNacimiento) {
        this.cedula = pCedula;
        this.nombre = pNombre;
        this.correo = pCorreo;
        this.telefono = pTelefono;
        this.direccion = pDirección;
        this.sexo = pSexo;
        this.fechaNacimiento = pNacimiento;
    }

    public String getCedula() {
        return this.cedula;
    }

    public void setCedula(String pCedula) {
        this.cedula = pCedula;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String pNombre) {
        this.nombre = pNombre;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String pCorreo) {
        this.correo = pCorreo;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String pTelefono) {
        this.telefono = pTelefono;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String pDireccion) {
        this.direccion = pDireccion;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String pSexo) {
        this.sexo = pSexo;
    }

    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(Date pFechaNacimiento) {
        this.fechaNacimiento = pFechaNacimiento;
    }

    public int getNumeroCasillero() {
        return this.numeroCasillero;
    }

    public void setNumeroCasillero(int pNumeroCasillero) {
        this.numeroCasillero = pNumeroCasillero;
    }
    
    

    
}
