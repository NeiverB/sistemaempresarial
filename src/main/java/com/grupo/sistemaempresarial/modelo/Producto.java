package com.grupo.sistemaempresarial.modelo;

import java.time.LocalDate;

public class Producto {

    private int id;
    private String nombre;
    private double precio;

    private LocalDate fechaRegistro;

    private String estado;

    private boolean destacado;

    private String descripcion;

    // Se crea una categoría vacía para evitar que sea null
    private Categoria categoria = new Categoria();

    public Producto() {
    }

    public Producto(
            int id,
            String nombre,
            double precio,
            LocalDate fechaRegistro,
            String estado,
            boolean destacado,
            String descripcion,
            Categoria categoria) {

        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
        this.destacado = destacado;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isDestacado() {
        return destacado;
    }

    public void setDestacado(boolean destacado) {
        this.destacado = destacado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}