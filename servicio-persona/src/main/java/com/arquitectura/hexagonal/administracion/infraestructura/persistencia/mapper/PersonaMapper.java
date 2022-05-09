package com.arquitectura.hexagonal.administracion.infraestructura.persistencia.mapper;

import com.arquitectura.hexagonal.administracion.dominio.modelo.Persona;
import com.arquitectura.hexagonal.administracion.infraestructura.persistencia.entidad.PersonaEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author johana 1/04/2022
 */

@Mapper(componentModel = "spring")
public interface PersonaMapper {

    Persona fromPersonaEntity(PersonaEntity personaEntity);
    PersonaEntity personatoPersonaEntity(Persona persona);
    List<Persona> listPersona(List<PersonaEntity> personas);
}
