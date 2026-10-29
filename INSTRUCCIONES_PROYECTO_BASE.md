# Proyecto base: API del almacén de papelería

## 1. Crear el esqueleto Maven (una sola vez)
Este paquete NO incluye `pom.xml` ni `mvnw`: se generan con la versión actual de Spring Boot.

1. Entra en https://start.spring.io
2. Project: **Maven** · Language: **Java** · Spring Boot: la versión estable que salga por defecto.
3. Group: `com.hellin` · Artifact: `almacen` · Package name: `com.hellin.almacen` · Java: **21**.
4. Dependencies: **Spring Web**, **Spring Data JPA**, **PostgreSQL Driver**, **H2 Database**.
5. Generate, descomprime y **copia encima** el contenido de esta carpeta (sustituye los archivos que coincidan).

## 2. Base de datos
**Opción A, PostgreSQL con Docker:**
```bash
docker run --name pg-almacen -e POSTGRES_USER=almacen -e POSTGRES_PASSWORD=cambiame -e POSTGRES_DB=almacen -p 5432:5432 -d postgres:17
```
**Opción B, PostgreSQL instalado** (https://www.postgresql.org/download/): crea el usuario `almacen` y la base `almacen`.

**Opción C, sin PostgreSQL** (para probar rápido): perfil `h2`, ver el apartado 3.

## 3. Ejecutar
```bash
# Linux / macOS / Git Bash
export DB_PASSWORD=cambiame
./mvnw spring-boot:run

# Windows PowerShell
$env:DB_PASSWORD="cambiame"
.\mvnw spring-boot:run

# Sin PostgreSQL (base de datos en memoria)
./mvnw spring-boot:run -Dspring-boot.run.profiles=h2
```
Prueba: http://localhost:8080/api/articulos

## 4. Pruebas automáticas sin PostgreSQL
```bash
SPRING_PROFILES_ACTIVE=h2 ./mvnw verify          # Linux / macOS / Git Bash
$env:SPRING_PROFILES_ACTIVE="h2"; .\mvnw verify  # Windows PowerShell
```
