package com.mednow.mednowapi.enums;

import lombok.Getter;

import java.util.Objects;

@Getter
public enum EspecialidadeMedico {
    CARDIOLOGIA(1, "Cardiologia"),
    DERMATOLOGIA(2, "Dermatologia"),
    ENDOCRINOLOGIA(3, "Endocrinologia"),
    GASTROENTEROLOGIA(4, "Gastroenterologia"),
    GERIATRIA(5, "Geriatria"),
    GINECOLOGIA_OBSTETRICIA(6, "Ginecologia e Obstetrícia"),
    HEMATOLOGIA(7, "Hematologia"),
    INFECTOLOGIA(8, "Infectologia"),
    NEFROLOGIA(9, "Nefrologia"),
    NEUROLOGIA(10, "Neurologia"),
    OFTALMOLOGIA(11, "Oftalmologia"),
    ONCOLOGIA(12, "Oncologia"),
    ORTOPEDIA(13, "Ortopedia"),
    OTORRINOLARINGOLOGIA(14, "Otorrinolaringologia"),
    PEDIATRIA(15, "Pediatria"),
    PNEUMOLOGIA(16, "Pneumologia"),
    PSIQUIATRIA(17, "Psiquiatria"),
    RADIOLOGIA(18, "Radiologia"),
    REUMATOLOGIA(19, "Reumatologia"),
    UROLOGIA(20, "Urologia");

    private final Integer especialidadeCod;
    private final String especialidade;

    EspecialidadeMedico(Integer especialidadeCod, String especialidade) {
        this.especialidadeCod = especialidadeCod;
        this.especialidade = especialidade;
    }

    public static EspecialidadeMedico valueOf(Integer especialidadeCod) {
        for (EspecialidadeMedico especialidade : EspecialidadeMedico.values()) {
            if(Objects.equals(especialidade.getEspecialidadeCod(), especialidadeCod)) return especialidade;
        }

        throw new IllegalArgumentException("Código inválido");
    }
}
