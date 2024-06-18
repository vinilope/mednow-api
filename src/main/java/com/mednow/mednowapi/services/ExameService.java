package com.mednow.mednowapi.services;

import com.mednow.mednowapi.dtos.requests.ExameRequest;
import com.mednow.mednowapi.models.Exame;
import com.mednow.mednowapi.repositories.ExameRepository;
import jakarta.transaction.Transactional;
import lombok.Builder;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

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
        return exameRepository.findAll();
    }

    public Exame getExameById(UUID id) {
        return exameRepository.findById(id).orElse(null);
    }

    public void deleteExameById(UUID id) {
        exameRepository.deleteById(id);
    }
}