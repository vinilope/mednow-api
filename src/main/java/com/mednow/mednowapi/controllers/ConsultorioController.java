package com.mednow.mednowapi.controllers;

import com.mednow.mednowapi.dtos.ConsultorioDto;
import com.mednow.mednowapi.models.ConsultorioModel;
import com.mednow.mednowapi.repositories.ConsultorioRepository;
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
@RequestMapping("/consultorio")
public class ConsultorioController {

    @Autowired
    private ConsultorioRepository consultorioRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<ConsultorioModel> saveConsultorio(@RequestBody @Valid ConsultorioDto consultorioDto) {
        var consultorioModel = new ConsultorioModel();
        BeanUtils.copyProperties(consultorioDto, consultorioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(consultorioRepository.save(consultorioModel));
    }

    @GetMapping("/")
    public ResponseEntity<List<ConsultorioModel>> getConsultorios() {
        return ResponseEntity.status(HttpStatus.OK).body(consultorioRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getConsultorioById(@PathVariable UUID id) {
        Optional<ConsultorioModel> consultorioO = consultorioRepository.findById(id);

        if (consultorioO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consultório não encontrado.");
        };

        return ResponseEntity.status(HttpStatus.OK).body(consultorioO.get());
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Object> updateConsultorio(@PathVariable UUID id, @RequestBody @Valid ConsultorioDto consultorioDto) {
        Optional<ConsultorioModel> consultorioO = consultorioRepository.findById(id);

        if (consultorioO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consultório não encontrado.");
        };

        var consultorioModel = consultorioO.get();
        BeanUtils.copyProperties(consultorioDto, consultorioModel);
        return ResponseEntity.status(HttpStatus.OK).body(consultorioRepository.save(consultorioModel));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> deleteConsultorio(@PathVariable UUID id) {
        Optional<ConsultorioModel> consultorioO = consultorioRepository.findById(id);

        if (consultorioO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consultório não encontrado.");
        };

        consultorioRepository.delete(consultorioO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Consultório deletado com sucesso.");
    }
}
