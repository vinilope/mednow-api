package com.mednow.mednowapi.dtos;

import com.mednow.mednowapi.models.Consulta;
import com.mednow.mednowapi.models.Encaminhamento;
import com.mednow.mednowapi.models.Especialidade;
import com.mednow.mednowapi.models.Usuario;

import java.util.List;

public record MedicoDto(
        String nome,
        String crm,
        String telefone,
        String email,
        Especialidade especialidade,
        Usuario usuario,
        List<Consulta> consultas,
        List<Encaminhamento> encaminhamentos
) {}
