package com.arquitectura.hexagonal.administracion.aplicacion.mapper;

import com.arquitectura.hexagonal.administracion.aplicacion.dto.PersonaDto;
import com.arquitectura.hexagonal.administracion.aplicacion.dto.PersonaRequestDto;
import com.arquitectura.hexagonal.administracion.aplicacion.dto.PersonaResponseDto;
import com.arquitectura.hexagonal.administracion.aplicacion.feignimagenrepositorio.ImagenFeignRepositorio;
import com.arquitectura.hexagonal.administracion.dominio.modelo.Persona;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author johana 6/04/2022
 */

@Component
@AllArgsConstructor
public class PersonaMapperApp {

    private ImagenFeignRepositorio imagenFeignRepositorio;

    public Persona fromPersonaRequest(PersonaRequestDto personaRequestDto) {
        return new Persona(
                personaRequestDto.getId(),
                personaRequestDto.getNombre(),
                personaRequestDto.getApellido(),
                personaRequestDto.getDocumento(),
                personaRequestDto.getTipoDocumento(),
                personaRequestDto.getEdad());
    }

    public PersonaRequestDto personaToPersonaRequest(Persona persona) {
        return new PersonaRequestDto(
                persona.getId(),
                persona.getNombre(),
                persona.getApellido(),
                persona.getDocumento(),
                persona.getTipoDocumento(),
                persona.getEdad());
    }

    public PersonaResponseDto personaToPersonaResponse(Persona persona) {
        return new PersonaResponseDto(
                persona.getId(),
                persona.getNombre(),
                persona.getApellido(),
                persona.getDocumento(),
                persona.getTipoDocumento(),
                persona.getEdad(),
                imagenFeignRepositorio.obtenerImagenPorIdPersona(String.valueOf(persona.getId())));
    }

    public PersonaDto personaToPersonaDto(Persona persona) {
        return new PersonaDto(
                persona.getId(),
                persona.getNombre(),
                persona.getApellido(),
                persona.getDocumento(),
                persona.getTipoDocumento(),
                persona.getEdad());
    }

    public List<PersonaResponseDto> listPersona(List<Persona> personas) {
        if (personas == null) {
            return Collections.emptyList();
        }
        List<PersonaResponseDto> list = new ArrayList<>(personas.size());
        for (Persona persona : personas) {
            list.add(personaToPersonaResponse(persona));
        }
        return list;
    }
}
