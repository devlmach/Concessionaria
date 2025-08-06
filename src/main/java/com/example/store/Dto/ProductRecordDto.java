package com.example.store.Dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRecordDto(@NotBlank
                               String name,

                               @NotNull
                               String size,

                               @NotNull
                               BigDecimal value) {

}
