package gestorArchivo;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
/**
 *
 * @author Javiera Jara, Alvaro Vega, Felipe Vogt
 */
public abstract class GestorArchivo {
    
    /**
     *Metedo para escribir en un archivo, en caso de que no exista crea el archivo de texto
     * @param archivo corresponde a un archivo de tipo File a la cual se le quiere guardar una linea de texto
     * @param cadena corresponde a la cadena que se escribira en el archivo
     */
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

    /**
     *Metodo para leer un archivo de texto completo
     * @param archivo, corresponde a un archivo tipo File el cual se quiere leer su contenido
     * @return retorna todo el contenido de un texto en una cadena
     */
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

    /**
     *Metodo para borrar un archivo en caso de que se necesite
     * @param archivo, corresponde al archivo que se quiere eliminar
     */
    public void borrarArchivo(File archivo){
        try {
            if(archivo.exists()){
                archivo.delete(); 
            }
        } catch (Exception ex) {
        }
    } 

    /**
     *Metodo para modificar un archivo de texto, crea 2 archivos uno sin modificar y otro modificado, el arhivo
     * sin modigica se borra para que solo quede el archivo modificado.
     * @param archivoAntiguo, corresponde al archivo sin modificar que posteriormente sera modificado y eliminado
     * @param cadenaAntigua, corresponde a la cadena que se quiere modificar
     * @param cadenaNueva, corresponde a la cadena que va a remplazar la cadena antigua
     */
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

     /**
     *Metodo que elimina una linea que se encuentre en un archivo
     * @param archivoAntiguo corresponde al archivo que se le eliminara una linea
     * @param  cadenaAntigua corresponde a la linea que se eliminara
     */
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
    /**
     *Metodo para buscar algun registro en un archivo de texto
     * @param archivo, corresponde al archivo que se le buscaran datos
     * @param cadenaBuscada, corresponde a una cadena que se buscara en el archivo en caso de encontrala retornara toda la cadena que contenga la cadenaBuscada
     * @return retorna la cadena que contiene cadenaBuscada
     */
    public String buscarRegistro(File archivo,String cadenaBuscada){
        try {
            if(archivo.exists()){
                BufferedReader lee = new BufferedReader(new FileReader(archivo));
                String cadena;
                String cadenaEncontrada="";
                while((cadena = lee.readLine())!=null) { 
                    if (cadena.toUpperCase().trim().contains(cadenaBuscada.toUpperCase().trim())) {
                        cadenaEncontrada=cadena;
                    }
                }
                lee.close();
                return cadenaEncontrada;
                              
            }else{
                return "";
            }
        } catch (Exception ex) {
            return "";
            
        }
        
    }

}
