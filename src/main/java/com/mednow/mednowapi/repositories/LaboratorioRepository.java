package com.mednow.mednowapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LaboratorioRepository extends JpaRepository<LaboratorioRepository, UUID> {
}
