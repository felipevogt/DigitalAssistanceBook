package gestorEmpleado;

public class Isapre extends Salud{
    
    public Isapre(String nombreDescuento, double descuento) {
        super(nombreDescuento, descuento);
    }

    @Override
    public String toString() {
        return nombreDescuento;
    }

    
    
    
}
