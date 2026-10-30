package com.hellin.almacen.service;

import com.hellin.almacen.model.Articulo;
import com.hellin.almacen.repository.ArticuloRepository;
import org.springframework.stereotype.Service;
import java.util.LinkedHashMap;

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

 /**
     * Busca un artículo por su identificador y devuelve solo sus datos básicos:
     * id, nombre y stock. Si el stock es 0, añade la clave {@code mensaje} con el
     * valor {@code "Agotado"}.
     *
     * @param id identificador del artículo
     * @return un {@link Optional} con el mapa de datos básicos, o vacío si el
     *         artículo no existe
     */
    public Optional<Map<String, Object>> buscarBasico(Integer id) {
        Optional<Articulo> resultado = repositorio.findById(id);
        if (resultado.isEmpty()) {
            return Optional.empty();
        }
        Articulo articulo = resultado.get();
        Map<String, Object> datos = new LinkedHashMap<>();
        datos.put("id", articulo.getId());
        datos.put("nombre", articulo.getNombre());
        datos.put("stock", articulo.getStock());
        if (articulo.getStock() == 0) {
            datos.put("mensaje", "Agotado");
        }
        return Optional.of(datos);
    }
}