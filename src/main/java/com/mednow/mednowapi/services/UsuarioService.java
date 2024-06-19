package com.mednow.mednowapi.services;

import com.mednow.mednowapi.dtos.requests.UsuarioRequest;
import com.mednow.mednowapi.models.Usuario;
import com.mednow.mednowapi.repositories.UsuarioRepository;
import exceptions.ReponseException;
import jakarta.transaction.Transactional;
import lombok.Builder;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@Builder
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public Usuario inserirUsuario(UsuarioRequest usuarioRequest) {
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioRequest, usuario);

        return usuarioRepository.save(usuario);
    }

    public List<Usuario> getAllUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();

        if (usuarios.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum usuário encontrado.");
        }

        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(UUID idUsuario) {

        if (usuarioRepository.findById(idUsuario).isEmpty()) {
            throw new ReponseException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }

        return usuarioRepository.findById(idUsuario).get();
    }

    public void deleteUsuarioById(UUID idUsuario) {

        if (usuarioRepository.findById(idUsuario).isEmpty()) {
            throw new ReponseException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }

        usuarioRepository.deleteById(idUsuario);
    }

    public Usuario atualizarUsuario(UUID idUsuario, UsuarioRequest usuarioRequest) {
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioRequest, usuario);
        usuario.setIdUsuario(idUsuario);

        if (usuarioRepository.findById(idUsuario).isEmpty()) {
            throw new ReponseException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }

        return usuarioRepository.save(usuario);
    }
}
