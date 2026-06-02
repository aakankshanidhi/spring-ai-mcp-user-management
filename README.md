# Spring AI MCP User Management System

An AI-powered User Management System built using Spring Boot, Spring AI, Groq LLM APIs, JWT Authentication, MCP Tool Calling, AI Chat Memory, PostgreSQL, Redis, and Railway Deployment.

The application allows users to manage database records using both REST APIs and natural language prompts through AI-powered tool calling.

---

# Features

## User Management APIs

* Create User
* Get All Users
* Get User By ID
* Get User By Name
* Get User By Email
* Get Users By City
* Update User
* Delete User

---

## AI-Powered MCP Tool Calling

Integrated Spring AI with Groq API to enable natural language interaction with the database.

Supported AI Operations:

* Get User By ID
* Get User By Name
* Get User By Email
* Get Users By City
* Get All Users
* Create User
* Update User
* Delete User

Example Prompts:

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

Features:

* Maintains context across multiple prompts
* Supports conversation-specific memory
* Uses Conversation ID for session tracking
* Enables follow-up questions

Example:

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

Features:

* User Registration
* Login API
* JWT Token Generation
* Protected APIs
* Stateless Authentication
* Secure AI Endpoints

Protected APIs require:

```text
Authorization: Bearer <jwt_token>
```

---

## DTO Architecture

Implemented:

* UserRequestDto
* UserResponseDto
* LoginRequestDto
* AuthResponseDto

Benefits:

* Cleaner API structure
* Better security
* Validation support
* Separation of concerns

---

## Validation & Global Exception Handling

Implemented:

* Request validation using Jakarta Validation
* Global exception handling using @RestControllerAdvice

Handled exceptions:

* Resource Not Found
* Validation Errors
* Authentication Errors
* AI Tool Errors
* AI Rate Limit Errors
* General Exceptions

---

## Redis Caching

Integrated Redis caching for optimized performance.

Cached APIs:

* Get User By ID
* Get User By Name
* Get User By Email

Benefits:

* Faster API responses
* Reduced database load

---

## Swagger Documentation

Swagger UI integrated for API testing.

Local:

```text
http://localhost:8080/swagger-ui/index.html
```

---

## Railway Deployment

Application successfully deployed on Railway.

Cloud Features:

* Public API access
* H2 database support for deployment
* Environment variable configuration
* Groq API integration

Deployment URL:

```text
https://spring-ai-mcp-user-management-production.up.railway.app
```

Swagger URL:

```text
https://spring-ai-mcp-user-management-production.up.railway.app/swagger-ui/index.html
```

---

# Tech Stack

* Java 17
* Spring Boot 3.4.5
* Spring AI
* Groq API
* Spring Security
* JWT Authentication
* PostgreSQL
* H2 Database
* Redis / Memurai
* Spring Data JPA
* Maven
* Swagger OpenAPI
* Railway
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
├── mcptools
├── repository
├── security
├── service
└── memory
```

---

# Setup Instructions

## 1. Clone Repository

```bash
git clone <your-repository-url>
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

## 4. Configure Redis

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

# Authentication APIs

## Register User

POST

```text
/api/users
```

---

## Login

POST

```text
/auth/login
```

Returns:

```json
{
  "token": "JWT_TOKEN"
}
```

---

# AI Endpoint

GET

```text
/ai
```

Parameters:

```text
prompt
conversationId
```

Example:

```text
/ai?conversationId=abc123&prompt=get user with id 1
```

---

# Future Enhancements

* Vector Database Integration
* Embeddings
* MCP Tool Chaining
* Role-Based Access Control (RBAC)
* Pagination & Sorting
* Dockerization
* Unit & Integration Testing
* Kubernetes Deployment

---

# Author

Aakanksha Nidhi
