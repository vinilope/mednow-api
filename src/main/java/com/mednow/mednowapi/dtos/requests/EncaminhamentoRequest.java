package com.mednow.mednowapi.dtos.requests;

import com.mednow.mednowapi.enums.StatusEncaminhamento;
import com.mednow.mednowapi.models.Consulta;
import com.mednow.mednowapi.models.Medico;

import java.time.LocalDate;

public record EncaminhamentoRequest(
        LocalDate data,
        String descricao,
        Integer status,
        Consulta consulta,
        Medico encaminhadoA
) {}
