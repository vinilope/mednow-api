package com.mednow.mednowapi.services;

import com.mednow.mednowapi.dtos.requests.EnderecoRequest;
import com.mednow.mednowapi.models.Endereco;
import com.mednow.mednowapi.repositories.EnderecoRepository;
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
public class EnderecoService {

    private EnderecoRepository enderecoRepository;

    public Endereco inserirEndereco(EnderecoRequest enderecoRequest) {
        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(enderecoRequest, endereco);

        return enderecoRepository.save(endereco);
    }

    public List<Endereco> getAllEnderecos() {
        List<Endereco> enderecos = enderecoRepository.findAll();

        if (enderecos.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum endereco encontrado.");
        }

        return enderecoRepository.findAll();
    }

    public Endereco getEnderecoById(UUID idEndereco) {

        if (enderecoRepository.findById(idEndereco).isEmpty()) {
            throw new ReponseException(HttpStatus.NOT_FOUND, "Endereco não encontrado");
        }

        return enderecoRepository.findById(idEndereco).get();
    }

    public void deleteEnderecoById(UUID idEndereco) {

        if (enderecoRepository.findById(idEndereco).isEmpty()) {
            throw new ReponseException(HttpStatus.NOT_FOUND, "Endereco não encontrado");
        }

        enderecoRepository.deleteById(idEndereco);
    }

    public Endereco atualizarEndereco(UUID idEndereco, EnderecoRequest enderecoRequest) {
        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(enderecoRequest, endereco);
        endereco.setIdEndereco(idEndereco);

        if (enderecoRepository.findById(idEndereco).isEmpty()) {
            throw new ReponseException(HttpStatus.NOT_FOUND, "Endereco não encontrado");
        }

        return enderecoRepository.save(endereco);
    }
}
