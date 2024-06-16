package com.mednow.mednowapi.dtos;

import com.mednow.mednowapi.models.Exame;

import java.util.List;

public record TipoExameDto(
        String descricao,
        List<Exame> exames
) {}
