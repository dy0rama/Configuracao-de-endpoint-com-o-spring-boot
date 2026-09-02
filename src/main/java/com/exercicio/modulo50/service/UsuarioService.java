package com.exercicio.modulo50.service;

import com.exercicio.modulo50.entities.Usuario;
import com.exercicio.modulo50.repository.UsuarioRepository;
import com.exercicio.modulo50.request.UsuarioRequest;
import com.exercicio.modulo50.response.UsuarioResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // CREATE
    public UsuarioResponse criar(UsuarioRequest request) {
        Usuario usuario = new Usuario();

        usuario.setUsuario(request.getUsuario());
        usuario.setSenha(passwordEncoder.encode(request.getSenha()));

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return new UsuarioResponse(usuarioSalvo.getId(), usuarioSalvo.getUsuario());
    }

    // READ - buscar por ID
    public UsuarioResponse buscarPorId(UUID id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() ->
                        new RuntimeException("Usuário não encontrado"));

        return new UsuarioResponse(usuario.getId(), usuario.getUsuario());
    }

    // READ - listar todos
    public List<UsuarioResponse> listarTodos() {
        return usuarioRepository.findAll().stream()
                .map(usuario -> new UsuarioResponse(usuario.getId(), usuario.getUsuario())).toList();
    }

    // UPDATE
    public UsuarioResponse atualizar(UUID id, UsuarioRequest request) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setUsuario(request.getUsuario());
        usuario.setSenha(request.getSenha());

        Usuario usuarioAtualizado = usuarioRepository.save(usuario);

        return new UsuarioResponse(usuarioAtualizado.getId(), usuarioAtualizado.getUsuario());
    }

    // DELETE
    public void deletar(UUID id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuarioRepository.delete(usuario);
    }
}
