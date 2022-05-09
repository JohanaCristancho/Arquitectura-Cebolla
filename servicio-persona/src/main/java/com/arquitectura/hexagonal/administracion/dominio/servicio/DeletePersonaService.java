package com.arquitectura.hexagonal.administracion.dominio.servicio;

import com.arquitectura.hexagonal.administracion.dominio.excepciones.PersonaNotFoundExcepcion;
import com.arquitectura.hexagonal.administracion.dominio.repositorio.PersonaRepositorioPort;

/**
 * @author johana 31/03/2022
 */

public class DeletePersonaService {

    private final PersonaRepositorioPort personaRepositorioPort;

    public DeletePersonaService(PersonaRepositorioPort personaRepositorioPort) {
        this.personaRepositorioPort = personaRepositorioPort;
    }

    public void eliminarPersona(Long idPersona) {
        existePersona(idPersona);
        personaRepositorioPort.deletePersona(idPersona);
    }

    public void existePersona(Long idPersona) {
        if (!personaRepositorioPort.existePersona(idPersona)) {
            throw new PersonaNotFoundExcepcion("Persona con id " + idPersona + " no existe");
        }
    }
}
