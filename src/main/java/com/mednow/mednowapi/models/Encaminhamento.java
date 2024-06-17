package com.mednow.mednowapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mednow.mednowapi.enums.StatusEncaminhamento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Table
@Entity(name = "encaminhamento")
public class Encaminhamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idEncaminhamento;

    private LocalDate data;
    private String descricao;
    private StatusEncaminhamento status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_consulta")
    private Consulta consulta;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_encaminhado_a")
    private Medico medico;
}
