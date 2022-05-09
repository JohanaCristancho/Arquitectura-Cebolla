package com.arquitectura.hexagonal.administracion.infraestructura.controlador;

import com.arquitectura.hexagonal.administracion.aplicacion.casosdeuso.DeleteImagenUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author johana 6/04/2022
 */

@RestController
@RequestMapping("/imagen")
@RequiredArgsConstructor
public class DeleteImagenController {

    private final DeleteImagenUseCase deleteImagenUseCase;

    @Operation(summary = "Eliminar objeto imagen en MySQL")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "La imagen se elimino satisfactoriamente"),
            @ApiResponse(responseCode = "400", description = "Datos incorrrectos al intentar eliminar una imagen")
    })
    @DeleteMapping(value = "/{id}")
    public void eliminarImagen(@PathVariable String id){
        deleteImagenUseCase.ejeutar(id);
    }
}
