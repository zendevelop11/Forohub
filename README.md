# Foro Hub: API REST para Gestión de Foros

## Descripción del Proyecto

**Foro Hub** es una API REST desarrollada en **Spring Boot** para gestionar foros en línea, permitiendo a los usuarios interactuar mediante la creación, visualización, actualización y eliminación de tópicos y respuestas. Esta solución proporciona una base sólida para comprender el backend de un sistema de foros, siguiendo las mejores prácticas del modelo REST.

## Funcionalidades Principales

1. **Gestión de Tópicos**:
   - Crear nuevos tópicos.
   - Obtener todos los tópicos.
   - Consultar detalles de un tópico específico.
   - Actualizar tópicos existentes.
   - Eliminar tópicos.

2. **Gestión de Respuestas**:
   - Añadir respuestas a los tópicos.
   - Listar todas las respuestas.
   - Consultar detalles de una respuesta específica.
   - Actualizar respuestas.
   - Eliminar respuestas.

3. **Gestión de Cursos**:
   - Crear, actualizar y eliminar cursos.
   - Listar todos los cursos disponibles.

4. **Autenticación y Autorización**:
   - Implementación de un sistema de autenticación basado en **JWT**.
   - Restricción de acceso a rutas protegidas según roles de usuario.

## Endpoints

### Tópicos (`/topicos`)
- **GET /topicos**: Obtener todos los tópicos.
- **GET /topicos/{id}**: Consultar un tópico por su ID.
- **POST /topicos**: Crear un nuevo tópico.
- **PUT /topicos/{id}**: Actualizar un tópico existente.
- **DELETE /topicos/{id}**: Eliminar un tópico.

### Respuestas (`/respuestas`)
- **GET /respuestas**: Listar todas las respuestas.
- **GET /respuestas/{id}**: Consultar una respuesta por su ID.
- **POST /respuestas**: Crear una nueva respuesta.
- **PUT /respuestas/{id}**: Actualizar una respuesta existente.
- **DELETE /respuestas/{id}**: Eliminar una respuesta.

### Cursos (`/cursos`)
- **GET /cursos**: Listar todos los cursos.
- **GET /cursos/{id}**: Consultar un curso por su ID.
- **POST /cursos**: Crear un nuevo curso.
- **PUT /cursos/{id}**: Actualizar un curso existente.
- **DELETE /cursos/{id}**: Eliminar un curso.

### Autenticación (`/login`)
- **POST /login**: Autenticación de usuarios mediante credenciales.

## Validaciones
La API incluye validaciones para garantizar la integridad de los datos:
- Reglas de negocio para evitar datos inconsistentes.
- Validación de entradas en solicitudes de creación y actualización.

## Persistencia de Datos
La información se almacena en una base de datos relacional configurada mediante **JPA/Hibernate**. Las entidades principales incluyen:
- `Usuario`
- `Curso`
- `Topico`
- `Respuesta`

## Instalación y Ejecución

### Prerrequisitos
- Java 17 o superior.
- Maven 3.8 o superior.
- Base de datos compatible (e.g., MySQL, PostgreSQL).

### Pasos
1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu-repo/foro-hub.git
   ```
2. Navega al directorio del proyecto:
   ```bash
   cd foro-hub
   ```
3. Configura la base de datos en el archivo `application.properties` o `application.yml`.
4. Ejecuta la aplicación:
   ```bash
   mvn spring-boot:run
   ```

## Tecnología Utilizada
- **Framework**: Spring Boot (versión más reciente).
- **Base de datos**: MySQL/PostgreSQL.
- **Seguridad**: Spring Security y JWT.
- **Documentación**: OpenAPI/Swagger.
- **Herramientas de Desarrollo Ágil**: Trello para la gestión de tareas.
