package com.example.store.Models.usuarios;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "usuarios")
@Table(name = "usuarios", schema = "pb")
@Getter
@Setter
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String cpf;

    @Enumerated(EnumType.STRING)
    private ROLE role;

    public Usuarios(@Valid DadosCadastroUsuarios dadosCadastroUsuarios) {
        this.name = dadosCadastroUsuarios.name();
        this.cpf = dadosCadastroUsuarios.cpf();
        this.role = dadosCadastroUsuarios.role();
    }
}
