# Java 21 base image
FROM eclipse-temurin:21-jdk-jammy

# Install Maven
RUN apt-get update && apt-get install -y maven

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Build the project
RUN mvn clean package -DskipTests

# Expose Spring Boot port
EXPOSE 8080

# Run Spring Boot jar
CMD ["java","-jar","target/family-backend-0.0.1-SNAPSHOT.jar"]