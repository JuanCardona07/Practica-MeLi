package com.meli.tienda.service;

import com.meli.tienda.exception.ProductoDuplicadoException;
import com.meli.tienda.exception.ProductoNoEncontradoException;
import com.meli.tienda.model.Producto;
import com.meli.tienda.repository.ProductoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Producto> listarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Producto buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductoNoEncontradoException(id));
    }

    @Transactional
    public Producto crear(Producto producto) {
        if (repository.existsByNombreIgnoreCase(producto.getNombre())) {
            throw new ProductoDuplicadoException(producto.getNombre());
        }
        return repository.save(producto);
    }

    @Transactional
    public Producto actualizar(Long id, Producto cambios ) {
        Producto existente = buscarPorId(id);
        existente.setNombre(cambios.getNombre());
        existente.setPrecio(cambios.getPrecio());
        return repository.save(existente);
    }

    @Transactional
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new ProductoNoEncontradoException(id);
        }
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Producto> buscarPorNombre(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre);
    }

    @Transactional(readOnly = true)
    public Page<Producto> buscarConPrecioMinimo(BigDecimal minimo, Pageable pageable) {
        return repository.findByPrecioGreaterThanEqual(minimo, pageable);
    }

    @Transactional(readOnly = true)
    public Page<Producto> listarPaginado(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
