package com.arquitectura.hexagonal.testUtilidades;

import com.arquitectura.hexagonal.administracion.aplicacion.dto.ImagenDto;
import com.arquitectura.hexagonal.administracion.aplicacion.dto.PersonaDto;
import com.arquitectura.hexagonal.administracion.aplicacion.dto.PersonaRequestDto;
import com.arquitectura.hexagonal.administracion.aplicacion.dto.PersonaResponseDto;
import com.arquitectura.hexagonal.administracion.dominio.modelo.Persona;

import java.util.List;

/**
 * @author johana 16/04/2022
 */
public class Datos {

    public static final Persona johana = new Persona(1L, "Eddy Johana", "Cristancho", "10921563210", "TC", 20);
    public static final Persona karina = new Persona(2L, "Karina", "Cañas", "109215632178", "TC", 20);
    public static final List <Persona> personas = List.of(johana,karina);

    static byte[] imagen = {1,2,3,5};
    public static final ImagenDto imagenDto = new ImagenDto("1","validacion", "imagen", imagen,"imagen");
    public static final ImagenDto imagenDto2 = new ImagenDto("1","validacion", "imagen", imagen,"imagen");

    public static final PersonaResponseDto personaResponseDto = new PersonaResponseDto(1L, "Martha", "Cañas", "109215632178", "TC", 20, imagenDto);
    public static final PersonaResponseDto personaResponseDto2 = new PersonaResponseDto(2L, "Martha", "Cañas", "109215632178", "TC", 20, imagenDto);

    public static final PersonaRequestDto personaRequestDto  =  new PersonaRequestDto (1L, "Martha", "Cañas", "109215632178", "TC", 20);
    public static final PersonaRequestDto personaRequestDto2 =  new PersonaRequestDto (null, "Juliana", "Torrez", "209215632170", "TC", 20);

    public static final List <PersonaResponseDto> listaPersonas = List.of(personaResponseDto,personaResponseDto2);

    public static final PersonaDto personaDto = new PersonaDto(3L, "Martha", "Cañas", "109215632178", "TC", 20);

}

