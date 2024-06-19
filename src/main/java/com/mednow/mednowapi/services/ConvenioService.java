package com.mednow.mednowapi.services;

import com.mednow.mednowapi.dtos.requests.ConvenioRequest;
import com.mednow.mednowapi.models.Convenio;
import com.mednow.mednowapi.repositories.ConvenioRepository;
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
public class ConvenioService {

    private ConvenioRepository convenioRepository;

    public Convenio inserirConvenio(ConvenioRequest convenioRequest) {
        Convenio convenio = new Convenio();
        BeanUtils.copyProperties(convenioRequest, convenio);

        return convenioRepository.save(convenio);
    }

    public List<Convenio> getAllConvenios() {
        List<Convenio> convenios = convenioRepository.findAll();

        if (convenios.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum convenio encontrado.");
        }

        return convenioRepository.findAll();
    }

    public Convenio getConvenioById(UUID idConvenio) {

        if (convenioRepository.findById(idConvenio).isEmpty()) {
            throw new ReponseException(HttpStatus.NOT_FOUND, "Convenio não encontrado");
        }

        return convenioRepository.findById(idConvenio).get();
    }

    public void deleteConvenioById(UUID idConvenio) {

        if (convenioRepository.findById(idConvenio).isEmpty()) {
            throw new ReponseException(HttpStatus.NOT_FOUND, "Convenio não encontrado");
        }

        convenioRepository.deleteById(idConvenio);
    }

    public Convenio atualizarConvenio(UUID idConvenio, ConvenioRequest convenioRequest) {
        Convenio convenio = new Convenio();
        BeanUtils.copyProperties(convenioRequest, convenio);
        convenio.setIdConvenio(idConvenio);

        if (convenioRepository.findById(idConvenio).isEmpty()) {
            throw new ReponseException(HttpStatus.NOT_FOUND, "Convenio não encontrado");
        }

        return convenioRepository.save(convenio);
    }
}
