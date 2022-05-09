package com.arquitectura.hexagonal.administracion.dominio.modelo;

/**
 * @author johana 7/04/2022
 */
public class ImagenMongo {

    private String id;
    private String tipo;
    private String nombre;
    private String imagen;
    private Long idPersona;

    public ImagenMongo(String id, String tipo, String nombre, String imagen, Long idPersona) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.imagen = imagen;
        this.idPersona = idPersona;
    }

    public String getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public Long getIdPersona() {
        return idPersona;
    }
}
