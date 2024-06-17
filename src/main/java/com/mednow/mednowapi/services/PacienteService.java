package com.mednow.mednowapi.services;

import com.mednow.mednowapi.models.Paciente;
import com.mednow.mednowapi.repositories.PacienteRepository;
import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@Builder
public class PacienteService {

    private PacienteRepository pacienteRepository;

    public Paciente inserirPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente getPacienteById(UUID id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    public void deletePacienteById(UUID id) {
        pacienteRepository.deleteById(id);
    }
}