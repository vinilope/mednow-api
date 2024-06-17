package com.mednow.mednowapi.services;

import com.mednow.mednowapi.models.Usuario;
import com.mednow.mednowapi.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@Builder
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public Usuario inserirUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(UUID id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public void deleteUsuarioById(UUID id) {
        usuarioRepository.deleteById(id);
    }
}