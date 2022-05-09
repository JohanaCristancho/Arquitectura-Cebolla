package com.arquitectura.hexagonal.administracion.aplicacion.casosdeuso;

import com.arquitectura.hexagonal.administracion.aplicacion.feignimagenrepositorio.ImagenFeignRepositorio;
import com.arquitectura.hexagonal.administracion.dominio.servicio.DeletePersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author johana 4/04/2022
 */

@Service
@RequiredArgsConstructor
public class DeletePersonaUseCase {

    private final DeletePersonaService deletePersonaService;
    private final ImagenFeignRepositorio imagenFeignRepositorio;

    public void ejecutar(Long idPersona){
        imagenFeignRepositorio.eliminarImagen(String.valueOf(idPersona));
        deletePersonaService.eliminarPersona(idPersona);
    }

}
