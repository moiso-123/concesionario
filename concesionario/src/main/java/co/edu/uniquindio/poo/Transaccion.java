package co.edu.uniquindio.poo;
import java.util.Date;

public class Transaccion {
    private String id;
    private Empleado empleado;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private Date fecha;
    private String tipo; // Venta, Alquiler, Compra

    public Transaccion(String id, Empleado empleado, Cliente cliente, Vehiculo vehiculo, Date fecha, String tipo) {
        this.id = id;
        this.empleado = empleado;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fecha = fecha;
        this.tipo = tipo;
    }

    // Getters y Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void mostrarDetalles() {
        System.out.println("----- Transacción -----");
        System.out.println("ID: " + id);
        System.out.println("Empleado: " + empleado.nombre);
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Vehículo: " + vehiculo.getMarca() + " " + vehiculo.getModelo());
        System.out.println("Fecha: " + fecha.toString());
        System.out.println("Tipo: " + tipo);
        System.out.println("-----------------------");
    }
}

