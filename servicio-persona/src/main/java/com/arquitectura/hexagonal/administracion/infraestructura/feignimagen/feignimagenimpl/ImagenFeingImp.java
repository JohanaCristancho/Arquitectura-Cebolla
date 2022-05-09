package com.arquitectura.hexagonal.administracion.infraestructura.feignimagen.feignimagenimpl;

import com.arquitectura.hexagonal.administracion.aplicacion.dto.ImagenDto;
import com.arquitectura.hexagonal.administracion.aplicacion.feignimagenrepositorio.ImagenFeignRepositorio;
import com.arquitectura.hexagonal.administracion.infraestructura.feignimagen.ImagenFeign;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @author johana 22/04/2022
 */

@Repository
@AllArgsConstructor
public class ImagenFeingImp implements ImagenFeignRepositorio {

    private final ImagenFeign imagenFeign;

    @Override
    public ImagenDto obtenerImagenPorIdPersona(String idPersona) {
       return imagenFeign.imagenPorIdPersona(idPersona);
    }

    @Override
    public void eliminarImagen(String id) {
     ImagenDto imagenDto = imagenFeign.imagenPorIdPersona(id);
     if(imagenDto!=null){
         imagenFeign.eliminarImagen(imagenDto.getId());
     }
    }
}
