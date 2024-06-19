package com.mednow.mednowapi.services;

import com.mednow.mednowapi.dtos.requests.LaboratorioRequest;
import com.mednow.mednowapi.models.Laboratorio;
import com.mednow.mednowapi.repositories.LaboratorioRepository;
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
public class LaboratorioService {

    private LaboratorioRepository laboratorioRepository;

    public Laboratorio inserirLaboratorio(LaboratorioRequest laboratorioRequest) {
        Laboratorio laboratorio = new Laboratorio();
        BeanUtils.copyProperties(laboratorioRequest, laboratorio);

        return laboratorioRepository.save(laboratorio);
    }

    public List<Laboratorio> getAllLaboratorios() {
        List<Laboratorio> laboratorios = laboratorioRepository.findAll();

        if (laboratorios.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum laboratório encontrado.");
        }

        return laboratorioRepository.findAll();
    }

    public Laboratorio getLaboratorioById(UUID idLaboratorio) {

        if (laboratorioRepository.findById(idLaboratorio).isEmpty()) {
            throw new ReponseException(HttpStatus.NOT_FOUND, "Laboratório não encontrado");
        }

        return laboratorioRepository.findById(idLaboratorio).get();
    }

    public void deleteLaboratorioById(UUID idLaboratorio) {

        if (laboratorioRepository.findById(idLaboratorio).isEmpty()) {
            throw new ReponseException(HttpStatus.NOT_FOUND, "Laboratório não encontrado");
        }

        laboratorioRepository.deleteById(idLaboratorio);
    }

    public Laboratorio atualizarLaboratorio(UUID idLaboratorio, LaboratorioRequest laboratorioRequest) {
        Laboratorio laboratorio = new Laboratorio();
        BeanUtils.copyProperties(laboratorioRequest, laboratorio);
        laboratorio.setIdLaboratorio(idLaboratorio);

        if (laboratorioRepository.findById(idLaboratorio).isEmpty()) {
            throw new ReponseException(HttpStatus.NOT_FOUND, "Laboratório não encontrado");
        }

        return laboratorioRepository.save(laboratorio);
    }
}
