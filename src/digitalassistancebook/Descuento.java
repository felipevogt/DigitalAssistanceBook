package digitalassistancebook;
public class Descuento {

    //Atributos propios de la clase
    private String nombreDescuento;
    private double descuento;

    //Atributos de la asociacion
    private Empleado empleado;
    //Metodos de la asociacion
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    //Constructor
    public Descuento(String nombreDescuento, double descuento) {
        this.nombreDescuento = nombreDescuento;
        this.descuento = descuento;
    }

    //Getter
    public String getNombreDescuento() {
        return nombreDescuento;
    }
    public double getDescuento() {
        return descuento;
    }


    
    

}