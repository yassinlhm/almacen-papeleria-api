package com.hellin.almacen.controller;

import com.hellin.almacen.model.Articulo;
import com.hellin.almacen.service.ArticuloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Map;
import java.util.Optional;

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
 * Devuelve los datos básicos de un artículo.
 *
 * @param id identificador del artículo
 * @return 200 si existe o 404 si no existe
 */
@GetMapping("/{id}/basico")
public ResponseEntity<Map<String, Object>> buscarBasico(
        @PathVariable Integer id) {

    Optional<Map<String, Object>> datos = servicio.buscarBasico(id);

    if (datos.isPresent()) {
        return ResponseEntity.ok(datos.get());
    }

    return ResponseEntity.notFound().build();
}

    // TODO (#n de la incidencia): GET /api/articulos/{id}/basico -> datos básicos (200) o 404 si no existe
}