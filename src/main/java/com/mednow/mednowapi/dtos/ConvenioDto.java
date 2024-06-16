package com.mednow.mednowapi.dtos;

import com.mednow.mednowapi.models.Paciente;

import java.util.List;

public record ConvenioDto(
        String nome,
        String descricao,
        String telefone,
        String email,
        List<Paciente> pacientes
) {}
