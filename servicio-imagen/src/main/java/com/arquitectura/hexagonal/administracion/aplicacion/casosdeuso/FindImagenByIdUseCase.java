package com.arquitectura.hexagonal.administracion.aplicacion.casosdeuso;

import com.arquitectura.hexagonal.administracion.dominio.modelo.ImagenMongo;
import com.arquitectura.hexagonal.administracion.dominio.servicio.FindImagenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author johana 6/04/2022
 */
@Component
@RequiredArgsConstructor
public class FindImagenByIdUseCase {

    private final FindImagenService findImagenService;

    public ImagenMongo ejecutar(String id) {
        return findImagenService.buscarImagenPorId(id);
    }
}
