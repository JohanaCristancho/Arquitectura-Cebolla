package com.arquitectura.hexagonal.administracion.dominio.servicio;

import com.arquitectura.hexagonal.administracion.dominio.excepciones.ImagenNotFoundExcepcion;
import com.arquitectura.hexagonal.administracion.dominio.repositorio.ImagenMongoRepositorioPort;
import com.arquitectura.hexagonal.administracion.dominio.modelo.ImagenMongo;

import java.util.List;

/**
 * @author johana 31/03/2022
 */
public class FindImagenService {

    private final ImagenMongoRepositorioPort imagenRepositorioPort;

    public FindImagenService(ImagenMongoRepositorioPort imagenRepositorioPort) {
        this.imagenRepositorioPort = imagenRepositorioPort;
    }

    public ImagenMongo buscarImagenPorId(String id) {
        validarExistePorId(id);
        return imagenRepositorioPort.finById(id);
    }

    public List<ImagenMongo> listaImagenes() {
        return imagenRepositorioPort.finByAllImagenes();
    }

    public ImagenMongo listaImagenesPorIdPersona(String id) {
        return imagenRepositorioPort.findSummaryByIdPersona(id);
    }

    private void validarExistePorId(String id) {
        boolean existe = imagenRepositorioPort.existeImagen(id);
        if (!existe) {
            throw new ImagenNotFoundExcepcion("No hay ninguna imagen asociada al id " + id);
        }
    }
}
