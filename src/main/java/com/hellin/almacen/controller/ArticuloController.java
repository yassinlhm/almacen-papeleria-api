package com.hellin.almacen.controller;

import com.hellin.almacen.model.Articulo;
import com.hellin.almacen.service.ArticuloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
* Controlador REST con los endpoints públicos del catálogo de artículos.
* Todas las rutas empiezan por {@code /api/articulos}.
*
* @author Equipo almacen-papeleria-api
* @version 1.0.0
*/
@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {
/** Servicio con la lógica de negocio de los artículos. */
private final ArticuloService servicio;
/**
* Crea el controlador con el servicio que le inyecta Spring.
*
* @param servicio servicio de artículos
*/
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
/**
* {@code GET /api/articulos/{id}/basico}: devuelve id, nombre y stock de
un
* artículo, con {@code "mensaje": "Agotado"} si no quedan unidades.
*
* @param id identificador del artículo
* @return 200 OK con los datos básicos, o 404 Not Found si el artículo
no existe
*/
@GetMapping("/{id}/basico")
public ResponseEntity<Map<String, Object>> buscarBasico(@PathVariable
Integer id) {

Optional<Map<String, Object>> datos = servicio.buscarBasico(id);
if (datos.isPresent()) {
return ResponseEntity.ok(datos.get());
}
return ResponseEntity.notFound().build();
}
}