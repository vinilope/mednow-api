package com.mednow.mednowapi.dtos;

import com.mednow.mednowapi.models.Consulta;
import com.mednow.mednowapi.models.Laboratorio;
import com.mednow.mednowapi.models.TipoExame;

import java.time.LocalDate;

public record ExameDto(
        LocalDate data,
        String observacao,
        TipoExame tipoExame,
        Consulta consulta,
        Laboratorio laboratorio
) {}
