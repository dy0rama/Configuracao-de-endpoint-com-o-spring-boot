package com.exercicio.modulo50.exceptions;

import com.exercicio.modulo50.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<ErrorResponse> handleUsuarioNaoEncontradoException(UsuarioNaoEncontradoException ex) {
        ErrorResponse errorResponse =
                new ErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "Usuário não encontrado", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
