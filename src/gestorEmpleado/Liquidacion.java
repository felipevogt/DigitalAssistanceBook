package gestorEmpleado;


import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Javiera Jara, Alvaro Vega, Felipe Vogt
 */
public class Liquidacion {

    //Atributos
    public int calcularSueldoBase(int totalHoras, int valorHora){
        return (totalHoras*valorHora);
    }
    public int calcularAdicionalHorasExtras(int totalHorasExtras, int valorHoraExtra){
        return (totalHorasExtras*valorHoraExtra);
    }
    public int calcularSueldoBruto(int sueldoBase, int adicionalHorasExtras){
        return sueldoBase + adicionalHorasExtras;
    }
    public double calcularDescuento(int sueldoBruto, double descuento){
        return sueldoBruto*descuento;  
    }
    public double calcularSueldoLiquido(double descuento1, double descuento2, double descuento3, int sueldoBruto){
        return(sueldoBruto - descuento1 - descuento2 - descuento3);
    }

}