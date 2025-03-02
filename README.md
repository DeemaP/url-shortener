# URL Shortener

## Описание
Этот проект представляет собой сервис сокращения URL-адресов. Вы можете отправить длинный URL,
получить короткую ссылку и использовать её для быстрого редиректа на оригинальный адрес.

## Стек технологий
- Java 17
- Spring Boot 3
- PostgreSQL
- Redis
- Liquibase
- Gradle
- Docker & Docker Compose

## Установка и запуск

### 1. Клонирование репозитория
```sh
git clone https://github.com/your-username/url-shortener.git
cd url-shortener
```

### 2. Сборка проекта
Соберите JAR-файл с помощью Gradle:
```sh
./gradlew clean build
```

### 3. Запуск через Docker Compose
Если у вас установлен Docker и Docker Compose, просто запустите:
```sh
docker-compose up -d
```
Это создаст и запустит контейнеры для:
- PostgreSQL (База данных)
- Redis (Кеширование)
- Сервиса URL Shortener

## Swagger UI
Документация API доступна по адресу:
```
http://localhost:8080/swagger-ui.html
```