package com.mednow.mednowapi.dtos.responses;

import com.mednow.mednowapi.models.Convenio;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ConvenioResponse {
    private final String nome;
    private final String descricao;
    private final String telefone;
    private final String email;
    private final List<PacienteResponse> pacientes;

    public ConvenioResponse(Convenio convenio) {
        this.nome = convenio.getNome();
        this.descricao = convenio.getDescricao();
        this.telefone = convenio.getTelefone();
        this.email = convenio.getEmail();
        this.pacientes = convenio.getPacientes().stream().map(PacienteResponse::new).collect(Collectors.toList());
    }
}
