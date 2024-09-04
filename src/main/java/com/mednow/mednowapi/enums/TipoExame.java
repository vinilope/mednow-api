package com.mednow.mednowapi.enums;

import lombok.Getter;

@Getter
public enum TipoExame {
    HEMOGRAMA_COMPLETO(1, "Hemograma Completo"),
    GLICEMIA(2, "Glicemia"),
    PERFIL_LIPIDICO(3, "Perfil Lipídico"),
    FUNCAO_HEPATICA(4, "Função Hepática"),
    FUNCAO_RENAL(5, "Função Renal"),
    HORMONIOS(6, "Hormônios"),
    MARCADORES_TUMORAIS(7, "Marcadores Tumorais"),
    URINA_TIPO_I(8, "Urina Tipo I (EAS)"),
    UROCULTURA(9, "Urocultura"),
    EXAME_24_HORAS(10, "Exame de 24 Horas"),
    RAIO_X(11, "Raio-X"),
    ULTRASSONOGRAFIA(12, "Ultrassonografia (USG)"),
    TOMOGRAFIA_COMPUTADORIZADA(13, "Tomografia Computadorizada (TC)"),
    RESSONANCIA_MAGNETICA(14, "Ressonância Magnética (RM)"),
    MAMOGRAFIA(15, "Mamografia"),
    ENDOSCOPIA_DIGESTIVA_ALTA(16, "Endoscopia Digestiva Alta"),
    COLONOSCOPIA(17, "Colonoscopia"),
    BRONCOSCOPIA(18, "Broncoscopia"),
    ELETROCARDIOGRAMA(19, "Eletrocardiograma (ECG)"),
    ECOCARDIOGRAMA(20, "Ecocardiograma"),
    TESTE_DE_ESFORCO(21, "Teste de Esforço"),
    HOLTER(22, "Holter"),
    ESPIROMETRIA(23, "Espirometria"),
    TESTE_DE_DIFUSAO_PULMONAR(24, "Teste de Difusão Pulmonar"),
    ELETROENCEFALOGRAMA(25, "Eletroencefalograma (EEG)"),
    PET_SCAN(26, "Tomografia por Emissão de Pósitrons (PET scan)"),
    TESTES_HORMONAIS(27, "Testes de Estimulação e Supressão Hormonal"),
    TESTES_GENETICOS(28, "Testes de DNA"),
    BIOPSIA(29, "Biópsia"),
    OFTALMOSCOPIA(30, "Oftalmoscopia"),
    TONOMETRIA(31, "Tonometrias"),
    PAPANICOLAU(32, "Papanicolau (Citologia Cervical)"),
    COLPOSCOPIA(33, "Colposcopia");

    private final Integer exameCod;
    private final String exame;

    TipoExame(Integer exameCod, String exame) {
        this.exameCod = exameCod;
        this.exame = exame;
    }
}
