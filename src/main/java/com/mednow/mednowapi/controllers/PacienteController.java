package com.mednow.mednowapi.controllers;

import com.mednow.mednowapi.dtos.requests.PacienteRequest;
import com.mednow.mednowapi.dtos.responses.PacienteResponse;
import com.mednow.mednowapi.models.Paciente;
import com.mednow.mednowapi.services.PacienteService;
import jakarta.validation.Valid;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/paciente")
@Builder
public class PacienteController {

    private PacienteService pacienteService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Paciente> savePaciente(@RequestBody @Valid PacienteRequest pacienteRequest) {

        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.inserirPaciente(pacienteRequest));
    }

    @GetMapping("/")
    public ResponseEntity<List<Paciente>> getPacientes() {

        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.getAllPacientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponse> getPacienteById(@PathVariable UUID id) {

        return ResponseEntity.status(HttpStatus.OK).body(new PacienteResponse(pacienteService.getPacienteById(id)));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable UUID id, @RequestBody @Valid PacienteRequest pacienteRequest) {

        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.atualizarPaciente(id, pacienteRequest));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletePaciente(@PathVariable UUID id) {

        pacienteService.deletePacienteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Paciente deletado com sucesso.");
    }
}
