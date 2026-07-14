package com.mercadolibre.ejercicios.tdd;

import java.util.Map;

/**
 * EJERCICIO 2 (TDD) - Piedra, Papel o Tijera.
 *
 * Este método está SIN implementar a propósito.
 * Construilo con TDD: primero un test que falle (rojo), después el
 * código mínimo para que pase (verde), y así con cada regla.
 *
 * Reglas:
 *   - "piedra" le gana a "tijera"
 *   - "tijera" le gana a "papel"
 *   - "papel"  le gana a "piedra"
 *   - jugadas iguales -> empate
 */
public class PiedraPapelTijera {

    /**
     * @return 0 si es empate, 1 si gana el jugador1, 2 si gana el jugador2.
     */
    /*public int jugar(String jugador1, String jugador2) {
        if (jugador1.equals("piedra") && jugador2.equals("tijera")) {
            return 1;
        }
        if (jugador1.equals("tijera") && jugador2.equals("papel")) {
            return 1;
        }
        if (jugador1.equals("papel") && jugador2.equals("piedra")) {
            return 1;
        }
        if (jugador1.equals(jugador2)) {
            return 0;
        }
        return 2;
    }*/

    private static final Map<String, String> LE_GANA_A = Map.of(
            "piedra", "tijera",
            "tijera", "papel",
            "papel", "piedra"
    );

    public int jugar(String jugador1, String jugador2) {
        if (jugador1.equals(jugador2)) {
            return 0;
        }
        if (LE_GANA_A.get(jugador1).equals(jugador2)) {
            return 1;
        }
        return 2;
    }
}
