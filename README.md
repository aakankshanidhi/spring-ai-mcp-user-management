# Spring AI MCP User Management System

An AI-powered User Management System built using **Spring Boot**, **Spring AI**, **Groq LLM APIs**, **JWT Authentication**, **MCP Tool Calling**, **AI Chat Memory**, **PostgreSQL**, **Redis Caching**, **Docker**, and **Render**.

The application enables users to manage database records using both traditional REST APIs and natural language prompts through AI-powered tool calling.

---

# 🚀 Live Demo

### Application

https://spring-ai-mcp-user-management.onrender.com

### Swagger UI

https://spring-ai-mcp-user-management.onrender.com/swagger-ui/index.html

---

# ✨ Project Highlights

- AI-powered User Management using Spring AI & Groq LLM
- Natural Language Database Operations via MCP Tool Calling
- JWT Authentication & Spring Security
- AI Conversation Memory
- REST APIs with DTO Architecture
- Global Exception Handling
- Swagger/OpenAPI Documentation
- Dockerized Spring Boot Application
- Live Cloud Deployment on Render

---

# Features

## User Management APIs

- Create User
- Get All Users
- Get User By ID
- Get User By Name
- Get User By Email
- Get Users By City
- Update User
- Delete User

---

## AI-Powered MCP Tool Calling

Integrated Spring AI with Groq API to enable natural language interaction with the database.

### Supported AI Operations

- Get User By ID
- Get User By Name
- Get User By Email
- Get Users By City
- Get All Users
- Create User
- Update User
- Delete User

### Example Prompts

```text
get user with id 2

get user with name Rahul

get users from Delhi

get user with email rahul@gmail.com

show all users

delete user with id 3

update user with id 1 city Bangalore

add user with name Ryan email ryan@gmail.com age 25 city Delhi password 1234
```

---

## AI Chat Memory

Implemented conversation-based memory using Spring AI Chat Memory.

### Features

- Maintains conversation context
- Conversation-specific memory
- Uses Conversation ID
- Supports follow-up questions

### Example

```text
Conversation ID = abc123

Prompt 1:
Get user with name Khushi

Prompt 2:
What is her city?
```

The AI remembers the previously discussed user within the same conversation.

---

## JWT Authentication

Implemented secure JWT-based authentication.

### Features

- User Registration
- Login API
- JWT Token Generation
- Protected APIs
- Stateless Authentication
- Secure AI Endpoints

Protected APIs require:

```text
Authorization: Bearer <JWT_TOKEN>
```

---

## DTO Architecture

Implemented DTOs:

- UserRequestDto
- UserResponseDto
- LoginRequestDto
- AuthResponseDto

### Benefits

- Clean API Design
- Better Security
- Validation Support
- Separation of Concerns

---

## Validation & Global Exception Handling

Implemented:

- Jakarta Validation
- Global Exception Handling using `@RestControllerAdvice`

Handled Exceptions:

- Resource Not Found
- Validation Errors
- Authentication Errors
- AI Tool Errors
- AI Rate Limit Errors
- General Exceptions

---

## Redis Caching

Redis caching is supported for local development.

### Cached APIs

- Get User By ID
- Get User By Name
- Get User By Email

### Benefits

- Faster API Responses
- Reduced Database Load

> Redis caching is disabled in the Render deployment to simplify free cloud hosting.

---

## Swagger Documentation

Swagger UI integrated for API testing.

### Local

```text
http://localhost:8080/swagger-ui/index.html
```

### Live

```text
https://spring-ai-mcp-user-management.onrender.com/swagger-ui/index.html
```

---

# Docker & Render Deployment

The application is containerized using Docker and deployed on Render.

### Cloud Features

- Dockerized Spring Boot Application
- Public API Access
- H2 Database for Cloud Deployment
- Environment Variable Configuration
- Groq API Integration
- Automatic GitHub Deployments
- Free Cloud Hosting via Render

### Deployment URL

```text
https://spring-ai-mcp-user-management.onrender.com
```

### Swagger URL

```text
https://spring-ai-mcp-user-management.onrender.com/swagger-ui/index.html
```

---

# Tech Stack

- Java 17
- Spring Boot 3.4.5
- Spring AI
- Groq API
- Spring Security
- JWT Authentication
- PostgreSQL
- H2 Database
- Redis / Memurai (Local Development)
- Spring Data JPA
- Maven
- Swagger OpenAPI
- Docker
- Render
- Lombok

---

# Project Structure

```text
src/main/java/com/springai/MCPServer

├── config
├── controller
├── dto
├── entity
├── exception
├── mcptools
├── repository
├── security
├── service
```

---

# Setup Instructions

## 1. Clone Repository

```bash
git clone https://github.com/aakankshanidhi/spring-ai-mcp-user-management.git
```

---

## 2. Configure Database

### PostgreSQL (Local)

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/userdb
spring.datasource.username=postgres
spring.datasource.password=your_password
```

### H2 (Cloud Deployment)

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
```

---

## 3. Configure Groq API

```properties
spring.ai.openai.api-key=YOUR_GROQ_API_KEY
spring.ai.openai.base-url=https://api.groq.com/openai
spring.ai.openai.chat.options.model=llama-3.3-70b-versatile
```

---

## 4. Configure Redis (Optional)

```properties
spring.data.redis.host=localhost
spring.data.redis.port=6379
```

---

## 5. Run Application

```bash
mvn spring-boot:run
```

---

# Docker

## Build Docker Image

```bash
docker build -t spring-ai-mcp-user-management .
```

## Run Docker Container

```bash
docker run -p 8080:8080 \
-e GROQ_API_KEY=YOUR_GROQ_API_KEY \
spring-ai-mcp-user-management
```

---

# Authentication APIs

## Register User

**POST**

```text
/api/users
```

---

## Login

**POST**

```text
/auth/login
```

Response:

```json
{
  "token": "JWT_TOKEN"
}
```

---

# AI Endpoint

**GET**

```text
/ai/chat
```

### Parameters

```text
prompt
conversationId
```

### Example

```text
/ai/chat?conversationId=abc123&prompt=get user with id 1
```

---

# Future Enhancements

- PostgreSQL Cloud Database
- Redis Cloud Integration
- Vector Database Integration
- Embeddings & RAG
- MCP Tool Chaining
- Role-Based Access Control (RBAC)
- Pagination & Sorting
- Unit & Integration Testing
- Docker Compose
- Kubernetes Deployment
- CI/CD using GitHub Actions

---

# Author

**Aakanksha Nidhi**
