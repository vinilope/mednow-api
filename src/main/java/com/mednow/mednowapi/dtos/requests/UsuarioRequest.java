package com.mednow.mednowapi.dtos.requests;

public record UsuarioRequest(
        String nomeAcesso,
        String senha,
        Integer tipoUsuario
) {}
