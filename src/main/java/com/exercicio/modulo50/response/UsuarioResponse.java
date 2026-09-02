package com.exercicio.modulo50.response;

import java.util.UUID;

public class UsuarioResponse {
    private UUID id;
    private String usuario;

    public UsuarioResponse() {
    }

    public UsuarioResponse(UUID id, String usuario) {
        this.id = id;
        this.usuario = usuario;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
