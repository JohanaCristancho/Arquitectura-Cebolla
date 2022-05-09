package com.arquitectura.hexagonal.administracion.infraestructura.controlador;

import com.arquitectura.hexagonal.administracion.aplicacion.casosdeuso.DeletePersonaUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author johana 4/04/2022
 */

@RestController
@RequestMapping("/persona")
@RequiredArgsConstructor
public class DeletePersonaController {

    private final DeletePersonaUseCase deletePersonaUseCase;

    @Operation(summary = "Eliminar objeto persona.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La persona se elimino correctamente"),
            @ApiResponse(responseCode = "400", description = "Problemas con la petición para eliminar el registro")
    })
    @DeleteMapping(value = "/{id}")
    public void eliminarPersona(@PathVariable Long id){
        deletePersonaUseCase.ejecutar(id);
    }
}
