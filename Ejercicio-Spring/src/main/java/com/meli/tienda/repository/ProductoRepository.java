package com.meli.tienda.repository;

import com.meli.tienda.model.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByNombreContainingIgnoreCase(String nombre);

    Page<Producto> findByPrecioGreaterThanEqual(BigDecimal minimo, Pageable pageable);

    boolean existsByNombreIgnoreCase(String nombre);
}
