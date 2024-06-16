package com.mednow.mednowapi.dtos;

import com.mednow.mednowapi.models.Encaminhamento;
import com.mednow.mednowapi.models.Exame;
import com.mednow.mednowapi.models.Medico;
import com.mednow.mednowapi.models.Paciente;

import java.time.LocalDateTime;
import java.util.List;

public record ConsultaDto(
        LocalDateTime dataHora,
        String descricao,
        Boolean pedido_exame,
        Boolean encaminhado,
        Paciente paciente,
        Medico medico,
        List<Exame> exameList,
        Encaminhamento encaminhamento
) {}
