package com.mednow.mednowapi.services;

import com.mednow.mednowapi.dtos.requests.EncaminhamentoRequest;
import com.mednow.mednowapi.models.Encaminhamento;
import com.mednow.mednowapi.repositories.EncaminhamentoRepository;
import exceptions.ReponseException;
import jakarta.transaction.Transactional;
import lombok.Builder;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@Builder
public class EncaminhamentoService {

    private EncaminhamentoRepository encaminhamentoRepository;

    public Encaminhamento inserirEncaminhamento(EncaminhamentoRequest encaminhamentoRequest) {
        Encaminhamento encaminhamento = new Encaminhamento();
        BeanUtils.copyProperties(encaminhamentoRequest, encaminhamento);

        return encaminhamentoRepository.save(encaminhamento);
    }

    public List<Encaminhamento> getAllEncaminhamentos() {
        List<Encaminhamento> encaminhamentos = encaminhamentoRepository.findAll();

        if (encaminhamentos.isEmpty()) {
            throw new ReponseException(HttpStatus.NOT_FOUND, "Nenhum encaminhamento encontrado.");
        }

        return encaminhamentoRepository.findAll();
    }

    public Encaminhamento getEncaminhamentoById(UUID idEncaminhamento) {

        if (encaminhamentoRepository.findById(idEncaminhamento).isEmpty()) {
            throw new ReponseException(HttpStatus.NOT_FOUND, "Encaminhamento não encontrado");
        }

        return encaminhamentoRepository.findById(idEncaminhamento).get();
    }

    public void deleteEncaminhamentoById(UUID idEncaminhamento) {

        if (encaminhamentoRepository.findById(idEncaminhamento).isEmpty()) {
            throw new ReponseException(HttpStatus.NOT_FOUND, "Encaminhamento não encontrado");
        }

        encaminhamentoRepository.deleteById(idEncaminhamento);
    }

    public Encaminhamento atualizarEncaminhamento(UUID idEncaminhamento, EncaminhamentoRequest encaminhamentoRequest) {
        Encaminhamento encaminhamento = new Encaminhamento();
        BeanUtils.copyProperties(encaminhamentoRequest, encaminhamento);
        encaminhamento.setIdEncaminhamento(idEncaminhamento);

        if (encaminhamentoRepository.findById(idEncaminhamento).isEmpty()) {
            throw new ReponseException(HttpStatus.NOT_FOUND, "Encaminhamento não encontrado");
        }

        return encaminhamentoRepository.save(encaminhamento);
    }
}
