package com.mednow.mednowapi.dtos;

import java.time.LocalDate;

public record PacienteDto(
        String nome,
        LocalDate dataNasc,
        String cpf,
        String telefone,
        String email
) {}
