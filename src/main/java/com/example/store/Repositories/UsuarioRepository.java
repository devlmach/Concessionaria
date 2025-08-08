package com.example.store.Repositories;

import com.example.store.Models.usuarios.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {

    Boolean existsByCpf(String cpf);
}
