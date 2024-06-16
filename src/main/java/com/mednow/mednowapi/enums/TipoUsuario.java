package com.mednow.mednowapi.enums;

public enum TipoUsuario {
    ADMIN(0, "adm"),
    MEDICO(1, "med");

    private Integer userCod;
    private String userValue;

    TipoUsuario(Integer userCod, String userValue) {
        this.userCod = userCod;
        this.userValue = userValue;
    }
}
