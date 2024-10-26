package co.edu.uniquindio.poo;

public class Moto extends Vehiculo {
    private int cambios;
    private int velocidadMaxima;
    private int cilindraje;

    public Moto(String marca, boolean esNuevo, String modelo, String tipoCombustible, String transmision,
                int cambios, int velocidadMaxima, int cilindraje) {
        super(marca, esNuevo, modelo, tipoCombustible, transmision);
        this.cambios = cambios;
        this.velocidadMaxima = velocidadMaxima;
        this.cilindraje = cilindraje;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("----- Moto -----");
        System.out.println("Marca: " + marca);
        System.out.println("Estado: " + (esNuevo ? "Nuevo" : "Usado"));
        System.out.println("Modelo: " + modelo);
        System.out.println("Tipo de Combustible: " + tipoCombustible);
        System.out.println("Transmisión: " + transmision);
        System.out.println("Cambios: " + cambios);
        System.out.println("Velocidad Máxima: " + velocidadMaxima + " km/h");
        System.out.println("Cilindraje: " + cilindraje + " cc");
        System.out.println("-----------------");
    }
}

