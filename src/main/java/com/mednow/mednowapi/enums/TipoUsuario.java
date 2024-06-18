package com.mednow.mednowapi.enums;

public enum TipoUsuario {
    ADMIN(0, "Admin"),
    MEDICO(1, "Médico");

    private Integer userCod;
    private String user;

    TipoUsuario(Integer userCod, String user) {
        this.userCod = userCod;
        this.user = user;
    }
}
