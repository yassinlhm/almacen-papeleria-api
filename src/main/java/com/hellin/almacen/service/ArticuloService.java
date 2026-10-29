package com.hellin.almacen.service;

import com.hellin.almacen.model.Articulo;
import com.hellin.almacen.repository.ArticuloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

// TODO: documentar la clase y todos sus métodos con Javadoc.
@Service
public class ArticuloService {

    private final ArticuloRepository repositorio;

    public ArticuloService(ArticuloRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<Articulo> listarTodos() {
        // TODO (#n de la incidencia): devolver todos los artículos. Pista: repositorio.findAll()
        throw new UnsupportedOperationException("Pendiente de implementar");
    }

    public Optional<Map<String, Object>> buscarBasico(Integer id) {
        // TODO (#n de la incidencia): buscar el artículo por id y devolver un mapa con id, nombre y stock.
        // Si el stock es 0, añadir "mensaje": "Agotado". Si no existe, Optional.empty().
        throw new UnsupportedOperationException("Pendiente de implementar");
    }
}
