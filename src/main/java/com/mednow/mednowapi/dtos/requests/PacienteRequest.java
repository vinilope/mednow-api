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
        // TODO: poder tanto cadastrar um endereço junto, quando cadastrar um paciente com endereço já existente
         UUID fkEndereco
        // Endereco endereco
) {}
