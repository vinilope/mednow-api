package com.mednow.mednowapi.dtos.responses;

import com.mednow.mednowapi.enums.StatusEncaminhamento;
import com.mednow.mednowapi.models.Encaminhamento;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class EncaminhamentoResponse {
    private final LocalDate data;
    private final String descricao;
    private final StatusEncaminhamento status;
    private final ConsultaResponse consulta;
    private final MedicoResponse medico;

    public EncaminhamentoResponse(Encaminhamento encaminhamento) {
        this.data = encaminhamento.getData();
        this.descricao = encaminhamento.getDescricao();
        this.status = encaminhamento.getStatus();
        this.consulta = new ConsultaResponse(encaminhamento.getConsulta());
        this.medico = new MedicoResponse(encaminhamento.getMedico());
    }
}
