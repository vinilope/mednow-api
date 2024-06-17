package com.mednow.mednowapi.services;

import com.mednow.mednowapi.models.Medico;
import com.mednow.mednowapi.repositories.MedicoRepository;
import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@Builder
public class MedicoService {

    private MedicoRepository medicoRepository;

    public Medico inserirMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    public List<Medico> getAllMedicos() {
        return medicoRepository.findAll();
    }

    public Medico getMedicoById(UUID id) {
        return medicoRepository.findById(id).orElse(null);
    }

    public void deleteMedicoById(UUID id) {
        medicoRepository.deleteById(id);
    }
}