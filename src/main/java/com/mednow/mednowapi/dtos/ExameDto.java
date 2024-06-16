package com.mednow.mednowapi.dtos;

import java.time.LocalDate;

public record ExameDto(
        LocalDate data,
        String observacao
) {}
