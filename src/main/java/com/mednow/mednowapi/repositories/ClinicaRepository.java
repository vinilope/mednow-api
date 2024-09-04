package com.mednow.mednowapi.repositories;

import com.mednow.mednowapi.dtos.responses.QuantidadeClinicaResponse;
import com.mednow.mednowapi.models.Clinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface ClinicaRepository extends JpaRepository<Clinica, UUID> {

    @Query("SELECT new com.mednow.mednowapi.dtos.responses.QuantidadeClinicaResponse(" +
            "(SELECT COUNT (*) AS quantidadeClinica FROM Clinica c))")
    QuantidadeClinicaResponse listarQuantidade();
}
