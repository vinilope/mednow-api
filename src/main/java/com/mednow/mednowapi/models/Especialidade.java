package com.mednow.mednowapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Table
@Entity(name = "especialidade")
public class Especialidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idEspecialidade;

    private String descricao;

    @JsonIgnore
    @OneToMany(mappedBy = "especialidade")
    private List<Medico> medicos;
}
