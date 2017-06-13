package gestorEmpleado;
public class Trabajo {

    //Atributos propios de la clase
    private String tipoTrabajo;
    private int valorHora;
    private int valorHoraExtra;
    

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

    @Override
    public String toString() {
        return tipoTrabajo;
    }
    
    

}