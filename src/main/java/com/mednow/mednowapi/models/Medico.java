package com.mednow.mednowapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mednow.mednowapi.enums.EspecialidadeMedico;
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

    private String nome;
    private String crm;
    private String telefone;
    private String email;
    private Integer especialidade;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_clinica")
    private Clinica clinica;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "medico")
    private List<Consulta> consultas;

    @OneToMany(mappedBy = "medico")
    private List<Encaminhamento> encaminhamentos;
}
