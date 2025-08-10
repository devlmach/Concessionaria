package com.example.store.Models.usuarios;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Usuarios")
@Table(name = "usuarios")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String cpf;

    @Enumerated(EnumType.STRING)
    private ROLE role;

    public Usuarios(DadosCadastroUsuarios dadosCadastroUsuarios) {
        this.name = dadosCadastroUsuarios.name();
        this.cpf = dadosCadastroUsuarios.cpf();
        this.role = dadosCadastroUsuarios.role();
    }
}
