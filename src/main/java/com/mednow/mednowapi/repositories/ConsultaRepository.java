package com.mednow.mednowapi.repositories;

import com.mednow.mednowapi.models.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConsultaRepository extends JpaRepository<Consulta, UUID> {
}
