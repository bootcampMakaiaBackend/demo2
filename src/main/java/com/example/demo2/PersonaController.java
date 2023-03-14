package com.example.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/v1")
public class PersonaController {

    private PersonaService personaService;

    @Autowired
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }


    //agregar empleados
    @PostMapping("/personas")
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona persona) {
        Persona persona1 =  personaService.crearPersona(persona);
        return ResponseEntity.ok(persona1);
    }

    //obtener empleados
    @GetMapping("/personas")
    public List<Persona> obtenerPersonas() {
        return personaService.obtenerPersonas();
    }

    //Obtener empleado por cedula
    @GetMapping("/personas/{cedula}")
    public Persona obtenerPersonaCedula(@PathVariable("cedula") String cedula) {
        return personaService.obtenerPersonaCedula(cedula);
    }

    //Eliminar una Persona
    @DeleteMapping("/personas/{cedula}")
    public Persona eliminar(@PathVariable("cedula") String cedula) {
        return personaService.eliminar(cedula);
    }

    //Filtrar por ciudad
    //localhost:8080/api/v1/personas/?ciudad=Medellin
    @GetMapping("/personas/")
    public List<Persona> obtenerPersonasCiudad(@RequestParam String ciudad) {
        return personaService.personasCiudad(ciudad);
    }







}
