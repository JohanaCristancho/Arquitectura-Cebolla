package com.arquitectura.hexagonal.administracion.infraestructura.persistencia.mapper;

import com.arquitectura.hexagonal.administracion.dominio.modelo.ImagenMongo;
import com.arquitectura.hexagonal.administracion.infraestructura.persistencia.entidad.ImagenMongoEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-26T21:57:16-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14 (Oracle Corporation)"
)
*/
@Component
public class ImagenMongoMapperImpl implements ImagenMongoMapper {

    @Override
    public ImagenMongo fromImagenMongo(ImagenMongoEntity imagenMongoEntity) {
        if ( imagenMongoEntity == null ) {
            return null;
        }

        String id = null;
        String tipo = null;
        String nombre = null;
        String imagen = null;
        Long idPersona = null;

        id = imagenMongoEntity.getId();
        tipo = imagenMongoEntity.getTipo();
        nombre = imagenMongoEntity.getNombre();
        imagen = imagenMongoEntity.getImagen();
        if ( imagenMongoEntity.getIdPersona() != null ) {
            idPersona = Long.parseLong( imagenMongoEntity.getIdPersona() );
        }

        ImagenMongo imagenMongo = new ImagenMongo( id, tipo, nombre, imagen, idPersona );

        return imagenMongo;
    }

    @Override
    public ImagenMongoEntity imagenToImagenMongo(ImagenMongo imagenMongo) {
        if ( imagenMongo == null ) {
            return null;
        }

        ImagenMongoEntity imagenMongoEntity = new ImagenMongoEntity();

        imagenMongoEntity.setId( imagenMongo.getId() );
        imagenMongoEntity.setNombre( imagenMongo.getNombre() );
        imagenMongoEntity.setTipo( imagenMongo.getTipo() );
        imagenMongoEntity.setImagen( imagenMongo.getImagen() );
        if ( imagenMongo.getIdPersona() != null ) {
            imagenMongoEntity.setIdPersona( String.valueOf( imagenMongo.getIdPersona() ) );
        }

        return imagenMongoEntity;
    }

    @Override
    public List<ImagenMongo> listImagen(List<ImagenMongoEntity> imagenes) {
        if ( imagenes == null ) {
            return null;
        }

        List<ImagenMongo> list = new ArrayList<ImagenMongo>( imagenes.size() );
        for ( ImagenMongoEntity imagenMongoEntity : imagenes ) {
            list.add( fromImagenMongo( imagenMongoEntity ) );
        }

        return list;
    }
}
