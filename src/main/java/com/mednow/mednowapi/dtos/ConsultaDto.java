package com.mednow.mednowapi.dtos;

import com.mednow.mednowapi.models.Medico;
import com.mednow.mednowapi.models.Paciente;

import java.time.LocalDateTime;

public record ConsultaDto(
        LocalDateTime dataHora,
        String descricao,
        Boolean exame,
        Boolean encaminhamento,
        Paciente paciente,
        Medico medico
) {}
