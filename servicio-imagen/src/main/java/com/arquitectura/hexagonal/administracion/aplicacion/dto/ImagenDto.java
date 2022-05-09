package com.arquitectura.hexagonal.administracion.aplicacion.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author johana 7/04/2022
 */

@Getter @Setter
@Builder
@AllArgsConstructor
public class ImagenDto {

    private String id;
    private String tipo;
    private String nombre;
    private byte[] imagen;
    private Long idPersona;
}
