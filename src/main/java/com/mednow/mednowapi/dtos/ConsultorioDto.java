package com.mednow.mednowapi.dtos;

import jakarta.validation.constraints.NotBlank;

public record ConsultorioDto (
        @NotBlank String nome
) {}
