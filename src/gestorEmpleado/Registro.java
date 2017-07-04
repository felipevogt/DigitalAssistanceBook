package gestorEmpleado;


import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 *
 * @author Javiera Jara, Alvaro Vega, Felipe Vogt
 */

public class Registro {

    public int capturaHora(){
        Calendar calendario = new GregorianCalendar();
        Date horaActual = new Date();
        calendario.setTime(horaActual);
        String hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" 
                + calendario.get(Calendar.HOUR_OF_DAY);
        return Integer.parseInt(hora);
    }
    public int capturarMinuto(){
        Calendar calendario = new GregorianCalendar();
        Date horaActual = new Date();
        calendario.setTime(horaActual);
        String minuto = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" 
                + calendario.get(Calendar.MINUTE);
        return Integer.parseInt(minuto);
    }
    public String capturarFecha(){
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(fecha);
    }
}
