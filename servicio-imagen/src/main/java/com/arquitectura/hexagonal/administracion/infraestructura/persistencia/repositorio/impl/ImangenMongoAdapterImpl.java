package com.arquitectura.hexagonal.administracion.infraestructura.persistencia.repositorio.impl;

import com.arquitectura.hexagonal.administracion.dominio.modelo.ImagenMongo;
import com.arquitectura.hexagonal.administracion.dominio.repositorio.ImagenMongoRepositorioPort;
import com.arquitectura.hexagonal.administracion.infraestructura.persistencia.mapper.ImagenMongoMapper;
import com.arquitectura.hexagonal.administracion.infraestructura.persistencia.entidad.ImagenMongoEntity;
import com.arquitectura.hexagonal.administracion.infraestructura.persistencia.repositorio.ImagenMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author johana 7/04/2022
 */
@Repository
@RequiredArgsConstructor
public class ImangenMongoAdapterImpl implements ImagenMongoRepositorioPort {

    private final ImagenMongoRepository imagenMongoRepository;
    private final ImagenMongoMapper imagenMongoMapper;

    @Override
    public ImagenMongo saveImagen(ImagenMongo imagen) {
        ImagenMongoEntity imagenMongoEntity = imagenMongoRepository.save(imagenMongoMapper.imagenToImagenMongo(imagen));
        return imagenMongoMapper.fromImagenMongo(imagenMongoEntity);
    }

    @Override
    public void deleteImagen(String id) {
        imagenMongoRepository.deleteById(id);
    }

    @Override
    public ImagenMongo finById(String id) {
        ImagenMongoEntity imagenMongoEntity = imagenMongoRepository.finById(id);
        return imagenMongoMapper.fromImagenMongo(imagenMongoEntity);
    }

    @Override
    public List<ImagenMongo> finByAllImagenes() {
        List<ImagenMongoEntity> listaImagenMongoEntities = imagenMongoRepository.findAll();
        return imagenMongoMapper.listImagen(listaImagenMongoEntities);
    }

    @Override
    public boolean existeImagen(String id) {
        return imagenMongoRepository.existsById(id);
    }

    @Override
    public ImagenMongo findSummaryByIdPersona(String idPersona) {
        ImagenMongoEntity imagenMongoEntity = imagenMongoRepository.findSummaryByIdPersona(idPersona);
        return imagenMongoMapper.fromImagenMongo(imagenMongoEntity);
    }

}
