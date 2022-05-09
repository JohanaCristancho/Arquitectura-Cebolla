package com.arquitectura.hexagonal.administracion.infraestructura.controlador;

import com.arquitectura.hexagonal.administracion.aplicacion.casosdeuso.UpdatePersonaUseCase;
import com.arquitectura.hexagonal.administracion.aplicacion.dto.PersonaRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author johana 6/04/2022
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/persona")
public class UpdatePersonaController {

    private final UpdatePersonaUseCase updatePersonaUseCase;

    @Operation(summary = "Actualizar objeto persona.",
            description = "Se permite actualizar los datos de la persona")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La acualizacón de la persona fue exitosa "),
            @ApiResponse(responseCode = "400", description = "Problemas con la petición para realizar el registro" )
    })
    @PutMapping("/")
    public ResponseEntity<PersonaRequestDto>actualizarPersona(@RequestBody PersonaRequestDto personaRequestDto){
        return new ResponseEntity(updatePersonaUseCase.ejecutar(personaRequestDto), HttpStatus.OK);
    }
}
