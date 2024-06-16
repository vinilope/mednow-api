package com.mednow.mednowapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Table
@Entity(name = "tipoExame")
public class TipoExame implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idTipoExame;

    @OneToMany(mappedBy = "exame")
    private List<Exame> exames;
}
