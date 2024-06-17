package com.mednow.mednowapi.controllers;

import com.mednow.mednowapi.dtos.LaboratorioDto;
import com.mednow.mednowapi.models.Laboratorio;
import com.mednow.mednowapi.services.LaboratorioService;
import jakarta.validation.Valid;
import lombok.Builder;
import org.springframework.beans.BeanUtils;
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
    public ResponseEntity<Object> saveLaboratorio(@RequestBody @Valid LaboratorioDto laboratorioDto) {
        var laboratorio = new Laboratorio();
        BeanUtils.copyProperties(laboratorioDto, laboratorio);

        return ResponseEntity.status(HttpStatus.CREATED).body(laboratorioService.inserirLaboratorio(laboratorio));
    }

    @GetMapping("/")
    public ResponseEntity<Object> getLaboratorios() {
        List<Laboratorio> laboratorios = laboratorioService.getAllLaboratorios();

        if (laboratorios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum laboratório encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(laboratorios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getLaboratorioById(@PathVariable UUID id) {
        Laboratorio laboratorio = laboratorioService.getLaboratorioById(id);

        if (laboratorio == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Laboratório não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(laboratorio);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Object> updateLaboratorioById(@PathVariable UUID id, @RequestBody @Valid LaboratorioDto laboratorioDto) {
        Laboratorio laboratorio = laboratorioService.getLaboratorioById(id);

        if (laboratorio == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Laboratório não encontrado.");
        }

        BeanUtils.copyProperties(laboratorioDto, laboratorio);
        return ResponseEntity.status(HttpStatus.OK).body(laboratorioService.inserirLaboratorio(laboratorio));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> deleteLaboratorioById(@PathVariable UUID id) {
        Laboratorio laboratorio = laboratorioService.getLaboratorioById(id);

        if (laboratorio == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Laboratório não encontrado.");
        }

        laboratorioService.deleteLaboratorioById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Laboratório deletado com sucesso.");
    }
}
