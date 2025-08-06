package com.example.store.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.store.Models.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {

}
