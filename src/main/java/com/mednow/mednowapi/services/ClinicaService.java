package com.mednow.mednowapi.services;

import com.mednow.mednowapi.models.Clinica;
import com.mednow.mednowapi.repositories.ClinicaRepository;
import jakarta.transaction.Transactional;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@Builder
public class ClinicaService {

    private ClinicaRepository clinicaRepository;

    public Clinica inserirClinica(Clinica clinica) {
        return clinicaRepository.save(clinica);
    }

    public List<Clinica> getAllClinicas() {
        return clinicaRepository.findAll();
    }

    public Clinica getClinicaById(UUID idClinica) {
        return clinicaRepository.findById(idClinica).orElse(null);
    }

    public void deleteClinicaById(UUID id) {
        clinicaRepository.deleteById(id);
    }
}
