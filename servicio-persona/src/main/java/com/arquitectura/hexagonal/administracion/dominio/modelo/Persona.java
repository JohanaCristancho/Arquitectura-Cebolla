package com.arquitectura.hexagonal.administracion.dominio.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author johana 31/03/2022
 */

@Getter
@Setter
public class Persona {


    private Long id;

    @NotBlank(message = "El nombre no puede ser vacio")
    private String nombre;
    private String apellido;
    private String documento;
    private String tipoDocumento;

    @NotBlank(message = "El nombre no puede ser vacio")
    private Integer edad;

    public Persona(Long id, String nombre, String apellido, String documento, String tipoDocumento, Integer edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.tipoDocumento = tipoDocumento;
        this.edad = edad;
    }

    public Persona() {
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public Integer getEdad() {
        return edad;
    }

}