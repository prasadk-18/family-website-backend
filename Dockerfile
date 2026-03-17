# Use OpenJDK 17
FROM eclipse-temurin:17-jdk-jammy

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Copy source code
COPY src ./src

# Give execution permission to Maven wrapper
RUN chmod +x mvnw

# Build the project (skip tests for faster deploy)
RUN ./mvnw clean package -DskipTests

# Expose port 8080 (Render will map its PORT environment variable)
EXPOSE 8080

# Run the jar - automatically picks the JAR file in target/
CMD ["sh", "-c", "java -jar target/*.jar"]