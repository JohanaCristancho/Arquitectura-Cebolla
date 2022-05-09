package com.arquitectura.hexagonal.dominio;

import com.arquitectura.hexagonal.administracion.dominio.excepciones.PersonaDuplicadaExcepcion;
import com.arquitectura.hexagonal.administracion.dominio.excepciones.PersonaNotFoundExcepcion;
import com.arquitectura.hexagonal.administracion.dominio.modelo.Persona;
import com.arquitectura.hexagonal.administracion.dominio.repositorio.PersonaRepositorioPort;
import com.arquitectura.hexagonal.administracion.dominio.servicio.DeletePersonaService;
import com.arquitectura.hexagonal.administracion.dominio.servicio.FindPersonaService;
import com.arquitectura.hexagonal.administracion.dominio.servicio.SavePersonaService;
import com.arquitectura.hexagonal.administracion.dominio.servicio.UpdatePersonaService;
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
class PersonaServiceTest {

    @Mock
    PersonaRepositorioPort personaRepositorioPort;

    @InjectMocks
    SavePersonaService savePersonaService;

    @InjectMocks
    UpdatePersonaService updatePersonaService;

    @InjectMocks
    DeletePersonaService deletePersonaService;

    @InjectMocks
    FindPersonaService findPersonaService;

    @Test
    public void registrarPersonaTest() {
        when(personaRepositorioPort.savePersona(argThat(persona -> persona.getDocumento().equalsIgnoreCase("10921563210")))).thenReturn(Datos.johana);
        Persona persona = savePersonaService.registrarPersona(Datos.johana);
        assertEquals("Eddy Johana",persona.getNombre());
    }

    @Test
    public void registrarPersonaConCedulaQueYaExisteTest() {
        when(personaRepositorioPort.findByDocumento("10921563210")).thenReturn(Datos.johana);
        Exception exception = assertThrows(
                PersonaDuplicadaExcepcion.class, () -> {
                    savePersonaService.registrarPersona(Datos.johana);
                });
        String expectedMessage = "El documento 10921563210 que intenta registar ya esta asociada a otra persona";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void actualizarPersonaTest(){
     when(personaRepositorioPort.savePersona(
             argThat(persona -> persona.getDocumento().equalsIgnoreCase("10921563210")))).thenReturn(Datos.johana);
     Persona persona = updatePersonaService.actualizarPersona(Datos.johana);
     assertEquals("Eddy Johana", persona.getNombre());
    }

    @Test
    public void actualizarPersonaConCedulaQueYaExisteTest(){
        Persona karina = new Persona(2L, "Karina", "Cañas", "10921563210", "TC", 20);
        when(personaRepositorioPort.findByDocumento("10921563210")).thenReturn(karina);
        Exception exception = assertThrows(
                PersonaDuplicadaExcepcion.class, () -> {
                    updatePersonaService.actualizarPersona(Datos.johana);
                });
        String expectedMessage = "El documento 10921563210 que intenta registar ya esta asociada a otra persona";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void eliminarPersonaTest(){
        when(personaRepositorioPort.existePersona(1l)).thenReturn(true);
        deletePersonaService.eliminarPersona(1L);
        verify(personaRepositorioPort).deletePersona(1L);
    }

    @Test
    public void eliminarPersonaQueNoExisteTest() {
        when(personaRepositorioPort.existePersona(1l)).thenReturn(false);
        Exception exception = assertThrows(PersonaNotFoundExcepcion.class,
                () -> deletePersonaService.eliminarPersona(1L));
        String expectedMessage = "Persona con id 1 no existe";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void listaPersonasTest() {
        when(personaRepositorioPort.findByAllPersonas()).thenReturn(Datos.personas);
        List<Persona> personas = findPersonaService.buscarListaPersonas();
        assertEquals("Karina", personas.get(1).getNombre());
    }

    @Test
    public void personaPorDocumento() {
        when(personaRepositorioPort.findByDocumento("10921563210")).thenReturn(Datos.johana);
        Persona persona = findPersonaService.buscarPersonaPorDocumento("10921563210");
        assertEquals("Eddy Johana", persona.getNombre());
    }

    @Test
    public void personaConDocumentoNoExiste() {
        when(personaRepositorioPort.findByDocumento("10921563210")).thenReturn(null);
        Exception exception = assertThrows(PersonaNotFoundExcepcion.class,
                () -> findPersonaService.buscarPersonaPorDocumento("10921563210"));
        String expectedMessage = "Persona con documento 10921563210 no existe";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void personaPorIdPersona() {
        when(personaRepositorioPort.findById(2L)).thenReturn(Datos.karina);
        Persona persona = findPersonaService.buscarPersonaPorId(2L);
        assertEquals("Karina", persona.getNombre());
    }

    @Test
    public void personaNoExiste() {
        when(personaRepositorioPort.findById(1l)).thenReturn(null);
        Exception exception = assertThrows(PersonaNotFoundExcepcion.class,
                () -> findPersonaService.buscarPersonaPorId(1L));
        String expectedMessage = "Persona con id 1 no existe";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}