package gestorArchivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;

public abstract class GestorArchivo {
    
    //permite escribir en un archivo si existe, caso contrario lo crea.
    //necesita como entrada la ubicacion del archivo y el String para guardar
    public void escribirArchivo(File archivo,String cadena){
        try {
            if(!archivo.exists()){
                archivo.createNewFile();
            }
            
            BufferedWriter escribe = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo,true),
                    "utf-8"));

            escribe.write(cadena + "\r\n");

            escribe.close();
        } catch (Exception ex) {
        } 
    }

    //Permite leer el contenido guardado en un archivo
    public String leerArchivo(File archivo){
        try {
            /*Si existe el fichero*/
            if(archivo.exists()){
                /*Abre un flujo de lectura a el fichero*/
                BufferedReader lee= new BufferedReader(new FileReader(archivo));
                String linea;
                String leyendo="";
               
                while((linea=lee.readLine())!=null) {
                leyendo= leyendo+linea;            
                }
                
                /*Cierra el flujo*/
                lee.close();
                return leyendo;
            }else{
                System.out.println("Fichero No Existe");
                return "";
            }
        } catch (Exception ex) {
            return "";
        }
    }

    //Borra el archivo
    public void borrarArchivo(File archivo){
        try {
            if(archivo.exists()){
                archivo.delete(); 
            }
        } catch (Exception ex) {
        }
    } 

    //Crea un nuevo archivo con los datos modificados y elimina el archivo con los datos antiguos
    public void modificarArchivo(File archivoAntiguo,String cadenaAntigua,String cadenaNueva){        
        
        String nombreArchivoNuevo = "modificando.txt";
        File archivoNuevo = new File(nombreArchivoNuevo);
        try {
            if(archivoAntiguo.exists()){
                BufferedReader lee = new BufferedReader(new FileReader(archivoAntiguo));
                String cadena;
                while((cadena = lee.readLine())!=null) { 
                    if (cadena.toUpperCase().trim().equals(cadenaAntigua.toUpperCase().trim())) {
                        escribirArchivo(archivoNuevo, cadenaNueva);
                    }else{
                         escribirArchivo(archivoNuevo, cadena);
                    }             
                }
                lee.close();
                borrarArchivo(archivoAntiguo);
                archivoNuevo.renameTo(archivoAntiguo);
               
            }else{
            }
        } catch (Exception ex) {
        }
    }

    public void eliminarRegistro(File archivoAntiguo,String cadenaAntigua){        
        String nombreArchivoNuevo = "modificando.txt";
        File archivoNuevo = new File(nombreArchivoNuevo);
        try {
            if(archivoAntiguo.exists()){
                BufferedReader lee= new BufferedReader(new FileReader(archivoAntiguo));
                String cadena;
                while((cadena = lee.readLine())!=null) { 
                    if (!cadena.toUpperCase().trim().equals(cadenaAntigua.toUpperCase().trim())) {
                       escribirArchivo(archivoNuevo,cadena);
                    }else{
                    }             
                }
                lee.close();
                borrarArchivo(archivoAntiguo);
                archivoNuevo.renameTo(archivoAntiguo);
            }else{           
            }
        } catch (Exception ex) { 
        }
    }

}
