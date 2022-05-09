package com.arquitectura.hexagonal.administracion.infraestructura.controlador;

import com.arquitectura.hexagonal.administracion.aplicacion.casosdeuso.SavePersonaUseCase;
import com.arquitectura.hexagonal.administracion.aplicacion.dto.PersonaRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author johana 5/04/2022
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/persona")
public class SavePersonaController {

    private final SavePersonaUseCase savePersonaUseCase;

    @Operation(summary = "Registrar objeto persona.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "El registro de la persona se realiza correctamente"),
            @ApiResponse(responseCode = "400", description = "Problemas con la petición para realizar el registro" ),
    })
    @PostMapping("/")
    public ResponseEntity<PersonaRequestDto> guardarPersona(@RequestBody PersonaRequestDto personaRequestDto) {
        return new ResponseEntity(savePersonaUseCase.ejecutar(personaRequestDto), HttpStatus.CREATED);
    }
}
