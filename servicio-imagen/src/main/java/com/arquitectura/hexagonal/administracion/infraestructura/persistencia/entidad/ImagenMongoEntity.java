package com.arquitectura.hexagonal.administracion.infraestructura.persistencia.entidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * @author johana 7/04/2022
 */
@Document(collection = "Imagen")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImagenMongoEntity {

    @Id
    private String id;

    private String nombre;

    private String tipo;

    private String imagen;

    private String idPersona;

}