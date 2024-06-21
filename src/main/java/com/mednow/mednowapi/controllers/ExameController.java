package com.mednow.mednowapi.controllers;

import com.mednow.mednowapi.dtos.requests.ExameRequest;
import com.mednow.mednowapi.dtos.responses.ExameResponse;
import com.mednow.mednowapi.models.Exame;
import com.mednow.mednowapi.services.ExameService;
import jakarta.validation.Valid;
import lombok.Builder;
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
    public ResponseEntity<Exame> saveExame(@RequestBody @Valid ExameRequest exameRequest) {

        return ResponseEntity.status(HttpStatus.CREATED).body(exameService.inserirExame(exameRequest));
    }

    @GetMapping("/")
    public ResponseEntity<List<Exame>> getExames() {

        return ResponseEntity.status(HttpStatus.OK).body(exameService.getAllExames());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExameResponse> getExameById(@PathVariable UUID id) {

        return ResponseEntity.status(HttpStatus.OK).body(new ExameResponse(exameService.getExameById(id)));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Exame> updateExame(@PathVariable UUID id, @RequestBody @Valid ExameRequest exameRequest) {

        return ResponseEntity.status(HttpStatus.OK).body(exameService.atualizarExame(id, exameRequest));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deleteExame(@PathVariable UUID id) {

        exameService.deleteExameById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Exame deletado com sucesso.");
    }
}
