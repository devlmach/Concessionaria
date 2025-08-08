package com.example.store.Models.usuarios;

public record DadosDetalhamentoUsuarios(
        Long id,
        String name,
        String cpf,
        ROLE role) {

    public DadosDetalhamentoUsuarios(Usuarios usuarios) {
        this(usuarios.getId(),
                usuarios.getName(),
                usuarios.getCpf(),
                usuarios.getRole());
    }
}
