package com.mednow.mednowapi.services;

import com.mednow.mednowapi.models.Laboratorio;
import com.mednow.mednowapi.repositories.LaboratorioRepository;
import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@Builder
public class LaboratorioService {

    private LaboratorioRepository laboratorioRepository;

    public Laboratorio inserirLaboratorio(Laboratorio laboratorio) {
        return laboratorioRepository.save(laboratorio);
    }

    public List<Laboratorio> getAllLaboratorios() {
        return laboratorioRepository.findAll();
    }

    public Laboratorio getLaboratorioById(UUID id) {
        return laboratorioRepository.findById(id).orElse(null);
    }

    public void deleteLaboratorioById(UUID id) {
        laboratorioRepository.deleteById(id);
    }
}