package com.arquitectura.hexagonal.administracion.infraestructura.controlador;

import com.arquitectura.hexagonal.administracion.aplicacion.casosdeuso.FindImagenByIdUseCase;
import com.arquitectura.hexagonal.administracion.aplicacion.dto.ImagenDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author johana 6/04/2022
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/imagen")
public class FindImagenByIdController {

    private final FindImagenByIdUseCase findImagenByIdUseCase;

    @Operation(summary = "Imagen registrada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se obtiene con exito imagen filtrada por id"),
    })
    @GetMapping("/{id}")
    public ResponseEntity<ImagenDto> listaImagenPorId(@PathVariable String id) {
        return new ResponseEntity(findImagenByIdUseCase.ejecutar(id), HttpStatus.OK);
    }

}
