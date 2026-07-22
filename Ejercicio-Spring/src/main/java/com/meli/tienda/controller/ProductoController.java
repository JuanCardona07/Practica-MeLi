package com.meli.tienda.controller;

import com.meli.tienda.dto.ProductoDTO;
import com.meli.tienda.mapper.ProductoMapper;
import com.meli.tienda.model.Producto;
import com.meli.tienda.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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
                .map(ProductoMapper::aDTO)
                .toList();
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> buscar(@PathVariable Long id) {
        Producto producto = service.buscarPorId(id);
        return ResponseEntity.ok(ProductoMapper.aDTO(producto));
    }

    @GetMapping("/precio-minimo")
    public ResponseEntity<Page<ProductoDTO>> buscarConPrecioMinimo(
            @RequestParam BigDecimal minimo,
            Pageable pageable) {
        Page<ProductoDTO> respuesta = service.buscarConPrecioMinimo(minimo, pageable)
                .map(ProductoMapper::aDTO);
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<ProductoDTO>> buscarPorNombre(@RequestParam String nombre) {
        List<ProductoDTO> respuesta = service.buscarPorNombre(nombre).stream()
                .map(ProductoMapper::aDTO)
                .toList();
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/pagina")
    public ResponseEntity<Page<ProductoDTO>> listarPaginado(Pageable pageable) {
        Page<ProductoDTO> respuesta = service.listarPaginado(pageable)
                .map(ProductoMapper::aDTO);
        return ResponseEntity.ok(respuesta);
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> crear(@Valid @RequestBody ProductoDTO nuevoProducto) {
        Producto creado = service.crear(ProductoMapper.aEntidad(nuevoProducto));
        URI ubicacion = URI.create("/api/productos/" + creado.getId());
        return ResponseEntity.status(HttpStatus.CREATED)
                .location(ubicacion)
                .body(ProductoMapper.aDTO(creado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> actualizar(@PathVariable Long id, @Valid @RequestBody ProductoDTO cambios) {
        Producto actualizado = service.actualizar(id, ProductoMapper.aEntidad(cambios));
        return ResponseEntity.ok(ProductoMapper.aDTO(actualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}