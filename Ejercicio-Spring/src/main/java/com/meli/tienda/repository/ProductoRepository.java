package com.meli.tienda.repository;

import com.meli.tienda.model.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Query method: Spring lee el nombre del método y genera el SQL solo.
    // Equivalente a: SELECT * FROM productos WHERE LOWER(nombre) LIKE LOWER('%valor%')
    List<Producto> findByNombreContainingIgnoreCase(String nombre);

    // @Query manual con JPQL, para cuando el nombre del método no alcanza.
    @Query("SELECT p FROM Producto p WHERE p.precio >= :minimo ORDER BY p.precio ASC")
    Page<Producto> buscarConPrecioMinimo(@Param("minimo") double minimo, Pageable pageable);
}
