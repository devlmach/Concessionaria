package com.example.store.Models.usuarios;

public record DadosListagemUsuarios(
        Long id,
        String name,
        String cpf,
        String email,
        ROLE role) {

    public DadosListagemUsuarios(Usuarios usuarios) {
        this(usuarios.getId(),
                usuarios.getName(),
                usuarios.getCpf(),
                usuarios.getEmail(),
                usuarios.getRole());
    }
}
