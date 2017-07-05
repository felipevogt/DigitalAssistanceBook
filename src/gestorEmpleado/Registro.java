package gestorEmpleado;


import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 *
 * @author Javiera Jara, Alvaro Vega, Felipe Vogt
 */

public class Registro {
    /**
     * Captura la hora actual del sitema
     * @return retorna la hora capturada
     */
    public int capturaHora(){
        Calendar calendario = new GregorianCalendar();
        Date horaActual = new Date();
        calendario.setTime(horaActual);
        String hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" 
                + calendario.get(Calendar.HOUR_OF_DAY);
        return Integer.parseInt(hora);
    }
    /**
     * captura el minuto actual del sistema
     * @return retorna el minuto capturado
     */
    public int capturarMinuto(){
        Calendar calendario = new GregorianCalendar();
        Date horaActual = new Date();
        calendario.setTime(horaActual);
        String minuto = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" 
                + calendario.get(Calendar.MINUTE);
        return Integer.parseInt(minuto);
    }
    /**
     * Captura la fecha actual del sistema
     * @return retorna la fecha capturada
     */
    public String capturarFecha(){
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(fecha);
    }
    public Date capturarDate(){
        Date date = new Date();
        return date;
    }
}
