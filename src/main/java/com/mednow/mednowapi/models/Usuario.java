package com.mednow.mednowapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Table
@Entity(name = "usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idUsuario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_medico")
    private Medico medico;
}
