package com.example.demo2;

public class Persona {

    private String  cedula;
    private String nombre;
    private String apellido;
    private String edad;
    private String ciudad;

    public Persona(String nombre, String apellido, String edad, String ciudad, String cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.ciudad = ciudad;
        this.cedula = cedula;
    }


    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEdad() {
        return edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getCedula() {
        return cedula;
    }
}
