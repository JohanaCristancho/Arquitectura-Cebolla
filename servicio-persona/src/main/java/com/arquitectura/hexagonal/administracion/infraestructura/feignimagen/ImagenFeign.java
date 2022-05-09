package com.arquitectura.hexagonal.administracion.infraestructura.feignimagen;

import com.arquitectura.hexagonal.administracion.aplicacion.dto.ImagenDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author johana 22/04/2022
 */

@FeignClient(name = "ImagenFeign", url = "${feign.modulo.imagen}")
public interface ImagenFeign {

    @GetMapping("/listaimagenes/{id}")
    ImagenDto imagenPorIdPersona(@PathVariable String id);

    @DeleteMapping("/imagen/{id}")
    void eliminarImagen(@PathVariable String id);
}
