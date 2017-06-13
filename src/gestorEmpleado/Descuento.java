package gestorEmpleado;

public abstract class  Descuento {

    //Atributos propios de la clase
    protected String nombreDescuento;
    protected double descuento;

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