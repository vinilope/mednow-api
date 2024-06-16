package com.mednow.mednowapi.dtos;

import com.mednow.mednowapi.models.Endereco;
import com.mednow.mednowapi.models.Exame;

import java.util.List;

public record LaboratorioDto(
        String nome,
        String telefone,
        String email,
        String cnpj,
        String site,
        Endereco endereco,
        List<Exame> exames
) {}
