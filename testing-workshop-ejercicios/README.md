# Testing en Java — Proyecto de ejercicios

Proyecto para **practicar** lo visto en el workshop. El código de producción ya
está implementado; tu tarea es **escribir los tests que faltan**.

## Requisitos
- Java 17+
- Maven (o IntelliJ IDEA)

## Cómo trabajar
1. Corré `mvn test`: vas a ver tests en rojo (los `TODO`).
2. Abrí **EJERCICIOS.md** y seguí la lista.
3. Completá cada test hasta que todo quede en verde.
4. Si te trabás, mirá **SOLUCIONES.md**.

## Los 4 ejercicios
| # | Tema | Clase | Concepto |
|---|------|-------|----------|
| 1 | JUnit 5 | `Carrito` | assertEquals, assertThrows |
| 2 | TDD | `PiedraPapelTijera` | Red-Green-Refactor |
| 3 | Mockito | `JuegoDeDados` + `Aleatorio` | mockear una dependencia |
| 4 | Spring Boot Test | `TareaController` | @WebMvcTest, MockMvc, @MockBean |

## Levantar la app (opcional)
```bash
mvn spring-boot:run
curl http://localhost:8080/tareas
curl "http://localhost:8080/tareas?pendientes=true"
```
