package com.mednow.mednowapi.dtos.responses;

import com.mednow.mednowapi.enums.EspecialidadeMedico;
import com.mednow.mednowapi.models.*;
import lombok.Getter;

import java.util.List;

@Getter
public class MedicoResponse {
   private final String nome;
   private final String crm;
   private final String telefone;
   private final String email;
   private final Integer especialidade;
   private final UsuarioResponse usuario;

    public MedicoResponse(Medico medico) {
        this.nome = medico.getNome();
        this.crm = medico.getCrm();
        this.telefone = medico.getTelefone();
        this.email = medico.getEmail();
        this.especialidade = medico.getEspecialidade();
        this.usuario = new UsuarioResponse(medico.getUsuario());
    }
}
