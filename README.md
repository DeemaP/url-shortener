# URL Shortener

## Description
This project is a URL shortening service. You can send a long URL, receive a short link, and use it for quick redirection to the original address.

## Tech Stack
- Java 17
- Spring Boot 3
- PostgreSQL
- Redis
- Liquibase
- Gradle
- Docker & Docker Compose

## Installation & Run

### 1. Clone the repository
```sh
git clone https://github.com/DeemaP/url-shortener.git
cd url-shortener
```

### 2. Run with Docker Compose
If you have Docker and Docker Compose installed, simply run:
```sh
docker-compose up -d
```
This will create and start containers for:
- PostgreSQL (Database)
- Redis (Caching)
- URL Shortener Service

## Swagger UI
API documentation is available at:
```
http://localhost:8080/swagger-ui.html
```

