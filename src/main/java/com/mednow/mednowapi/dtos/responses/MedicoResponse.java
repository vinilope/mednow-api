package com.mednow.mednowapi.dtos.responses;

import com.mednow.mednowapi.enums.EspecialidadeMedico;
import com.mednow.mednowapi.models.Medico;
import lombok.Getter;

@Getter
public class MedicoResponse {
   private final String nome;
   private final String crm;
   private final String telefone;
   private final String email;
   private final String especialidade;
   private final UsuarioResponse usuario;

    public MedicoResponse(Medico medico) {
        this.nome = medico.getNome();
        this.crm = medico.getCrm();
        this.telefone = medico.getTelefone();
        this.email = medico.getEmail();
        this.especialidade = EspecialidadeMedico.valueOf(medico.getEspecialidade()).getEspecialidade();
        this.usuario = new UsuarioResponse(medico.getUsuario());
    }
}
