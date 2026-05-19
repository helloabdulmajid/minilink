# MiniLink - Full Stack URL Shortener Platform 🚀

MiniLink is a modern full-stack URL Shortener platform built using Spring Boot, PostgreSQL, React, and Tailwind CSS.

The application allows users to:

- Create shortened URLs
- Generate custom aliases
- Configure URL expiration
- Redirect users to original URLs
- Track click analytics
- Manage recent links
- View analytics dashboard
- Use responsive modern UI
- Deploy using cloud infrastructure

This project was built to practice and demonstrate real-world backend and frontend engineering concepts including:

- REST API development
- Layered architecture
- DTO usage
- Validation handling
- Exception handling
- PostgreSQL cloud database integration
- Frontend API integration
- Responsive UI design
- Production deployment preparation

---

# Current Project Status

## Backend Status ✅

Completed:

- URL shortening API
- Redirect handling
- Analytics tracking
- Custom alias support
- URL expiration support
- Validation & exception handling
- Swagger/OpenAPI documentation
- PostgreSQL migration
- Cloud database integration using Aiven
- Environment variable security setup

---

## Frontend Status ✅

Completed:

- React + Vite frontend
- Tailwind CSS UI
- Responsive mobile design
- Home page
- Analytics page
- Navbar
- Footer
- Recent links section
- Copy short URL feature
- Clickable short URLs
- Toast notifications
- Loading animations
- API integration with backend

---

# Features

# URL Shortening

Generate unique short URLs for long URLs.

Example:

```txt
https://github.com/helloabdulmajid
↓
http://localhost:8080/github
```

---

# Custom Alias Support

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

# URL Expiration

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

# Redirect Handling

Short URLs redirect users to original URLs.

Example:

```txt
GET /github
→ Redirects to https://github.com
```

---

# Click Tracking & Analytics

Tracks total redirect clicks for each URL.

Analytics endpoint:

```txt
GET /api/v1/urls/{shortCode}/analytics
```

Example response:

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

# Responsive Frontend UI

The frontend supports:

- Mobile responsive layout
- Modern dark UI
- Gradient buttons
- Analytics dashboard
- Interactive navigation
- Footer section
- Smooth hover effects

---

# Tech Stack

# Backend

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Maven

---

# Frontend

- React
- Vite
- Tailwind CSS
- Axios
- React Router
- React Hot Toast

---

# Database

- PostgreSQL
- Aiven Cloud Database

---

# Tools & Libraries

- Lombok
- Swagger/OpenAPI
- Git & GitHub
- Postman
- IntelliJ IDEA
- VS Code

---

# Architecture

The project follows layered backend architecture.

```txt
Controller → Service → Repository → Database
```

Frontend communicates with backend APIs using Axios.

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

---

# 2. Redirect URL

## Endpoint

```txt
GET /{shortCode}
```

---

# 3. URL Analytics

## Endpoint

```txt
GET /api/v1/urls/{shortCode}/analytics
```

---

# Validation Rules

# Original URL

- Required
- Must start with:
    - http://
    - https://

---

# Custom Alias

- Optional
- Must be unique
- Duplicate aliases are blocked

---

# Expiration Date

- Optional
- Expired URLs automatically become inaccessible

---

# Exception Handling

Global exception handling implemented using:

```txt
@RestControllerAdvice
```

Custom exceptions:

- ShortUrlNotFoundException
- ShortUrlExpiredException
- DuplicateShortCodeException

---

# HTTP Status Codes

| Status Code | Meaning |
|---|---|
| 201 Created | Short URL created |
| 302 Found | Redirect successful |
| 400 Bad Request | Validation error |
| 404 Not Found | Short URL not found |
| 409 Conflict | Duplicate alias |
| 410 Gone | URL expired |

---

# Database Design

# Table: short_url

| Column | Description |
|---|---|
| id | Primary Key |
| original_url | Original long URL |
| short_code | Generated/custom short code |
| click_count | Total redirect clicks |
| created_at | URL creation timestamp |
| expires_at | Expiration timestamp |
| active | Active status |

---

# PostgreSQL Cloud Migration ✅

The project was migrated from MySQL to PostgreSQL using Aiven Cloud Database.

Benefits:

- Cloud hosted database
- Better deployment readiness
- Production-style setup
- Secure environment variable support

---

# Environment Variables

Sensitive credentials are stored using environment variables.

Example:

```env
DB_URL=your_database_url
DB_USERNAME=your_database_username
DB_PASSWORD=your_database_password
```

---

# How To Run Backend

## Clone Repository

```bash
git clone https://github.com/helloabdulmajid/minilink.git
```

---

## Open Project

Open using IntelliJ IDEA.

---

## Configure Environment Variables

Example:

```env
DB_URL=jdbc:postgresql://localhost:5432/minilink
DB_USERNAME=postgres
DB_PASSWORD=password
```

---

## Run Application

Run:

```txt
MinilinkApplication.java
```

Backend runs on:

```txt
http://localhost:8080
```

---

# How To Run Frontend

## Open Frontend Folder

```bash
cd minilink-web
```

---

## Install Dependencies

```bash
npm install
```

---

## Run Frontend

```bash
npm run dev
```

Frontend runs on:

```txt
http://localhost:5173
```

---

# Planned Future Improvements

- JWT Authentication
- User Accounts
- QR Code Generation
- Redis Caching
- Docker Support
- Public Deployment
- Rate Limiting
- Admin Dashboard
- Advanced Analytics

---

# Learning Outcomes

This project helped in understanding:

- REST API development
- Full stack integration
- React frontend development
- Tailwind responsive UI
- PostgreSQL cloud integration
- Environment variable security
- Exception handling
- DTO usage
- JPA & Hibernate
- API testing
- Git workflow
- Deployment preparation

---

# Author

## Abdul Majid

Java Backend Developer

GitHub:

https://github.com/helloabdulmajid

---

# Project Status

## Backend Completed ✅

## Frontend Completed ✅

## PostgreSQL Migration Completed ✅

## Deployment Phase In Progress 🚀