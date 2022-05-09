package com.arquitectura.hexagonal.administracion.dominio.servicio;

import com.arquitectura.hexagonal.administracion.dominio.excepciones.PersonaNotFoundExcepcion;
import com.arquitectura.hexagonal.administracion.dominio.modelo.Persona;
import com.arquitectura.hexagonal.administracion.dominio.repositorio.PersonaRepositorioPort;

import java.util.List;

/**
 * @author johana 6/04/2022
 */

public class FindPersonaService {

    private final PersonaRepositorioPort personaRepositorioPort;

    public FindPersonaService(PersonaRepositorioPort personaRepositorioPort) {
        this.personaRepositorioPort = personaRepositorioPort;
    }

    public List<Persona> buscarListaPersonas() {
        return personaRepositorioPort.findByAllPersonas();
    }

    public Persona buscarPersonaPorDocumento(String documento) {
        Persona persona = personaRepositorioPort.findByDocumento(documento);
        if (persona == null) {
            throw new PersonaNotFoundExcepcion("Persona con documento " + documento + " no existe");
        }
        return persona;
    }

    public Persona buscarPersonaPorId(long id) {
        Persona persona = personaRepositorioPort.findById(id);
        if (persona == null) {
            throw new PersonaNotFoundExcepcion("Persona con id " + id + " no existe");
        }
        return persona;
    }
}
