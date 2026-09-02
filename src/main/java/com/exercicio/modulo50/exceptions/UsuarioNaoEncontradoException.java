package com.exercicio.modulo50.exceptions;

import java.util.UUID;

public class UsuarioNaoEncontradoException extends RuntimeException {
    public UsuarioNaoEncontradoException(UUID id) {
        super("Usuário não encontrado com ID: " + id);
    }
}
