package com.mednow.mednowapi.controllers;

import com.mednow.mednowapi.dtos.requests.ClinicaRequest;
import com.mednow.mednowapi.dtos.responses.ClinicaResponse;
import com.mednow.mednowapi.models.Clinica;
import com.mednow.mednowapi.services.ClinicaService;
import jakarta.validation.Valid;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clinica")
@Builder
public class ClinicaController {

    private ClinicaService clinicaService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> saveClinica(@RequestBody @Valid ClinicaRequest clinicaRequest) {

        return ResponseEntity.status(HttpStatus.CREATED).body(clinicaService.inserirClinica(clinicaRequest));
    }

    @GetMapping("/")
    public ResponseEntity<Object> getClinicas() {
        List<Clinica> clinicas = clinicaService.getAllClinicas();

        if (clinicas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhuma clínica encontrada.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(clinicas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClinicaResponse> getClinicaById(@PathVariable UUID id) {

        return ResponseEntity.status(HttpStatus.OK).body(new ClinicaResponse(clinicaService.getClinicaById(id)));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Object> updateClinica(@PathVariable UUID id, @RequestBody @Valid ClinicaRequest clinicaRequest) {

        return ResponseEntity.status(HttpStatus.OK).body(clinicaService.atualizarClinica(id, clinicaRequest));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> deleteClinica(@PathVariable UUID id) {

        clinicaService.deleteClinicaById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Clínica deletada com sucesso.");
    }
}
