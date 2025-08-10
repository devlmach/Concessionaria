package com.example.store.Models.usuarios;

public record DadosListagemUsuarios(
        Long id,
        String name,
        String cpf,
        ROLE role) {

    public DadosListagemUsuarios(Usuarios usuarios) {
        this(usuarios.getId(),
                usuarios.getName(),
                usuarios.getCpf(),
                usuarios.getRole());
    }
}
