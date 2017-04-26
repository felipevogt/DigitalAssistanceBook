package digitalassistancebook;
public class Trabajo {

    //Atributos propios de la clase
    private String tipoTrabajo;
    private int valorHora;
    private int valorHoraExtra;
    
    //Atributos de la asociacion
    private Empleado empleado;
    //Metodos de la asociacion
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    //Constructor
    public Trabajo(String tipoTrabajo, int valorHora, int valorHoraExtra) {
        this.tipoTrabajo = tipoTrabajo;
        this.valorHora = valorHora;
        this.valorHoraExtra = valorHoraExtra;
    }

    //Getter
    public String getTipoTrabajo() {
        return tipoTrabajo;
    }
    public int getValorHora() {
        return valorHora;
    }
    public int getValorHoraExtra() {
        return valorHoraExtra;
    }

}