package com.mednow.mednowapi.services;

import com.mednow.mednowapi.models.Clinica;
import com.mednow.mednowapi.repositories.ClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClinicaService {

    @Autowired
    private ClinicaRepository clinicaRepository;

//    public Clinica inserir(Clinica clinica) {
//        return clinicaRepository.save(clinica);
//    }
}
