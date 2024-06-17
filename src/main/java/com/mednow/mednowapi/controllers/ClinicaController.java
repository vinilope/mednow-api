package com.mednow.mednowapi.controllers;

import com.mednow.mednowapi.dtos.ClinicaDto;
import com.mednow.mednowapi.models.Clinica;
import com.mednow.mednowapi.services.ClinicaService;
import jakarta.validation.Valid;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
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
    public ResponseEntity<Object> saveClinica(@RequestBody @Valid ClinicaDto clinicaDto) {
        var clinica = new Clinica();
        BeanUtils.copyProperties(clinicaDto, clinica);

        return ResponseEntity.status(HttpStatus.CREATED).body(clinicaService.inserirClinica(clinica));
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
    public ResponseEntity<Object> getClinicaById(@PathVariable UUID id) {
        Clinica clinica = clinicaService.getClinicaById(id);

        if (clinica == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Clínica não encontrada.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(clinica);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Object> updateClinica(@PathVariable UUID id, @RequestBody @Valid ClinicaDto clinicaDto) {
        Clinica clinica = clinicaService.getClinicaById(id);

        if (clinica == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Clínica não encontrada.");
        }

        BeanUtils.copyProperties(clinicaDto, clinica);
        return ResponseEntity.status(HttpStatus.OK).body(clinicaService.inserirClinica(clinica));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> deleteClinica(@PathVariable UUID id) {
        Clinica clinica = clinicaService.getClinicaById(id);

        if (clinica == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Clínica não encontrada.");
        }

        clinicaService.deleteClinicaById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Clínica deletada com sucesso.");
    }
}
