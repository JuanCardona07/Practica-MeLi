package com.mercadolibre.ejercicios.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * EJERCICIO 2 (TDD).
 * Trabajá con la clase PiedraPapelTijera, que está SIN implementar.
 *
 * Flujo TDD para cada regla:
 *   1) Escribí el test (queda ROJO, porque el método aún no funciona).
 *   2) Implementá lo mínimo en PiedraPapelTijera para pasar (VERDE).
 *   3) Refactorizá si hace falta y pasá a la siguiente regla.
 *
 * Recordá: 0 = empate, 1 = gana jugador1, 2 = gana jugador2.
 */
class PiedraPapelTijeraTest {

    private final PiedraPapelTijera juego = new PiedraPapelTijera();

    // ===== EJEMPLO (ya escrito): arranca en ROJO hasta que implementes la clase =====
    @Test
    void piedraVenceATijera_ganaJugador1() {
        assertEquals(1, juego.jugar("piedra", "tijera"));
    }

    // ===== TODO 1: "tijera" vence a "papel" -> gana jugador1 (1) =====
    @Test
    void tijeraVenceAPapel() {
        assertEquals(1, juego.jugar("tijera", "papel"));
    }

    // ===== TODO 2: "papel" vence a "piedra" -> gana jugador1 (1) =====
    @Test
    void papelVenceAPiedra() {
        assertEquals(1, juego.jugar("papel", "piedra"));
    }

    // ===== TODO 3: jugadas iguales -> empate (0) =====
    @Test
    void jugadasIguales_esEmpate() {
        assertEquals(0, juego.jugar("piedra", "piedra"));
    }

    // ===== TODO 4: si pierde el jugador1, debe ganar el jugador2 (2) =====
    // Ejemplo: jugar("tijera", "piedra") -> 2
    @Test
    void cuandoPierdeJugador1_ganaJugador2() {
        assertEquals(2, juego.jugar("tijera", "piedra"));
    }
}
