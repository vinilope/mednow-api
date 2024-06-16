package com.mednow.mednowapi.repositories;

import com.mednow.mednowapi.models.TipoExame;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TipoExameRepository extends JpaRepository<TipoExame, UUID> {
}
