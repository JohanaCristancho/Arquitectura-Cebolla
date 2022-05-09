package com.arquitectura.hexagonal.administracion.infraestructura.configuracion;

import com.arquitectura.hexagonal.administracion.dominio.servicio.FindImagenService;
import com.arquitectura.hexagonal.administracion.dominio.repositorio.ImagenMongoRepositorioPort;
import com.arquitectura.hexagonal.administracion.dominio.servicio.DeleteImagenServicio;
import com.arquitectura.hexagonal.administracion.dominio.servicio.SaveImagenServicio;
import com.arquitectura.hexagonal.administracion.dominio.servicio.UpdateImagenServicio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author johana 7/04/2022
 */


@Configuration
public class ImagenMongoConfig {

    @Bean
    public DeleteImagenServicio deleteImagenServicio(ImagenMongoRepositorioPort imagenMongoRepositorioPort){
        return new DeleteImagenServicio(imagenMongoRepositorioPort);
    }

    @Bean
    public SaveImagenServicio saveImagenServicio(ImagenMongoRepositorioPort imagenMongoRepositorioPort){
        return new SaveImagenServicio(imagenMongoRepositorioPort);
    }

    @Bean
    public UpdateImagenServicio updateImagenServicio(ImagenMongoRepositorioPort imagenMongoRepositorioPort){
        return new UpdateImagenServicio(imagenMongoRepositorioPort);
    }

    @Bean
    public FindImagenService findImagenService(ImagenMongoRepositorioPort imagenMongoRepositorioPort){
        return new FindImagenService(imagenMongoRepositorioPort);
    }
}
