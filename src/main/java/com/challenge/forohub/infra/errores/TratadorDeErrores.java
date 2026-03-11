package com.challenge.forohub.infra.errores;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErrores {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity tratarErrorRuntime(RuntimeException ex){

        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}