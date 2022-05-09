package com.arquitectura.hexagonal.testUtilidades;

import com.arquitectura.hexagonal.administracion.aplicacion.dto.ImagenDto;
import com.arquitectura.hexagonal.administracion.dominio.modelo.ImagenMongo;

import java.util.List;

/**
 * @author johana 16/04/2022
 */
public class Datos {

    static byte[] imagen = {1,2,3,5};
    public static final ImagenMongo imagenMongo = new ImagenMongo("1","validacion", "imagen","imagen",1l);
    public static final ImagenMongo imagenMongo1 = new ImagenMongo("2","validacion", "flores", "foto",2l);
    public static final ImagenMongo imagenMongo3 = new ImagenMongo("2","validacion", "flores", "",2l);

    public static final ImagenDto imagenDto = new ImagenDto("1","validacion", "imagen",imagen,1l);
    public static final ImagenDto imagenDto1 = new ImagenDto("2","validacion", "flores", imagen,2l);
    public static final ImagenDto imagenDto2 = new ImagenDto(null,"validacion", "flores", imagen,2l);

    public static final List<ImagenMongo> listaImagenes = List.of(imagenMongo,imagenMongo1);

}

