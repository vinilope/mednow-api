package com.mednow.mednowapi.controllers;

import com.mednow.mednowapi.dtos.requests.ConvenioRequest;
import com.mednow.mednowapi.dtos.responses.ConvenioResponse;
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
    public ResponseEntity<ConvenioResponse> getConvenioById(@PathVariable UUID id) {

        return ResponseEntity.status(HttpStatus.OK).body(new ConvenioResponse(convenioService.getConvenioById(id)));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Object> updateConvenio(@PathVariable UUID id, @RequestBody @Valid ConvenioRequest convenioRequest) {

        return ResponseEntity.status(HttpStatus.OK).body(convenioService.atualizarConvenio(id, convenioRequest));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> deleteConvenio(@PathVariable UUID id) {

        convenioService.deleteConvenioById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Convenio deletado com sucesso.");
    }
}
