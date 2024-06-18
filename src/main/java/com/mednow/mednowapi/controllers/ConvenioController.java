package com.mednow.mednowapi.controllers;

import com.mednow.mednowapi.dtos.requests.ConvenioRequest;
import com.mednow.mednowapi.models.Convenio;
import com.mednow.mednowapi.services.ConvenioService;
import jakarta.validation.Valid;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/convenio")
@Builder
public class ConvenioController {

    private ConvenioService convenioService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> saveConvenio(@RequestBody @Valid ConvenioRequest convenioRequest) {

        return ResponseEntity.status(HttpStatus.CREATED).body(convenioService.inserirConvenio(convenioRequest));
    }

    @GetMapping("/")
    public ResponseEntity<Object> getConvenios() {
        List<Convenio> convenios = convenioService.getAllConvenios();

        if (convenios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum convenio encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(convenios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getConvenioById(@PathVariable UUID id) {
        Convenio convenio = convenioService.getConvenioById(id);

        if (convenio == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Convenio não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(convenio);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Object> updateConvenioById(@PathVariable UUID id, @RequestBody @Valid ConvenioRequest convenioRequest) {
        Convenio convenio = convenioService.getConvenioById(id);

        if (convenio == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Convenio não encontrada.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(convenioService.inserirConvenio(convenioRequest));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> deleteConvenioById(@PathVariable UUID id) {
        Convenio convenio = convenioService.getConvenioById(id);

        if (convenio == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Convenio não encontrado.");
        }

        convenioService.deleteConvenioById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Convenio deletado com sucesso.");
    }
}
