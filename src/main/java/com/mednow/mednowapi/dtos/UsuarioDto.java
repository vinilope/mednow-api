package com.mednow.mednowapi.dtos;

import com.mednow.mednowapi.enums.TipoUsuario;

public record UsuarioDto(
        String nomeUsuario,
        String senha,
        TipoUsuario tipoUsuario
) {}
