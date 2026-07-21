package com.meli.tienda.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record ProductoDTO(
        Long id,

@NotBlank(message = "El nombre no puede estar vacio")
        String nombre,

@NotNull(message = "El precio es obligatorio")
@PositiveOrZero(message = "El precio no puede ser negativo")
        BigDecimal precio
                ) {
                }