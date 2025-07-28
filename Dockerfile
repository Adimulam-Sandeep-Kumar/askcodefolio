# Use official OpenJDK 21 base image
FROM eclipse-temurin:21-jdk-alpine

# Set working directory in the container
WORKDIR /app

# Copy the built jar from the host into the container
COPY target/portfolio-0.0.1-SNAPSHOT.jar app.jar

# Expose the port Spring Boot runs on
EXPOSE 8080

# Default command to run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
