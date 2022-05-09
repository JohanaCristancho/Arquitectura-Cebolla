package com.arquitectura.hexagonal.administracion.aplicacion.mapper;

import com.arquitectura.hexagonal.administracion.aplicacion.dto.ImagenDto;
import com.arquitectura.hexagonal.administracion.dominio.modelo.ImagenMongo;
import org.springframework.stereotype.Component;

import java.util.Base64;

/**
 * @author johana 7/04/2022
 */
@Component
public class ImagenMapperApp {

    public static ImagenMongo imagenDtoToImagenMongo (ImagenDto imagenDto) {
        return new ImagenMongo (
                imagenDto.getId(),
                imagenDto.getTipo(),
                imagenDto.getNombre(),
                Base64.getEncoder().encodeToString(imagenDto.getImagen()),
                imagenDto.getIdPersona());
    }

    public static ImagenDto imagenMongoToImagenDto (ImagenMongo imagen) {
        return new ImagenDto(
                imagen.getId(),
                imagen.getTipo(),
                imagen.getNombre(),
                Base64.getDecoder().decode(imagen.getImagen()),
                imagen.getIdPersona());
    }
}
