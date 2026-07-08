# Ejercicios prácticos — Testing en Java

¡Bienvenido/a a la práctica! Acá vas a escribir los tests que faltan.
El código de producción **ya está hecho y funciona**; tu trabajo es cubrirlo con tests.

## Cómo empezar

1. Abrí el proyecto en IntelliJ (o corré `mvn test` en la terminal).
2. Vas a ver varios tests en **rojo**: son los `TODO` que tenés que completar.
3. En cada archivo de test hay **un ejemplo ya resuelto** para que veas el patrón.
4. Reemplazá cada `fail("TODO...")` por un test de verdad, hasta ponerlos todos en **verde**.

> Consejo: corré los tests seguido. Rojo → escribís → verde. Un pasito a la vez.

---

## Ejercicio 1 — JUnit 5 · `Carrito`

Archivo: `src/test/.../carrito/CarritoTest.java`

Tests a escribir:
1. Al agregar 2 productos, `cantidad()` es 2.
2. Agregar 100 y 50 → `total()` es 150.
3. Total 200 con 25% de descuento → 150.
4. Agregar un precio **negativo** lanza `IllegalArgumentException` (usá `assertThrows`).
5. (Extra) Un descuento mayor a 100 lanza `IllegalArgumentException`.

Conceptos: `@Test`, `assertEquals`, `assertTrue`, `assertThrows`, Arrange-Act-Assert.

---

## Ejercicio 2 — TDD · `PiedraPapelTijera`

Archivo: `src/test/.../tdd/PiedraPapelTijeraTest.java`
Clase a implementar: `PiedraPapelTijera` (arranca **sin implementar**).

Este es el ejercicio de **TDD**: escribí el test **primero**, mirá que quede rojo,
y recién ahí implementá lo mínimo en `PiedraPapelTijera.jugar(...)`.

Reglas (devuelve 0 empate, 1 gana jugador1, 2 gana jugador2):
1. "piedra" vence a "tijera" *(ya escrito como ejemplo)*.
2. "tijera" vence a "papel".
3. "papel" vence a "piedra".
4. Jugadas iguales → empate.
5. Si pierde el jugador1, gana el jugador2.

Orden sugerido: hacé pasar la regla 1 primero (implementá lo mínimo),
después sumá una regla por vez. Cuando estén todas en verde, **refactorizá**.

Conceptos: ciclo **Red → Green → Refactor**.

---

## Ejercicio 3 — Mockito · `JuegoDeDados`

Archivo: `src/test/.../dados/JuegoDeDadosTest.java`

`JuegoDeDados` depende de `Aleatorio`. En el test **mockeamos** `Aleatorio`
para que el dado deje de ser azaroso.

Tests a escribir:
1. Si el aleatorio devuelve 6, `esGanador()` es `true`.
2. Si el aleatorio devuelve 3, `esGanador()` es `false`.

Pistas: usá `when(aleatorio.entre(1, 6)).thenReturn(6)` y `assertTrue` / `assertFalse`.
Las anotaciones `@Mock` e `@InjectMocks` ya están puestas.

Conceptos: `@Mock`, `@InjectMocks`, `when/thenReturn`, `verify`.

---

## Ejercicio 4 — Spring Boot Test · `TareaController`

Archivo: `src/test/.../tareas/TareaControllerTest.java`

Test a escribir:
1. `GET /tareas?pendientes=true` debe llamar a `service.listarPendientes()`
   y devolver solo tareas no completadas.

Pistas (están también en el archivo):
- `when(service.listarPendientes()).thenReturn(List.of(new Tarea(2L, "Aprender Mockito", false)));`
- `mvc.perform(get("/tareas").param("pendientes", "true"))`
- `.andExpect(status().isOk())`
- `.andExpect(jsonPath("$[0].completada").value(false));`

Conceptos: `@WebMvcTest`, `MockMvc`, `@MockBean`, `jsonPath`.

---

## Checklist para cada test que escribas

- [ ] El nombre se lee como una frase: `metodo_condicion_resultado`.
- [ ] Sigue Arrange – Act – Assert.
- [ ] Verifica **una sola** cosa.
- [ ] Pasa de rojo a verde.

## ¿Te trabaste?

Las soluciones completas están en `SOLUCIONES.md`. Miralas solo después de intentarlo. 🙂
