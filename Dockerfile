# Use a lightweight JDK image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the Spring Boot JAR file
COPY target/profile-0.0.1-SNAPSHOT.jar app.jar

# Expose HTTP port
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
