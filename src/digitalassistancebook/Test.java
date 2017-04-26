package digitalassistancebook;
public class Test {
    
    public static void main(String[] args) {
        
        //Test 1
        
        //Creacion de un empleado
        Empleado empleado1 = new Empleado();
        empleado1.setNombre("Pedro");
        empleado1.setRut("19304584-7");
        empleado1.setTelefono("+56984059140");
        empleado1.setFechaIngreso("25-04-20107");
        empleado1.setHorasPorDia(5);
        
        //Creacion de un trabajo
        Trabajo carpintero = new Trabajo("Carpintero", 5000, 2000);
        //Asociar empleado1 con carpintero
        empleado1.setTrabajo(carpintero);
        carpintero.setEmpleado(empleado1);
        
        //Crear 3 descuentos
        Descuento desc1 = new Descuento("Cuprum", 0.07);
        Descuento desc2 = new Descuento("Provida", 0.05);
        Descuento desc3 = new Descuento("Cruz blanca", 0.09);
        //Asociar empleado1 con descuentos
        empleado1.agregarDescuentos(desc1, desc2, desc3);
        desc1.setEmpleado(empleado1);
        desc2.setEmpleado(empleado1);
        desc3.setEmpleado(empleado1);
        
        //Crear registros
        Registro r1 = new Registro();
        r1.setFecha("01-01-2017");
        r1.setHoraEntrada(8);
        r1.setHoraSalida(18);
        r1.setMinutoEntrada(30);
        r1.setMinutoSalida(50);
        empleado1.agregarRegistros(r1);
        r1.setEmpleado(empleado1);
        
        Registro r2 = new Registro();
        r2.setFecha("02-01-2017");
        r2.setHoraEntrada(8);
        r2.setHoraSalida(18);
        r2.setMinutoEntrada(30);
        r2.setMinutoSalida(50);
        empleado1.agregarRegistros(r2);
        r2.setEmpleado(empleado1);
        
        Registro r3 = new Registro();
        r3.setFecha("03-01-2017");
        r3.setHoraEntrada(8);
        r3.setHoraSalida(18);
        r3.setMinutoEntrada(30);
        r3.setMinutoSalida(50);
        empleado1.agregarRegistros(r3);
        r3.setEmpleado(empleado1);
        
        Registro r4 = new Registro();
        r4.setFecha("04-01-2017");
        r4.setHoraEntrada(8);
        r4.setHoraSalida(18);
        r4.setMinutoEntrada(30);
        r4.setMinutoSalida(50);
        empleado1.agregarRegistros(r4);
        r4.setEmpleado(empleado1);
        
        Registro r5 = new Registro();
        r5.setFecha("05-01-2017");
        r5.setHoraEntrada(8);
        r5.setHoraSalida(18);
        r5.setMinutoEntrada(30);
        r5.setMinutoSalida(50);
        empleado1.agregarRegistros(r5);
        r5.setEmpleado(empleado1);
        
        //Crear liquidacion
        Liquidacion l1 = new Liquidacion("26-04-2017", 01);
        l1.setMontoFinal(l1.calcularSueldoLiquido(empleado1));
        System.out.println(l1.calcularSueldoBruto(empleado1));
        System.out.println(l1.calcularSueldoLiquido(empleado1));
        l1.mostrarLiquidacion(empleado1);
        System.out.println(l1.getMontoFinal());
        empleado1.guardarLiquidacion(l1);
        System.out.println(empleado1.getLiquidaciones().get(0).getMontoFinal());
        
    }
}
