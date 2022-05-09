package com.arquitectura.hexagonal.administracion.dominio.excepciones;

import lombok.Builder;

/**
 * @author johana 31/03/2022
 */

@Builder
public class ErrorMessage {

        private final String mensaje;
        private final String nombreExcepcion;

        public String getNombreExcepcion() {
                return nombreExcepcion;
        }

        public String getMensaje() {
                return mensaje;
        }

}
