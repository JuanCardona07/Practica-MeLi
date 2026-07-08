package com.mercadolibre.ejercicios.tareas;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {

    public List<Tarea> listar() {
        return List.of(
                new Tarea(1L, "Escribir mi primer test", true),
                new Tarea(2L, "Aprender Mockito", false),
                new Tarea(3L, "Probar un controller", false)
        );
    }

    public List<Tarea> listarPendientes() {
        return listar().stream()
                .filter(t -> !t.isCompletada())
                .toList();
    }
}
