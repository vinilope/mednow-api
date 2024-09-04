package com.mednow.mednowapi.dtos.responses;

import com.mednow.mednowapi.models.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ConsultaResponse {
    private final LocalDateTime dataHora;
    private final String descricao;
    private final Boolean pedido_exame;
    private final Boolean encaminhado;
    private final PacienteResponse paciente;
    private final MedicoResponse medico;

    public ConsultaResponse(Consulta consulta) {
        this.dataHora = consulta.getDataHora();
        this.descricao = consulta.getDescricao();
        this.pedido_exame = consulta.getPedidoExame();
        this.encaminhado = consulta.getEncaminhado();
        this.paciente = new PacienteResponse(consulta.getPaciente());
        this.medico = new MedicoResponse(consulta.getMedico());
    }
}
