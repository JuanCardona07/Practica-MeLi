package com.meli.tienda.service;

import com.meli.tienda.model.Producto;
import com.meli.tienda.repository.ProductoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<Producto> listarTodos() {
        return repository.findAll();
    }

    public Optional<Producto> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Producto crear(Producto producto) {
        producto.setId(null);
        return repository.save(producto);
    }

    @Transactional
    public Optional<Producto> actualizar(Long id, Producto cambios) {
        return repository.findById(id).map(existente -> {
            existente.setNombre(cambios.getNombre());
            existente.setPrecio(cambios.getPrecio());
            return repository.save(existente);
        });
    }

    @Transactional
    public boolean eliminar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Producto> buscarPorNombre(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre);
    }

    public Page<Producto> buscarPaginado(int pagina, int tamanio) {
        return repository.findAll(PageRequest.of(pagina, tamanio));
    }
}
