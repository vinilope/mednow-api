package com.mednow.mednowapi.services;

import com.mednow.mednowapi.dtos.requests.MedicoRequest;
import com.mednow.mednowapi.models.Medico;
import com.mednow.mednowapi.repositories.MedicoRepository;
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
public class MedicoService {

    private MedicoRepository medicoRepository;
    private ClinicaService clinicaService;

    public Medico inserirMedico(MedicoRequest medicoRequest) {

        Medico medico = new Medico();
        BeanUtils.copyProperties(medicoRequest, medico);

        medico.setClinica(clinicaService.getClinicaById(medicoRequest.fkClinica()));

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