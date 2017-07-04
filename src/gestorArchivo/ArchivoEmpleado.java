package gestorArchivo;
import java.io.File;
/**
 *
 * @author Javiera Jara, Alvaro Vega, Felipe Vogt
 */



public class ArchivoEmpleado extends GestorArchivo{
 
    private File ruta;
    private File archivo;
    
     /**
     * Constructor de la clase ArchivoEmpleado, la cual es hija de la clase GestorArchivo
     * 
     */
    public ArchivoEmpleado() {
        this.ruta = new File("Archivos");
        ruta.mkdir();
        String nuevaRuta = ruta.getName() + "\\" + "Empleados.txt";
        this.archivo = new File(nuevaRuta);
    }
     /**
     *Metodo heredado de GestorArchivo, el cual escribe en el archivo
     * @param candena, corresponde a la cadena que se guardara en el archivo de texto
     */
    public void escribirArchivo(String cadena) {
        super.escribirArchivo(this.archivo, cadena); 
    }
     /**
     *Metodo heredado de GestorArchivo, el cual lee los datos que se encuentren en el archivo
     */
    public String leerArchivo(){
        return super.leerArchivo(this.archivo);
    }
     /**
     *Metodo heredado de GestorArchivo, Modifica una linea que se encuentre en el archivo
     * @param cadenaAntigua, este parametro corresponde a la cadena antigua del texto la cual se modificara
     * @param cadenaNueva, este parametro corresponde a la nueva cadena que remplazara la cadena antigua
     */
    public void modificarArchivo(String cadenaAntigua, String cadenaNueva) {
        super.modificarArchivo(this.archivo, cadenaAntigua, cadenaNueva);
    }
    
     /**
     *Metodo heredado de GestorArchivo, el cual elimina una linea del archivo de texto
     * @param cadenaAntigua, corresponde a la cadena que se borrara del archivo
     */
    public void eliminarRegistro(String cadenaAntigua) {
        super.eliminarRegistro(this.archivo, cadenaAntigua);
    }

  
    
    
    
    
    
    
    
}
