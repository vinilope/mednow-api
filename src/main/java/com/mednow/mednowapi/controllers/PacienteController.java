package com.mednow.mednowapi.controllers;

import com.mednow.mednowapi.dtos.requests.PacienteRequest;
import com.mednow.mednowapi.models.Paciente;
import com.mednow.mednowapi.services.PacienteService;
import jakarta.validation.Valid;
import lombok.Builder;
import org.springframework.beans.BeanUtils;
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
    public ResponseEntity<Object> savePaciente(@RequestBody @Valid PacienteRequest pacienteRequest) {
        var paciente = new Paciente();
        BeanUtils.copyProperties(pacienteRequest, paciente);

        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.inserirPaciente(paciente));
    }

    @GetMapping("/")
    public ResponseEntity<Object> getPacientes() {
        List<Paciente> pacientes = pacienteService.getAllPacientes();

        if (pacientes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum paciente encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(pacientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPacienteById(@PathVariable UUID id) {
        Paciente paciente = pacienteService.getPacienteById(id);

        if (paciente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(paciente);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Object> updatePacienteById(@PathVariable UUID id, @RequestBody @Valid PacienteRequest pacienteRequest) {
        Paciente paciente = pacienteService.getPacienteById(id);

        if (paciente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado.");
        }

        BeanUtils.copyProperties(pacienteRequest, paciente);
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.inserirPaciente(paciente));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> deletePacienteById(@PathVariable UUID id) {
        Paciente paciente = pacienteService.getPacienteById(id);

        if (paciente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado.");
        }

        pacienteService.deletePacienteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Paciente deletado com sucesso.");
    }
}
