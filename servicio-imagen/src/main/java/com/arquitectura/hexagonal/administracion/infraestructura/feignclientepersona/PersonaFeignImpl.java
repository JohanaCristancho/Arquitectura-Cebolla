package com.arquitectura.hexagonal.administracion.infraestructura.feignclientepersona;

import com.arquitectura.hexagonal.administracion.aplicacion.dto.PersonaDto;
import com.arquitectura.hexagonal.administracion.aplicacion.feignpersonarepositorio.PersonaFeignRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @author johana 25/04/2022
 */

@Repository
@RequiredArgsConstructor
public class PersonaFeignImpl implements PersonaFeignRepositorio {

        private final PersonaFeign personaFeign;

        @Override
        public PersonaDto obtenerPersona(long id) {
             return personaFeign.personaPorId(id);
        }
}
