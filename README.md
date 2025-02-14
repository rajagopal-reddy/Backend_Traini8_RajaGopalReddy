# Training Center Registry

The **Training Center Registry** is a Spring Boot-based application for managing training centers. It provides APIs for creating and retrieving training centers with proper validation, error handling and exception management. The project uses a MySQL database for persistence.

---

## Features

- Create new training centers with validations (e.g., unique center codes).
- Retrieve a list of all registered training centers.
- Comprehensive error handling for common scenarios like:
  - Duplicate entries
  - Invalid inputs
  - Database operation failures
  - Resources not found
- Environment-based configuration using Spring profiles.
- Detailed logging of SQL queries and application events.

---

## Tech Stack

- **Java 17**
- **Spring Boot 3.x**
  - Spring Web
  - Spring Data JPA
  - Hibernate
- **MySQL** as the database
- **Lombok** for boilerplate code reduction
- **Postman** (recommended for testing the APIs)
  - POST http://localhost:2999/api/v1/training-centers
  - GET http://localhost:2999/api/v1/training-centers

---

## Installation

1. Clone the repository:
   ```bash
   https://github.com/rajagopal-reddy/Backend_Traini8_RajaGopalReddy.git
