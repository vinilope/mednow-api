package com.mednow.mednowapi.dtos.responses;

import com.mednow.mednowapi.models.Laboratorio;
import lombok.Getter;

@Getter
public class LaboratorioResponse {
    private final String nome;
    private final String telefone;
    private final String email;
    private final String cnpj;
    private final String site;

    public LaboratorioResponse(Laboratorio laboratorio) {
        this.nome = laboratorio.getNome();
        this.telefone = laboratorio.getTelefone();
        this.email = laboratorio.getEmail();
        this.cnpj = laboratorio.getCnpj();
        this.site = laboratorio.getSite();
    }
}
