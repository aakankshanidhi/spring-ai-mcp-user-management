# Spring AI MCP User Management System

An AI-powered User Management System built using:

* Spring Boot
* Spring AI
* Groq API
* PostgreSQL
* Redis
* JWT Authentication
* MCP Tool Calling
* Swagger/OpenAPI
* DTO Architecture
* Validation
* AI Chat Memory

---

# Features

## Core Backend Features

* CRUD operations for users
* Layered architecture
* DTO-based request/response handling
* Global exception handling
* Input validation using Jakarta Validation
* Swagger/OpenAPI documentation
* JWT-based authentication & authorization
* Password encryption using BCrypt

---

## AI Features

* AI-powered database interaction
* Natural language prompt handling
* MCP tool calling with Spring AI
* AI memory with conversation tracking
* Context-aware AI responses
* Multi-tool AI interaction support

---

## Redis Features

* Redis caching for optimized API performance
* Cache-based user retrieval

---

# Tech Stack

* Java 17
* Spring Boot 3.4.5
* Spring AI
* Spring Security
* PostgreSQL
* Redis
* Groq LLM API
* Maven

---

# Implemented AI Tools

* Get user by ID
* Get user by name
* Create user
* Update user
* Delete user
* Get all users
* Get users by city

---

# Example AI Prompts

* get user with id 2
* get user Rahul
* what is his city
* add user named Ryan from Delhi
* update user 3 city to Noida
* delete user with id 5
* show users from Delhi

---

# AI Memory Example

Conversation ID: `1`

Prompt 1:

```text
get user Rahul
```

Prompt 2:

```text
what is his city
```

The AI remembers previous conversation context using Spring AI chat memory.

---

# Authentication Flow

## Register User

```http
POST /users
```

## Login

```http
POST /auth/login
```

Returns JWT token.

## Access Protected APIs

Pass token in header:

```text
Authorization: Bearer YOUR_TOKEN
```

---

# API Documentation

Swagger UI:

```text
http://localhost:8080/swagger-ui/index.html
```

---

# Run Project

## Clone Repository

```bash
git clone <repo-url>
```

---

## Configure PostgreSQL

Update `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_db
spring.datasource.username=postgres
spring.datasource.password=your_password
```

---

## Configure Redis

```properties
spring.data.redis.host=localhost
spring.data.redis.port=6379
```

---

## Add Groq API Key

```properties
spring.ai.openai.api-key=YOUR_GROQ_API_KEY
spring.ai.openai.base-url=https://api.groq.com/openai
```

---

## Run Application

```bash
mvn spring-boot:run
```

---

# Future Enhancements

* Vector Database + Embeddings
* Semantic Search
* MCP Tool Chaining
* RAG-based AI Retrieval
* Docker Deployment
* Kubernetes Deployment
* CI/CD Pipeline
* Conversation persistence in Redis/PostgreSQL

---

# Author

Aakanksha Nidhi
