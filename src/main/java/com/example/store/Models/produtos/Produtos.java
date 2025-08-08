package com.example.store.Models.produtos;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "products")
@Table(name = "products", schema = "pb")
@Getter
@Setter
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Marca")
    @NotBlank
    private String name;

    @Column(name = "Tamanho")
    @NotNull
    private String size;

    @Column(name = "Preço")
    @NotNull
    private BigDecimal value;
}
