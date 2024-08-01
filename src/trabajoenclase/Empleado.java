/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoenclase;

import java.util.Calendar;

/**
 *
 * @author User
 */
public abstract class Empleado {
    protected int codigo;
    protected String nombre;
    protected Calendar contrato;
    
    public Empleado(int codigo, String nombre){
        this.codigo=codigo;
        this.nombre=nombre;
        contrato=Calendar.getInstance();
    }

    public final int getCodigo() {
        return codigo;
    }

    public final String getNombre() {
        return nombre;
    }

    public final Calendar getContrato() {
        return contrato;
    }
   
    public final void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public abstract double pagar();
    
    public abstract double bono();

    public String toString() {
        return "Empleado{" + "Codigo=" + codigo + "\nNombre=" + nombre;
    }
    
    
    
}
