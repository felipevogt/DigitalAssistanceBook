package gestorEmpleado;


import gestorArchivo.ArchivoEmpleado;
import gestorArchivo.ArchivoRegistro;
import gestorArchivo.ArchivoTrabajo;
import gestorArchivo.ArchivoAfiliacion;
import gestorArchivo.ArchivoLiquidacion;
import gestorArchivo.ArchivoSalud;
import gestorArchivo.ArchivoSeguro;

import java.util.ArrayList;

/**
 *
 * @author Javiera Jara, Alvaro Vega, Felipe Vogt
 */
public class GestorEmpleado {
    
    private ArrayList<Empleado> empleados= new ArrayList<Empleado>();

    
    
    
    /**
     * Agrega un empleado al arraylist
     * 
     */
    public void agregarEmpleado(String rut, String nombre, String apellidoPaterno, String apellidoMaterno,  
            String fechaNacimiento, String fechaIngreso, String telefono, String sexo, String estadoCivil, 
            int horasPorDia, String codTrabajo, String codSalud, String codSeguro, String codAfiliacion){
        
        Empleado empleado = new Empleado(rut, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, fechaIngreso, 
                telefono, sexo, estadoCivil, horasPorDia, codTrabajo, codSalud, codSeguro, codAfiliacion);
        
        empleados.add(empleado);
    }
    /**
     * 
     * modifica un empleado del archivo de texto
     * 
     */
    public void modificarEmpleado(int indice, String rut, String nombre, String apellidoPaterno, String apellidoMaterno,  
            String fechaNacimiento, String fechaIngreso, String telefono, String sexo, String estadoCivil, 
            int horasPorDia, String codTrabajo, String codSalud, String codSeguro, String codAfiliacion){
        String cadenaNueva = rut + "#" + nombre + "#" + apellidoPaterno + "#" + apellidoMaterno + "#" + fechaNacimiento + "#" + 
                fechaIngreso + "#" + telefono + "#" + sexo + "#" + estadoCivil + "#" + horasPorDia + "#" 
                +codTrabajo + "#" + codSalud + "#" + codSeguro + "#" + codAfiliacion + "#";
        
        String cadenaAntigua = empleados.get(indice).getRut()+"#"+empleados.get(indice).getNombre()+"#"+empleados.get(indice).getApellidoPaterno()+"#"+empleados.get(indice).getApellidoMaterno()+"#"+empleados.get(indice).getFechaNacimiento()+"#"+
                               empleados.get(indice).getFechaIngreso()+"#"+empleados.get(indice).getTelefono()+"#"+empleados.get(indice).getSexo()+"#"+empleados.get(indice).getEstadoCivil()+"#"+empleados.get(indice).getHorasPorDia()+"#"+
                               empleados.get(indice).getCodTrabajo()+"#"+empleados.get(indice).getCodSalud()+"#"+empleados.get(indice).getCodSeguro()+"#"+empleados.get(indice).getCodAfiliacion()+"#";
        ArchivoEmpleado archEmp = new ArchivoEmpleado();
        archEmp.modificarArchivo(cadenaAntigua, cadenaNueva);
        ArchivoRegistro archRegistro = new ArchivoRegistro(empleados.get(indice).getRut());
        ArchivoRegistro archRegistroNuevo = new ArchivoRegistro(rut);
        archRegistro.moverArchivo(archRegistroNuevo.getRutaEmpleado());
        archRegistro.autoDestruccion();
       
       
        
    }
    
