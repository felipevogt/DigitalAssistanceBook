package gestorEmpleado;


import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Javiera Jara, Alvaro Vega, Felipe Vogt
 */
public class Liquidacion {

    /**
     * metodo para calcular el sueldo base de un empleado, que se calcularian
     * multiplicando el total de horas trabajadas por el valor de la hora que tenga un empleado
     * @param totalHora, corresponde al total de horas trabajadas en un mes
     * @param valorHora, corresponde al valor de la hora que tenga un empleado
     * @return retorna el valorHora por el totalHora
     * 
     */
    public int calcularSueldoBase(int totalHoras, int valorHora){
        return (totalHoras*valorHora);
    }
    /**
     * metodo para calcular el sueldo base de un empleado, que se calcularian
     * multiplicando el total de horas extras trabajadas por el valor de la hora extra que tenga un empleado
     * @param totalHorasExtras, corresponde al total de horas extras trabajadas en un mes
     * @param valorHoraExtra, corresponde al valor de la hora extra que tenga un empleado
     * @return retorna el valorHoraExtra por el totalHoraExtra
     * 
     */
    public int calcularAdicionalHorasExtras(int totalHorasExtras, int valorHoraExtra){
        return (totalHorasExtras*valorHoraExtra);
    }
    /**
     * metodo para calcular el sueldo bruto de un empleado, el cual se calcula sumando el sueldo base mas
     * el adicional por las horas extras
     * @param sueldoBase, corresponde al sueldo base que tenga un empleado
     * @param adicionalHorasExtras, corresponde a lo ganado por las horas extras
     * @return retorna la suma de sueldoBase mas la de adiconalHorasExtras
     * 
     */
    public int calcularSueldoBruto(int sueldoBase, int adicionalHorasExtras){
        return sueldoBase + adicionalHorasExtras;
    }
    /**
     * Aplica un descuento al sueldo bruto
     * @param sueldoBruto
     * @param descuento
     * @return retorna la multiplicacion de sueldoBruto y descuento que seria lo que se debe descontar del sueldo bruto
     */
    public double calcularDescuento(int sueldoBruto, double descuento){
        return sueldoBruto*descuento;  
    }
    /**
     * Le resta al sueldoBruto los tres descuentos oblgatorios que tiene un empleado
     * @param descuento1, corresponde al descuento por Afp
     * @param descuento2, corresponde al descuento por isapre o fonasa
     * @param descuento3, corresponde al descuento del seguro
     * @param sueldoBruto, sueldo bruto del empleado
     * @return retorna el sueldo liquido que tiene que ganar un empleaod
     */
    public double calcularSueldoLiquido(double descuento1, double descuento2, double descuento3, int sueldoBruto){
        return(sueldoBruto - descuento1 - descuento2 - descuento3);
    }

}