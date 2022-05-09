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
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @author johana 26/04/2022
 */

@WebMvcTest({ DeleteImagenController.class,
        FindAllImagenController.class,
        FindImagenByIdController.class,
        SaveImagenController.class,
        UpdateImagenController.class})
public class ImagenControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    DeleteImagenUseCase deleteImagenUseCase;

    @MockBean
    FindAllImagenUseCase findAllImagenUseCase;

    @MockBean
    FindImagenByIdUseCase findImagenByIdUseCase;

    @MockBean
    SaveImagenUseCase saveImagenUseCase;

    @MockBean
    UpdateImagenUseCase updateImagenUseCase;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void listarImagenTest() throws Exception {
        when(findAllImagenUseCase.ejecutar()).thenReturn(Datos.listaImagenes);
        mockMvc.perform(get("/listaimagenes/").
                        contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void listarImagenPorIdTest() throws Exception {
        when(findImagenByIdUseCase.ejecutar("1")).thenReturn(Datos.imagenMongo);
        mockMvc.perform(get("/imagen/1").
                        contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void createImagenTest() throws Exception {
        MockMultipartFile file = new MockMultipartFile("imagen", "foo.txt", MediaType.TEXT_PLAIN_VALUE, "Hello World".getBytes());
        when(saveImagenUseCase.ejecutar(argThat(imagen -> imagen.getNombre().equalsIgnoreCase("validacion")))).thenReturn(Datos.imagenDto2);
        mockMvc.perform(multipart("/imagen/")
                .file(file)
                        .param("idPersona", "1")
                        .contentType(MediaType.MULTIPART_FORM_DATA))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void actualizarImagenTest() throws Exception {

        MockMultipartFile file = new MockMultipartFile("imagen", "foo.txt", MediaType.TEXT_PLAIN_VALUE, "Hello World".getBytes());
        when(updateImagenUseCase.ejecutar(argThat(imagen -> imagen.getNombre().equalsIgnoreCase("validacion")))).thenReturn(Datos.imagenDto);
        MockMultipartHttpServletRequestBuilder builder = MockMvcRequestBuilders.multipart("/imagen/1");
        builder.with(request -> {
            request.setMethod("PUT");
            return request;
        });

        mockMvc.perform(builder
                        .file(file)
                        .param("idPersona", "1")
                        .contentType(MediaType.MULTIPART_FORM_DATA_VALUE))
                .andExpect(status().isCreated())
                .andDo(print());

        mockMvc.perform(builder
                        .file(file)
                        .param("idPersona", "1")
                        .contentType(MediaType.MULTIPART_FORM_DATA_VALUE))
                .andExpect(status().isCreated())
                .andDo(print());

    }

    @Test
    void eliminarImagenTest() throws Exception {
        when(findImagenByIdUseCase.ejecutar("2")).thenReturn(Datos.imagenMongo1);
        mockMvc.perform(delete("/imagen/2"))
                .andDo(print())
                .andExpect(status().isOk());

    }
}