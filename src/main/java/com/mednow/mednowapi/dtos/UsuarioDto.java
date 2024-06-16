package com.mednow.mednowapi.dtos;

import com.mednow.mednowapi.enums.TipoUsuario;
import com.mednow.mednowapi.models.Medico;

public record UsuarioDto(
        String nomeUsuario,
        String senha,
        TipoUsuario tipoUsuario,
        Medico medico
) {}
