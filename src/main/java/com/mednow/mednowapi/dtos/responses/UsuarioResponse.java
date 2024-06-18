package com.mednow.mednowapi.dtos.responses;

import com.mednow.mednowapi.models.Usuario;
import lombok.Getter;

@Getter
public class UsuarioResponse {
    private final Integer tipo;

    public UsuarioResponse(Usuario usuario) {
        this.tipo = usuario.getTipoUsuario();
    }
}
