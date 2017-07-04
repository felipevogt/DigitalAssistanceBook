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
public class ArchivoRegistro extends GestorArchivo{
    
    private File ruta;
    private File archivo;
    private String rutaEmpleado;

    /**
     * Constructor de la clase ArchivoRegistro, la cual es hija de la clase GestorArchivo
     * @param rutEmpleado, corresponde al rut del empleado que sera el nombre de la carpeta que tendra los archivos correspondiente a la liquidación
     * 
     */
    public ArchivoRegistro(String rutEmpleado) {
        this.rutaEmpleado = "Archivos\\" + rutEmpleado;
        this.ruta = new File(rutaEmpleado);
        this.ruta.mkdirs();
    }

    /**
     *Metodo heredado de GestorArchivo, el cual escribe en el archivo de texto
     * Cada empleado tendra varios archivos de registros
     * @param cadena, corresponde a la cadena que se almacenara en el archivo de texto
     * @param mes, corresponde a un mes, el cual sera parte del nombre del archivo de texto
     * @param ano, corresponde a un año, el cual sera parte del nombre del arhcivo de texto
     * el archivo se crea al momneto de llamar a este metodo
     */
    public void escribirArchivo(String cadena, String mes, String ano) {
        String rutaRegistros = this.rutaEmpleado + "\\" + mes + "-" + ano + ".txt";
        this.archivo = new File(rutaRegistros);
        super.escribirArchivo(this.archivo, cadena); 
    }
     /**
     *Metodo heredado de GestorArchivo, el cual modifica una linea del archivo de texto
     * @param cadenaAntigua, linea de texto la cual se borrara
     * @param cadenaNueva, linea de texto que remplazara la cadena antiguaaw
     * @param mes, mes que forma parte del nombre del archivo
     * @param ano, año que forma parte del nombre del archivo
     */
    public void modificarArchivo(String cadenaAntigua, String cadenaNueva, String mes, String ano) {
        String rutaRegistros = this.rutaEmpleado + "\\" + mes + "-" + ano + ".txt";
        this.archivo = new File(rutaRegistros);
        super.modificarArchivo(this.archivo, cadenaAntigua, cadenaNueva);
    }

     /**
     *Metodo heredado de GestorArchivo, el cual busca una linea
     * @param cadenaBuscada, corresponde a una cadena que se buscara dentro del archivo
     * @return retorna la linea encontrada que cotiene la cadenaBuscada
     */
    public String buscarEnArchivo(String cadenaBuscada, String mes, String ano) {
        String rutaRegistros = this.rutaEmpleado + "\\" + mes + "-" + ano + ".txt";
        this.archivo = new File(rutaRegistros);
        return super.buscarRegistro(this.archivo, cadenaBuscada); 
    }

     /**
     *Metodo heredado de GestorArchivo, el cual lee los datos que se encuentren en el archivo
     */
    public String leerArchivo(String mes, String ano) {
        String rutaRegistros = this.rutaEmpleado + "\\" + mes + "-" + ano + ".txt";
        this.archivo = new File(rutaRegistros);
        return super.leerArchivo(this.archivo); 
    }
     /**
     *get del archivo de texto, para posteriormente verificar su existencia
     */
    public File getArchivo(String mes, String ano) {
        String rutaRegistros = this.rutaEmpleado + "\\" + mes + "-" + ano + ".txt";
        this.archivo = new File(rutaRegistros);
        return this.archivo;
    }

  
    
    
}
