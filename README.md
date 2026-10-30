# almacen-papeleria-api

![CI](https://github.com/yassinlhm/almacen-papeleria-api/actions/workflows/ci.yml/badge.svg)

API REST del almacén de una papelería, hecha con Spring Boot (Java 21), Spring Data JPA y PostgreSQL.
Permite consultar el catálogo de artículos y los datos básicos de cada uno, indicando si está agotado.

## Funcionalidades

- Listar todos los artículos del almacén.
- Consultar id, nombre y stock de un artículo; si no quedan unidades, la respuesta incluye `"mensaje": "Agotado"`.
- Respuesta 404 si el artículo no existe.

## Endpoints

| Método | Ruta | Descripción | Códigos |
|--------|------|-------------|---------|
| GET | `/api/articulos` | Todos los artículos con todos sus campos | 200 |
| GET | `/api/articulos/{id}/basico` | Id, nombre y stock de un artículo | 200, 404 |

### `GET /api/articulos`

```json
[
  { "id": 1, "nombre": "Bolígrafo azul", "precio": 0.45, "stock": 500, "categoria": "papelería" },
  { "id": 3, "nombre": "Grapadora metálica", "precio": 8.95, "stock": 0, "categoria": "oficina" }
]
```

### `GET /api/articulos/1/basico` (con stock)

```json
{ "id": 1, "nombre": "Bolígrafo azul", "stock": 500 }
```

### `GET /api/articulos/3/basico` (agotado)

```json
{ "id": 3, "nombre": "Grapadora metálica", "stock": 0, "mensaje": "Agotado" }
```

### `GET /api/articulos/99/basico` (no existe)

Respuesta `404 Not Found` sin cuerpo.

## Requisitos

- JDK 21
- Maven (se incluye el wrapper `mvnw`)
- PostgreSQL 17 (o Docker). Opcionalmente, sin PostgreSQL con el perfil `h2`.
- Git

## Instalación y ejecución en local

1. Clona el repositorio y entra en la carpeta:
   ```bash
   git clone https://github.com/yassinlhm/almacen-papeleria-api.git
   cd almacen-papeleria-api
   ```
2. Arranca PostgreSQL con **una** de estas opciones:
   - **Docker:**
     ```bash
     docker run --name pg-almacen -e POSTGRES_USER=almacen -e POSTGRES_PASSWORD=cambiame -e POSTGRES_DB=almacen -p 5432:5432 -d postgres:17
     ```
   - **PostgreSQL instalado** (https://www.postgresql.org/download/): crea el usuario `almacen` y la base de datos `almacen`.
3. Define la contraseña como variable de entorno (nunca se guarda en el código) y ejecuta:
   ```bash
   # Linux / macOS / Git Bash
   export DB_PASSWORD=cambiame
   ./mvnw spring-boot:run
   ```
   ```powershell
   # Windows PowerShell
   $env:DB_PASSWORD="cambiame"
   .\mvnw spring-boot:run
   ```
   Variables opcionales: `DB_HOST` (por defecto `localhost`), `DB_NAME` y `DB_USER` (por defecto `almacen`).
4. Prueba la API:
   ```bash
   curl http://localhost:8080/api/articulos
   curl http://localhost:8080/api/articulos/3/basico
   ```

Al arrancar se crean la tabla y los datos de ejemplo (`schema.sql` y `data.sql`).

### Sin PostgreSQL (base de datos en memoria)

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=h2
```

### Pruebas automáticas

```bash
SPRING_PROFILES_ACTIVE=h2 ./mvnw verify          # Linux / macOS / Git Bash
$env:SPRING_PROFILES_ACTIVE="h2"; .\mvnw verify  # Windows PowerShell
```

## Documentación del código (Javadoc)

```bash
./mvnw javadoc:javadoc
```

Se genera en `target/reports/apidocs/index.html` (en `target/site/apidocs` según la versión del plugin).

## Estructura

```
src/main/java/com/hellin/almacen/
  controller/  ArticuloController   (endpoints REST)
  service/     ArticuloService      (lógica: mensaje "Agotado")
  repository/  ArticuloRepository   (acceso a datos con JPA)
  model/       Articulo             (entidad)
src/main/resources/  application*.properties, schema.sql, data.sql
```

## Equipo y flujo de trabajo

| Integrante | Usuario de GitHub | Rol | Tareas principales |
|------------|-------------------|-----|--------------------|
| Yassin Lahmidi Moussaoui | [@yassinlhm](https://github.com/yassinlhm) | A · Planificación | Repositorio, issues, Project, `listarTodos` (#3), README (#11) y versión v1.0.0 |
| Oussama Htit | [@OussamaHtit](https://github.com/OussamaHtit) | B · Integración continua | Endpoint de listado (#4), CI con GitHub Actions (#12) y wiki *Endpoints* (#8) |
| Ilyas Benbraitit Karim | [@Ilyas2914](https://github.com/Ilyas2914) | C · Desarrollo y documentación | `buscarBasico` (#5), endpoint de datos básicos (#6) y wiki *Modelo de datos* y *Guía de uso* (#9, #10) |

- Cada tarea es una **issue** con su estimación, dentro del milestone *Sprint 1*, y se sigue en el **Project** del equipo. La documentación funcional está en la **wiki**.
- Ramas: `main` tiene solo versiones estables; `develop` es la rama de integración. Cada tarea se hace en su propia rama `feature/<nº issue>-<descripcion>` creada desde `develop`.
- Cada rama se sube con una *Pull Request* hacia `develop` que lleva `Closes #<nº>` y la revisa y aprueba otro compañero antes de fusionarla.
- `develop` y `main` están protegidas: no se puede fusionar si el check `compilar` del CI no sale en verde.
- Commits en formato convencional y con la issue, por ejemplo `feat: añade el endpoint de datos básicos con 404 (#6)`.
- Al terminar el sprint se pasa `develop` a `main` con una PR y se publica la versión con un tag y una *Release*.

## Uso de IA

Hemos usado un asistente de IA (Claude) como apoyo para aprender y resolver dudas: qué comandos de Git usar en cada paso, cómo configurar Git solo para este repositorio, errores al instalar Java 21 y al hacer `push` con el token, el formato del Javadoc y la sintaxis del workflow de GitHub Actions. Todo lo que nos sugería lo hemos probado y revisado nosotros antes de subirlo. Nunca hemos pegado contraseñas, tokens ni claves en la IA.