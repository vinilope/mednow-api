package com.mednow.mednowapi.controllers;

import com.mednow.mednowapi.dtos.requests.MedicoRequest;
import com.mednow.mednowapi.dtos.responses.MedicoResponse;
import com.mednow.mednowapi.services.MedicoService;
import jakarta.validation.Valid;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/medico")
@Builder
public class MedicoController {

    private MedicoService medicoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> saveMedico(@RequestBody @Valid MedicoRequest medicoRequest) {

        return ResponseEntity.status(HttpStatus.CREATED).body(medicoService.inserirMedico(medicoRequest));
    }

    @GetMapping("/")
    public ResponseEntity<Object> getMedicos() {

        return ResponseEntity.status(HttpStatus.OK).body(medicoService.getAllMedicos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoResponse> getMedicoById(@PathVariable UUID id) {

        return ResponseEntity.status(HttpStatus.OK).body(new MedicoResponse(medicoService.getMedicoById(id)));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Object> updateMedico(@PathVariable UUID id, @RequestBody @Valid MedicoRequest medicoRequest) {

        return ResponseEntity.status(HttpStatus.OK).body(medicoService.atualizarMedico(id, medicoRequest));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> deleteMedico(@PathVariable UUID id) {

        medicoService.deleteMedicoById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Médico deletado com sucesso.");
    }
}
