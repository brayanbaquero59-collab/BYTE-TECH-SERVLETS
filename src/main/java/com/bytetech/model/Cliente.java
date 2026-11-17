package com.bytetech.model;

public class Cliente {
    private final String nombre;
    private final String correo;
    private final String telefono;
    private final String interes;

    public Cliente(String nombre, String correo, String telefono, String interes) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.interes = interes;
    }

    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getTelefono() { return telefono; }
    public String getInteres() { return interes; }
}
