package com.arquitectura.hexagonal.administracion.aplicacion.casosdeuso;

import com.arquitectura.hexagonal.administracion.aplicacion.dto.PersonaResponseDto;
import com.arquitectura.hexagonal.administracion.aplicacion.mapper.PersonaMapperApp;
import com.arquitectura.hexagonal.administracion.dominio.servicio.FindPersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author johana 6/04/2022
 */

@Service
@RequiredArgsConstructor
public class FindPersonaByDocumentUseCase {

    private final FindPersonaService findPersonaService;
    private final PersonaMapperApp personaMapper;

    public PersonaResponseDto ejecutar(String documento){
       return  personaMapper.personaToPersonaResponse(findPersonaService.buscarPersonaPorDocumento(documento));
    }
}
