package com.mednow.mednowapi.dtos;

import com.mednow.mednowapi.enums.StatusEncaminhamento;
import com.mednow.mednowapi.models.Consulta;
import com.mednow.mednowapi.models.Medico;

import java.time.LocalDate;

public record EncaminhamentoDto(
        LocalDate data,
        String descricao,
        StatusEncaminhamento status,
        Consulta consulta,
        Medico medico
) {}
