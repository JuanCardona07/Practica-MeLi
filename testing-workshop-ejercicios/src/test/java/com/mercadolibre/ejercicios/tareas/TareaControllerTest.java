package com.mercadolibre.ejercicios.tareas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * EJERCICIO 4 (Spring Boot Test).
 * Testeamos SOLO la capa web con @WebMvcTest + MockMvc + @MockBean.
 * El primer test está resuelto; completá el segundo.
 */
@WebMvcTest(TareaController.class)
class TareaControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    TareaService service;

    // ===== EJEMPLO RESUELTO =====
    @Test
    void GET_tareas_devuelve200yLaLista() throws Exception {
        when(service.listar()).thenReturn(List.of(
                new Tarea(1L, "Escribir mi primer test", true)
        ));

        mvc.perform(get("/tareas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].titulo").value("Escribir mi primer test"))
                .andExpect(jsonPath("$[0].completada").value(true));
    }

    // ===== TODO 1: GET /tareas?pendientes=true debe usar listarPendientes() =====
    // Pistas:
    //   - when(service.listarPendientes()).thenReturn(List.of(new Tarea(2L, "Aprender Mockito", false)));
    //   - mvc.perform(get("/tareas").param("pendientes", "true"))
    //   - .andExpect(status().isOk())
    //   - .andExpect(jsonPath("$[0].completada").value(false));
    @Test
    void GET_tareasPendientes_usaListarPendientes() throws Exception {
        //Arange
        when(service.listarPendientes()).thenReturn(List.of(
                new Tarea(2L, "Aprender Mockito", false)
        ));

        //Act + Assert
        mvc.perform(get("/tareas").param("pendientes", "true"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].titulo").value("Aprender Mockito"))
                .andExpect(jsonPath("$[0].completada").value(false));
    }
}
