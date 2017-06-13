
package gestorEmpleado;


public class Viatico {
    
    private String nombre;
    private int valor;

    public String getNombre() {
        return nombre;
    }


    public Viatico(String nombre, int valor) {
        this.nombre = nombre;
        this.valor = valor;
      
    }
    
    public int extra(int diasTrabajado ){
    
    return this.valor*diasTrabajado;
    
    }
    
    
    
}
