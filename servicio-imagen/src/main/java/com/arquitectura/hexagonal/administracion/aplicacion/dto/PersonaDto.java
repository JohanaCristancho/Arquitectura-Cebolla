package com.arquitectura.hexagonal.administracion.aplicacion.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author johana 25/04/2022
 */

@Getter
@Setter
public class PersonaDto {

    private Long id;
    private String nombre;
    private String apellido;
    private String documento;
    private String tipoDocumento;
}
