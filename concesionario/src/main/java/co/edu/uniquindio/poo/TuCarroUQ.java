package co.edu.uniquindio.poo;

import java.util.Date;
// TuCarroUQ.java
import java.util.LinkedList;
import java.util.Scanner;


public class TuCarroUQ {
    private LinkedList<Vehiculo> vehiculos;
    private LinkedList<Cliente> clientes;
    private LinkedList<Empleado> empleados;
    private LinkedList<Transaccion> transacciones;
    private Administrador admin;

    public TuCarroUQ() {
        vehiculos = new LinkedList<>();
        clientes = new LinkedList<>();
        empleados = new LinkedList<>();
        transacciones = new LinkedList<>();
        // Crear un administrador por defecto
        admin = new Administrador("admin1", "Administrador", "moiso", "moiso@173");
        empleados.add(admin);
    }

    public void iniciarSistema() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido a Tu Carro UQ");
        // Implementar autenticación 
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = scanner.nextLine();

        Empleado empleadoLogueado = autenticar(usuario, contraseña);
        if (empleadoLogueado != null) {
            System.out.println("¡Bienvenido, " + empleadoLogueado.nombre + "!");
            // Menú de opciones
            boolean salir = false;
            while (!salir) {
                System.out.println("Seleccione una opción:");
                System.out.println("1. Registrar Vehículo");
                System.out.println("2. Registrar Cliente");
                System.out.println("3. Realizar Venta");
                System.out.println("4. Realizar Alquiler");
                System.out.println("5. Salir");
                int opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        registrarVehiculo(scanner);
                        break;
                    case 2:
                        registrarCliente(scanner);
                        break;
                    case 3:
                        realizarVenta(scanner, empleadoLogueado);
                        break;
                    case 4:
                        realizarAlquiler(scanner, empleadoLogueado);
                        break;
                    case 5:
                        salir = true;
                        System.out.println("Saliendo del sistema. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                }
            }
        } else {
            System.out.println("Credenciales inválidas. Acceso denegado.");
        }
        
    }

    private Empleado autenticar(String usuario, String contraseña) {
        for (Empleado emp : empleados) {
            if (emp.usuario.equals(usuario) && emp.contraseña.equals(contraseña)) {
                return emp;
            }
        }
        return null;
    }

    private void registrarVehiculo(Scanner scanner) {
        System.out.println("Seleccione el tipo de vehículo a registrar:");
        System.out.println("1. Moto");
        // Agregar opciones para otros tipos de vehículos
        int tipo = Integer.parseInt(scanner.nextLine());

        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("¿Es nuevo? (true/false): ");
        boolean esNuevo = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Tipo de Combustible: ");
        String combustible = scanner.nextLine();
        System.out.print("Transmisión (Manual/Automática): ");
        String transmision = scanner.nextLine();

        switch (tipo) {
            case 1:
                System.out.print("Cambios: ");
                int cambios = Integer.parseInt(scanner.nextLine());
                System.out.print("Velocidad Máxima (km/h): ");
                int velocidadMax = Integer.parseInt(scanner.nextLine());
                System.out.print("Cilindraje (cc): ");
                int cilindraje = Integer.parseInt(scanner.nextLine());
                Moto moto = new Moto(marca, esNuevo, modelo, combustible, transmision, cambios, velocidadMax, cilindraje);
                vehiculos.add(moto);
                System.out.println("Moto registrada exitosamente.");
                break;
            // Implementar casos para otros tipos de vehículos
            default:
                System.out.println("Tipo de vehículo no soportado.");
        }
    }

    private void registrarCliente(Scanner scanner) {
        System.out.print("Nombre del Cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.println("Id del cliente");
        String id = scanner.nextLine();

        Cliente cliente = new Cliente(nombre, direccion, telefono, email, id);
        clientes.add(cliente);
        System.out.println("Cliente registrado exitosamente.");
    }

    private void realizarVenta(Scanner scanner, Empleado empleado) {
        boolean prueba= false;

        while (prueba==false) {
            
        
        System.out.print("Ingrese el ID del cliente: ");
        String idCliente = scanner.nextLine();
        Cliente cliente = buscarCliente(idCliente);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Ingrese el modelo del vehículo a vender: ");
        String modelo = scanner.nextLine();
        Vehiculo vehiculo = buscarVehiculo(modelo);
        if (vehiculo == null) {
            System.out.println("Vehículo no disponible.");
            return;
        }

        Transaccion venta = new Transaccion("T" + (transacciones.size() + 1), empleado, cliente, vehiculo, new Date(), "Venta");
        transacciones.add(venta);
        vehiculos.remove(vehiculo);
        System.out.println("Venta realizada exitosamente.");
        prueba=true;

    }
    }

    private void realizarAlquiler(Scanner scanner, Empleado empleado) {
        System.out.print("Ingrese el ID del cliente: ");
        String idCliente = scanner.nextLine();
        Cliente cliente = buscarCliente(idCliente);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Ingrese el modelo del vehículo a alquilar: ");
        String modelo = scanner.nextLine();
        Vehiculo vehiculo = buscarVehiculo(modelo);
        if (vehiculo == null) {
            System.out.println("Vehículo no disponible.");
            return;
        }

        Transaccion alquiler = new Transaccion("T" + (transacciones.size() + 1), empleado, cliente, vehiculo, new Date(), "Alquiler");
        transacciones.add(alquiler);
        System.out.println("Alquiler realizado exitosamente.");
    }

    private Cliente buscarCliente(String id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equalsIgnoreCase(id)) { // Simplificación: Usar nombre como ID
                return cliente;
            }
        }
        return null;
    }

    private Vehiculo buscarVehiculo(String modelo) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getModelo().equalsIgnoreCase(modelo)) {
                return vehiculo;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TuCarroUQ sistema = new TuCarroUQ();
        sistema.iniciarSistema();
    }
}