    /**
     * Elimina un empleado del archivo de texto 
     */
    public void eliminarEmpleado(int indice){
               
        String cadenaAntigua = empleados.get(indice).getRut()+"#"+empleados.get(indice).getNombre()+"#"+empleados.get(indice).getApellidoPaterno()+"#"+empleados.get(indice).getApellidoMaterno()+"#"+empleados.get(indice).getFechaNacimiento()+"#"+
                               empleados.get(indice).getFechaIngreso()+"#"+empleados.get(indice).getTelefono()+"#"+empleados.get(indice).getSexo()+"#"+empleados.get(indice).getEstadoCivil()+"#"+empleados.get(indice).getHorasPorDia()+"#"+
                               empleados.get(indice).getCodTrabajo()+"#"+empleados.get(indice).getCodSalud()+"#"+empleados.get(indice).getCodSeguro()+"#"+empleados.get(indice).getCodAfiliacion()+"#";
        
        ArchivoEmpleado archEmp = new ArchivoEmpleado();
        archEmp.eliminarRegistro(cadenaAntigua);
        
      
    }
    /**
     * 
     * guarda un empleado en un archivo de texto
     */
    public void guardarEmpleado(String rut, String nombre, String apellidoPaterno, String apellidoMaterno, 
            String fechaNacimiento, String fechaIngreso, String telefono, String sexo, String estadoCivil, 
            int horasPorDia, String codTrabajo, String codSalud, String codSeguro, String codAfiliacion){
        
        String cadena = rut + "#" + nombre + "#" + apellidoPaterno + "#" + apellidoMaterno + "#" + fechaNacimiento + "#" + 
                fechaIngreso + "#" + telefono + "#" + sexo + "#" + estadoCivil + "#" + horasPorDia + "#" 
                +codTrabajo + "#" + codSalud + "#" + codSeguro + "#" + codAfiliacion + "#";
        
        ArchivoEmpleado archEmp = new ArchivoEmpleado();
        archEmp.escribirArchivo(cadena);
        
        
    }
    
    /**
     * carga los empleados de un archivo de texto y los almacena en un arraylist llamando al metodo agregarEmpleados    
    */
    public void cargarEmpleado(){
        ArchivoEmpleado archEmp = new ArchivoEmpleado();
        
        String cargando[];
        cargando=archEmp.leerArchivo().split("#");
        for(int f=0;f<cargando.length;f=f+14){
            
            agregarEmpleado(cargando[0+f],cargando[1+f],cargando[2+f],cargando[3+f],cargando[4+f],cargando[5+f],cargando[6+f],cargando[7+f],cargando[8+f],Integer.parseInt(cargando[9+f]), 
                            cargando[10+f], cargando[11+f], cargando[12+f], cargando[13+f]);
            
        }
    }
    
    /**
     * Guarda la hora de entrada de un empleado en un archivo de texto que lleva de nombre el mes y año en la carpeta con nombre del rut del empleado
     */
    public void guardarEntradaEmpleado(int indice, int horaEntrada, int minutoEntrada, String dia, String mes, String ano){
        ArchivoRegistro archReg = new ArchivoRegistro(this.empleados.get(indice).getRut());
        String cadena = "dia:" + dia + "#" + horaEntrada + "#" + minutoEntrada + "#" + "null#" + "null#" + "0#" + "0#";
        archReg.escribirArchivo(cadena, mes, ano);
    }
    /**
     * Guarda la hora de salida de un empleado en un archivo de texto que lleva de nombre el mes y año en la carpeta con nombre del rut del empleado
     */
    public void guardarSalidaEmpleado(int indice, int horaSalida, int minutoSalida, String dia, String mes, String ano){
        ArchivoRegistro archReg = new ArchivoRegistro(this.empleados.get(indice).getRut());
        String cadena = "dia:"+dia;
        String cadenaEncontrada = archReg.buscarEnArchivo(cadena, mes, ano);
        String datosEntrada[]= cadenaEncontrada.split("#");
        int horasTrabajadas = this.calcularHorasDiarias(this.empleados.get(indice).getHorasPorDia(), Integer.parseInt(datosEntrada[1]),
                              Integer.parseInt(datosEntrada[2]), horaSalida, minutoSalida);
        int horasExtras = this.calcularHorasExtrasDiarias(this.empleados.get(indice).getHorasPorDia(), Integer.parseInt(datosEntrada[1]),
                              Integer.parseInt(datosEntrada[2]), horaSalida, minutoSalida);
        String cadenaSalida = datosEntrada[0]+"#"+datosEntrada[1]+"#"+datosEntrada[2]+"#"+horaSalida+
                              "#"+minutoSalida+"#"+horasTrabajadas+"#"+horasExtras+"#";
        archReg.modificarArchivo(cadenaEncontrada, cadenaSalida, mes, ano);
        
        
        
    }
    /**
     * 
     * Calcula las horas que trabajo en 1 dia un empleado
     * @return retorna el total de horas trabajadas en 1 dia
     */
    public int calcularHorasDiarias(int horasPorDia, int horaEntrada, int minutoEntrada, int horaSalida, int minutoSalida){
        if (minutoSalida - minutoEntrada < 0){
            if (((horaSalida - horaEntrada) - 1) >= horasPorDia){
                return horasPorDia;                
            }else{
                return (horaSalida - horaEntrada) - 1;
            }
        }else{
            if ((horaSalida - horaEntrada) >= horasPorDia){
                return horasPorDia;                
            }else{
                return (horaSalida - horaEntrada);
            }
        }
    } 
    
