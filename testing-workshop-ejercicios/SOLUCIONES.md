# Soluciones

> Miralas después de intentar los ejercicios. Sirven como guía para el instructor.

## Ejercicio 1 — `CarritoTest`

```java
@Test
void agregarDosProductos_cantidadEsDos() {
    Carrito carrito = new Carrito();
    carrito.agregar(100);
    carrito.agregar(50);
    assertEquals(2, carrito.cantidad());
    assertFalse(carrito.estaVacio());   // import assertFalse
}

@Test
void total_sumaLosPrecios() {
    Carrito carrito = new Carrito();
    carrito.agregar(100);
    carrito.agregar(50);
    assertEquals(150, carrito.total());
}

@Test
void totalConDescuento_aplicaElPorcentaje() {
    Carrito carrito = new Carrito();
    carrito.agregar(200);
    assertEquals(150, carrito.totalConDescuento(25));
}

@Test
void agregarPrecioNegativo_lanzaExcepcion() {
    Carrito carrito = new Carrito();
    assertThrows(IllegalArgumentException.class, () -> carrito.agregar(-10));
}

@Test
void descuentoInvalido_lanzaExcepcion() {
    Carrito carrito = new Carrito();
    carrito.agregar(100);
    assertThrows(IllegalArgumentException.class, () -> carrito.totalConDescuento(150));
}
```

## Ejercicio 2 — `PiedraPapelTijera` (implementación) + tests

Implementación de la clase:

```java
public int jugar(String jugador1, String jugador2) {
    if (jugador1.equals(jugador2)) {
        return 0; // empate
    }
    boolean ganaJugador1 =
            (jugador1.equals("piedra") && jugador2.equals("tijera")) ||
            (jugador1.equals("tijera") && jugador2.equals("papel"))  ||
            (jugador1.equals("papel")  && jugador2.equals("piedra"));
    return ganaJugador1 ? 1 : 2;
}
```

Tests:

```java
@Test
void tijeraVenceAPapel() {
    assertEquals(1, juego.jugar("tijera", "papel"));
}

@Test
void papelVenceAPiedra() {
    assertEquals(1, juego.jugar("papel", "piedra"));
}

@Test
void jugadasIguales_esEmpate() {
    assertEquals(0, juego.jugar("piedra", "piedra"));
}

@Test
void cuandoPierdeJugador1_ganaJugador2() {
    assertEquals(2, juego.jugar("tijera", "piedra"));
}
```

## Ejercicio 3 — `JuegoDeDadosTest`

```java
@Test
void esGanador_cuandoSaleSeis_devuelveTrue() {
    when(aleatorio.entre(1, 6)).thenReturn(6);
    assertTrue(juego.esGanador());
}

@Test
void esGanador_cuandoNoSaleSeis_devuelveFalse() {
    when(aleatorio.entre(1, 6)).thenReturn(3);
    assertFalse(juego.esGanador());
}
```

## Ejercicio 4 — `TareaControllerTest`

```java
@Test
void GET_tareasPendientes_usaListarPendientes() throws Exception {
    when(service.listarPendientes()).thenReturn(List.of(
            new Tarea(2L, "Aprender Mockito", false)
    ));

    mvc.perform(get("/tareas").param("pendientes", "true"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].titulo").value("Aprender Mockito"))
            .andExpect(jsonPath("$[0].completada").value(false));
}
```
