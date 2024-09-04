package com.mednow.mednowapi.dtos.requests;

import com.mednow.mednowapi.models.Endereco;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

public record ClinicaRequest (
        @NotBlank(message = "Nome da clínica não deve estar em branco.")
        String nome,
        String telefone,
        String email,
        @NotBlank(message = "CNPJ não deve estar em branco.")
        @CNPJ(message = "CNPJ deve ser válido.")
        String cnpj,
        Endereco endereco
) {}