    /**
     * calcula el total de horas extras en 1 dia
     * @return retorna el total de horas extras realizadas en un dia
     */
    public int calcularHorasExtrasDiarias(int horasPorDia, int horaEntrada, int minutoEntrada, int horaSalida, int minutoSalida){
        
        if (minutoSalida - minutoEntrada < 0){
            if ((horaSalida - horaEntrada) - 1 > horasPorDia){
                return ((horaSalida - horaEntrada) - 1) - horasPorDia;
            }else{
                return 0;
            }
        }else{
            if ((horaSalida - horaEntrada) > horasPorDia){
                return (horaSalida - horaEntrada) - horasPorDia;
            }else{
                return 0;
            }
        }

    }
    
    /**
     * calcula las horas mensuales realizadas por un empleado 
     * @return retorna el total de horas mensuales
     */
    public int calcularHorasMensuales(int indice, String mes, String ano){
        String rut = this.empleados.get(indice).getRut();
        ArchivoRegistro archReg = new ArchivoRegistro(rut);
        String cadenaLeida[] = archReg.leerArchivo(mes, ano).split("#");
        int totalHoras = 0;
        for(int i = 0; i < cadenaLeida.length; i=i+7){
            totalHoras = totalHoras + Integer.parseInt(cadenaLeida[5+i]);
        }
        return totalHoras;
    }
    /**
     * calcula las horas extras mensuales realizadas por un empleado 
     * @return retorna el total de horas extras mensuales
     */
    
    public int calcularHorasExtrasMensuales(int indice, String mes, String ano){
        String rut = this.empleados.get(indice).getRut();
        ArchivoRegistro archReg = new ArchivoRegistro(rut);
        String cadenaLeida[] = archReg.leerArchivo(mes, ano).split("#");
        int totalHoras = 0;
        for(int i = 0; i < cadenaLeida.length; i=i+7){
            totalHoras = totalHoras + Integer.parseInt(cadenaLeida[6+i]);
        }
        return totalHoras;
    }
    
    /**
     * calcula el total de dias trabajados sumando todas las lineas del archivo de registro correspondiente
     * @return retorna el total de dias
     */
    public int calcularDiasTrabajados(int indice, String mes, String ano){
        String rut = this.empleados.get(indice).getRut();
        ArchivoRegistro archReg = new ArchivoRegistro(rut);
        String cadenaLeida[]= archReg.leerArchivo(mes,ano).split("#");
        int totalDias=0;
        for(int i = 0; i <cadenaLeida.length; i=i+7){
            totalDias = totalDias+1;
        }
        return totalDias;
        
    }
    
    /**
     * busca en el archivo trabajos por el codigo, el valor de la hora trabajada
     * @return retorna el valor de la hora de un trabajo
     */
    public int getValorHora(String codTrabajo){
        ArchivoTrabajo archTrabajo = new ArchivoTrabajo();
        String cadenaLeida[]= archTrabajo.leerArchivo().split("#");
        String valorHora=cadenaLeida[2+(Integer.parseInt(codTrabajo)-1)*4];
        return Integer.parseInt(valorHora);
        
    }
    /**
     * busca en el archivo trabajos por el codigo, el valor de la hora extra trabajada
     * @return retorna el valor de la hora extra de un trabajo
     */
    public int getValorHoraExtra(String codTrabajo){
        ArchivoTrabajo archTrabajo = new ArchivoTrabajo();
        String cadenaLeida[]= archTrabajo.leerArchivo().split("#");
        String valorHora=cadenaLeida[3+(Integer.parseInt(codTrabajo)-1)*4];
        return Integer.parseInt(valorHora);
        
    }
   /**
     * busca en el archivo trabajos por el codigo, el tipo de trabajo
     * @return retorna el nombre del trabajo
     */
    public String getNombreTrabajo(String codTrabajo){
        ArchivoTrabajo archTrabajo = new ArchivoTrabajo();
        String cadenaLeida[]= archTrabajo.leerArchivo().split("#");
        String nombreTrabajo = cadenaLeida[1+(Integer.parseInt(codTrabajo)-1)*4];
        return nombreTrabajo;
        
    }
    /**
     * busca en el archivo afiliacion por el codigo, el descuento de dicha afiliacion
     * @return retorna el descuento
     */
    public double getDescuentoAfiliacion(String codAfilacion){
        ArchivoAfiliacion archAfilacion = new ArchivoAfiliacion();
        String cadenaLeida[]= archAfilacion.leerArchivo().split("#");
        String valorDescuento=cadenaLeida[2+(Integer.parseInt(codAfilacion)-1)*3];
        return Double.parseDouble(valorDescuento);
    }
    
