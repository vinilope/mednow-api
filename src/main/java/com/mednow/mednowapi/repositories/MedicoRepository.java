package com.mednow.mednowapi.repositories;

import com.mednow.mednowapi.models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MedicoRepository extends JpaRepository<Medico, UUID> {
}
