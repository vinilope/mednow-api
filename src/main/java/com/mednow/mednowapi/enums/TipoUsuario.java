package com.mednow.mednowapi.enums;

import lombok.Getter;

@Getter
public enum TipoUsuario {
    ADMIN(0, "Admin"),
    MEDICO(1, "Médico");

    private final Integer userCod;
    private final String usuario;

    TipoUsuario(Integer userCod, String usuario) {
        this.userCod = userCod;
        this.usuario = usuario;
    }
}
