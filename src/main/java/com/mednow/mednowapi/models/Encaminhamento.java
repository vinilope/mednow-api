package com.mednow.mednowapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_consulta")
    private Consulta consulta;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_encaminhado_a")
    private Medico medico;
}
