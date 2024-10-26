package co.edu.uniquindio.poo;

public abstract class Vehiculo {
    protected String marca;
    protected boolean esNuevo;
    protected String modelo;
    protected String tipoCombustible;
    protected String transmision;

    public Vehiculo(String marca, boolean esNuevo, String modelo, String tipoCombustible, String transmision) {
        this.marca = marca;
        this.esNuevo = esNuevo;
        this.modelo = modelo;
        this.tipoCombustible = tipoCombustible;
        this.transmision = transmision;
    }

    public String getMarca() {
        return marca;
    }

    public boolean isEsNuevo() {
        return esNuevo;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public String getTransmision() {
        return transmision;
    }

    public abstract void mostrarDetalles();
}
