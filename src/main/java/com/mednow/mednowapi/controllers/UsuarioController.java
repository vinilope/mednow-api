package com.mednow.mednowapi.controllers;

import com.mednow.mednowapi.dtos.requests.UsuarioRequest;
import com.mednow.mednowapi.models.Usuario;
import com.mednow.mednowapi.services.UsuarioService;
import jakarta.validation.Valid;
import lombok.Builder;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuario")
@Builder
public class UsuarioController {

    private UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> saveUsuario(@RequestBody @Valid UsuarioRequest usuarioRequest) {
        var usuario = new Usuario();
        BeanUtils.copyProperties(usuarioRequest, usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.inserirUsuario(usuario));
    }

    @GetMapping("/")
    public ResponseEntity<List<Usuario>> getUsuarios() {
        List<Usuario> usuarios = usuarioService.getAllUsuarios();

        if (usuarios.isEmpty()) {
            throw new RuntimeException("Usuário blablabla");
        }

        return ResponseEntity.status(HttpStatus.OK).body(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUsuarioById(@PathVariable UUID id) {
        Usuario usuario = usuarioService.getUsuarioById(id);

        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Object> updateUsuarioById(@PathVariable UUID id, @RequestBody @Valid UsuarioRequest usuarioRequest) {
        Usuario usuario = usuarioService.getUsuarioById(id);

        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }

        BeanUtils.copyProperties(usuarioRequest, usuario);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.inserirUsuario(usuario));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> deleteUsuarioById(@PathVariable UUID id) {
        Usuario usuario = usuarioService.getUsuarioById(id);

        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }

        usuarioService.deleteUsuarioById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso.");
    }
}
