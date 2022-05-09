package com.arquitectura.hexagonal.administracion.aplicacion.casosdeuso;

import com.arquitectura.hexagonal.administracion.aplicacion.dto.ImagenDto;
import com.arquitectura.hexagonal.administracion.aplicacion.excepciones.PersonaNotFoundExcepcion;
import com.arquitectura.hexagonal.administracion.aplicacion.feignpersonarepositorio.PersonaFeignRepositorio;
import com.arquitectura.hexagonal.administracion.aplicacion.mapper.ImagenMapperApp;
import com.arquitectura.hexagonal.administracion.dominio.modelo.ImagenMongo;
import com.arquitectura.hexagonal.administracion.dominio.servicio.UpdateImagenServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author johana 6/04/2022
 */

@Component
@RequiredArgsConstructor
public class UpdateImagenUseCase {

    private final UpdateImagenServicio updateImagenServicio;
    private final ImagenMapperApp imagenMapper;
    private final PersonaFeignRepositorio personaFeignRepositorio;

    public ImagenDto ejecutar(ImagenDto imagenDto){
        validarPersonaExiste(imagenDto);
        ImagenMongo imagen = updateImagenServicio.actualizarImagen(imagenMapper.imagenDtoToImagenMongo(imagenDto));
        return imagenMapper.imagenMongoToImagenDto(imagen);
    }

    public void validarPersonaExiste(ImagenDto imagenDto) {
        try {
            personaFeignRepositorio.obtenerPersona(imagenDto.getIdPersona());
        } catch (Exception e) {
            throw new PersonaNotFoundExcepcion("Persona con id " + imagenDto.getIdPersona() + " no existe");
        }
    }
}
