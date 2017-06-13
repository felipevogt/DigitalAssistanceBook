package gestorEmpleado;

public class Fonasa extends Salud{

    public Fonasa(String nombreDescuento, double descuento) {
        super(nombreDescuento, descuento);

    }

    @Override
    public String toString() {
        return this.nombreDescuento;
    }
    
}
