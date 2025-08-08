package com.example.store.Models.usuarios;

import jakarta.validation.Valid;

public record DadosCadastroUsuarios(
        String name,
        String cpf,

        @Valid
        ROLE role) {
}
