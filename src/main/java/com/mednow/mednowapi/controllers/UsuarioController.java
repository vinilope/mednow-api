package com.mednow.mednowapi.controllers;

import com.mednow.mednowapi.dtos.requests.UsuarioRequest;
import com.mednow.mednowapi.dtos.responses.UsuarioResponse;
import com.mednow.mednowapi.models.Usuario;
import com.mednow.mednowapi.services.UsuarioService;
import jakarta.validation.Valid;
import lombok.Builder;
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
    public ResponseEntity<Usuario> saveUsuario(@RequestBody @Valid UsuarioRequest usuarioRequest) {

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.inserirUsuario(usuarioRequest));
    }

    @GetMapping("/")
    public ResponseEntity<List<Usuario>> getUsuarios() {

        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.getAllUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> getUsuarioById(@PathVariable UUID id) {

        return ResponseEntity.status(HttpStatus.OK).body(new UsuarioResponse(usuarioService.getUsuarioById(id)));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable UUID id, @RequestBody @Valid UsuarioRequest usuarioRequest) {

        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.atualizarUsuario(id, usuarioRequest));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable UUID id) {

        usuarioService.deleteUsuarioById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso.");
    }
}
