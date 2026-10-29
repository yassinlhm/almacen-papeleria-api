package com.hellin.almacen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Punto de entrada de la API REST del almacén de papelería.
 *
 * @author Departamento de Informática
 * @version 1.0.0
 */
@SpringBootApplication
public class AlmacenApplication {

    /**
     * Arranca la aplicación Spring Boot.
     *
     * @param args argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        SpringApplication.run(AlmacenApplication.class, args);
    }
}
