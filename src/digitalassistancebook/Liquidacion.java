package digitalassistancebook;
public class Liquidacion {

    //Atributos
    private String fechaPago;
    private int numeroLiquidacion;
    private double montoFinal;

    public Liquidacion(String fechaPago, int numeroLiquidacion) {
        this.fechaPago = fechaPago;
        this.numeroLiquidacion = numeroLiquidacion;
    }
    //Set y get monto final
    public void setMontoFinal(double montoFinal) {
        this.montoFinal = montoFinal;
    }
    public double getMontoFinal() {
        return montoFinal;
    }
    
    //Metodos
    public int calcularSueldoBruto(Empleado empleado){
        int totalHoras = 0;
        for (int i = 0; i < empleado.getRegistros().size(); i++){
            totalHoras = totalHoras + empleado.getRegistros().get(i).calcularHorasDiarias()*empleado.getValorHora() + empleado.getRegistros().get(i).calcularHorasExtrasDiarias()*empleado.getValorHoraExtra(); 
        }
        return totalHoras;
    }
    public double calcularSueldoLiquido(Empleado empleado){
        double sueldoLiquido = this.calcularSueldoBruto(empleado);
        for (int i = 0; i < empleado.getDescuentos().size(); i++){
            sueldoLiquido = sueldoLiquido - this.calcularSueldoBruto(empleado)*empleado.getDescuentos().get(i).getDescuento();
        }
        return sueldoLiquido;
    }
    public void mostrarLiquidacion(Empleado empleado){
        System.out.println("sueldo bruto: " + this.calcularSueldoBruto(empleado));
        for (int i = 0; i<empleado.getDescuentos().size(); i++){
            System.out.println("- " + this.calcularSueldoBruto(empleado)*empleado.getDescuentos().get(i).getDescuento());
        }
        System.out.println("Su sueldo es de: " + this.calcularSueldoLiquido(empleado));
    }

}