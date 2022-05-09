package com.arquitectura.hexagonal.administracion.dominio.servicio;

import com.arquitectura.hexagonal.administracion.dominio.excepciones.ImagenDataDuplicada;
import com.arquitectura.hexagonal.administracion.dominio.excepciones.ImagenNotFoundExcepcion;
import com.arquitectura.hexagonal.administracion.dominio.modelo.ImagenMongo;
import com.arquitectura.hexagonal.administracion.dominio.repositorio.ImagenMongoRepositorioPort;

/**
 * @author johana 31/03/2022
 */
public class SaveImagenServicio {

    private final ImagenMongoRepositorioPort imagenRepositorioPort;

    public SaveImagenServicio(ImagenMongoRepositorioPort imagenRepositorioPort){
        this.imagenRepositorioPort = imagenRepositorioPort;
    }

    public ImagenMongo guardarImagen(ImagenMongo imagen) {
        validarDatosDeImagen(imagen);
        validarSiImagenAsociadaIdPersona(imagen.getIdPersona());
        return imagenRepositorioPort.saveImagen(imagen);
    }

    public void validarDatosDeImagen(ImagenMongo imagen) {
        if(imagen.getImagen().isEmpty()){
            throw new ImagenNotFoundExcepcion("Es necesario agregar una imagen");
        }
    }

    public void validarSiImagenAsociadaIdPersona(Long idPersona) {
        ImagenMongo imagenMongo = imagenRepositorioPort.findSummaryByIdPersona(String.valueOf(idPersona));
        if (imagenMongo!=null) {
            throw new ImagenDataDuplicada("Ya hay una imagen asociada a una persona con id " + idPersona);
        }
    }
}
