/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestorArchivo;

import java.io.File;

/**
 *
 * @author Javiera Jara, Alvaro Vega, Felipe Vogt
 */
public class ArchivoLiquidacion extends GestorArchivo{
    private String rutaLiquidacion;
    private File ruta;
    private File archivo;
    
    /**
     * Constructor de la clase ArchivoLiquidacion, la cual es hija de la clase GestorArchivo
     * @param rutEmpleado, corresponde al rut del empleado que sera el nombre de la carpeta que tendra los archivos correspondiente a la liquidación
     * 
     */
    public ArchivoLiquidacion(String rutEmpleado) {
        this.rutaLiquidacion = "Archivos\\" + rutEmpleado + "\\Liquidaciones";
        this.ruta = new File(rutaLiquidacion);
        this.ruta.mkdirs();
    }
    /**
     *Metodo heredado de GestorArchivo, el cual escribe en el archivo
     * este metodo contiene todos los atributos de un empleado
     * @param mes, corresponde a parte del nombre del archivo de texto
     * @param ano, corresponde al año que forma parte del archivo de texto
     * @param nombre, nombre del empleado
     * @param rut, rut del empleado
     * @param fechaIngreso, fecha ingreso del empleado
     * @param cargo, tipo de trabajo que realiza el empleado
     * @param afiliacion, afiliacion a la que pertenece el empleado
     * @param salud, isapre o fonasa segun el empleado
     * @param seguro, seguro que tenga el empleado
     * @param diasTrabajados, dias que trabajo en el mes
     * @param horasTrabajadas, horas que trabajo en el mes
     * @param horasExtras, horas extras que realizo en el mes el empleado
     * @param  sueldoBase, corresponde al sueldo de un empleado calculado en la clase Liquidacion
     * @param  adicionalHorasExtras, corresponde a lo que gana un empleado por realizar horas extras (calculado en la clase Liquidacion)
     * @param  sueldoBruto, corresponde al sueldo bruto de un empleado. calculado en la clase Liquidacion
     * @param  descuentoAfp, corresponde al valor descontado del sueldo de un empleado. calculado en la clase Liquidacion
     * @param  descuentoSalud, corresponde al valor descontado del sueldo de un empleado. calculado en la clase Liquidacion
     * @param  descuentoSeguro, corresponde al valor descontado del sueldo de un empleado. calculado en la clase Liquidacion
     * @param  totalDescuento, corresponde al valor total descontado del sueldo de un empleado. calculado en la clase Liquidacion
     * @param  sueldoLiquido, corresponde al sueldo final de un empleado. calculado en la clase Liquidacion
     */
    public void escribirArchivo(String mes, String ano, String nombre, String rut, String fechaIngreso, String cargo, String afiliacion, String salud, String seguro, String diasTrabajados, String horasTrabajadas, String horasExtras,
            String sueldoBase, String adicionalHorasExtras, String sueldoBruto,
            String descuentoAfp, String descuentoSalud, String descuentoSeguro, String totalDescuento, String sueldoLiquido) {
        String rutaRegistros = this.rutaLiquidacion + "\\" + mes + "-" + ano + ".txt";
        this.archivo = new File(rutaRegistros);
        super.escribirArchivo(this.archivo, "--------Datos Empleado---------"); 
        super.escribirArchivo(this.archivo, "Nombre: " + nombre);
        super.escribirArchivo(this.archivo, "Rut: " + rut);
        super.escribirArchivo(this.archivo, "Fecha ingreso: " + fechaIngreso);
        super.escribirArchivo(this.archivo, "Cargo: " + cargo);
        super.escribirArchivo(this.archivo, "Afiliacion: " + afiliacion);
        super.escribirArchivo(this.archivo, "Salud: " + salud);
        super.escribirArchivo(this.archivo, "Seguro: " + seguro);
        super.escribirArchivo(this.archivo, "Dias trabajados: " + diasTrabajados);
        super.escribirArchivo(this.archivo, "Horas trabajadas: " + horasTrabajadas);
        super.escribirArchivo(this.archivo, "Horas extras realizadas: " + horasExtras);
        super.escribirArchivo(this.archivo, "------------Haberes------------"); 
        super.escribirArchivo(this.archivo, "Sueldo Base: " + sueldoBase);
        super.escribirArchivo(this.archivo, "Adicional horas extra: +" + adicionalHorasExtras);
        super.escribirArchivo(this.archivo, "Total imponible: " + sueldoBruto);
        super.escribirArchivo(this.archivo, "-----------Descuentos----------"); 
        super.escribirArchivo(this.archivo, "Cotizacion AFP: " + "-" + descuentoAfp);
        super.escribirArchivo(this.archivo, "Cotizacion Salud: " + "-" + descuentoSalud);
        super.escribirArchivo(this.archivo, "Seguro cesantia: " + "-" + descuentoSeguro);
        super.escribirArchivo(this.archivo, "total Descuentos: " + "-" + totalDescuento);
        super.escribirArchivo(this.archivo, "-------------Sueldo------------");
        super.escribirArchivo(this.archivo, "Sueldo liquido: "+ sueldoLiquido);
        
    }

    public File getArchivo() {
        return archivo;
    }
    


    
    
}
