package com.mednow.mednowapi.repositories;

import com.mednow.mednowapi.models.Convenio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConvenioRepository extends JpaRepository<Convenio, UUID> {
}
