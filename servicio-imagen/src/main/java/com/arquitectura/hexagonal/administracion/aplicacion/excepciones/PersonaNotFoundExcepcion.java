package com.arquitectura.hexagonal.administracion.aplicacion.excepciones;

/**
 * @author johana 6/04/2022
 */
public class PersonaNotFoundExcepcion extends RuntimeException{

    public PersonaNotFoundExcepcion(String imagenNoExiste){
        super(imagenNoExiste);
    }
}
