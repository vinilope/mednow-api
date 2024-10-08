package com.mednow.mednowapi.controllers;

import com.mednow.mednowapi.dtos.requests.LaboratorioRequest;
import com.mednow.mednowapi.dtos.responses.LaboratorioResponse;
import com.mednow.mednowapi.models.Laboratorio;
import com.mednow.mednowapi.services.LaboratorioService;
import jakarta.validation.Valid;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/laboratorio")
@Builder
public class LaboratorioController {

    private LaboratorioService laboratorioService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Laboratorio> saveLaboratorio(@RequestBody @Valid LaboratorioRequest laboratorioRequest) {

        return ResponseEntity.status(HttpStatus.CREATED).body(laboratorioService.inserirLaboratorio(laboratorioRequest));
    }

    @GetMapping("/")
    public ResponseEntity<List<Laboratorio>> getLaboratorios() {

        return ResponseEntity.status(HttpStatus.OK).body(laboratorioService.getAllLaboratorios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LaboratorioResponse> getLaboratorioById(@PathVariable UUID id) {

        return ResponseEntity.status(HttpStatus.OK).body(new LaboratorioResponse(laboratorioService.getLaboratorioById(id)));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Laboratorio> updateLaboratorio(@PathVariable UUID id, @RequestBody @Valid LaboratorioRequest laboratorioRequest) {

        return ResponseEntity.status(HttpStatus.OK).body(laboratorioService.atualizarLaboratorio(id, laboratorioRequest));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deleteLaboratorio(@PathVariable UUID id) {

        laboratorioService.deleteLaboratorioById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Laboratório deletado com sucesso.");
    }
}
