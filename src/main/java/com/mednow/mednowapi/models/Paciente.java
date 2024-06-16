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
@Entity(name = "paciente")
public class Paciente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idPaciente;
    private String nome;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_convenio")
    private Convenio convenio;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_endereco")
    private Endereco endereco;

    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultas;
}
