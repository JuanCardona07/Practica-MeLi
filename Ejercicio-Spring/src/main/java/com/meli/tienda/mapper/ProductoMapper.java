package com.meli.tienda.mapper;

import com.meli.tienda.dto.ProductoDTO;
import com.meli.tienda.model.Producto;

public class ProductoMapper {

    private ProductoMapper() {

    }

    public static ProductoDTO aDTO(Producto producto) {
        return new ProductoDTO(producto.getId(), producto.getNombre(), producto.getPrecio());
    }

    public static Producto aEntidad(ProductoDTO dto) {
        return new Producto(null, dto.nombre(), dto.precio());
    }
}