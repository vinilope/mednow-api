package com.mednow.mednowapi.controllers;

import com.mednow.mednowapi.dtos.EncaminhamentoDto;
import com.mednow.mednowapi.models.Encaminhamento;
import com.mednow.mednowapi.services.EncaminhamentoService;
import jakarta.validation.Valid;
import lombok.Builder;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/encaminhamento")
@Builder
public class EncaminhamentoController {

    private EncaminhamentoService encaminhamentoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> saveEncaminhamento(@RequestBody @Valid EncaminhamentoDto encaminhamentoDto) {
        var encaminhamento = new Encaminhamento();
        BeanUtils.copyProperties(encaminhamentoDto, encaminhamento);

        return ResponseEntity.status(HttpStatus.CREATED).body(encaminhamentoService.inserirEncaminhamento(encaminhamento));
    }

    @GetMapping("/")
    public ResponseEntity<Object> getEncaminhamentos() {
        List<Encaminhamento> encaminhamentos = encaminhamentoService.getAllEncaminhamentos();

        if (encaminhamentos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum encaminhamento encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(encaminhamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEncaminhamentoById(@PathVariable UUID id) {
        Encaminhamento encaminhamento = encaminhamentoService.getEncaminhamentoById(id);

        if (encaminhamento == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Encaminhamento não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(encaminhamento);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Object> updateEncaminhamentoById(@PathVariable UUID id, @RequestBody @Valid EncaminhamentoDto encaminhamentoDto) {
        Encaminhamento encaminhamento = encaminhamentoService.getEncaminhamentoById(id);

        if (encaminhamento == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Encaminhamento não encontrado.");
        }

        BeanUtils.copyProperties(encaminhamentoDto, encaminhamento);
        return ResponseEntity.status(HttpStatus.OK).body(encaminhamentoService.inserirEncaminhamento(encaminhamento));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> deleteEncaminhamentoById(@PathVariable UUID id) {
        Encaminhamento encaminhamento = encaminhamentoService.getEncaminhamentoById(id);

        if (encaminhamento == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Encaminhamento não encontrado.");
        }

        encaminhamentoService.deleteEncaminhamentoById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Encaminhamento deletado com sucesso.");
    }
}
