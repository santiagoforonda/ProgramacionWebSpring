package com.futbol.BackendLigaFutbol.Excepciones;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalExcepcion {

    @ExceptionHandler(EquipoNotFound.class)
    public  ResponseEntity<ErrorResponse> teamNotfound(EquipoNotFound equipo, WebRequest wr){
        ErrorResponse respuesta = new ErrorResponse();
        respuesta.setErrorCode(HttpStatus.NOT_FOUND.value());
        respuesta.setTime(LocalDateTime.now());
        respuesta.setDescripcion(wr.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
    }

    @ExceptionHandler(PartidoNotFound.class)
    public  ResponseEntity<ErrorResponse> matchNotfound(PartidoNotFound partido, WebRequest wr){
        ErrorResponse respuesta = new ErrorResponse();
        respuesta.setErrorCode(HttpStatus.NOT_FOUND.value());
        respuesta.setTime(LocalDateTime.now());
        respuesta.setDescripcion(wr.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
    }

    
}
