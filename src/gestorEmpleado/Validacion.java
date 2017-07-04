package gestorEmpleado;


import gestorArchivo.ArchivoRegistro;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Javiera Jara, Alvaro Vega, Felipe Vogt
 */


public class Validacion {
    
   
    public boolean validarNombreApellido(String nombre){
        Pattern pat = Pattern.compile("[A-Z][a-z]{1,20}");
        Matcher mat = pat.matcher(nombre);
        if (mat.matches()){
            return true;
        }else{
            return false;
        }
    }
    public boolean validarRut(String rut){
        Pattern pat = Pattern.compile("\\d{7,8}-[0-9kK]");
        Matcher mat = pat.matcher(rut);
        if (mat.matches()){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean validarRutRepedito(String rut, GestorEmpleado empleados){
        GestorEmpleado ge = empleados;
        int valido = 0;
        for (int i = 0; i < ge.getEmpleados().size(); i++){
            if (ge.getEmpleados().get(i).getRut().equals(rut)){
                valido = valido + 1;
            }
        }   
        if (valido != 0){
            return true;
        }else{
            return false;
        }
        
    }
    public boolean validarTelefono(String telefono){
        Pattern pat = Pattern.compile("\\d{9}");
        Matcher mat = pat.matcher(telefono);
        if (mat.matches()){
            return true;
        }else{
            return false;
        }
    }
    public boolean validarHoras(String hora){
        Pattern pat = Pattern.compile("[1-9]");
        Matcher mat = pat.matcher(hora);
        if (mat.matches()){
            return true;
        }else{
            return false;
        }
    }


    public boolean validarAño(int anoIngreso, int anoNacimiento){
        if (anoIngreso > anoNacimiento){
            return true;
        }else{
            return false;
        }
    }

    public boolean validarRegistro(String rut, String dia, String mes, String ano){
        ArchivoRegistro archReg = new ArchivoRegistro(rut);
        String diaBuscado = "dia:" + dia;
        String cadenaEncontrada = archReg.buscarEnArchivo(diaBuscado, mes, ano);
        if (cadenaEncontrada.contains(diaBuscado)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean validarSalida(String rut, String dia, String mes, String ano ){
        ArchivoRegistro archReg = new ArchivoRegistro(rut);
        String diaBuscado = "dia:" + dia;
        String cadenaEncontrada = archReg.buscarEnArchivo(diaBuscado, mes, ano);
        if(cadenaEncontrada.contains(diaBuscado)){
            String datosCadena[] = cadenaEncontrada.split("#");
            if (datosCadena[3].equals("null")){
                return false;
            }else{
                return true;
            }
        }else{
            return true;
        }
    }
    public boolean validarArchivoRegistro(String rut, String mes, String ano){
        ArchivoRegistro archReg = new ArchivoRegistro(rut);
        if(archReg.getArchivo(mes, ano).exists()){
            return true;
        }else{
            return false;
        }
    }
}
