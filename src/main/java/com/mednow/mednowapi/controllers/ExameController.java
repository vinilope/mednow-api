package com.mednow.mednowapi.controllers;

import com.mednow.mednowapi.dtos.requests.ExameRequest;
import com.mednow.mednowapi.models.Exame;
import com.mednow.mednowapi.services.ExameService;
import jakarta.validation.Valid;
import lombok.Builder;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/exame")
@Builder
public class ExameController {

    private ExameService exameService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> saveExame(@RequestBody @Valid ExameRequest exameRequest) {

        return ResponseEntity.status(HttpStatus.CREATED).body(exameService.inserirExame(exameRequest));
    }

    @GetMapping("/")
    public ResponseEntity<Object> getExames() {
        List<Exame> exames = exameService.getAllExames();

        if (exames.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum exame encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(exames);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getExameById(@PathVariable UUID id) {
        Exame exame = exameService.getExameById(id);

        if (exame == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exame não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(exame);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Object> updateExameById(@PathVariable UUID id, @RequestBody @Valid ExameRequest exameRequest) {
        Exame exame = exameService.getExameById(id);

        if (exame == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exame não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(exameService.inserirExame(exameRequest));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> deleteExameById(@PathVariable UUID id) {
        Exame exame = exameService.getExameById(id);

        if (exame == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exame não encontrado.");
        }

        exameService.deleteExameById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Exame deletado com sucesso.");
    }
}
