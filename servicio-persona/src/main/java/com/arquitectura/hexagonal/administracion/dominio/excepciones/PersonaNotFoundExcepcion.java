package com.arquitectura.hexagonal.administracion.dominio.excepciones;

/**
 * @author johana 31/03/2022
 */
public class PersonaNotFoundExcepcion extends RuntimeException {

    public PersonaNotFoundExcepcion(String personaNoExiste) {
        super(personaNoExiste);
    }
}
