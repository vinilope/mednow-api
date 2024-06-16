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
@Entity(name = "medico")
public class Medico implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idMedico;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_clinica")
    private Clinica clinica;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_especialidade")
    private Especialidade especialidade;

    @OneToOne(mappedBy = "medico")
    private Usuario usuario;

    @OneToMany(mappedBy = "medico")
    private List<Consulta> consultas;

    @OneToMany(mappedBy = "medico")
    private List<Encaminhamento> encaminhamentos;
}
