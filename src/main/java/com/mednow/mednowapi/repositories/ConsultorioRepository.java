package com.mednow.mednowapi.repositories;

import com.mednow.mednowapi.models.ConsultorioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConsultorioRepository extends JpaRepository<ConsultorioModel, UUID> {
}
