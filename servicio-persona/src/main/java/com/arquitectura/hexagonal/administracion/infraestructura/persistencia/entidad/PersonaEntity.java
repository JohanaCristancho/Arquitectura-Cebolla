package com.arquitectura.hexagonal.administracion.infraestructura.persistencia.entidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author johana 1/04/2022
 */

@Entity
@Table(name = "persona")
@Data
@AllArgsConstructor @NoArgsConstructor
public class PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Long id;

    private String nombre;

    private String apellido;

    @Column(name = "cedula")
    private String documento;

    @Column(name = "tipo_documento")
    private String tipoDocumento;

    private Integer edad;
}
