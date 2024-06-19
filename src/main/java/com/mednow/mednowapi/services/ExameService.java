package com.mednow.mednowapi.services;

import com.mednow.mednowapi.dtos.requests.ExameRequest;
import com.mednow.mednowapi.models.Exame;
import com.mednow.mednowapi.repositories.ExameRepository;
import exceptions.ReponseException;
import jakarta.transaction.Transactional;
import lombok.Builder;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@Builder
public class ExameService {

    private ExameRepository exameRepository;

    public Exame inserirExame(ExameRequest exameRequest) {
        Exame exame = new Exame();
        BeanUtils.copyProperties(exameRequest, exame);

        return exameRepository.save(exame);
    }

    public List<Exame> getAllExames() {
        List<Exame> exames = exameRepository.findAll();

        if (exames.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum exame encontrado.");
        }

        return exameRepository.findAll();
    }

    public Exame getExameById(UUID idExame) {

        if (exameRepository.findById(idExame).isEmpty()) {
            throw new ReponseException(HttpStatus.NOT_FOUND, "Exame não encontrado");
        }

        return exameRepository.findById(idExame).get();
    }

    public void deleteExameById(UUID idExame) {

        if (exameRepository.findById(idExame).isEmpty()) {
            throw new ReponseException(HttpStatus.NOT_FOUND, "Exame não encontrado");
        }

        exameRepository.deleteById(idExame);
    }

    public Exame atualizarExame(UUID idExame, ExameRequest exameRequest) {
        Exame exame = new Exame();
        BeanUtils.copyProperties(exameRequest, exame);
        exame.setIdExame(idExame);

        if (exameRepository.findById(idExame).isEmpty()) {
            throw new ReponseException(HttpStatus.NOT_FOUND, "Exame não encontrado");
        }

        return exameRepository.save(exame);
    }
}
