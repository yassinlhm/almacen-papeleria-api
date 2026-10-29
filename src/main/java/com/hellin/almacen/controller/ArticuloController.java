package com.hellin.almacen.controller;

import com.hellin.almacen.model.Articulo;
import com.hellin.almacen.service.ArticuloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// TODO: documentar la clase y todos sus métodos con Javadoc.
@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {

    private final ArticuloService servicio;

    public ArticuloController(ArticuloService servicio) {
        this.servicio = servicio;
    }

    /**
     * {@code GET /api/articulos}: devuelve el catálogo completo.
     *
     * @return respuesta 200 OK con la lista de todos los artículos
     */
    @GetMapping
    public ResponseEntity<List<Articulo>> listarTodos() {
        return ResponseEntity.ok(servicio.listarTodos());
    }

    // TODO (#n de la incidencia): GET /api/articulos/{id}/basico -> datos básicos (200) o 404 si no existe
}