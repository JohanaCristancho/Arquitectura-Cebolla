package com.arquitectura.hexagonal.administracion.aplicacion.excepciones;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author johana 31/03/2022
 */

@ControllerAdvice
public class ControllerAdviceImage extends ResponseEntityExceptionHandler {

    private static final String OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR = "Ocurrió un error favor contactar al administrador.";
    private static final ConcurrentHashMap<String, Integer> CODIGOS_ESTADO = new ConcurrentHashMap<>();

    public ControllerAdviceImage() {
        CODIGOS_ESTADO.put(ImagenDataDuplicada.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(PersonaNotFoundExcepcion.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put("MissingServletRequestParameterException", HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put("BindException", HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorMessage> handleAllExceptions(Exception excepcion) {
        ResponseEntity<ErrorMessage> resultado;

        var nombreExcepcion = excepcion.getClass().getSimpleName();
        var mensaje = excepcion.getMessage();
        var codigo = CODIGOS_ESTADO.get(nombreExcepcion);

        if (codigo != null) {
            var error = ErrorMessage.builder().nombreExcepcion(nombreExcepcion).mensaje(mensaje).build();
            resultado = new ResponseEntity<>(error, HttpStatus.valueOf(codigo));
        } else {
            var error = ErrorMessage.builder().nombreExcepcion(nombreExcepcion)
                    .mensaje(OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR).build();
            resultado = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return resultado;
    }

    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        var bindingResult = ex.getBindingResult();
        var errores = bindingResult.getFieldErrors().stream().map(err -> {
            Map<String, String> error = new HashMap<>();
            error.put(err.getField(), err.getDefaultMessage());
            return error;
        }).collect(Collectors.toList());

        var nombreExcepcion = ex.getClass().getSimpleName();
        var codigo = CODIGOS_ESTADO.get(nombreExcepcion);

        if (codigo != null) {
            var error = ErrorMessage.builder().nombreExcepcion(nombreExcepcion).mensaje(String.valueOf(errores)).build();
            return new ResponseEntity<>(error, HttpStatus.valueOf(codigo));
        } else {
            var error = ErrorMessage.builder().nombreExcepcion(nombreExcepcion)
                    .mensaje(OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR).build();
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public final ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                     HttpHeaders headers, HttpStatus status, WebRequest request) {
        var bindingResult = ex.getBindingResult();
        var errores = bindingResult.getFieldErrors().stream().map(err -> {
            Map<String, String> error = new HashMap<>();
            error.put(err.getField(), err.getDefaultMessage());
            return error;

        }).collect(Collectors.toList());

        var nombreExcepcion = ex.getClass().getSimpleName();
        var codigo = CODIGOS_ESTADO.get(nombreExcepcion);
        var error = ErrorMessage.builder().nombreExcepcion(nombreExcepcion).mensaje(String.valueOf(errores)).build();
        return new ResponseEntity<>(error, HttpStatus.valueOf(codigo));
    }

    @Override
    public final ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
                                                                             HttpHeaders headers, HttpStatus status, WebRequest request) {
        var mensaje = ex.getParameterName() + " es requerido";
        var nombreExcepcion = ex.getClass().getSimpleName();
        var codigo = CODIGOS_ESTADO.get(nombreExcepcion);
        var error = ErrorMessage.builder().nombreExcepcion(nombreExcepcion).mensaje(mensaje).build();
        return new ResponseEntity<>(error, HttpStatus.valueOf(codigo));
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<Object> handleMissingRequestHeaderException(final MissingRequestHeaderException e) {
        var mensaje = e.getHeaderName() + " es requerido";

        var nombreExcepcion = e.getClass().getSimpleName();
        var codigo = CODIGOS_ESTADO.get(nombreExcepcion);
        var error = ErrorMessage.builder().nombreExcepcion(nombreExcepcion).mensaje(mensaje).build();
        return new ResponseEntity<>(error, HttpStatus.valueOf(codigo));
    }

}
