package com.mednow.mednowapi.dtos;

import java.time.LocalDateTime;

public record ConsultaDto(
        LocalDateTime dataHora,
        String descricao,
        Boolean exame,
        Boolean encaminhamento
) {}
