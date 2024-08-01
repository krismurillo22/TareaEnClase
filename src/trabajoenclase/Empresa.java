/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoenclase;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Empresa {
    
    static Scanner lea = new Scanner(System.in);   
    static ArrayList<Empleado> empleados=new ArrayList<>();
    Empleado Empleado;
    
    public static void main(String[] args) {
        int op;
        
        do{
            System.out.println("1- Agregar Empleado");
            System.out.println("2- Pagar Empleado");
            System.out.println("3- Lista de Empleados");
            System.out.println("4- Sub Menu especifico");
            System.out.println("5- Salir");
            System.out.print("Escoja Opcion: ");
            op = lea.nextInt();
            
            switch(op){
                case 1:
                    hire();
                    break;
                case 2:
                    pay();
                    break;
                case 3:
                    list();
                    break;
                case 4:
                    submenu();
                    break;
            }
        }while(op!=5);
        
    }
    
    /**
     * Recorre la lista de Empleados. Si encuentra un
     * empleado con ese codigo, se retorna, sino, retorna null
     * @param cod Codigo del Empleado
     * @return El obj Empleado si se encuentra, null si no
     */
    private static Empleado search(int cod){
        for (int contar=0;contar<empleados.size();contar++) {
            Empleado empleadoActual = empleados.get(contar);
            if (empleadoActual.getCodigo()== cod) {
                return empleadoActual;
                
            }
        }
        return null;
    }

    /**
     * Contrata un nuevo empleado
     * 1- Se pide del teclado el tipo: COMUN, HORA, VENTA o TEMPORAL
     * 2- Se instancia un objeto segun el tipo y se guarda en el arreglo
     * 3- pero siempre y cuando el Codigo NO este repetido
     * 4- LOS DATOS requeridos se ingresan del teclado
     */
    private static void hire() {
        System.out.println("Ingrese el tipo de empleado(COMUN, HORA, VENTA o TEMPORAL): ");
        String tipo=lea.next().toUpperCase();
        System.out.println("Ingrese el codigo: ");      
        int codigo=lea.nextInt();
        System.out.println("Ingrese el nombre: ");
        String nombre=lea.next();
        double Salario=0;
        if (tipo.equals("COMUN")||tipo.equals("VENTA") ){
            System.out.println("Ingrese Salario: ");
            Salario= lea.nextDouble();
        }
        
        if (search(codigo)==null){
            if (tipo.equals("COMUN")){
                EmpleadoComun empleado=new EmpleadoComun(codigo,nombre,Salario);
                empleados.add(empleado);
            }else if (tipo.equals("HORA")){
                EmpleadoPorHora empleado=new EmpleadoPorHora(codigo,nombre);
                empleados.add(empleado);
            }else if (tipo.equals("VENTA")){
                EmpleadoPorVenta empleado=new EmpleadoPorVenta(codigo,nombre,Salario);
                empleados.add(empleado);
            }else if (tipo.equals("TEMPORAL")){
                EmpleadoTemporal empleado=new EmpleadoTemporal(codigo,nombre);
                empleados.add(empleado);
            }else{
                System.out.println("Tipo seleccionado no existe.");
            }
        }else{
            System.out.println("Codigo ya existe.");
        }
        
    }

    /**
     * Le paga a un empleado
     * 1- Pide del teclado el codigo
     * 2- Buscamos ese empleado
     * 3- Si existe, mostramos en pantalla su pago
     */
    private static void pay() {
        System.out.println("Ingrese el codigo del empleado: ");
        int codigo=lea.nextInt();
        if (search(codigo)!=null){
            Empleado empleadoactual= search(codigo);
            double pago=empleadoactual.pagar();
            System.out.println("El pago se realizo por una cantidad de: "+pago);
            
        }
    }

    /**
     * Imprimir la lista de empleados
     */
    private static void list() {
        for (int contar = 0; contar < empleados.size(); contar++) {
        System.out.println(empleados.get(contar));
}
    }

    
    private static void submenu() {
        int op;
        do{
            System.out.println("1-Fecha Fin Contrato a Temporales");
            System.out.println("2-Ingresar Venta");
            System.out.println("3-Ingresar Horas de Trabajo");
            System.out.println("4-Regresar al Menu Principal");
            System.out.print("Escoja Opcion: ");
            op = lea.nextInt();
            
            switch(op){
                case 1:
                    setFin();
                    break;
                case 2:
                    ventas();
                    break;
                case 3:
                    horas();
            }
            
        }while(op!=4);
    }
    
    /**
     * 1- Leer un codigo
     * 2- Buscar el empleado, que existe y q sea Temporal
     * 3- Si concuerda, set fecha fin contrato
     * 4- Leer del teclado los datos
     */
    private static void setFin() {
        System.out.println("Ingrese el codigo del empleado: ");
        int codigo=lea.nextInt();
        
        if (search(codigo)!=null){
            Empleado empleado=search(codigo);
            if (empleado instanceof EmpleadoTemporal){
                System.out.println("Ingrese el año:");
                int year=lea.nextInt();
                System.out.println("Ingrese el mes: ");
                int mes=lea.nextInt();
                System.out.println("Ingrese el dia: ");
                int dia=lea.nextInt();
                ((EmpleadoTemporal) empleado).setFinContrato(year, mes, dia);
            }else{
                System.out.println("Ese emplado no es por Temporal.");
            }
        }else{
            System.out.println("Codigo no existe.");
        }
    }

    /**
     * 1- Leer un codigo
     * 2- Buscar empleado, que exista y que sea PorVentas
     * 3- Si concuerda, agregar una venta
     * 4- Leer del teclado los datos
     */
    private static void ventas() {
        System.out.println("Ingrese el codigo del empleado: ");
        int codigo=lea.nextInt();
        
        if (search(codigo)!=null){
            Empleado empleado=search(codigo);
            if (empleado instanceof EmpleadoPorVenta){
                System.out.println("Ingrese el monto de la venta realizada: ");
                int venta=lea.nextInt();
                ((EmpleadoPorVenta) empleado).agregarVentas(venta);
            }else{
                System.out.println("Ese emplado no es por Venta.");
            }
        }else{
            System.out.println("Codigo no existe.");
        }
        
    }

    /**
     * 1- Leer un codigo
     * 2- Buscar empleado, que exista y que sea PorHoras
     * 3- Si concuerda, agregar las horas trabajadas
     * 4- Leer del teclado los datos
     */
    private static void horas() {
        System.out.println("Ingrese el codigo del empleado: ");
        int codigo=lea.nextInt();
        
        if (search(codigo)!=null){
            Empleado empleado=search(codigo);
            if (empleado instanceof EmpleadoPorHora){
                System.out.println("Ingrese las horas: ");
                int Horas=lea.nextInt();
                ((EmpleadoPorHora) empleado).setHorasT(Horas);
            }else{
                System.out.println("Ese emplado no es por Horas.");
            }
        }else{
            System.out.println("Codigo no existe.");
        }
    }
}
