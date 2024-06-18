package com.mednow.mednowapi.dtos.responses;

import com.mednow.mednowapi.models.Paciente;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PacienteResponse {
    private final String nome;
    private final LocalDate dataNasc;
    private final String cpf;
    private final String telefone;
    private final String email;
    private final ConvenioResponse convenio;
    private final EnderecoResponse endereco;

    public PacienteResponse(Paciente paciente) {
        this.nome = paciente.getNome();
        this.dataNasc = paciente.getDataNasc();
        this.cpf = paciente.getCpf();
        this.telefone = paciente.getTelefone();
        this.email = paciente.getEmail();
        this.convenio = new ConvenioResponse(paciente.getConvenio());
        this.endereco = new EnderecoResponse(paciente.getEndereco());
    }
}
