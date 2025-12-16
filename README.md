# api_alumno

API REST sencilla para gestionar la entidad **Alumno** (CRUD) usando **Spring Boot**, **Spring Data JPA**, **MySQL** y auditoría con **Hibernate Envers**.

## Tecnologías

- Java 11
- Spring Boot 2.3.x
- Spring Web
- Spring Data JPA
- MySQL Connector
- Hibernate Envers (auditoría)
- Lombok

## Requisitos

- Java 11
- MySQL en ejecución

## Configuración

La app lee la configuración desde `src/main/resources/application.properties`.

Valores actuales (por defecto):

- **Base URL**: `http://localhost:9050`
- **DB**: `jdbc:mysql://localhost:3306/db_alumno`
- **User**: `root`
- **Password**: vacío

Ajusta `spring.datasource.*` según tu entorno.

## Ejecutar

Con Maven Wrapper:

```bash
./mvnw spring-boot:run
```

## Endpoints

Base path: `/api/v1/alumno`

- **GET** `/api/v1/alumno` — lista todos
- **GET** `/api/v1/alumno/{id}` — obtiene uno por id
- **POST** `/api/v1/alumno` — crea
- **PUT** `/api/v1/alumno/{id}` — actualiza
- **DELETE** `/api/v1/alumno/{id}` — elimina

Ejemplo de body (POST/PUT):

```json
{
  "nombre": "Juan",
  "apellido": "Pérez",
  "email": "juan.perez@mail.com",
  "createAt": "2025-12-16T00:00:00.000+00:00"
}
```

## Auditoría (Envers)

La entidad `Alumno` está anotada con `@Audited`, lo que permite registrar revisiones históricas (tabla de auditoría y tabla de revisiones). La clase `Revision` modela el metadato de revisión y `CustomRevisionListener` es el hook para capturar información adicional por revisión (actualmente no agrega campos extra).
