package com.example.store.Models.usuarios;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record DadosCadastroUsuarios(
        @NotBlank
        String name,

        @NotBlank
        @CPF
        String cpf,

        @NotNull
        ROLE role) {
}
