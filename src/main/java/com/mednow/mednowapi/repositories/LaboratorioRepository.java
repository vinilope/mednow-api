package com.mednow.mednowapi.repositories;

import com.mednow.mednowapi.models.Laboratorio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LaboratorioRepository extends JpaRepository<Laboratorio, UUID> {
}
