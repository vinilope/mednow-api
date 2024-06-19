package com.mednow.mednowapi.controllers;

import com.mednow.mednowapi.dtos.requests.EncaminhamentoRequest;
import com.mednow.mednowapi.dtos.responses.EncaminhamentoResponse;
import com.mednow.mednowapi.models.Encaminhamento;
import com.mednow.mednowapi.services.EncaminhamentoService;
import jakarta.validation.Valid;
import lombok.Builder;
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
    public ResponseEntity<Object> saveEncaminhamento(@RequestBody @Valid EncaminhamentoRequest encaminhamentoRequest) {

        return ResponseEntity.status(HttpStatus.CREATED).body(encaminhamentoService.inserirEncaminhamento(encaminhamentoRequest));
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
    public ResponseEntity<EncaminhamentoResponse> getEncaminhamentoById(@PathVariable UUID id) {

        return ResponseEntity.status(HttpStatus.OK).body(new EncaminhamentoResponse(encaminhamentoService.getEncaminhamentoById(id)));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Object> updateEncaminhamento(@PathVariable UUID id, @RequestBody @Valid EncaminhamentoRequest encaminhamentoRequest) {

        return ResponseEntity.status(HttpStatus.OK).body(encaminhamentoService.atualizarEncaminhamento(id, encaminhamentoRequest));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> deleteEncaminhamento(@PathVariable UUID id) {

        encaminhamentoService.deleteEncaminhamentoById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Encaminhamento deletado com sucesso.");
    }
}
