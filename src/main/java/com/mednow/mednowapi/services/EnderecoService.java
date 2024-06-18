package com.mednow.mednowapi.services;

import com.mednow.mednowapi.dtos.requests.EnderecoRequest;
import com.mednow.mednowapi.models.Endereco;
import com.mednow.mednowapi.repositories.EnderecoRepository;
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
public class EnderecoService {

    private EnderecoRepository enderecoRepository;

    public Endereco inserirEndereco(EnderecoRequest enderecoRequest) {

        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(enderecoRequest, endereco);

        return enderecoRepository.save(endereco);
    }

    public List<Endereco> getAllEnderecos() {
        return enderecoRepository.findAll();
    }

    public Endereco getEnderecoById(UUID id) {
        return enderecoRepository.findById(id).orElse(null);
    }

    public void deleteEnderecoById(UUID id) {
        enderecoRepository.deleteById(id);
    }
}