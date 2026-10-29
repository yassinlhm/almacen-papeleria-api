package com.hellin.almacen.repository;

import com.hellin.almacen.model.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Acceso a la tabla {@code articulo}. Spring Data JPA genera automáticamente la
 * implementación de los métodos heredados, como {@code findAll()} y {@code findById()}.
 *
 * @author Departamento de Informática
 * @version 1.0.0
 */
public interface ArticuloRepository extends JpaRepository<Articulo, Integer> {
}
