package digitalassistancebook;

import java.util.ArrayList;

public class Empleado {

    //Atributos propios de la clase
    private String nombre;
    private String rut;
    private String fechaIngreso;
    private String telefono;
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
    
    
    //Atributos asociados
    private Trabajo trabajo;
    private ArrayList<Registro> registros = new ArrayList<Registro>();;
    private ArrayList<Descuento> descuentos = new ArrayList<Descuento>();;
    private ArrayList<Liquidacion> liquidaciones = new ArrayList<Liquidacion>();;

    //Metodos asociaciones
    public void setTrabajo(Trabajo trabajo) {
        this.trabajo = trabajo;
    }
    public void agregarRegistros(Registro registro) {
        this.registros.add(registro);
    }
    public void agregarDescuentos(Descuento descuento1, Descuento descuento2, Descuento descuento3) {
        this.descuentos.add(descuento1);
        this.descuentos.add(descuento2);
        this.descuentos.add(descuento3);
    }
    public void guardarLiquidacion(Liquidacion liquidacion){
        this.liquidaciones.add(liquidacion);
    }

    
    //Getter de atributos asociados
    public int getValorHora() {
        return trabajo.getValorHora();
    }
    public int getValorHoraExtra() {
        return trabajo.getValorHoraExtra();
    }
    public ArrayList<Registro> getRegistros() {
        return registros;
    }
    public ArrayList<Descuento> getDescuentos() {
        return descuentos;
    }
    public ArrayList<Liquidacion> getLiquidaciones() {
        return liquidaciones;
    }
    
    //Getter atributos propios
    public int getHorasPorDias() {
        return horasPorDia;
    }
    
}