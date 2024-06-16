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
@Entity(name = "convenio")
public class Convenio implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idConvenio;
    private String nome;
    private String descricao;
    private String telefone;
    private String email;

    @OneToMany(mappedBy = "convenio")
    private List<Paciente> pacientes;
}
