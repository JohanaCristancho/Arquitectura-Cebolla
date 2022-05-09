package com.arquitectura.hexagonal.administracion.aplicacion.feignimagenrepositorio;

import com.arquitectura.hexagonal.administracion.aplicacion.dto.ImagenDto;

/**
 * @author johana 22/04/2022
 */

public interface ImagenFeignRepositorio {
    ImagenDto obtenerImagenPorIdPersona(String idPersona);
    void eliminarImagen(String idImagen);
}
