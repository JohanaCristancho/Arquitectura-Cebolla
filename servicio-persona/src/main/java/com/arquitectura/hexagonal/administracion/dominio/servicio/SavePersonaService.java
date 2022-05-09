package com.arquitectura.hexagonal.administracion.dominio.servicio;

import com.arquitectura.hexagonal.administracion.dominio.excepciones.PersonaDuplicadaExcepcion;
import com.arquitectura.hexagonal.administracion.dominio.modelo.Persona;
import com.arquitectura.hexagonal.administracion.dominio.repositorio.PersonaRepositorioPort;

/**
 * @author johana 31/03/2022
 */

public class SavePersonaService {

    private final PersonaRepositorioPort personaRepositorioPort;

    public SavePersonaService(PersonaRepositorioPort personaRepositorioPort) {
        this.personaRepositorioPort = personaRepositorioPort;
    }

    public Persona registrarPersona(Persona persona) {
        validarPersonaExisteConNumeroCedula(persona.getDocumento());
        return personaRepositorioPort.savePersona(persona);
    }

    public void validarPersonaExisteConNumeroCedula(String documento) {
        Persona personaExiste = personaRepositorioPort.findByDocumento(documento);
        if (personaExiste != null) {
            throw new PersonaDuplicadaExcepcion("El documento " + documento + " que intenta registar ya esta asociada a otra persona");
        }
    }
}
