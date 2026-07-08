# TaskApp

![TaskApp screenshot](../screenshot.png)

TaskApp is a Spring Boot REST API for managing tasks. It uses Spring Web, Spring Data JPA, validation, and an in-memory H2 database.

## Features

- Create, list, update, and delete tasks
- Request validation for task payloads
- UUID-based task identifiers
- Enum-based priority and status values

## Tech Stack

- Java 25
- Spring Boot 4.1
- Spring Web MVC
- Spring Data JPA
- Bean Validation
- H2 database

## Requirements

- Java 25
- Maven 3.9+ or the included Maven wrapper

## Run Locally

From the `taskapp` directory:

```bash
./mvnw spring-boot:run
```

On Windows PowerShell:

```powershell
.\mvnw.cmd spring-boot:run
```

The application starts on the default Spring Boot port `8080`.

## API

Base path: `/api/v1/tasks`

### Create a task

`POST /api/v1/tasks`

Request body:

```json
{
  "title": "Finish README",
  "description": "Document the task API and setup steps",
  "dueDate": "2026-07-10",
  "priority": "HIGH"
}
```

Validation rules:

- `title` is required and must be 255 characters or fewer
- `description` is required and must be 1000 characters or fewer
- `dueDate` is required and must be today or later
- `priority` is required and must be one of `LOW`, `MEDIUM`, or `HIGH`

### List tasks

`GET /api/v1/tasks`

### Update a task

`PUT /api/v1/tasks/{taskId}`

Request body:

```json
{
  "title": "Finish README",
  "description": "Document the task API and setup steps",
  "dueDate": "2026-07-10",
  "priority": "HIGH",
  "status": "OPEN"
}
```

### Delete a task

`DELETE /api/v1/tasks/{taskId}`

## Response Model

Task responses include:

- `id`
- `title`
- `description`
- `dueDate`
- `priority`
- `status`

## Project Structure

- `controller` - REST endpoints
- `service` - task business logic
- `repository` - JPA persistence layer
- `mapper` - DTO and domain mapping
- `domain` - request and response types, entities, and enums
- `exception` - custom exceptions and API error handling

## Notes

- The app uses H2, so data is stored in-memory unless the persistence configuration is changed.
- Global exception handling is implemented for API error responses.
