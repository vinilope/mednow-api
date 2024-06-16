package com.mednow.mednowapi.dtos;

public record MedicoDto(
        String nome,
        String crm,
        String telefone,
        String email
) {}
