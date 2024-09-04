package com.mednow.mednowapi.services;

import com.mednow.mednowapi.dtos.requests.PacienteRequest;
import com.mednow.mednowapi.models.Paciente;
import com.mednow.mednowapi.repositories.PacienteRepository;
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
public class PacienteService {

    private PacienteRepository pacienteRepository;

    public Paciente inserirPaciente(PacienteRequest pacienteRequest) {
        Paciente paciente = new Paciente();
        BeanUtils.copyProperties(pacienteRequest, paciente);

        return pacienteRepository.save(paciente);
    }

    public List<Paciente> getAllPacientes() {
        List<Paciente> pacientes = pacienteRepository.findAll();

        if (pacientes.isEmpty()) {
            throw new ReponseException(HttpStatus.NOT_FOUND, "Nenhum paciente encontrado.");
        }

        return pacienteRepository.findAll();
    }

    public Paciente getPacienteById(UUID idPaciente) {

        if (pacienteRepository.findById(idPaciente).isEmpty()) {
            throw new ReponseException(HttpStatus.NOT_FOUND, "Paciente não encontrado");
        }

        return pacienteRepository.findById(idPaciente).get();
    }

    public void deletePacienteById(UUID idPaciente) {

        if (pacienteRepository.findById(idPaciente).isEmpty()) {
            throw new ReponseException(HttpStatus.NOT_FOUND, "Paciente não encontrado");
        }

        pacienteRepository.deleteById(idPaciente);
    }

    public Paciente atualizarPaciente(UUID idPaciente, PacienteRequest pacienteRequest) {
        Paciente paciente = new Paciente();
        BeanUtils.copyProperties(pacienteRequest, paciente);
        paciente.setIdPaciente(idPaciente);

        if (pacienteRepository.findById(idPaciente).isEmpty()) {
            throw new ReponseException(HttpStatus.NOT_FOUND, "Paciente não encontrado");
        }

        return pacienteRepository.save(paciente);
    }
}
