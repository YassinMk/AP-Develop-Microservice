# Bank Account Management Microservice

This project is a microservice for managing bank accounts, developed using Spring Boot and an H2 in-memory database for testing purposes. It follows the principles of RESTful web services and includes GraphQL support.

## Features

- Create and manage bank accounts
- RESTful API endpoints for account management
- GraphQL API for flexible querying
- In-memory H2 database for testing
- Swagger documentation for REST API
- Projections and DTOs for efficient data access
- Service layer for business logic

## Technologies Used

- **Spring Boot** (Web, Spring Data JPA, Spring Data Rest)
- **H2 Database** (In-memory for testing)
- **Lombok** (For reducing boilerplate code)
- **GraphQL** (For advanced API querying)
- **Swagger** (For API documentation)

## Project Structure

1. **Entity:** JPA entity `Compte` for representing bank accounts.
2. **Repository:** `CompteRepository` interface for database operations using Spring Data.
3. **Service Layer:** Business logic and microservice architecture using DTOs and Mappers.
4. **Web Layer:** RESTful API and GraphQL API for account management.
5. **Testing:** DAO layer tested using H2 database and Postman for API tests.

## How to Run

1. Clone the repository.
2. Run the Spring Boot application.
3. Access the in-memory H2 database at `/h2-console`.
4. Test the REST API using Postman or any REST client.
5. View the Swagger API documentation at `/swagger-ui.html`.
6. Query the GraphQL API using `/graphql`.

## API Documentation

- Swagger documentation can be accessed via `/swagger-ui.html` for testing and exploring the RESTful endpoints.
- The GraphQL API allows for flexible queries and mutations, enabling complex data retrieval scenarios.

## Future Improvements

- Integration with a production database like MySQL or PostgreSQL.
- Implement authentication and authorization mechanisms for securing the APIs.
