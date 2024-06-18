package com.mednow.mednowapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mednow.mednowapi.enums.TipoUsuario;
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

    private String nomeAcesso;
    private String senha;
    private Integer tipoUsuario;

    @JsonIgnore
    @OneToOne(mappedBy = "usuario")
    private Medico medico;
}
