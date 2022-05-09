package com.arquitectura.hexagonal.administracion.dominio.servicio;

import com.arquitectura.hexagonal.administracion.dominio.excepciones.PersonaDuplicadaExcepcion;
import com.arquitectura.hexagonal.administracion.dominio.modelo.Persona;
import com.arquitectura.hexagonal.administracion.dominio.repositorio.PersonaRepositorioPort;

/**
 * @author johana 31/03/2022
 */

public class UpdatePersonaService {

    private final PersonaRepositorioPort personaRepositorioPort;

    public UpdatePersonaService(PersonaRepositorioPort personaRepositorioPort) {
        this.personaRepositorioPort = personaRepositorioPort;
    }

    public Persona actualizarPersona(Persona persona) {
        validarPersonaExisteConNumeroCedula(persona);
        return personaRepositorioPort.savePersona(persona);
    }

    public void validarPersonaExisteConNumeroCedula(Persona persona) {
        Persona personaExiste = personaRepositorioPort.findByDocumento(persona.getDocumento());
        if (personaExiste != null && personaExiste.getId() != persona.getId()) {
            throw new PersonaDuplicadaExcepcion("El documento " + persona.getDocumento() + " que intenta registar ya esta asociada a otra persona");
        }
    }

}
