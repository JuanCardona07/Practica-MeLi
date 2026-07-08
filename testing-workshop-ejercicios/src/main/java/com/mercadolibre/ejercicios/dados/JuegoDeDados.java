package com.mercadolibre.ejercicios.dados;

/**
 * EJERCICIO 3 (Mockito) - Un juego de dados.
 * Depende de Aleatorio (que recibe por el constructor), así en el test
 * podemos pasarle un mock y controlar qué "sale" en el dado.
 */
public class JuegoDeDados {

    private final Aleatorio aleatorio;

    public JuegoDeDados(Aleatorio aleatorio) {
        this.aleatorio = aleatorio;
    }

    /** Tira el dado: un número del 1 al 6. */
    public int tirar() {
        return aleatorio.entre(1, 6);
    }

    /** Es ganador si saca un 6. */
    public boolean esGanador() {
        return tirar() == 6;
    }
}
