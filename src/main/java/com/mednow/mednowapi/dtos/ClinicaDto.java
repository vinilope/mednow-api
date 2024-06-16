package com.mednow.mednowapi.dtos;

import com.mednow.mednowapi.models.Endereco;
import com.mednow.mednowapi.models.Medico;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record ClinicaDto (
        @NotBlank String nome,
        String telefone,
        String email,
        String cnpj,
        Endereco endereco,
        List<Medico> medicos
) {}
