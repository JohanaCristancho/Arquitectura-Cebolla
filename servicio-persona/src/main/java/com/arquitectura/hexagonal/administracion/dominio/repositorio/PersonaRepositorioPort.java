package com.arquitectura.hexagonal.administracion.dominio.repositorio;

import com.arquitectura.hexagonal.administracion.dominio.modelo.Persona;

import java.util.List;

/**
 * @author johana 30/03/2022
 */

public interface PersonaRepositorioPort {

    Persona savePersona(Persona persona);

    Persona findByDocumento(String documento);

    Persona findById(long id);

    List<Persona> findByAllPersonas();

    boolean existePersona(Long id);

    void deletePersona(Long id);

}
