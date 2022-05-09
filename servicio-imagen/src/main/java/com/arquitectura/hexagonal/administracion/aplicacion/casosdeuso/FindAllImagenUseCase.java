package com.arquitectura.hexagonal.administracion.aplicacion.casosdeuso;

import com.arquitectura.hexagonal.administracion.dominio.modelo.ImagenMongo;
import com.arquitectura.hexagonal.administracion.dominio.servicio.FindImagenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author johana 6/04/2022
 */

@Component
@RequiredArgsConstructor
public class FindAllImagenUseCase {

    private final FindImagenService findImagenService;

    public List<ImagenMongo> ejecutar() {
        return findImagenService.listaImagenes();
    }

    public ImagenMongo buscarPersona(String id){
        return findImagenService.listaImagenesPorIdPersona(id);
    }
}