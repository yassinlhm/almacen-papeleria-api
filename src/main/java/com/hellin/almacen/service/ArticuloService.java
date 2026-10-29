package com.hellin.almacen.service;

import com.hellin.almacen.model.Articulo;
import com.hellin.almacen.repository.ArticuloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Lógica de negocio de los artículos del almacén. Hace de intermediario entre el
 * controlador REST y el repositorio de acceso a datos.
 * @author Equipo almacen-papeleria-api
 * @version 1.0.0 */
@Service
public class ArticuloService {

    /** Repositorio para acceder a la tabla {@code articulo}. */
    private final ArticuloRepository repositorio;

    /** Crea el servicio con el repositorio que le inyecta Spring.
     * @param repositorio repositorio de acceso a los artículos */
    public ArticuloService(ArticuloRepository repositorio) {
        this.repositorio = repositorio;
    }

    /**
     * Devuelve todos los artículos del catálogo.
     * @return lista con todos los artículos; vacía si no hay ninguno  */
    public List<Articulo> listarTodos() {
        return repositorio.findAll();
    }

    public Optional<Map<String, Object>> buscarBasico(Integer id) {
        // TODO (#n de la incidencia): buscar el artículo por id y devolver un mapa con id, nombre y stock.
        // Si el stock es 0, añadir "mensaje": "Agotado". Si no existe, Optional.empty().
        throw new UnsupportedOperationException("Pendiente de implementar");
    }
}