package com.mednow.mednowapi.dtos;

import jakarta.validation.constraints.NotBlank;

public record ClinicaDto (
        @NotBlank String nome,
        String telefone,
        String email,
        String cnpj
) {}
