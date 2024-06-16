package com.mednow.mednowapi.controllers;

import com.mednow.mednowapi.dtos.ClinicaDto;
import com.mednow.mednowapi.models.Clinica;
import com.mednow.mednowapi.repositories.ClinicaRepository;
import com.mednow.mednowapi.services.ClinicaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/clinica")
public class ClinicaController {

    @Autowired
    private ClinicaRepository clinicaRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<Clinica> saveClinica(@RequestBody @Valid ClinicaDto clinicaDto) {
        var clinica = new Clinica();
        BeanUtils.copyProperties(clinicaDto, clinica);

        return ResponseEntity.status(HttpStatus.CREATED).body(clinicaRepository.save(clinica));
    }

    @GetMapping("/")
    public ResponseEntity<List<Clinica>> getClinicas() {
        return ResponseEntity.status(HttpStatus.OK).body(clinicaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getClinicaById(@PathVariable UUID id) {
        Optional<Clinica> clinicaO = clinicaRepository.findById(id);

        if (clinicaO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Clínica não encontrada.");
        };

        return ResponseEntity.status(HttpStatus.OK).body(clinicaO.get());
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Object> updateClinica(@PathVariable UUID id, @RequestBody @Valid ClinicaDto clinicaDto) {
        Optional<Clinica> clinicaO = clinicaRepository.findById(id);

        if (clinicaO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Clínica não encontrada.");
        };

        var clinicaModel = clinicaO.get();
        BeanUtils.copyProperties(clinicaDto, clinicaModel);
        return ResponseEntity.status(HttpStatus.OK).body(clinicaRepository.save(clinicaModel));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> deleteClinica(@PathVariable UUID id) {
        Optional<Clinica> clinicaO = clinicaRepository.findById(id);

        if (clinicaO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Clínica não encontrada.");
        };

        clinicaRepository.delete(clinicaO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Clínica deletada com sucesso.");
    }
}
