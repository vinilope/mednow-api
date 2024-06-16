package com.mednow.mednowapi.repositories;

import com.mednow.mednowapi.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PacienteRepository extends JpaRepository<Paciente, UUID> {
}
