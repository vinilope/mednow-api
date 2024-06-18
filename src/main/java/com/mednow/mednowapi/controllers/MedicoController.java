package com.mednow.mednowapi.controllers;

import com.mednow.mednowapi.dtos.requests.MedicoRequest;
import com.mednow.mednowapi.models.Medico;
import com.mednow.mednowapi.services.MedicoService;
import jakarta.validation.Valid;
import lombok.Builder;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/medico")
@Builder
public class MedicoController {

    private MedicoService medicoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> saveMedico(@RequestBody @Valid MedicoRequest medicoRequest) {
        var medico = new Medico();
        BeanUtils.copyProperties(medicoRequest, medico);

        return ResponseEntity.status(HttpStatus.CREATED).body(medicoService.inserirMedico(medico));
    }

    @GetMapping("/")
    public ResponseEntity<Object> getMedicos() {
        List<Medico> medicos = medicoService.getAllMedicos();

        if (medicos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum médico encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(medicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getMedicoById(@PathVariable UUID id) {
        Medico medico = medicoService.getMedicoById(id);

        if (medico == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Médico não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(medico);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Object> updateMedicoById(@PathVariable UUID id, @RequestBody @Valid MedicoRequest medicoRequest) {
        Medico medico = medicoService.getMedicoById(id);

        if (medico == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Médico não encontrado.");
        }

        BeanUtils.copyProperties(medicoRequest, medico);
        return ResponseEntity.status(HttpStatus.OK).body(medicoService.inserirMedico(medico));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> deleteMedicoById(@PathVariable UUID id) {
        Medico medico = medicoService.getMedicoById(id);

        if (medico == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Médico não encontrado.");
        }

        medicoService.deleteMedicoById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Médico deletado com sucesso.");
    }
}
