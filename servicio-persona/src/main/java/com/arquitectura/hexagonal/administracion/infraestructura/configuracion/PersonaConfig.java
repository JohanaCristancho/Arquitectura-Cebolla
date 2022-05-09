package com.arquitectura.hexagonal.administracion.infraestructura.configuracion;

import com.arquitectura.hexagonal.administracion.dominio.repositorio.PersonaRepositorioPort;
import com.arquitectura.hexagonal.administracion.dominio.servicio.DeletePersonaService;
import com.arquitectura.hexagonal.administracion.dominio.servicio.FindPersonaService;
import com.arquitectura.hexagonal.administracion.dominio.servicio.SavePersonaService;
import com.arquitectura.hexagonal.administracion.dominio.servicio.UpdatePersonaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author johana 4/04/2022
 */
@Configuration
public class PersonaConfig {

    @Bean
    public DeletePersonaService deletePersonaService(PersonaRepositorioPort personaRepositorioPort){
        return new DeletePersonaService(personaRepositorioPort);
    }

    @Bean
    public SavePersonaService savePersonaService (PersonaRepositorioPort personaRepositorioPort){
        return new SavePersonaService(personaRepositorioPort);
    }

    @Bean
    public UpdatePersonaService updatePersonaService (PersonaRepositorioPort personaRepositorioPort){
        return new UpdatePersonaService(personaRepositorioPort);
    }

    @Bean
    public FindPersonaService findPersonaService (PersonaRepositorioPort personaRepositorioPort){
        return new FindPersonaService(personaRepositorioPort);
    }
}
