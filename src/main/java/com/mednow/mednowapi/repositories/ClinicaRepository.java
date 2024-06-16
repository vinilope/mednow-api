package com.mednow.mednowapi.repositories;

import com.mednow.mednowapi.models.ClinicaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClinicaRepository extends JpaRepository<ClinicaModel, UUID> {
}
