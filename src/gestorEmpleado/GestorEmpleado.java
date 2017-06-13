package gestorEmpleado;

import gestorArchivo.ArchivoEmpleado;
import java.util.ArrayList;

public class GestorEmpleado {
    
    private ArrayList<Empleado> empleados= new ArrayList<Empleado>();
    
    //Agrega empleados a un arraylist
    public void agregarEmpleado(String nombre, String apellidoPaterno, String apellidoMaterno, String rut, 
            String fechaNacimiento, String fechaIngreso, String telefono, String sexo, String estadoCivil, 
            int horasPorDia, Trabajo trabajo, Salud salud, Seguro seguro, Afiliacion afiliacion){
        
        Empleado empleado = new Empleado(nombre, apellidoPaterno, apellidoMaterno, rut, fechaNacimiento, fechaIngreso, 
                telefono, sexo, estadoCivil, horasPorDia, trabajo, salud, seguro, afiliacion);
        
        empleados.add(empleado);
    }
    
    //Guarda a los empleados en un archivo de texto
    public void guardarEmpleado(String nombre, String apellidoPaterno, String apellidoMaterno, String rut, 
            String fechaNacimiento, String fechaIngreso, String telefono, String sexo, String estadoCivil, 
            int horasPorDia, Trabajo trabajo, Salud salud, Seguro seguro, Afiliacion afiliacion){
        
        String cadena = nombre + "#" + apellidoPaterno + "#" + apellidoMaterno + "#" + rut + "#" + fechaNacimiento + "#" + 
                fechaIngreso + "#" + telefono + "#" + sexo + "#" + estadoCivil + "#" + horasPorDia + "#" 
                + trabajo.getTipoTrabajo() + "#" + salud.getNombreDescuento() + "#" + seguro.getNombreDescuento() 
                + "#" + afiliacion.getNombreDescuento() + "#";
        
        ArchivoEmpleado archEmp = new ArchivoEmpleado();
        archEmp.escribirArchivo(cadena);
        
        
    }
    
//    public void cargarEmpleado(){
//        ArchivoEmpleado archEmp = new ArchivoEmpleado();
//        
//        String cargando[];
//        cargando=archEmp.leerArchivo().split("#");
//        int c=0;
//        for(int f=0;f<cargando.length;f++){
//            
//            agregarEmpleado(cargando[0],cargando[1],cargando[2],cargando[3],cargando[4],cargando[5],cargando[6],cargando[7],cargando[8],Integer.parseInt(cargando[9]), 
//                            cargando[10], cargando[11], cargando[12], cargando[13]);
//        }
//    }
    
    
    
    
}
