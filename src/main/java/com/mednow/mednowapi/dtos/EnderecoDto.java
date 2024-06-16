package com.mednow.mednowapi.dtos;

public record EnderecoDto(
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String estado,
        String cep
) {}
