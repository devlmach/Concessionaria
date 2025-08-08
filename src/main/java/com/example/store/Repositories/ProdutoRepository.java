package com.example.store.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.store.Models.produtos.Produtos;

@Repository
public interface ProdutoRepository extends JpaRepository<Produtos, Long> {

}
