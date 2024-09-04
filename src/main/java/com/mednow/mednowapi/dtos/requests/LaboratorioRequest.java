package com.mednow.mednowapi.dtos.requests;

import com.mednow.mednowapi.models.Endereco;
import com.mednow.mednowapi.models.Exame;

import java.util.List;

public record LaboratorioRequest(
        String nome,
        String telefone,
        String email,
        String cnpj,
        String site,
        Endereco endereco
) {}
