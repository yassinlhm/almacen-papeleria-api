package com.hellin.almacen.controller;

import com.hellin.almacen.service.ArticuloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO: documentar la clase y todos sus métodos con Javadoc.
@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {

    private final ArticuloService servicio;

    public ArticuloController(ArticuloService servicio) {
        this.servicio = servicio;
    }

    // TODO (#n de la incidencia): GET /api/articulos -> lista de todos los artículos (200)

    // TODO (#n de la incidencia): GET /api/articulos/{id}/basico -> datos básicos (200) o 404 si no existe
}
