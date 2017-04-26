package digitalassistancebook;
public class Registro {

    //Atributos propios de la clase
    private String fecha;
    private int horaEntrada;
    private int minutoEntrada;
    private int horaSalida;
    private int minutoSalida;

    //Atributos de la asociacion
    private Empleado empleado;
    //Metodos de la asociacion
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    //Setter 
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public void setHoraEntrada(int horaEntrada) {
        this.horaEntrada = horaEntrada;
    }
    public void setMinutoEntrada(int minutoEntrada) {
        this.minutoEntrada = minutoEntrada;
    }
    public void setHoraSalida(int horaSalida) {
        this.horaSalida = horaSalida;
    }
    public void setMinutoSalida(int minutoSalida) {
        this.minutoSalida = minutoSalida;
    }
    
    //Metodos
    public int calcularHorasDiarias(){
        if (this.minutoSalida - this.minutoEntrada < 0){
            if (((this.horaSalida - this.horaEntrada) - 1) >= empleado.getHorasPorDias()){
                return empleado.getHorasPorDias();                
            }else{
                return (this.horaSalida - this.horaEntrada) - 1;
            }
           
        }else{
            if ((this.horaSalida - this.horaEntrada) >= empleado.getHorasPorDias()){
                return empleado.getHorasPorDias();                
            }else{
                return (this.horaSalida - this.horaEntrada);
            }

            }
    }  
    public int calcularHorasExtrasDiarias(){
        
        if (this.minutoSalida - this.minutoEntrada < 0){
            if ((this.horaSalida - this.horaEntrada) - 1 > empleado.getHorasPorDias()){
                return ((this.horaSalida - this.horaEntrada) - 1) - empleado.getHorasPorDias();
            }else{
                return 0;
            }
        }else{
            if ((this.horaSalida - this.horaEntrada) > empleado.getHorasPorDias()){
                return (this.horaSalida - this.horaEntrada) - empleado.getHorasPorDias();
            }else{
                return 0;
            }
        }

    }



}