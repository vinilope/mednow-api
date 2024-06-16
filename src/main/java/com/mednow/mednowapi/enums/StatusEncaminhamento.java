package com.mednow.mednowapi.enums;

import lombok.Builder;

public enum StatusEncaminhamento {
    PENDENTE(1, "pending"),
    FINALIZADO(2, "finished");

    private Integer statusCod;
    private String statusValue;

    StatusEncaminhamento(Integer statusCod, String statusValue) {
        this.statusCod = statusCod;
        this.statusValue = statusValue;
    }
}
