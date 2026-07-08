package com.mercadolibre.ejercicios.carrito;

import java.util.ArrayList;
import java.util.List;

/**
 * EJERCICIO 1 (JUnit 5) - Un carrito de compras.
 * Está implementado y funciona. Tu tarea es escribir los tests
 * que le den cobertura (mirá EJERCICIOS.md).
 */
public class Carrito {

    private final List<Integer> precios = new ArrayList<>();

    /** Agrega un producto por su precio. */
    public void agregar(int precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser positivo");
        }
        precios.add(precio);
    }

    /** Cantidad de productos en el carrito. */
    public int cantidad() {
        return precios.size();
    }

    /** true si el carrito no tiene productos. */
    public boolean estaVacio() {
        return precios.isEmpty();
    }

    /** Suma de todos los precios. */
    public int total() {
        return precios.stream().mapToInt(Integer::intValue).sum();
    }

    /** Total aplicando un porcentaje de descuento (0 a 100). */
    public int totalConDescuento(int porcentaje) {
        if (porcentaje < 0 || porcentaje > 100) {
            throw new IllegalArgumentException("El porcentaje debe estar entre 0 y 100");
        }
        int total = total();
        return total - (total * porcentaje / 100);
    }
}
