package com.mednow.mednowapi.services;

import com.mednow.mednowapi.dtos.requests.MedicoRequest;
import com.mednow.mednowapi.models.Medico;
import com.mednow.mednowapi.repositories.MedicoRepository;
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
public class MedicoService {

    private MedicoRepository medicoRepository;

    public Medico inserirMedico(MedicoRequest medicoRequest) {
        Medico medico = new Medico();
        BeanUtils.copyProperties(medicoRequest, medico);

        return medicoRepository.save(medico);
    }

    public List<Medico> getAllMedicos() {
        List<Medico> medicos = medicoRepository.findAll();

        if (medicos.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum médico encontrado.");
        }

        return medicoRepository.findAll();
    }

    public Medico getMedicoById(UUID idMedico) {

        if (medicoRepository.findById(idMedico).isEmpty()) {
            throw new ReponseException(HttpStatus.NOT_FOUND, "Médico não encontrado");
        }

        return medicoRepository.findById(idMedico).get();
    }

    public void deleteMedicoById(UUID idMedico) {

        if (medicoRepository.findById(idMedico).isEmpty()) {
            throw new ReponseException(HttpStatus.NOT_FOUND, "Médico não encontrado");
        }

        medicoRepository.deleteById(idMedico);
    }

    public Medico atualizarMedico(UUID idMedico, MedicoRequest medicoRequest) {
        Medico medico = new Medico();
        BeanUtils.copyProperties(medicoRequest, medico);
        medico.setIdMedico(idMedico);

        if (medicoRepository.findById(idMedico).isEmpty()) {
            throw new ReponseException(HttpStatus.NOT_FOUND, "Médico não encontrado");
        }

        return medicoRepository.save(medico);
    }
}
