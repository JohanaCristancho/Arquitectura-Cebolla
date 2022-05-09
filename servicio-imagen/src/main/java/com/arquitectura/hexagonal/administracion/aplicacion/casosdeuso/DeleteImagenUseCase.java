package com.arquitectura.hexagonal.administracion.aplicacion.casosdeuso;

import com.arquitectura.hexagonal.administracion.dominio.servicio.DeleteImagenServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author johana 6/04/2022
 */
@Component
@RequiredArgsConstructor
public class DeleteImagenUseCase {

    private final DeleteImagenServicio deleteImagenServicio;

    public void ejeutar(String idImagen){
        deleteImagenServicio.eliminarImagen(idImagen);
    }

}
