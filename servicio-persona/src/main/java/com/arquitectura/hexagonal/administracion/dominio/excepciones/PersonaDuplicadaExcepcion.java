package com.arquitectura.hexagonal.administracion.dominio.excepciones;

/**
 * @author johana 1/04/2022
 */
public class PersonaDuplicadaExcepcion extends RuntimeException {

    public PersonaDuplicadaExcepcion(String personaDuplicada) {
        super(personaDuplicada);
    }
}
