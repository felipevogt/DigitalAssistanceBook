package gestorEmpleado;


public class Seguro extends Descuento {
    
    public Seguro(String nombreDescuento, double descuento) {
        super(nombreDescuento, descuento);
    }

    @Override
    public String toString() {
        return nombreDescuento;
    }
    
    
    
    
}
