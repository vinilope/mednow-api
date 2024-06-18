package com.mednow.mednowapi.controllers;

import com.mednow.mednowapi.dtos.requests.EnderecoRequest;
import com.mednow.mednowapi.models.Endereco;
import com.mednow.mednowapi.services.EnderecoService;
import jakarta.validation.Valid;
import lombok.Builder;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/endereco")
@Builder
public class EnderecoController {

    private EnderecoService enderecoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> saveEndereco(@RequestBody @Valid EnderecoRequest enderecoRequest) {

        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.inserirEndereco(enderecoRequest));
    }

    @GetMapping("/")
    public ResponseEntity<Object> getEnderecos() {
        List<Endereco> enderecos = enderecoService.getAllEnderecos();

        if (enderecos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum endereço encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(enderecos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEnderecoById(@PathVariable UUID id) {
        Endereco endereco = enderecoService.getEnderecoById(id);

        if (endereco == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(endereco);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Object> updateEnderecoById(@PathVariable UUID id, @RequestBody @Valid EnderecoRequest enderecoRequest) {
        Endereco endereco = enderecoService.getEnderecoById(id);

        if (endereco == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.inserirEndereco(enderecoRequest));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> deleteEnderecoById(@PathVariable UUID id) {
        Endereco endereco = enderecoService.getEnderecoById(id);

        if (endereco == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não encontrado.");
        }

        enderecoService.deleteEnderecoById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Endereço deletado com sucesso.");
    }
}
