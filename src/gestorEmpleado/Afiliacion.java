package gestorEmpleado;

public class Afiliacion extends Descuento{
    
  
    public Afiliacion(String nombreDescuento, double descuento) {
        super(nombreDescuento, descuento);
    }

    @Override
    public String toString() {
        return nombreDescuento;
    }
    
    
}
