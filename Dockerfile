FROM openjdk:17-jdk-slim-buster
WORKDIR /app
COPY build/libs/url-shortener.jar app.jar
ENTRYPOINT java -jar app.jar