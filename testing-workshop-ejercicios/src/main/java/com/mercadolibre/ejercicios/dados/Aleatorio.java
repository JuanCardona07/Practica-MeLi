package com.mercadolibre.ejercicios.dados;

/**
 * EJERCICIO 3 (Mockito) - Fuente de azar.
 * En los tests vamos a MOCKEAR esta interfaz para que el resultado
 * deje de ser aleatorio y podamos verificarlo.
 */
public interface Aleatorio {
    /** Devuelve un número entre min y max (ambos incluidos). */
    int entre(int min, int max);
}
