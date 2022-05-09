package com.arquitectura.hexagonal.administracion.aplicacion.casosdeuso;

import com.arquitectura.hexagonal.administracion.aplicacion.dto.ImagenDto;
import com.arquitectura.hexagonal.administracion.aplicacion.excepciones.PersonaNotFoundExcepcion;
import com.arquitectura.hexagonal.administracion.aplicacion.feignpersonarepositorio.PersonaFeignRepositorio;
import com.arquitectura.hexagonal.administracion.aplicacion.mapper.ImagenMapperApp;
import com.arquitectura.hexagonal.administracion.dominio.modelo.ImagenMongo;
import com.arquitectura.hexagonal.administracion.dominio.servicio.SaveImagenServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author johana 6/04/2022
 */

@Component
@RequiredArgsConstructor
public class SaveImagenUseCase {

    private final SaveImagenServicio saveImagenServicio;
    private final ImagenMapperApp imagenMapper;
    private final PersonaFeignRepositorio personaFeignRepositorio;

    public ImagenDto ejecutar(ImagenDto imagenDto) {
        validarPersonaExiste(imagenDto);
        ImagenMongo imagenMongo = saveImagenServicio.guardarImagen(imagenMapper.imagenDtoToImagenMongo(imagenDto));
        return imagenMapper.imagenMongoToImagenDto(imagenMongo);
    }

    public void validarPersonaExiste(ImagenDto imagenDto) {
        try {
            personaFeignRepositorio.obtenerPersona(imagenDto.getIdPersona());
        } catch (Exception e) {
            throw new PersonaNotFoundExcepcion("Persona con id " + imagenDto.getIdPersona() + " no existe");
        }
    }
}