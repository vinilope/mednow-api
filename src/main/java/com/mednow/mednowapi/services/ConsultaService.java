package com.mednow.mednowapi.services;

import com.mednow.mednowapi.dtos.requests.ConsultaRequest;
import com.mednow.mednowapi.dtos.responses.ConsultaResponse;
import com.mednow.mednowapi.models.Consulta;
import com.mednow.mednowapi.repositories.ConsultaRepository;
import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return consultaRepository.findAll();
    }

    public Consulta getConsultaById(UUID id) {
        return consultaRepository.findById(id).orElse(null);
    }

    public void deleteConsultaById(UUID id) {
        consultaRepository.deleteById(id);
    }
}
