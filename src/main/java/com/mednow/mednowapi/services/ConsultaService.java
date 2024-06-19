package com.mednow.mednowapi.services;

import com.mednow.mednowapi.dtos.requests.ConsultaRequest;
import com.mednow.mednowapi.models.Consulta;
import com.mednow.mednowapi.repositories.ConsultaRepository;
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
public class ConsultaService {

    private ConsultaRepository consultaRepository;

    public Consulta inserirConsulta(ConsultaRequest consultaRequest) {
        Consulta consulta = new Consulta();
        BeanUtils.copyProperties(consultaRequest, consulta);

        return consultaRepository.save(consulta);
    }

    public List<Consulta> getAllConsultas() {
        List<Consulta> consultas = consultaRepository.findAll();

        if (consultas.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma consulta encontrada.");
        }

        return consultaRepository.findAll();
    }

    public Consulta getConsultaById(UUID idConsulta) {

        if (consultaRepository.findById(idConsulta).isEmpty()) {
            throw new ReponseException(HttpStatus.NOT_FOUND, "Consulta não encontrada");
        }

        return consultaRepository.findById(idConsulta).get();
    }

    public void deleteConsultaById(UUID idConsulta) {

        if (consultaRepository.findById(idConsulta).isEmpty()) {
            throw new ReponseException(HttpStatus.NOT_FOUND, "Consulta não encontrada");
        }

        consultaRepository.deleteById(idConsulta);
    }

    public Consulta atualizarConsulta(UUID idConsulta, ConsultaRequest consultaRequest) {
        Consulta consulta = new Consulta();
        BeanUtils.copyProperties(consultaRequest, consulta);
        consulta.setIdConsulta(idConsulta);

        if (consultaRepository.findById(idConsulta).isEmpty()) {
            throw new ReponseException(HttpStatus.NOT_FOUND, "Consulta não encontrada");
        }

        return consultaRepository.save(consulta);
    }
}
