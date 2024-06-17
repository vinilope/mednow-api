package com.mednow.mednowapi.controllers;

import com.mednow.mednowapi.dtos.ConsultaDto;
import com.mednow.mednowapi.models.Consulta;
import com.mednow.mednowapi.services.ConsultaService;
import jakarta.validation.Valid;
import lombok.Builder;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/consulta")
@Builder
public class ConsultaController {

    private ConsultaService consultaService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> saveConsulta(@RequestBody @Valid ConsultaDto consultaDto) {
        var consulta = new Consulta();
        BeanUtils.copyProperties(consultaDto, consulta);

        return ResponseEntity.status(HttpStatus.CREATED).body(consultaService.inserirConsulta(consulta));
    }

    @GetMapping("/")
    public ResponseEntity<Object> getConsultas() {
        List<Consulta> consultas = consultaService.getAllConsultas();

        if (consultas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhuma consulta encontrada.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(consultas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getConsultaById(@PathVariable UUID id) {
        Consulta consulta = consultaService.getConsultaById(id);

        if (consulta == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consulta não encontrada.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(consulta);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Object> updateConsultaById(@PathVariable UUID id, @RequestBody @Valid ConsultaDto consultaDto) {
        Consulta consulta = consultaService.getConsultaById(id);

        if (consulta == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consulta não encontrada.");
        }

        BeanUtils.copyProperties(consultaDto, consulta);
        return ResponseEntity.status(HttpStatus.OK).body(consultaService.inserirConsulta(consulta));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> deleteConsultaById(@PathVariable UUID id) {
        Consulta consulta = consultaService.getConsultaById(id);

        if (consulta == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consulta não encontrada.");
        }

        consultaService.deleteConsultaById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Consulta deletada com sucesso.");
    }
}
