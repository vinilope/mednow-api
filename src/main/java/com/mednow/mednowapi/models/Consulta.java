package com.mednow.mednowapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Table
@Entity(name = "consulta")
public class Consulta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idConsulta;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_paciente")
    private Paciente paciente;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_medico")
    private Medico medico;

    @OneToMany(mappedBy = "exame")
    private List<Exame> exames;

    @OneToOne(mappedBy = "encaminhamento")
    private Encaminhamento encaminhamento;
}
