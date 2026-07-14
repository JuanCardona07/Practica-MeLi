package com.neocamp.EjerciciosPracticos;

public class SuperHeroe {
    //Atributos privados
    private String nombre;
    private String descripcion;
    private boolean llevaCapa;
    private int poder;

    //Constructor
    public SuperHeroe(String nombre, String descripcion, boolean llevaCapa, int poder) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.llevaCapa = llevaCapa;
        this.poder = poder;
    }

    //Getters
    public String getNombre(){ return nombre;};
    public String getDescripcion(){return descripcion;};
    public boolean isLlevaCapa(){return llevaCapa;};
    public int getPoder(){return poder;};

    //setters
    public void setNombre(String nombre) { this.nombre = nombre; };
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; };
    public void setLlevaCapa(boolean llevaCapa) { this.llevaCapa = llevaCapa; };
    public void setPoder(int poder) { this.poder = poder; };

    //ToString
    @Override
    public String toString(){
        return "SuperHeroe{nombre='" + nombre + "', descripcion='" + descripcion +
                "', llevaCapa=" + llevaCapa + ", poder=" + poder + "}";

    }
}
