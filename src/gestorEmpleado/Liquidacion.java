package gestorEmpleado;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Liquidacion {

    //Atributos
    private Date fechaPago;
    private int numeroLiquidacion;
    private double montoFinal;
    
    

    public String getFechaPago() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(this.fechaPago);
    }

    //Constructor de liquidacion con la fecha en que se realizara el pago y un numero de liquidacion
    public Liquidacion(int numeroLiquidacion) {
        this.fechaPago = new Date();
        this.numeroLiquidacion = numeroLiquidacion;
    }
    //Set y get monto final
    public void setMontoFinal(double montoFinal) {
        this.montoFinal = montoFinal;
    }
    public double getMontoFinal() {
        return montoFinal;
    }
    
   
    //Este metodo calcula el sueldo bruto de un empleado con parametros de entrada, el total de horas trabajadas,
    //el total de horas extras realizadas, el valor que tiene una hora de trabajo y el valor que tiene una hora extra de 
    //trabajo
    public int calcularSueldoBruto(int totalHoras, int totalHorasExtras, int valorHora, int valorHoraExtra){
        return (totalHoras*valorHora + totalHorasExtras*valorHoraExtra);
    }
    
    
    //Este metodo calcula el sueldo liquido que recibe un empleado, necesita como entrada los 3 tipos de descuentos que posee
    //un empleado que son los descuentos por las afiliaciones, el plan de salud y el seguro de cesantia. ademas de 
    //el sueldo bruto calculado con el metodo calcularSueldoBruto()
    public double calcularSueldoLiquido(double descuento1, double descuento2, double descuento3, int sueldoBruto){
        return(sueldoBruto - sueldoBruto*descuento1 - sueldoBruto*descuento2 - sueldoBruto*descuento3);
    }

}