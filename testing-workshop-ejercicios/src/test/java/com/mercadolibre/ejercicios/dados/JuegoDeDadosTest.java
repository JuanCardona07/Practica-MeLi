package com.mercadolibre.ejercicios.dados;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * EJERCICIO 3 (Mockito).
 * Idea: mockeamos Aleatorio para que el dado deje de ser azaroso
 * y podamos verificar el resultado.
 *
 * Ya están puestas las anotaciones de Mockito. Completá los tests.
 */
@ExtendWith(MockitoExtension.class)
class JuegoDeDadosTest {

    @Mock
    Aleatorio aleatorio;          // el mock: nosotros decidimos qué "sale"

    @InjectMocks
    JuegoDeDados juego;           // recibe el mock por el constructor

    // ===== EJEMPLO RESUELTO =====
    @Test
    void tirar_devuelveLoQueDaElAleatorio() {
        // Arrange: cuando pidan entre(1,6), devolvé 4
        when(aleatorio.entre(1, 6)).thenReturn(4);

        // Act
        int resultado = juego.tirar();

        // Assert
        assertEquals(4, resultado);
        verify(aleatorio).entre(1, 6);   // verificamos la interacción
    }

    // ===== TODO 1: si el aleatorio devuelve 6, esGanador() es true =====
    @Test
    void esGanador_cuandoSaleSeis_devuelveTrue() {
        //Arrange
        when(aleatorio.entre(1, 6)).thenReturn(6);

        //Act
        boolean resultado = juego.esGanador();

        //Assert
        assertTrue(resultado);
    }

    // ===== TODO 2: si el aleatorio devuelve 3, esGanador() es false =====
    @Test
    void esGanador_cuandoNoSaleSeis_devuelveFalse() {
        //Arrange
        when(aleatorio.entre(1, 6)).thenReturn(3);

        //Act
        boolean resultado = juego.esGanador();

        //Assert
        assertFalse(resultado);
    }
}
