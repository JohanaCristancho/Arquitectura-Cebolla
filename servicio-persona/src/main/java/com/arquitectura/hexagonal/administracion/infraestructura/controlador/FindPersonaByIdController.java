package com.arquitectura.hexagonal.administracion.infraestructura.controlador;

import com.arquitectura.hexagonal.administracion.aplicacion.casosdeuso.FindPersonaByIdUseCase;
import com.arquitectura.hexagonal.administracion.aplicacion.dto.PersonaDto;
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
@RequestMapping("/personadata")
public class FindPersonaByIdController {

    private final FindPersonaByIdUseCase findPersonaByIdUseCase;

    @Operation(summary = "Lista filtrada por numero de id",
            description = "Persona filtrada por el id con la imagen asociada ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "El recurso se obtiene correctamente"),
    })
    @GetMapping("/{id}")
    public ResponseEntity<PersonaDto> personaPorId(@PathVariable("id") Long id){
        return new ResponseEntity(findPersonaByIdUseCase.ejecutar(id), HttpStatus.OK);
    }
}
