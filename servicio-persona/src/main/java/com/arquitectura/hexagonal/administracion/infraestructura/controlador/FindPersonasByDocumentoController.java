package com.arquitectura.hexagonal.administracion.infraestructura.controlador;

import com.arquitectura.hexagonal.administracion.aplicacion.casosdeuso.FindPersonaByDocumentUseCase;
import com.arquitectura.hexagonal.administracion.aplicacion.dto.PersonaResponseDto;
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
@RequestMapping("/persona")
public class FindPersonasByDocumentoController {

    private final FindPersonaByDocumentUseCase findPersonaByDocumentUseCase;

    @Operation(summary = "Lista filtrada por numero de cedula",
            description = "Persona filtrada por el numero de cedula con la imagen asociada ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "El recurso se obtiene correctamente"),
    })
    @GetMapping("/{documento}")
    public ResponseEntity<PersonaResponseDto> personaPorDocumento(@PathVariable String documento){
        return new ResponseEntity(findPersonaByDocumentUseCase.ejecutar(documento), HttpStatus.OK);
    }
}
