package com.arquitectura.hexagonal.administracion.infraestructura.controlador;

import com.arquitectura.hexagonal.administracion.aplicacion.casosdeuso.*;
import com.arquitectura.hexagonal.testUtilidades.Datos;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author johana 25/04/2022
 */


@WebMvcTest({FindAllPersonaController.class,
        FindPersonaByIdController.class,
        FindPersonasByDocumentoController.class,
        SavePersonaController.class,
        UpdatePersonaController.class,
        DeletePersonaController.class})
public class PersonaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FindAllPersonaUseCase findAllPersonaUseCase;

    @MockBean
    FindPersonaByIdUseCase findPersonaByIdUseCase;

    @MockBean
    FindPersonaByDocumentUseCase findPersonaByDocumentUseCase;

    @MockBean
    SavePersonaUseCase savePersonaUseCase;

    @MockBean
    UpdatePersonaUseCase updatePersonaUseCase;

    @MockBean
    DeletePersonaUseCase deletePersonaUseCase;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void listarPersonaTest() throws Exception {
        when(findAllPersonaUseCase.ejecutar()).thenReturn(Datos.listaPersonas);
        mockMvc.perform(get("/listaPersonas/").
                        contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

   @Test
    void listarPersonaPorIdTest() throws Exception {
        when(findPersonaByIdUseCase.ejecutar(1L)).thenReturn(Datos.personaDto);
        mockMvc.perform(get("/personadata/1").
                        contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void listPersonaDocumentTest() throws Exception {
        when(findPersonaByDocumentUseCase.ejecutar("109215632178")).thenReturn(Datos.personaResponseDto);
        mockMvc.perform(get("/persona/109215632178").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nombre").value("Martha"));
    }

    @Test
    void createPersonTest() throws Exception {;
        when(savePersonaUseCase.ejecutar(argThat(persona -> persona.getDocumento().equalsIgnoreCase("209215632170")))).thenReturn(Datos.personaRequestDto2);
        mockMvc.perform(post("/persona/")
                        .content(objectMapper.writeValueAsString(Datos.personaRequestDto2))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void updatePersonTest() throws Exception {
        when(updatePersonaUseCase.ejecutar(argThat(persona -> persona.getDocumento().equalsIgnoreCase("209215632170")))).thenReturn(Datos.personaRequestDto);
        mockMvc.perform(put("/persona/")
                        .content(objectMapper.writeValueAsString(Datos.personaRequestDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deletePersonaTest() throws Exception {
        when(findPersonaByIdUseCase.ejecutar(1L)).thenReturn(Datos.personaDto);
        mockMvc.perform(delete("/persona/1"))
                .andDo(print())
                .andExpect(status().isOk());

    }
}