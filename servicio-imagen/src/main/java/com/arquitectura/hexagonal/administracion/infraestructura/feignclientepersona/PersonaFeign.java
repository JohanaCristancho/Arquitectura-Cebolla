package com.arquitectura.hexagonal.administracion.infraestructura.feignclientepersona;

import com.arquitectura.hexagonal.administracion.aplicacion.dto.PersonaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author johana 25/04/2022
 */

@FeignClient(name = "PersonaFeign", url ="${feign.modulo.persona}")
public interface PersonaFeign {

        @GetMapping("/personadata/{id}")
        PersonaDto personaPorId(@PathVariable long id);
}
