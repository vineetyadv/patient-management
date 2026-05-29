Project Title & Tagline

Patient Management System
A microservices-based backend system for managing patient records, authentication, and billing.

---
Architecture Overview

- 4 independent microservices communicating via REST and gRPC
- API Gateway as the single client entry point (port 4004)
- JWT-based authentication validated at the gateway level
- gRPC for high-performance inter-service communication (Patient → Billing)

---
Services  


     Service       │        Port             │              Description                 │

 API Gateway       │ 4004                    │    Routes requests, validates JWT tokens │

 Auth Service      │ 4005                    │    User login, JWT generation            │

 Patient Service   │ 4000                    │    Patient CRUD operations               │

 Billing Service   │ 4001 / 9001 (gRPC)      │    Billing account management            │


---
Tech Stack

- Java 21 + Spring Boot 4.x
- Spring Cloud Gateway (reactive/WebFlux)
- Spring Security + JJWT for authentication
- Spring Data JPA + PostgreSQL (H2 for dev/testing)
- gRPC + Protocol Buffers for service-to-service calls
- Maven multi-module build with Protobuf code generation
- Docker with multi-stage builds for each service
- OpenAPI / Swagger UI on Auth and Patient services

---
Key Features

- JWT authentication with role-based access control (10-hour expiration)
- Full patient CRUD with email uniqueness validation and UUID-based IDs
- Automatic billing account creation on patient registration via gRPC
- Global exception handling with structured error responses
- DTO pattern separating API contracts from domain models
- Swagger UI for interactive API documentation

---
Design Patterns Used

- API Gateway pattern
- Repository pattern (Spring Data JPA)
- DTO / Mapper pattern
- Global @ControllerAdvice exception handling
- Stateless JWT authentication
- gRPC protobuf service contracts as the single source of truth

---
Getting Started (bullet points to expand)

- Prerequisites: Java 21, Docker, Maven
- Clone and build with mvn clean package
- Set environment variables: JWT secret, DB credentials, billing service host/port
- Run each service via Docker or java -jar
- API docs available at /swagger-ui.html on Auth and Patient services

---
API Highlights

- POST /auth/login — returns a JWT token
- GET /auth/validate — validates a token (used by gateway)
- GET /api/patients — list all patients (JWT required)
- POST /api/patients — create a patient + auto-creates billing account
- PUT /api/patients/{id} — update patient record
- DELETE /api/patients/{id} — remove a patient

---
