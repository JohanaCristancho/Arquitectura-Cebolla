package com.arquitectura.hexagonal.administracion.infraestructura.controlador;

import com.arquitectura.hexagonal.administracion.aplicacion.casosdeuso.SaveImagenUseCase;
import com.arquitectura.hexagonal.administracion.aplicacion.dto.ImagenDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author johana 6/04/2022
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/imagen")
public class SaveImagenController {

    private final SaveImagenUseCase saveImagenUseCase;

    @Operation(summary = "Registrar objeto imagen en MySQL")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La imagen se registro exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos incorrectos al intentar registrar una imagen")
    })
    @PostMapping(value = "/" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ImagenDto> guardarImagen(@RequestParam(value="idPersona" ) long idPersona, @RequestParam(value="imagen" ) MultipartFile file) throws IOException {
        ImagenDto imagenCommand = ImagenDto.builder().imagen(file.getBytes()).idPersona(idPersona).nombre(file.getName()).tipo(file.getContentType()).build();
        return new ResponseEntity(saveImagenUseCase.ejecutar(imagenCommand), HttpStatus.CREATED);
    }
}
