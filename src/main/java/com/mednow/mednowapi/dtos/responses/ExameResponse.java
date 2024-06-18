package com.mednow.mednowapi.dtos.responses;

import com.mednow.mednowapi.models.Exame;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ExameResponse {
    private final LocalDate data;
    private final String observacao;
    private final Integer tipoExame;
    private final ConsultaResponse consulta;
    private final LaboratorioResponse laboratorio;

    public ExameResponse(Exame exame) {
        this.data = exame.getData();
        this.observacao = exame.getObservacao();
        this.tipoExame = exame.getTipoExame();
        this.consulta = new ConsultaResponse(exame.getConsulta());
        this.laboratorio = new LaboratorioResponse(exame.getLaboratorio());
    }
}
