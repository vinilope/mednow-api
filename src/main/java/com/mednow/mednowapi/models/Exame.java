package com.mednow.mednowapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Table
@Entity(name = "exame")
public class Exame implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idExame;

    private LocalDate data;
    private String observacao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_consulta")
    private Consulta consulta;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_laboratorio")
    private Laboratorio laboratorio;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_tipo_exame")
    private TipoExame tipoExame;
}
