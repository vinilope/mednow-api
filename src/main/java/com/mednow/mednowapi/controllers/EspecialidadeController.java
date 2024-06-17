package com.mednow.mednowapi.controllers;

import com.mednow.mednowapi.dtos.EspecialidadeDto;
import com.mednow.mednowapi.models.Especialidade;
import com.mednow.mednowapi.services.EspecialidadeService;
import jakarta.validation.Valid;
import lombok.Builder;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/especialidade")
@Builder
public class EspecialidadeController {

    private EspecialidadeService especialidadeService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> saveEspecialidade(@RequestBody @Valid EspecialidadeDto especialidadeDto) {
        var especialidade = new Especialidade();
        BeanUtils.copyProperties(especialidadeDto, especialidade);

        return ResponseEntity.status(HttpStatus.CREATED).body(especialidadeService.inserirEspecialidade(especialidade));
    }

    @GetMapping("/")
    public ResponseEntity<Object> getEspecialidades() {
        List<Especialidade> especialidades = especialidadeService.getAllEspecialidades();

        if (especialidades.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhuma especialidade encontrada.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(especialidades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEspecialidadeById(@PathVariable Integer id) {
        Especialidade especialidade = especialidadeService.getEspecialidadeById(id);

        if (especialidade == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Especialidade não encontrada.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(especialidade);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Object> updateEspecialidadeById(@PathVariable Integer id, @RequestBody @Valid EspecialidadeDto especialidadeDto) {
        Especialidade especialidade = especialidadeService.getEspecialidadeById(id);

        if (especialidade == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Especialidade não encontrada.");
        }

        BeanUtils.copyProperties(especialidadeDto, especialidade);
        return ResponseEntity.status(HttpStatus.OK).body(especialidadeService.inserirEspecialidade(especialidade));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> deleteEspecialidadeById(@PathVariable Integer id) {
        Especialidade especialidade = especialidadeService.getEspecialidadeById(id);

        if (especialidade == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Especialidade não encontrada.");
        }

        especialidadeService.deleteEspecialidadeById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Especialidade deletada com sucesso.");
    }
}
