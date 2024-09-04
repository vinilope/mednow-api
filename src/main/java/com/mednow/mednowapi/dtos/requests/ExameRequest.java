package com.mednow.mednowapi.dtos.requests;

import java.time.LocalDate;
import java.util.UUID;

public record ExameRequest(
        LocalDate data,
        String observacao,
        Integer tipoExame,
        UUID consulta,
        UUID fkLaboratorio
) {}
