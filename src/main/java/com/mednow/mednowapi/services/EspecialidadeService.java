package com.mednow.mednowapi.services;

import com.mednow.mednowapi.models.Especialidade;
import com.mednow.mednowapi.repositories.EspecialidadeRepository;
import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@Builder
public class EspecialidadeService {

    private EspecialidadeRepository especialidadeRepository;

    public Especialidade inserirEspecialidade(Especialidade especialidade) {
        return especialidadeRepository.save(especialidade);
    }

    public List<Especialidade> getAllEspecialidades() {
        return especialidadeRepository.findAll();
    }

    public Especialidade getEspecialidadeById(Integer id) {
        return especialidadeRepository.findById(id).orElse(null);
    }

    public void deleteEspecialidadeById(Integer id) {
        especialidadeRepository.deleteById(id);
    }
}