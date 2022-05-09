package com.arquitectura.hexagonal.administracion.dominio.servicio;

import com.arquitectura.hexagonal.administracion.dominio.excepciones.ImagenNotFoundExcepcion;
import com.arquitectura.hexagonal.administracion.dominio.repositorio.ImagenMongoRepositorioPort;

/**
 * @author johana 31/03/2022
 */
public class DeleteImagenServicio {

    private final ImagenMongoRepositorioPort imagenRepositorioPort;

    public DeleteImagenServicio(ImagenMongoRepositorioPort imagenRepositorioPost) {
        this.imagenRepositorioPort = imagenRepositorioPost;
    }

    public void eliminarImagen(String id) {
        validarSiExisteImagen(id);
        imagenRepositorioPort.deleteImagen(id);
    }

    private void validarSiExisteImagen(String id) {
        boolean existe = imagenRepositorioPort.existeImagen(id);
        if (!existe) {
            throw new ImagenNotFoundExcepcion("Imagen con id " + id + " no existe.");
        }
    }
}
