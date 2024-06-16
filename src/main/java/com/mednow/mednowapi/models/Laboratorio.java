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
@Entity(name = "laboratorio")
public class Laboratorio implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idLaboratorio;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_endereco")
    private Endereco endereco;

    @OneToMany(mappedBy = "laboratorio")
    private List<Exame> exames;
}
