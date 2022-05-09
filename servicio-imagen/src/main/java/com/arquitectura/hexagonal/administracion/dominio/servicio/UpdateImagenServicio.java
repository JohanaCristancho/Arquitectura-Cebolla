package com.arquitectura.hexagonal.administracion.dominio.servicio;

import com.arquitectura.hexagonal.administracion.dominio.excepciones.ImagenDataDuplicada;
import com.arquitectura.hexagonal.administracion.dominio.excepciones.ImagenNotFoundExcepcion;
import com.arquitectura.hexagonal.administracion.dominio.modelo.ImagenMongo;
import com.arquitectura.hexagonal.administracion.dominio.repositorio.ImagenMongoRepositorioPort;

/**
 * @author johana 31/03/2022
 */
public class UpdateImagenServicio {

    private final ImagenMongoRepositorioPort imagenRepositorioPort;

    public UpdateImagenServicio(ImagenMongoRepositorioPort imagenRepositorioPort) {
        this.imagenRepositorioPort = imagenRepositorioPort;
    }

    public ImagenMongo actualizarImagen(ImagenMongo imagen) {
        validarDatosDeImagen(imagen);
        validarSiImagenAsociadaIdPersona(imagen);
        return imagenRepositorioPort.saveImagen(imagen);
    }

    public void validarDatosDeImagen(ImagenMongo imagen) {
        if (imagen.getImagen().isEmpty()) {
            throw new ImagenNotFoundExcepcion("Es necesario agregar una imagen");
        }
    }

    public void validarSiImagenAsociadaIdPersona(ImagenMongo imagenMongo) {
        ImagenMongo imagen = imagenRepositorioPort.finById(imagenMongo.getId());
        if (imagen != null && imagenMongo.getIdPersona() != imagen.getIdPersona()) {
            validarSiImagenAsociadaIdPersona(imagenMongo.getIdPersona());
        }
    }

    public void validarSiImagenAsociadaIdPersona(Long idPersona) {
        ImagenMongo imagenMongo = imagenRepositorioPort.findSummaryByIdPersona(String.valueOf(idPersona));
        if (imagenMongo != null) {
            throw new ImagenDataDuplicada("Ya hay una imagen asociada a una persona con id " + idPersona);
        }
    }

}
