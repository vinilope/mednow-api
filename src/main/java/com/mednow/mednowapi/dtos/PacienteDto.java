package com.mednow.mednowapi.dtos;

import com.mednow.mednowapi.models.Consulta;
import com.mednow.mednowapi.models.Convenio;
import com.mednow.mednowapi.models.Endereco;

import java.time.LocalDate;
import java.util.List;

public record PacienteDto(
        String nome,
        LocalDate dataNasc,
        String cpf,
        String telefone,
        String email,
        Convenio convenio,
        Endereco endereco,
        List<Consulta> consultas
) {}
