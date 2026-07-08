package com.meli.tienda.dto;

import com.meli.tienda.model.Producto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public class ProductoDTO {
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacio")
    private String nombre;

    @PositiveOrZero(message = "El precio no puede ser negativo")
    private double precio;

    public ProductoDTO(){
    }

    public ProductoDTO(Long id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public static ProductoDTO desdeEntidad(Producto producto) {
        return new ProductoDTO(producto.getId(), producto.getNombre(), producto.getPrecio());
    }

    public Producto aEntidad() {
        return new Producto(this.id, this.nombre, this.precio);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
