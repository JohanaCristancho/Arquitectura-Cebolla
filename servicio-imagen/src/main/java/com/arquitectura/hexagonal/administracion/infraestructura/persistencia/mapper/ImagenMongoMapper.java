package com.arquitectura.hexagonal.administracion.infraestructura.persistencia.mapper;

import com.arquitectura.hexagonal.administracion.dominio.modelo.ImagenMongo;
import com.arquitectura.hexagonal.administracion.infraestructura.persistencia.entidad.ImagenMongoEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author johana 7/04/2022
 */

@Mapper(componentModel = "spring")
public interface ImagenMongoMapper {

    ImagenMongo fromImagenMongo(ImagenMongoEntity imagenMongoEntity);
    ImagenMongoEntity imagenToImagenMongo(ImagenMongo imagenMongo);
    List<ImagenMongo> listImagen(List<ImagenMongoEntity> imagenes);
}
