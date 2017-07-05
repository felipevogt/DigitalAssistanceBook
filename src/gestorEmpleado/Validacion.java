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
    
   /**
    * Valida que el nombre o apellido contenga solo letras y la primera inicial en mayuscula
    * @param nombre corresponde al nombre o apellido de una persona
    * @return retorna true o false dependiendo de si hizo match
    */
    public boolean validarNombreApellido(String nombre){
        Pattern pat = Pattern.compile("[A-Z][a-z]{1,20}");
        Matcher mat = pat.matcher(nombre);
        if (mat.matches()){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Comprueba que el rut solo tenga de 7 a 8 numeros seguidos de un guion y luedo de un digito o una k
     * @param rut corresponde al rut de una persona
     * @return retorna true o false dependiendo de si hizo match
     */
    public boolean validarRut(String rut){
        Pattern pat = Pattern.compile("\\d{7,8}-[0-9kK]");
        Matcher mat = pat.matcher(rut);
        if (mat.matches()){
            return true;
        }else{
            return false;
        }
    }
    /**
     * Comprueba si existe algun empleado con el mismo rut
     * @param rut corresponde al rut de un empleado
     * @param empleados corresponde a un objeto de tipo GestorEmpleado que contiene el arraylist de empleados
     * @return retorna true si existe algun empleado con el mismo rut, caso contrario retorna false
     */
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
    /**
     * Comprueba que el telefono solo contenga 9 numeros 
     * @param telefono, corresponde al numero de telefono
     * @return devuelve true en caso de que solo contenga 9 numeros o false en caso de que no se cumpla la condicion
     */
    public boolean validarTelefono(String telefono){
        Pattern pat = Pattern.compile("\\d{9}");
        Matcher mat = pat.matcher(telefono);
        if (mat.matches()){
            return true;
        }else{
            return false;
        }
    }
    /**
     * Comprueba que la hora solo sea de 1 a 9 ya que un empleado no puede trabajar mas de 0 horas
     * @param hora corresponde a las horas trabajadas
     * @return retorna true en caso de que se cumplea la condicon y false caso contrario
     */
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

    /**
     * Comprueba que en un archivo exista el dia que se esta buscando
     * @param rut corresponde al rut del empleado que lleva el nombre del archivo
     * @param dia corresponde al dia que se esta buscando
     * @param mes corresponde al mes que tiene como nombre el archivo
     * @param ano corresponde al año que tiene como nombre el archivo
     * @return retorna true en caso de que encuentre el dia buscado en el archivo, retorna false caso contrario
     */
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
