package com.mednow.mednowapi.controllers;

import com.mednow.mednowapi.dtos.TipoExameDto;
import com.mednow.mednowapi.models.TipoExame;
import com.mednow.mednowapi.services.TipoExameService;
import jakarta.validation.Valid;
import lombok.Builder;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo-exame")
@Builder
public class TipoExameController {

    private TipoExameService tipoExameService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> saveTipoExame(@RequestBody @Valid TipoExameDto tipoExameDto) {
        var tipoExame = new TipoExame();
        BeanUtils.copyProperties(tipoExameDto, tipoExame);

        return ResponseEntity.status(HttpStatus.CREATED).body(tipoExameService.inserirTipoExame(tipoExame));
    }

    @GetMapping("/")
    public ResponseEntity<Object> getTipoExames() {
        List<TipoExame> tipoExames = tipoExameService.getAllTipoExames();

        if (tipoExames.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum tipo de exame encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(tipoExames);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTipoExameById(@PathVariable Integer id) {
        TipoExame tipoExame = tipoExameService.getTipoExameById(id);

        if (tipoExame == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo de exame não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(tipoExame);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Object> updateTipoExameById(@PathVariable Integer id, @RequestBody @Valid TipoExameDto tipoExameDto) {
        TipoExame tipoExame = tipoExameService.getTipoExameById(id);

        if (tipoExame == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo de exame não encontrado.");
        }

        BeanUtils.copyProperties(tipoExameDto, tipoExame);
        return ResponseEntity.status(HttpStatus.OK).body(tipoExameService.inserirTipoExame(tipoExame));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> deleteTipoExameById(@PathVariable Integer id) {
        TipoExame tipoExame = tipoExameService.getTipoExameById(id);

        if (tipoExame == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo de exame não encontrado.");
        }

        tipoExameService.deleteTipoExameById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Tipo de exame deletado com sucesso.");
    }
}
