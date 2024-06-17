package com.mednow.mednowapi.services;

import com.mednow.mednowapi.models.Encaminhamento;
import com.mednow.mednowapi.repositories.EncaminhamentoRepository;
import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@Builder
public class EncaminhamentoService {

    private EncaminhamentoRepository encaminhamentoRepository;

    public Encaminhamento inserirEncaminhamento(Encaminhamento encaminhamento) {
        return encaminhamentoRepository.save(encaminhamento);
    }

    public List<Encaminhamento> getAllEncaminhamentos() {
        return encaminhamentoRepository.findAll();
    }

    public Encaminhamento getEncaminhamentoById(UUID id) {
        return encaminhamentoRepository.findById(id).orElse(null);
    }

    public void deleteEncaminhamentoById(UUID id) {
        encaminhamentoRepository.deleteById(id);
    }
}