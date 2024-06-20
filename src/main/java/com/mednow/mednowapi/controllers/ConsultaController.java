package com.mednow.mednowapi.controllers;

import com.mednow.mednowapi.dtos.requests.ConsultaRequest;
import com.mednow.mednowapi.dtos.responses.ConsultaResponse;
import com.mednow.mednowapi.services.ConsultaService;
import jakarta.validation.Valid;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/consulta")
@Builder
public class ConsultaController {

    private ConsultaService consultaService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> saveConsulta(@RequestBody @Valid ConsultaRequest consultaRequest) {

        return ResponseEntity.status(HttpStatus.CREATED).body(consultaService.inserirConsulta(consultaRequest));
    }

    @GetMapping("/")
    public ResponseEntity<Object> getConsultas() {

        return ResponseEntity.status(HttpStatus.OK).body(consultaService.getAllConsultas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaResponse> getConsultaById(@PathVariable UUID id) {

        return ResponseEntity.status(HttpStatus.OK).body(new ConsultaResponse(consultaService.getConsultaById(id)));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Object> updateConsulta(@PathVariable UUID id, @RequestBody @Valid ConsultaRequest consultaRequest) {

        return ResponseEntity.status(HttpStatus.OK).body(consultaService.atualizarConsulta(id, consultaRequest));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> deleteConsulta(@PathVariable UUID id) {

        consultaService.deleteConsultaById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Consulta deletada com sucesso.");
    }
}
