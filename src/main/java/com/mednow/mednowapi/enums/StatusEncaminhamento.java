package com.mednow.mednowapi.enums;

import lombok.Getter;

@Getter
public enum StatusEncaminhamento {
    FINALIZADO(1, "Finalizado"),
    CANCELADO(2, "Cancelado"),
    EM_PROGRESSO(3, "Em Progresso"),
    AGENDADO(4, "Agendado");

    private final Integer statusCod;
    private final String status;

    StatusEncaminhamento(Integer statusCod, String status) {
        this.statusCod = statusCod;
        this.status = status;
    }
}
