package com.mednow.mednowapi.services;

import com.mednow.mednowapi.dtos.requests.ConvenioRequest;
import com.mednow.mednowapi.models.Convenio;
import com.mednow.mednowapi.repositories.ConvenioRepository;
import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@Builder
public class ConvenioService {

    private ConvenioRepository convenioRepository;

    public Convenio inserirConvenio(ConvenioRequest convenioRequest) {

        Convenio convenio = new Convenio();
        BeanUtils.copyProperties(convenioRequest, convenio);

        return convenioRepository.save(convenio);
    }

    public List<Convenio> getAllConvenios() {
        return convenioRepository.findAll();
    }

    public Convenio getConvenioById(UUID id) {
        return convenioRepository.findById(id).orElse(null);
    }

    public void deleteConvenioById(UUID id) {
        convenioRepository.deleteById(id);
    }
}