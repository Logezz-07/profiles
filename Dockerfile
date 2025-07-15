# Stage 1: Build the app using Maven
FROM maven:3.9.4-eclipse-temurin-17 as builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the app using JDK
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/profile-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
