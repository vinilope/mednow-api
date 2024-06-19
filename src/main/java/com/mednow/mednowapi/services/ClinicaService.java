package com.mednow.mednowapi.services;

import com.mednow.mednowapi.dtos.requests.ClinicaRequest;
import com.mednow.mednowapi.models.Clinica;
import com.mednow.mednowapi.repositories.ClinicaRepository;
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
public class ClinicaService {

    private ClinicaRepository clinicaRepository;

    public Clinica inserirClinica(ClinicaRequest clinicaRequest) {
        Clinica clinica = new Clinica();
        BeanUtils.copyProperties(clinicaRequest, clinica);

        return clinicaRepository.save(clinica);
    }

    public List<Clinica> getAllClinicas() {
        List<Clinica> clinicas = clinicaRepository.findAll();

        if (clinicas.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma clínica encontrada.");
        }

        return clinicaRepository.findAll();
    }

    public Clinica getClinicaById(UUID idClinica) {

        if (clinicaRepository.findById(idClinica).isEmpty()) {
            throw new ReponseException(HttpStatus.NOT_FOUND, "Clínica não encontrada");
        }

        return clinicaRepository.findById(idClinica).get();
    }

    public void deleteClinicaById(UUID idClinica) {

        if (clinicaRepository.findById(idClinica).isEmpty()) {
            throw new ReponseException(HttpStatus.NOT_FOUND, "Clínica não encontrada");
        }

        clinicaRepository.deleteById(idClinica);
    }

    public Clinica atualizarClinica(UUID idClinica, ClinicaRequest clinicaRequest) {
        Clinica clinica = new Clinica();
        BeanUtils.copyProperties(clinicaRequest, clinica);
        clinica.setIdClinica(idClinica);

        if (clinicaRepository.findById(idClinica).isEmpty()) {
            throw new ReponseException(HttpStatus.NOT_FOUND, "Clínica não encontrada");
        }

        return clinicaRepository.save(clinica);
    }
}
