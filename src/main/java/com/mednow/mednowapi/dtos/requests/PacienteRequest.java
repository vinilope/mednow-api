package com.mednow.mednowapi.dtos.requests;

import com.mednow.mednowapi.models.Endereco;

import java.time.LocalDate;
import java.util.UUID;

public record PacienteRequest(
        String nome,
        LocalDate dataNasc,
        String cpf,
        String telefone,
        String email,
        UUID fkConvenio,
        // Caso um vir nulo, cadastrar o outro
        UUID fkEndereco,
        Endereco endereco
) {}
