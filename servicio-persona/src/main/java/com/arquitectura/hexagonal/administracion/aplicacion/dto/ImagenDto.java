package com.arquitectura.hexagonal.administracion.aplicacion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * @author johana 22/04/2022
 */

@Getter
@Setter
@AllArgsConstructor @RequiredArgsConstructor
public class ImagenDto {

    private String id;
    private String tipo;
    private String nombre;
    private byte[] imagen;
    private String idPersona;
}
