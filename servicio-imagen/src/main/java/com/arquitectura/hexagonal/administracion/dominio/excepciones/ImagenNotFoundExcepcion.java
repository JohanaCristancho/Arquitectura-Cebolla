package com.arquitectura.hexagonal.administracion.dominio.excepciones;

/**
 * @author johana 6/04/2022
 */
public class ImagenNotFoundExcepcion extends RuntimeException{

    public ImagenNotFoundExcepcion (String imagenNoExiste){
        super(imagenNoExiste);
    }
}
