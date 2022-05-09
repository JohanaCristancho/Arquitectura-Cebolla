package com.arquitectura.hexagonal.administracion.infraestructura.controlador;

import com.arquitectura.hexagonal.administracion.aplicacion.casosdeuso.UpdateImagenUseCase;
import com.arquitectura.hexagonal.administracion.aplicacion.dto.ImagenDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author johana 6/04/2022
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/imagen")
public class UpdateImagenController {

    private final UpdateImagenUseCase updateImagenUseCase;

    @Operation(summary = "Actualizar objeto imagen en MySQL")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "La imagen se actualizo satisfactoriamente"),
            @ApiResponse(responseCode = "400", description = "Datos incorrectos al intentar actualizar una imagen")
    })
    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ImagenDto> guardarImagen(@PathVariable String id, @RequestParam(value="idPersona" ) Long idPersona, @RequestParam(value="imagen" ) MultipartFile file) throws IOException {
        ImagenDto imagenCommand = ImagenDto.builder().imagen(file.getBytes()).idPersona(idPersona).nombre(file.getOriginalFilename()).tipo(file.getContentType()).id(id).build();
        return new ResponseEntity(updateImagenUseCase.ejecutar(imagenCommand), HttpStatus.CREATED);
    }
}
