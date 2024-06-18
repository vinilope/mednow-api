package com.mednow.mednowapi.enums;

public enum TipoUsuario {
    ADMIN(0, "Admin"),
    MEDICO(1, "Médico");

    private Integer userCod;
    private String usuario;

    TipoUsuario(Integer userCod, String usuario) {
        this.userCod = userCod;
        this.usuario = usuario;
    }
}
