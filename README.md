# Spring AI MCP User Management System

An AI-powered User Management System built using Spring Boot, Spring AI, PostgreSQL, Redis, and Groq LLM APIs.

This project allows users to interact with the database using natural language prompts through AI tool calling.

---

# Features

## User Management APIs

* Create User
* Get User By ID
* Get User By Name
* Update User
* Delete User

---

## AI-Powered MCP Tool Calling

Integrated Spring AI with Groq API to allow natural language interaction.

Example prompts:

```text
get user with id 2

get user with name Rahul

delete user with id 3

update user with id 1 city Bangalore

add user with name Ryan email ryan@gmail.com age 25 city Delhi password 1234
```

---

## JWT Authentication

Implemented secure JWT-based authentication.

Features:

* User Registration
* Login API
* JWT Token Generation
* Protected APIs
* Stateless Authentication

---

## DTO Architecture

Implemented:

* UserRequestDto
* UserResponseDto

Benefits:

* Cleaner API structure
* Better security
* Validation support
* Separation of concerns

---

## Validation & Global Exception Handling

Implemented:

* Request validation using Jakarta Validation
* Global exception handling using `@RestControllerAdvice`

Handled exceptions:

* Resource Not Found
* Validation Errors
* AI Tool Errors
* General Exceptions

---

## Redis Caching

Integrated Redis caching for optimized performance.

Cached APIs:

* Get User By ID
* Get User By Name

Benefits:

* Faster API responses
* Reduced database load

---

## Swagger Documentation

Swagger UI integrated for API testing.

Swagger URL:

```text
http://localhost:8080/swagger-ui/index.html
```

---

# Tech Stack

* Java 17
* Spring Boot 3.4.5
* Spring AI
* Groq API
* PostgreSQL
* Redis / Memurai
* Spring Security + JWT
* Spring Data JPA
* Maven
* Swagger OpenAPI
* Lombok

---

# Project Structure

```text
src/main/java/com/springai/MCPServer

├── config
├── controller
├── dto
├── entity
├── exception
├── repository
├── security
├── service
└── tools
```

---

# Setup Instructions

## 1. Clone Repository

```bash
git clone <your-repo-url>
```

---

## 2. Configure PostgreSQL

Create database:

```sql
CREATE DATABASE userdb;
```

Update `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/userdb
spring.datasource.username=postgres
spring.datasource.password=your_password
```

---

## 3. Configure Groq API Key

```properties
spring.ai.openai.api-key=YOUR_GROQ_API_KEY
spring.ai.openai.base-url=https://api.groq.com/openai
spring.ai.openai.chat.options.model=llama-3.3-70b-versatile
```

---

## 4. Configure Redis

Start Redis/Memurai server on port:

```text
6379
```

---

## 5. Run Application

```bash
mvn spring-boot:run
```

---

# Authentication APIs

## Register User

POST

```text
/api/users
```

Request Body:

```json
{
  "name": "Rahul",
  "email": "rahul@gmail.com",
  "password": "1234",
  "age": 26,
  "city": "Guwahati"
}
```

---

## Login

POST

```text
/auth/login
```

Request Body:

```json
{
  "email": "rahul@gmail.com",
  "password": "1234"
}
```

Returns JWT token.

---

# Future Enhancements

* Role-Based Authentication
* Pagination & Sorting
* Dockerization
* Unit Testing
* AI Chat Memory
* Vector Database Integration
* MCP Tool Chaining
* Cloud Deployment

---

# Author

Aakanksha Nidhi
