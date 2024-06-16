package com.mednow.mednowapi.dtos;

import com.mednow.mednowapi.models.Medico;

import java.util.List;

public record EspecialidadeDto(
        String descricao,
        List<Medico> medicos
) {}
