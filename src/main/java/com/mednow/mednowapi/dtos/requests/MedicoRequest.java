package com.mednow.mednowapi.dtos.requests;

import com.mednow.mednowapi.models.Consulta;
import com.mednow.mednowapi.models.Encaminhamento;
import com.mednow.mednowapi.models.Usuario;

import java.util.List;
import java.util.UUID;

public record MedicoRequest(
        String nome,
        String crm,
        String telefone,
        String email,
        Integer especialidade,
        UUID fkClinica,
        Usuario usuario
) {}
