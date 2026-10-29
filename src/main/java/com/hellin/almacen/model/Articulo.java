package com.hellin.almacen.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Artículo del almacén de papelería. Corresponde a la tabla {@code articulo}.
 *
 * @author Departamento de Informática
 * @version 1.0.0
 */
@Entity
@Table(name = "articulo")
public class Articulo {

    /** Identificador único del artículo (clave primaria). */
    @Id
    private Integer id;

    /** Nombre comercial del artículo, por ejemplo "Bolígrafo azul". */
    @Column(nullable = false)
    private String nombre;

    /** Precio unitario en euros, sin IVA. */
    @Column(nullable = false)
    private Float precio;

    /** Unidades disponibles en el almacén. Cero significa agotado. */
    @Column(nullable = false)
    private Integer stock;

    /** Tipo de producto, por ejemplo "papelería" u "oficina". */
    @Column(nullable = false)
    private String categoria;

    /** Constructor vacío, necesario para JPA. */
    public Articulo() {
    }

    /**
     * Crea un artículo con todos sus datos.
     *
     * @param id identificador único
     * @param nombre nombre del artículo
     * @param precio precio unitario en euros
     * @param stock unidades disponibles
     * @param categoria tipo de producto
     */
    public Articulo(Integer id, String nombre, Float precio, Integer stock, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    /** @return el identificador del artículo */
    public Integer getId() { return id; }

    /** @param id el nuevo identificador */
    public void setId(Integer id) { this.id = id; }

    /** @return el nombre del artículo */
    public String getNombre() { return nombre; }

    /** @param nombre el nuevo nombre */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /** @return el precio unitario en euros */
    public Float getPrecio() { return precio; }

    /** @param precio el nuevo precio unitario en euros */
    public void setPrecio(Float precio) { this.precio = precio; }

    /** @return las unidades disponibles */
    public Integer getStock() { return stock; }

    /** @param stock las nuevas unidades disponibles */
    public void setStock(Integer stock) { this.stock = stock; }

    /** @return la categoría del artículo */
    public String getCategoria() { return categoria; }

    /** @param categoria la nueva categoría */
    public void setCategoria(String categoria) { this.categoria = categoria; }
}
