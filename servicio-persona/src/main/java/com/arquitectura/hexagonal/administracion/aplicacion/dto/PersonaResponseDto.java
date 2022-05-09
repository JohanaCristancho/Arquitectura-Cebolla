package com.arquitectura.hexagonal.administracion.aplicacion.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author johana 12/04/2022
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PersonaResponseDto {

    private Long id;
    private String nombre;
    private String apellido;
    private String documento;
    private String tipoDocumento;
    private Integer edad;
    private ImagenDto imagenDto;
}
