package com.mednow.mednowapi.repositories;

import com.mednow.mednowapi.models.Clinica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClinicaRepository extends JpaRepository<Clinica, UUID> {
}
