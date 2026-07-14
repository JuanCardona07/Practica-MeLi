package com.meli.tienda.controller;

import com.meli.tienda.dto.ProductoDTO;
import com.meli.tienda.model.Producto;
import com.meli.tienda.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> listar() {
        List<ProductoDTO> respuesta = service.listarTodos().stream()
                .map(ProductoDTO::desdeEntidad)
                .toList();
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ProductoDTO::desdeEntidad)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<ProductoDTO>> buscarPorNombre(@RequestParam String nombre) {
        List<ProductoDTO> respuesta = service.buscarPorNombre(nombre).stream()
                .map(ProductoDTO::desdeEntidad)
                .toList();
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/pagina")
    public ResponseEntity<Page<ProductoDTO>> listarPaginado(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int tamanio) {
        Page<ProductoDTO> respuesta = service.buscarPaginado(pagina, tamanio)
                .map(ProductoDTO::desdeEntidad);
        return ResponseEntity.ok(respuesta);
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> crear(@Valid @RequestBody ProductoDTO nuevoProducto) {
        Producto creado = service.crear(nuevoProducto.aEntidad());
        URI ubicacion = URI.create("/api/productos/" + creado.getId());
        return ResponseEntity.created(ubicacion).body(ProductoDTO.desdeEntidad(creado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> actualizar(@PathVariable Long id, @Valid @RequestBody ProductoDTO cambios) {
        return service.actualizar(id, cambios.aEntidad())
                .map(ProductoDTO::desdeEntidad)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean seElimino = service.eliminar(id);
        return seElimino
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
