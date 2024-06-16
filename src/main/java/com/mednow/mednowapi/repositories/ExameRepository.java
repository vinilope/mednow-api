package com.mednow.mednowapi.repositories;

import com.mednow.mednowapi.models.Exame;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExameRepository extends JpaRepository<Exame, UUID> {
}
