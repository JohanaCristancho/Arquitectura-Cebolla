package com.arquitectura.hexagonal.administracion.aplicacion.excepciones;

/**
 * @author johana 6/04/2022
 */
public class ImagenDataDuplicada extends RuntimeException{

    public ImagenDataDuplicada(String imagenConPersonaDuplicada){
        super(imagenConPersonaDuplicada);
    }
}
