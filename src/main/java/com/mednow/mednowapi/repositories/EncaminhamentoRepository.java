package com.mednow.mednowapi.repositories;

import com.mednow.mednowapi.models.Encaminhamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EncaminhamentoRepository extends JpaRepository<Encaminhamento, UUID> {
}
