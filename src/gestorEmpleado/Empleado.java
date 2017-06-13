package gestorEmpleado;

public class Empleado {

    //Atributos propios de la clase
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String rut;
    private String fechaNacimiento;
    private String fechaIngreso;
    private String telefono;
    private String sexo;
    private String estadoCivil;
    private int horasPorDia;
    
    //Setter atributos
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }
    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setHorasPorDia(int horasPorDia) {
        this.horasPorDia = horasPorDia;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    
    //Atributos asociados
    private Trabajo trabajo;
    private Registro registros;
    private Salud descuentoSalud;
    private Seguro descuentoSeguro;
    private Afiliacion descuentoAfiliacion;
    private Liquidacion liquidacion;

    //Metodos asociaciones
    public void setTrabajo(Trabajo trabajo) {
        this.trabajo = trabajo;
    }
    public void setDescuentoSalud(Salud descuentoSalud) {
        this.descuentoSalud = descuentoSalud;
    }
    public void setDescuentoSeguro(Seguro descuentoSeguro) {
        this.descuentoSeguro = descuentoSeguro;
    }
    public void setDescuentoAfiliacion(Afiliacion descuentoAfiliacion) {
        this.descuentoAfiliacion = descuentoAfiliacion;
    }
    public void setLiquidacion(Liquidacion liquidacion) {
        this.liquidacion = liquidacion;
    }

 
    //Getter de atributos asociados
    public int getValorHora() {
        return trabajo.getValorHora();
    }
    public int getValorHoraExtra() {
        return trabajo.getValorHoraExtra();
    }
    //Getter atributos propios
    public int getHorasPorDias() {
        return horasPorDia;
    }

    
    //Constructor para crear un empleado
    public Empleado(String nombre, String apellidoPaterno, String apellidoMaterno, String rut, String fechaNacimiento,
            String fechaIngreso, String telefono, String sexo, String estadoCivil, int horasPorDia, 
            Trabajo trabajo, Salud descuentoSalud, Seguro descuentoSeguro, Afiliacion descuentoAfiliacion) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.rut = rut;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.telefono = telefono;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.horasPorDia = horasPorDia;
        this.trabajo = trabajo;
        this.descuentoSalud = descuentoSalud;
        this.descuentoSeguro = descuentoSeguro;
        this.descuentoAfiliacion = descuentoAfiliacion;
    }
    
}