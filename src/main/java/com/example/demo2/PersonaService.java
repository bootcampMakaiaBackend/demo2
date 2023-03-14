package com.example.demo2;

import com.example.demo2.exeception.ApiRequestException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaService {
    private List<Persona> personas;

    public PersonaService() {
        this.personas = new ArrayList<>();
    }

    public List<Persona> obtenerPersonas() {
        return personas;
    }

    public Persona crearPersona(Persona persona) {
        if(persona.getCedula() == null || persona.getNombre() ==null){
            throw new ApiRequestException("por obligacion la cedula y el nombre deben de ser diferentes de nulos");
        }
        this.personas.add(persona);
        return persona;
    }

    public Persona obtenerPersonaCedula(String cedula) {
        return personas.stream()
                .filter(x -> x.getCedula().equals(cedula))
                .findFirst().get();
    }

    public Persona eliminar(String cedula) {
        Persona persona = obtenerPersonaCedula(cedula);
        personas.remove(persona);
        return persona;
    }

    public List<Persona> personasCiudad(String ciudad) {
        return personas.stream()
                .filter(x -> x.getCiudad().equals(ciudad))
                .collect(Collectors.toList());
    }
}
