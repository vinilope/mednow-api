package com.mednow.mednowapi.dtos;

import com.mednow.mednowapi.enums.StatusEncaminhamento;

import java.time.LocalDate;

public record EncaminhamentoDto(
        LocalDate data,
        String descricao,
        StatusEncaminhamento status
) {}
