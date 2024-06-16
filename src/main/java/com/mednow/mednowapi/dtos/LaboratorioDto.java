package com.mednow.mednowapi.dtos;

public record LaboratorioDto(
        String nome,
        String telefone,
        String email,
        String cnpj,
        String site
) {}
