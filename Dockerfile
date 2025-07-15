# Use lightweight OpenJDK 17 base image
FROM openjdk:17-jdk-slim

# Set working directory in container
WORKDIR /app

# Copy the Spring Boot JAR and keystore into the container
COPY target/profile-0.0.1-SNAPSHOT.jar app.jar
COPY src/main/resources/keystore.p12 keystore.p12

# Expose HTTPS port
EXPOSE 8443

# Run the app with keystore config
ENTRYPOINT ["java", "-jar", "app.jar", \
  "--server.port=8443", \
  "--server.ssl.enabled=true", \
  "--server.ssl.key-store=keystore.p12", \
  "--server.ssl.key-store-password=Logezz@07", \
  "--server.ssl.key-store-type=PKCS12"]
