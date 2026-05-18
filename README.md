# MiniLink - Production Style URL Shortener API

MiniLink is a production-style URL Shortener backend application built using Spring Boot.

The application allows users to:

* Create shortened URLs
* Generate custom aliases
* Configure URL expiration
* Redirect users to original URLs
* Track click analytics
* Handle API validation and exceptions professionally

This project was built to practice and demonstrate backend engineering concepts including REST API development, layered architecture, validation, exception handling, analytics tracking, and API documentation.

---

# Features

## URL Shortening

Generate unique short URLs for long URLs.

Example:

```txt
https://github.com/helloabdulmajid
↓
http://localhost:8080/github
```

---

## Custom Alias Support

Users can create custom aliases instead of random short codes.

Example:

```json
{
  "originalUrl": "https://github.com",
  "customAlias": "github"
}
```

Generated URL:

```txt
http://localhost:8080/github
```

---

## URL Expiration

Supports optional URL expiration.

Expired URLs automatically return proper API errors.

Example:

```json
{
  "originalUrl": "https://google.com",
  "expiresAt": "2026-12-31T23:59:59"
}
```

---

## Redirect Handling

Short URLs redirect users to original URLs using Spring Boot redirect handling.

Example:

```txt
GET /github
→ Redirects to https://github.com
```

---

## Click Tracking & Analytics

Tracks total redirect clicks for each URL.

Analytics endpoint:

```txt
GET /api/v1/urls/{shortCode}/analytics
```

Response Example:

```json
{
  "originalUrl": "https://github.com",
  "shortCode": "github",
  "clickCount": 12,
  "createdAt": "2026-05-19T02:30:00",
  "expiresAt": null,
  "active": true
}
```

---

## Validation & Error Handling

Includes:

* URL format validation
* Duplicate alias validation
* Expired URL validation
* Global exception handling
* Clean API responses

---

## Swagger/OpenAPI Documentation

Integrated Swagger UI for interactive API testing and documentation.

Swagger URL:

```txt
http://localhost:8080/swagger-ui/index.html
```

---

# Tech Stack

## Backend

* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* Maven

## Database

* MySQL

## Tools & Libraries

* Lombok
* Swagger/OpenAPI
* Postman
* Git & GitHub

---

# Project Architecture

The project follows a layered architecture pattern.

```txt
Controller → Service → Repository → Database
```

## Architecture Benefits

* Clean code structure
* Better maintainability
* Separation of concerns
* Easier testing and debugging
* Scalable backend design

---

# Package Structure

```txt
com.abdulmajid.minilink
│
├── config
├── controller
├── dto
├── entity
├── exception
├── repository
├── service
├── service.impl
└── util
```

---

# API Endpoints

# 1. Create Short URL

## Endpoint

```txt
POST /api/v1/urls
```

## Request Body

```json
{
  "originalUrl": "https://github.com",
  "customAlias": "github",
  "expiresAt": "2026-12-31T23:59:59"
}
```

## Response

```json
{
  "originalUrl": "https://github.com",
  "shortCode": "github",
  "shortUrl": "http://localhost:8080/github",
  "clickCount": 0,
  "createdAt": "2026-05-19T02:30:00"
}
```

---

# 2. Redirect URL

## Endpoint

```txt
GET /{shortCode}
```

## Example

```txt
GET /github
```

Redirects to:

```txt
https://github.com
```

---

# 3. URL Analytics

## Endpoint

```txt
GET /api/v1/urls/{shortCode}/analytics
```

## Example

```txt
GET /api/v1/urls/github/analytics
```

## Response

```json
{
  "originalUrl": "https://github.com",
  "shortCode": "github",
  "clickCount": 25,
  "createdAt": "2026-05-19T02:30:00",
  "expiresAt": null,
  "active": true
}
```

---

# Validation Rules

## Original URL

* Required
* Must start with:

    * http://
    * https://

---

## Custom Alias

* Optional
* Must be unique
* Duplicate aliases are blocked

---

## Expiration Date

* Optional
* Expired URLs automatically become inaccessible

---

# Exception Handling

The project uses global exception handling using:

```txt
@RestControllerAdvice
```

Custom exceptions:

* ShortUrlNotFoundException
* ShortUrlExpiredException
* DuplicateShortCodeException

---

# HTTP Status Codes Used

| Status Code     | Meaning                        |
| --------------- | ------------------------------ |
| 201 Created     | Short URL created successfully |
| 302 Found       | Redirect successful            |
| 400 Bad Request | Validation error               |
| 404 Not Found   | Short URL not found            |
| 409 Conflict    | Duplicate alias                |
| 410 Gone        | URL expired                    |

---

# Database Design

## Table: short_url

| Column       | Description                 |
| ------------ | --------------------------- |
| id           | Primary Key                 |
| original_url | Original long URL           |
| short_code   | Generated/custom short code |
| click_count  | Total redirect clicks       |
| created_at   | URL creation timestamp      |
| expires_at   | Expiration timestamp        |
| active       | Active status               |

---

# How To Run The Project

## 1. Clone Repository

```bash
git clone https://github.com/helloabdulmajid/minilink.git
```

---

## 2. Open Project

Open in IntelliJ IDEA or preferred IDE.

---

## 3. Configure MySQL

Update:

```txt
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/minilink
spring.datasource.username=root
spring.datasource.password=yourpassword
```

---

## 4. Run Application

Run:

```txt
MinilinkApplication.java
```

---

# Future Improvements

Planned future enhancements:

* React Frontend
* Docker Support
* Redis Caching
* JWT Authentication
* User Accounts
* QR Code Generation
* URL Analytics Dashboard
* Public Deployment

---

# Learning Outcomes

This project helped in understanding:

* REST API development
* Layered backend architecture
* DTO usage
* Validation handling
* Exception handling
* Swagger/OpenAPI
* Redirect handling
* JPA & Hibernate
* API testing using Postman
* Git & GitHub workflow

---

# Author

## Abdul Majid

Java Backend Developer

GitHub:

[https://github.com/helloabdulmajid](https://github.com/helloabdulmajid)

---

# Project Status

Backend Phase Completed Successfully ✅

Next Phase:
Frontend Development using React + Tailwind CSS 🚀
