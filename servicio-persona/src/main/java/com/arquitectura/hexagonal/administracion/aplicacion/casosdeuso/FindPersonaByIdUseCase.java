package com.arquitectura.hexagonal.administracion.aplicacion.casosdeuso;

import com.arquitectura.hexagonal.administracion.aplicacion.dto.PersonaDto;
import com.arquitectura.hexagonal.administracion.aplicacion.mapper.PersonaMapperApp;
import com.arquitectura.hexagonal.administracion.dominio.servicio.FindPersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author johana 25/04/2022
 */

@Service
@RequiredArgsConstructor
public class FindPersonaByIdUseCase {

    private final FindPersonaService findPersonaService;
    private final PersonaMapperApp personaMapper;

    @Transactional
    public PersonaDto ejecutar(long idPersona){
        return personaMapper.personaToPersonaDto(findPersonaService.buscarPersonaPorId(idPersona));
    }

}
