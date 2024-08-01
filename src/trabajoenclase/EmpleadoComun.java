/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoenclase;

/**
 *
 * @author User
 */
public class EmpleadoComun extends Empleado implements Aumentable, Deductible{
 
    protected double salario;
    
    public EmpleadoComun(int codigo, String nombre, double salario) {
        super(codigo, nombre);
        this.salario=salario;
    }
    
    public double bono(){
        return 0;
    }
    
    public void setSalario(double salario){
        this.salario=salario;
    }
    
    public double deduct(){
        return salario*Deductible.TASA_DEDUCCION;
    }
    
    public double pagar(){
        return salario-deduct();
    }
    
    public boolean validForincrease(){
        return true;
    }
    
    public void increaseIncome(){
        if(validForincrease()){
            salario+=salario*0.1;
        }
    }

    public String toString() {
        return super.toString()+ "\nSalario=" + salario + "}";
    }
    
    

}
