package com.arquitectura.hexagonal.administracion.infraestructura.persistencia.mapper;

import com.arquitectura.hexagonal.administracion.dominio.modelo.Persona;
import com.arquitectura.hexagonal.administracion.infraestructura.persistencia.entidad.PersonaEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-26T21:04:20-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14 (Oracle Corporation)"
)
@Component
public class PersonaMapperImpl implements PersonaMapper {

    @Override
    public Persona fromPersonaEntity(PersonaEntity personaEntity) {
        if ( personaEntity == null ) {
            return null;
        }

        Persona persona = new Persona();

        persona.setId( personaEntity.getId() );
        persona.setNombre( personaEntity.getNombre() );
        persona.setApellido( personaEntity.getApellido() );
        persona.setDocumento( personaEntity.getDocumento() );
        persona.setTipoDocumento( personaEntity.getTipoDocumento() );
        persona.setEdad( personaEntity.getEdad() );

        return persona;
    }

    @Override
    public PersonaEntity personatoPersonaEntity(Persona persona) {
        if ( persona == null ) {
            return null;
        }

        PersonaEntity personaEntity = new PersonaEntity();

        personaEntity.setId( persona.getId() );
        personaEntity.setNombre( persona.getNombre() );
        personaEntity.setApellido( persona.getApellido() );
        personaEntity.setDocumento( persona.getDocumento() );
        personaEntity.setTipoDocumento( persona.getTipoDocumento() );
        personaEntity.setEdad( persona.getEdad() );

        return personaEntity;
    }

    @Override
    public List<Persona> listPersona(List<PersonaEntity> personas) {
        if ( personas == null ) {
            return null;
        }

        List<Persona> list = new ArrayList<Persona>( personas.size() );
        for ( PersonaEntity personaEntity : personas ) {
            list.add( fromPersonaEntity( personaEntity ) );
        }

        return list;
    }
}
