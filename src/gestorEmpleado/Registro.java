package gestorEmpleado;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;

public class Registro {

    //Atributos propios de la clase
    private Date fecha;
    private int horaEntrada;
    private int minutoEntrada;
    private int horaSalida;
    private int minutoSalida;


    //Captura hora en tiempo real
    public int capturaHora(){
        Calendar calendario = new GregorianCalendar();
        Date horaActual = new Date();
        calendario.setTime(horaActual);
        String hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" 
                + calendario.get(Calendar.HOUR_OF_DAY);
        return Integer.parseInt(hora);
    }
    
    //Captura minuto en tiempo real
    public int capturarMinuto(){
        Calendar calendario = new GregorianCalendar();
        Date horaActual = new Date();
        calendario.setTime(horaActual);
        String minuto = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" 
                + calendario.get(Calendar.MINUTE);
        return Integer.parseInt(minuto);
    }

    
    //guarda la fecha actual
    public void setFecha() {
        this.fecha = new Date();
    }
    //Obtiene el valor de la fecha en formato dd/MM/YYYY
    public String getFecha() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(this.fecha);
    }

    //Guarda los minutos y horas obtenidos de los metodos capturarHora y capturarMinuto
    public void setHoraEntrada() {
        this.horaEntrada = this.capturaHora();
    }
    public void setMinutoEntrada() {
        this.minutoEntrada = this.capturarMinuto();
    }
    public void setHoraSalida() {
        this.horaSalida = this.capturaHora();
    }
    public void setMinutoSalida() {
        this.minutoSalida = this.capturarMinuto();
    }

    
    //Calcula las horas trabajadas por un dia.(El metodo consiste en que si la diferencia de minutos de "salida-entrada" es
    //negativa , quiere decir que no alcanzo a cumplir una hora completa , por lo que se resta 1 a la diferencia entre la
    //hora "salida-entrada"
    public int calcularHorasDiarias(int horasPorDia){
        if (this.minutoSalida - this.minutoEntrada < 0){
            if (((this.horaSalida - this.horaEntrada) - 1) >= horasPorDia){
                return horasPorDia;                
            }else{
                return (this.horaSalida - this.horaEntrada) - 1;
            }
        }else{
            if ((this.horaSalida - this.horaEntrada) >= horasPorDia){
                return horasPorDia;                
            }else{
                return (this.horaSalida - this.horaEntrada);
            }
        }
    }  
    
    //Este metodo calcula las horas extras trabajadas en un solo dia, en caso de que las horas trabajadas
    //sean mayor a las horas correspondientes de un trabajador asignadas por un contrato.
    //En caso de que las horas trabajadas sean menores el metodo retorna el valor de 0
    public int calcularHorasExtrasDiarias(int horasPorDia){
        if (this.calcularHorasDiarias(horasPorDia) > horasPorDia){
            return this.calcularHorasDiarias(horasPorDia) - horasPorDia;
        }else{
            return 0;
        }
    }
}
