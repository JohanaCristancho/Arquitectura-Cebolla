package com.arquitectura.hexagonal.administracion.aplicacion.casosdeuso;

import com.arquitectura.hexagonal.administracion.aplicacion.dto.PersonaResponseDto;
import com.arquitectura.hexagonal.administracion.aplicacion.mapper.PersonaMapperApp;
import com.arquitectura.hexagonal.administracion.dominio.servicio.FindPersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author johana 6/04/2022
 */

@Service
@RequiredArgsConstructor
public class FindAllPersonaUseCase {

    private final FindPersonaService findPersonaService;
    private final PersonaMapperApp personaMapper;

    @Transactional
    public List<PersonaResponseDto> ejecutar(){
        return personaMapper.listPersona(findPersonaService.buscarListaPersonas());
    }

}
