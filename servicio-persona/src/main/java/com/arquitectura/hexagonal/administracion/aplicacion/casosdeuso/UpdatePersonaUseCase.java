package com.arquitectura.hexagonal.administracion.aplicacion.casosdeuso;

import com.arquitectura.hexagonal.administracion.aplicacion.dto.PersonaRequestDto;
import com.arquitectura.hexagonal.administracion.aplicacion.mapper.PersonaMapperApp;
import com.arquitectura.hexagonal.administracion.dominio.modelo.Persona;
import com.arquitectura.hexagonal.administracion.dominio.servicio.UpdatePersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author johana 4/04/2022
 */

@Service
@RequiredArgsConstructor
public class UpdatePersonaUseCase {

    private final UpdatePersonaService updatePersonaService;
    private final PersonaMapperApp personaMapper;

    public PersonaRequestDto ejecutar(PersonaRequestDto personaRequestDto) {
        Persona persona = updatePersonaService.actualizarPersona(personaMapper.fromPersonaRequest(personaRequestDto));
        return personaMapper.personaToPersonaRequest(persona);
    }

}
