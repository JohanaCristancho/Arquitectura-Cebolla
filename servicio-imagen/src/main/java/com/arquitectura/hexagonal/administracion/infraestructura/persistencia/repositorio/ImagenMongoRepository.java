package com.arquitectura.hexagonal.administracion.infraestructura.persistencia.repositorio;

import com.arquitectura.hexagonal.administracion.infraestructura.persistencia.entidad.ImagenMongoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * @author johana 7/04/2022
 */
public interface ImagenMongoRepository extends MongoRepository<ImagenMongoEntity, String> {

    @Query("{'id':?0 }")
    ImagenMongoEntity finById(String id);

    ImagenMongoEntity findSummaryByIdPersona(String id);
}
