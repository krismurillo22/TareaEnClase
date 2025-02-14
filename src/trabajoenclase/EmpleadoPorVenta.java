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
public class EmpleadoPorVenta extends EmpleadoComun{
    private double ventas[],tasa;

    public EmpleadoPorVenta(int codigo, String nombre, double salario) {
        super(codigo, nombre, salario);
        ventas=new double[12];
        tasa=0.05;
    }
    
    private int mesActual(){
        Calendar fecha=Calendar.getInstance();
        int mes=fecha.get(Calendar.MONTH);
        return mes;
    }
    
    public void agregarVentas(double monto){
        ventas[mesActual()]+=monto;
    }
    
    public double Comision(){
        return ventas[mesActual()]*tasa;
    }
    
    public double pagar(){
        return super.pagar()+Comision();
    }
    
    public String toString(){
        return super.toString()+"\nComision= "+Comision();
    }
}