    /**
     * busca en el archivo afiliacion por el codigo, el nombre de dicha afiliacion
     * @return retorna el nombre
     */
    public String getNombreAfiliacion(String codAfilacion){
        ArchivoAfiliacion archAfilacion = new ArchivoAfiliacion();
        String cadenaLeida[]= archAfilacion.leerArchivo().split("#");
        String nombreAfiliacion = cadenaLeida[1+(Integer.parseInt(codAfilacion)-1)*3];
        return nombreAfiliacion;
    }
    /**
     * busca en el archivo salud por el codigo, el descuento que puede ser de isapre o fonasa
     * @return retorna el descuento
     */
    public double getDescuentoSalud(String codSalud){
        ArchivoSalud archSalud = new ArchivoSalud();
        String cadenaLeida[]= archSalud.leerArchivo().split("#");
        String valorDescuento=cadenaLeida[2+(Integer.parseInt(codSalud)-1)*3];
        return Double.parseDouble(valorDescuento);
    }
    /**
     * busca en el archivo salud por el codigo, el nombre que puede ser de alguna isapre o fonasa
     * @return retorna el nombre
     */
    public String getNombreSalud(String codAfilacion){
        ArchivoSalud archSalud = new ArchivoSalud();
        String cadenaLeida[]= archSalud.leerArchivo().split("#");
        String nombreSalud = cadenaLeida[1+(Integer.parseInt(codAfilacion)-1)*3];
        return nombreSalud;
    }
    
    /**
     * busca en el archivo seguro por el codigo, el descuento que de algun seguro
     * @return retorna el descuento
     */
    public double getDescuentoSeguro(String codSeguro){
        ArchivoSeguro archSeguro= new ArchivoSeguro();
        String cadenaLeida[]= archSeguro.leerArchivo().split("#");
        String valorDescuento=cadenaLeida[2+(Integer.parseInt(codSeguro)-1)*3];
        return Double.parseDouble(valorDescuento);
    }
    /**
     * busca en el archivo seguro por el codigo, el nombre del descuento que de algun seguro
     * @return retorna el nombre
     */
    public String getNombreSeguro(String codSeguro){
        ArchivoSeguro archSeguro= new ArchivoSeguro();
        String cadenaLeida[]= archSeguro.leerArchivo().split("#");
        String nombreSeguro = cadenaLeida[1+(Integer.parseInt(codSeguro)-1)*3];
        return nombreSeguro;
    }
    
    /**
     * Guarda en un archivo de texto nombrado liquidacion, la liquidacion con todos los datos correspondientes de un empleado   
     */

    public void guardarLiquidacion(int indice, String mes, String ano,  String diasTrabajados, String horasTrabajadas, String horasExtras,
            String sueldoBase, String adicionalHorasExtras, String sueldoBruto,
            String descuentoAfp, String descuentoSalud, String descuentoSeguro, String totalDescuento, String sueldoLiquido){
        String rut = empleados.get(indice).getRut();
        String nombre = empleados.get(indice).getNombre() + " " + empleados.get(indice).getApellidoPaterno() + " " + empleados.get(indice).getApellidoMaterno();
        String fechaIngreso = empleados.get(indice).getFechaIngreso();
        String cargo = this.getNombreTrabajo(empleados.get(indice).getCodTrabajo());
        String afiliacion = this.getNombreAfiliacion(empleados.get(indice).getCodAfiliacion());
        String salud = this.getNombreSalud(empleados.get(indice).getCodSalud());
        String seguro = this.getNombreSeguro(empleados.get(indice).getCodSeguro());
        
        ArchivoLiquidacion archLiquidacion = new ArchivoLiquidacion(rut);

        
        archLiquidacion.escribirArchivo(mes, ano, nombre, rut, fechaIngreso, cargo, afiliacion, salud, seguro, diasTrabajados, horasTrabajadas, horasExtras,
                sueldoBase, adicionalHorasExtras, sueldoBruto, descuentoAfp, descuentoSalud, descuentoSeguro, totalDescuento, sueldoLiquido);
    }
    /**
     * get del arraylist
     * @return retorna el arraylist de empleados
     */
    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }




    
    
    
}
