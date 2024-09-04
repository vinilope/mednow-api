package com.mednow.mednowapi.dtos.requests;

import com.mednow.mednowapi.models.Paciente;

import java.util.List;

public record ConvenioRequest(
        String nome,
        String descricao,
        String telefone,
        String email
) {}
