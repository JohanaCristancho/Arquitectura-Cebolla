package com.arquitectura.hexagonal.administracion.infraestructura.persistencia.repositorio;

import com.arquitectura.hexagonal.administracion.infraestructura.persistencia.entidad.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author johana 1/04/2022
 */
public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {

    PersonaEntity findByDocumento(String documento);
}
