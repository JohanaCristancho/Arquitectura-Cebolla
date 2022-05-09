package com.arquitectura.hexagonal.administracion.infraestructura.controlador;

import com.arquitectura.hexagonal.administracion.aplicacion.casosdeuso.FindAllImagenUseCase;
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

@RequiredArgsConstructor
@RestController
@RequestMapping("/listaimagenes")
public class FindAllImagenController {

    private final FindAllImagenUseCase findAllImagenUseCase;

    @Operation(summary = "Listar imagenes registradas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se obtiene con exito la lista de imagenes registradas"),
    })
    @GetMapping("/")
    public ResponseEntity<ImagenDto> listaImagenes(){
        return new ResponseEntity(findAllImagenUseCase.ejecutar(), HttpStatus.OK);
    }

    @Operation(summary = "Imagen registrada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se obtiene con exito imagen filtrada por documento de una persona"),
    })
    @GetMapping("/{id}")
    public ResponseEntity<ImagenDto> listaImagenesPorIdPersona(@PathVariable String id){
        return new ResponseEntity(findAllImagenUseCase.buscarPersona(id), HttpStatus.OK);
    }
}
