package com.mednow.mednowapi.dtos.responses;

import com.mednow.mednowapi.models.Clinica;
import com.mednow.mednowapi.models.Medico;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ClinicaResponse {
    private final String nome;
    private final String telefone;
    private final String email;
    private final String cnpj;
    private final List<MedicoResponse> medicos;

    public ClinicaResponse(Clinica clinica) {
        this.nome = clinica.getNome();
        this.telefone = clinica.getTelefone();
        this.email = clinica.getEmail();
        this.cnpj = clinica.getCnpj();
        this.medicos = clinica.getMedicos().stream().map(MedicoResponse::new).toList();
    }
}
