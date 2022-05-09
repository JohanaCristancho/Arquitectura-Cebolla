package com.arquitectura.hexagonal.administracion.dominio.repositorio;

import com.arquitectura.hexagonal.administracion.dominio.modelo.ImagenMongo;

import java.util.List;

/**
 * @author johana 7/04/2022
 */
public interface ImagenMongoRepositorioPort {

    ImagenMongo saveImagen(ImagenMongo imagenMongo);
    void deleteImagen(String id);
    ImagenMongo finById(String id);
    List<ImagenMongo> finByAllImagenes();
    boolean existeImagen(String id);
    ImagenMongo findSummaryByIdPersona(String idPersona);

}
