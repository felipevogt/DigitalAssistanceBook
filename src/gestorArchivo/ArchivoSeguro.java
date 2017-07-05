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
public class ArchivoSeguro extends GestorArchivo {
    
    private File ruta;
    private File archivo;
    
    /**
     * Constructor de la clase ArchivoSeguro, la cual es hija de la clase GestorArchivo
     * 
     */
    public ArchivoSeguro() {
        this.ruta = new File("Archivos");
        ruta.mkdir();
        String nuevaRuta = ruta.getName() + "\\" + "Seguros.txt";
        this.archivo = new File(nuevaRuta);
    }
    /**
     *Metodo heredado de GestorArchivo, el cual lee los datos que se encuentren en el archivo
     * @return retorna todo el contenido de un texto en una cadena
     */
    public String leerArchivo() {
        return super.leerArchivo(this.archivo); 
    }
    
}
