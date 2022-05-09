package com.arquitectura.hexagonal.administracion.aplicacion.feignpersonarepositorio;

import com.arquitectura.hexagonal.administracion.aplicacion.dto.PersonaDto;

/**
 * @author johana 25/04/2022
 */

public interface PersonaFeignRepositorio {
    PersonaDto obtenerPersona (long id);
}
