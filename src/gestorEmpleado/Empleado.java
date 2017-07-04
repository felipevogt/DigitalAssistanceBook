package gestorEmpleado;
/**
 *
 * @author Javiera Jara, Alvaro Vega, Felipe Vogt
 */

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
    private String codTrabajo;
    private Registro registros;
    private String codSalud;
    private String codSeguro;
    private String codAfiliacion;

    
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
    public void setCodTrabajo(String codTrabajo) {
        this.codTrabajo = codTrabajo;
    }
    public void setCodSalud(String codSalud) {
        this.codSalud = codSalud;
    }
    public void setCodSeguro(String codSeguro) {
        this.codSeguro = codSeguro;
    }
    public void setCodAfiliacion(String codAfiliacion) {
        this.codAfiliacion = codAfiliacion;
    }

    public Empleado(String rut, String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, String fechaIngreso, String telefono, String sexo, String estadoCivil, int horasPorDia, String codTrabajo, String codSalud, String codSeguro, String codAfiliacion) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.telefono = telefono;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.horasPorDia = horasPorDia;
        this.codTrabajo = codTrabajo;
        this.codSalud = codSalud;
        this.codSeguro = codSeguro;
        this.codAfiliacion = codAfiliacion;
    }

    @Override
    public String toString() {
        return nombre + " " + apellidoPaterno + " " + apellidoMaterno + " " + rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getRut() {
        return rut;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public int getHorasPorDia() {
        return horasPorDia;
    }

    public String getCodTrabajo() {
        return codTrabajo;
    }

    public Registro getRegistros() {
        return registros;
    }

    public String getCodSalud() {
        return codSalud;
    }

    public String getCodSeguro() {
        return codSeguro;
    }

    public String getCodAfiliacion() {
        return codAfiliacion;
    }
    

    
}