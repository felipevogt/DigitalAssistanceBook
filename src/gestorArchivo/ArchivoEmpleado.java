package gestorArchivo;

import java.io.File;


public class ArchivoEmpleado extends GestorArchivo{
 
    private File ruta;
    private File archivo;

    public ArchivoEmpleado() {
        this.ruta = new File("Archivos");
        ruta.mkdir();
        String nuevaRuta = ruta.getName() + "\\" + "Empleados.txt";
        this.archivo = new File(nuevaRuta);
    }

    public void escribirArchivo(String cadena) {
        super.escribirArchivo(this.archivo, cadena); 
    }
    public String leerArchivo(){
        return super.leerArchivo(this.archivo);
    }
    
    
    
    
}
