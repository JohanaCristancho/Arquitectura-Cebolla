package com.arquitectura.hexagonal.administracion.infraestructura.persistencia.repositorio.impl;

import com.arquitectura.hexagonal.administracion.dominio.modelo.Persona;
import com.arquitectura.hexagonal.administracion.dominio.repositorio.PersonaRepositorioPort;
import com.arquitectura.hexagonal.administracion.infraestructura.persistencia.mapper.PersonaMapper;
import com.arquitectura.hexagonal.administracion.infraestructura.persistencia.repositorio.PersonaRepository;
import com.arquitectura.hexagonal.administracion.infraestructura.persistencia.entidad.PersonaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author johana 1/04/2022
 */

@Repository
@RequiredArgsConstructor
public class PersonaAdapterImpl implements PersonaRepositorioPort {

    private final PersonaRepository personaRepository;

    private final PersonaMapper personaMapper;

    @Override
    public Persona savePersona(Persona persona) {
       PersonaEntity personaEntity = personaRepository.save(personaMapper.personatoPersonaEntity(persona));
       return personaMapper.fromPersonaEntity(personaEntity);
    }

    @Override
    public Persona findByDocumento(String documento) {
        return personaMapper.fromPersonaEntity(personaRepository.findByDocumento(documento));
    }

    @Override
    public Persona findById(long id) {
        return personaMapper.fromPersonaEntity(personaRepository.getById(id));
    }

    @Override
    public List<Persona> findByAllPersonas() {
        return personaMapper.listPersona(personaRepository.findAll());
    }

    @Override
    public boolean existePersona(Long id) {
        return personaRepository.existsById(id);
    }

    @Override
    public void deletePersona(Long id) {
      personaRepository.deleteById(id);
    }
}
