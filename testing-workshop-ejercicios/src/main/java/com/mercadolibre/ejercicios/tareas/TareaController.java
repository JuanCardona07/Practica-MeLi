package com.mercadolibre.ejercicios.tareas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * EJERCICIO 4 (Spring Boot Test) - Controller de tareas.
 *
 *   GET /tareas                  -> todas las tareas
 *   GET /tareas?pendientes=true  -> solo las no completadas
 */
@RestController
@RequestMapping("/tareas")
public class TareaController {

    private final TareaService service;

    public TareaController(TareaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Tarea> listar(@RequestParam(required = false, defaultValue = "false") boolean pendientes) {
        if (pendientes) {
            return service.listarPendientes();
        }
        return service.listar();
    }
}
