package com.arquitectura.hexagonal.dominio;

import com.arquitectura.hexagonal.administracion.dominio.excepciones.ImagenDataDuplicada;
import com.arquitectura.hexagonal.administracion.dominio.excepciones.ImagenNotFoundExcepcion;
import com.arquitectura.hexagonal.administracion.dominio.modelo.ImagenMongo;
import com.arquitectura.hexagonal.administracion.dominio.repositorio.ImagenMongoRepositorioPort;
import com.arquitectura.hexagonal.administracion.dominio.servicio.DeleteImagenServicio;
import com.arquitectura.hexagonal.administracion.dominio.servicio.FindImagenService;
import com.arquitectura.hexagonal.administracion.dominio.servicio.SaveImagenServicio;
import com.arquitectura.hexagonal.administracion.dominio.servicio.UpdateImagenServicio;
import com.arquitectura.hexagonal.testUtilidades.Datos;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author johana 08/04/2022
 */

@ExtendWith(MockitoExtension.class)
public class ImagenServiceTest {

    @Mock
    ImagenMongoRepositorioPort imagenMongoRepositorioPort;

    @InjectMocks
    SaveImagenServicio saveImagenServicio;

    @InjectMocks
    UpdateImagenServicio updateImagenServicio;

    @InjectMocks
    DeleteImagenServicio deleteImagenServicio;

    @InjectMocks
    FindImagenService findImagenService;

    @Test
    void findAllImagenesTest() {
        when(imagenMongoRepositorioPort.finByAllImagenes()).thenReturn(Datos.listaImagenes);
        List<ImagenMongo> listaImagenes = findImagenService.listaImagenes();
        assertEquals("imagen", listaImagenes.get(0).getNombre());
        assertEquals("flores", listaImagenes.get(1).getNombre());
    }

    @Test
    void findByImagenTest() {
        when(imagenMongoRepositorioPort.existeImagen("1")).thenReturn(true);
        when(imagenMongoRepositorioPort.finById("1")).thenReturn(Datos.imagenMongo);
        ImagenMongo imagenMongo = findImagenService.buscarImagenPorId("1");
        assertEquals("imagen", imagenMongo.getNombre());
        assertEquals("validacion", imagenMongo.getTipo());
    }

    @Test
    void findByIdImagenNoExisteTest() {
        when(imagenMongoRepositorioPort.existeImagen("3")).thenReturn(false);
        Exception exception = assertThrows(
                ImagenNotFoundExcepcion.class, () -> {
                    findImagenService.buscarImagenPorId("3");
                });
        String expectedMessage = "No hay ninguna imagen asociada al id 3";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void findByIdPersonaImagenTest() {
        when(imagenMongoRepositorioPort.findSummaryByIdPersona("1")).thenReturn(Datos.imagenMongo);
        ImagenMongo imagenMongo = findImagenService.listaImagenesPorIdPersona("1");
        assertEquals("imagen", imagenMongo.getNombre());
        assertEquals("validacion", imagenMongo.getTipo());
    }

    @Test
    void registarImagenTest() {
        when(imagenMongoRepositorioPort.saveImagen(argThat(imagen -> imagen.getNombre().equalsIgnoreCase(
                "flores")))).thenReturn(Datos.imagenMongo1);
        ImagenMongo imagenMongo = saveImagenServicio.guardarImagen(Datos.imagenMongo1);
        assertEquals("flores", imagenMongo.getNombre());
    }

    @Test
    void registrarImagenConPersonaYaRegistradaTest() {
        when(imagenMongoRepositorioPort.findSummaryByIdPersona("1")).thenReturn(Datos.imagenMongo);
        Exception exception = assertThrows(
                ImagenDataDuplicada.class, () -> {
                    saveImagenServicio.guardarImagen(Datos.imagenMongo);
                });
        String expectedMessage = "Ya hay una imagen asociada a una persona con id 1";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void registrarSinImagenTest() {
        Exception exception = assertThrows(
                ImagenNotFoundExcepcion.class, () -> {
                    saveImagenServicio.guardarImagen(Datos.imagenMongo3);
                });
        String expectedMessage = "Es necesario agregar una imagen";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void actualizarImagenTest() {

        when(imagenMongoRepositorioPort.finById("1")).thenReturn(Datos.imagenMongo);
        when(imagenMongoRepositorioPort.saveImagen(argThat(imagen -> imagen.getNombre().equalsIgnoreCase("imagen")))).thenReturn(Datos.imagenMongo);
        ImagenMongo imagenMongo = updateImagenServicio.actualizarImagen(Datos.imagenMongo);
        assertEquals("imagen", imagenMongo.getNombre());
    }

    @Test
    void actualizarImagenConPersonaYaAsocaidaTest() {
        ImagenMongo imagenMongo = new ImagenMongo("3", "validacion", "imagen", "imagen", 2l);
        when(imagenMongoRepositorioPort.findSummaryByIdPersona("1")).thenReturn(Datos.imagenMongo);
        when(imagenMongoRepositorioPort.finById("1")).thenReturn(imagenMongo);
        Exception exception = assertThrows(
                ImagenDataDuplicada.class, () -> {
                    updateImagenServicio.actualizarImagen(Datos.imagenMongo);
                });
        String expectedMessage = "Ya hay una imagen asociada a una persona con id 1";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void actualizarSinImagenTest() {
        Exception exception = assertThrows(
                ImagenNotFoundExcepcion.class, () -> {
                    updateImagenServicio.actualizarImagen(Datos.imagenMongo3);
                });
        String expectedMessage = "Es necesario agregar una imagen";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void eliminarImgenTest() {
        when(imagenMongoRepositorioPort.existeImagen("1")).thenReturn(true);
        deleteImagenServicio.eliminarImagen("1");
        verify(imagenMongoRepositorioPort).deleteImagen("1");
    }

    @Test
    void eliminarImagenNotExistTest() {
        when(imagenMongoRepositorioPort.existeImagen("1")).thenReturn(false);
        Exception exception = assertThrows(ImagenNotFoundExcepcion.class,
                () -> deleteImagenServicio.eliminarImagen("1"));
        String expectedMessage = "Imagen con id 1 no existe.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
