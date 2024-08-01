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
public class EmpleadoTemporal extends EmpleadoComun{
    private Calendar finContrato;

    public EmpleadoTemporal(int codigo, String nombre) {
        super(codigo, nombre, 15000);
        this.finContrato=Calendar.getInstance();
    }
    
    public double pagar(){
        Calendar hoy=Calendar.getInstance();
        if (hoy.before(finContrato))
            return super.pagar();
        return 0;
    }

    public String toString() {
        return super.toString()+"\nFinContrato= " + finContrato.getTime();
    }
    
    
    
}
