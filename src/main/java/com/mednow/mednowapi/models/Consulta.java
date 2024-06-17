package com.mednow.mednowapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
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

    private LocalDateTime dataHora;
    private String descricao;
    private Boolean pedido_exame;
    private Boolean encaminhado;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_paciente")
    private Paciente paciente;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_medico")
    private Medico medico;

    @JsonIgnore
    @OneToMany(mappedBy = "consulta")
    private List<Exame> exames;

    @JsonIgnore
    @OneToOne(mappedBy = "consulta")
    private Encaminhamento encaminhamento;
}
