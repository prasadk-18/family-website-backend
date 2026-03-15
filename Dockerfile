# Use OpenJDK 21 base image
FROM openjdk:21-jdk-slim

# Set Maven version
ENV MAVEN_VERSION=3.9.14
ENV MAVEN_HOME=/opt/maven
ENV PATH=${MAVEN_HOME}/bin:${PATH}

# Install required tools
RUN apt-get update && \
    apt-get install -y curl tar git && \
    rm -rf /var/lib/apt/lists/*

# Download and install Maven manually
RUN curl -fsSL https://dlcdn.apache.org/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
    -o /tmp/apache-maven.tar.gz && \
    tar -xzf /tmp/apache-maven.tar.gz -C /opt && \
    mv /opt/apache-maven-${MAVEN_VERSION} ${MAVEN_HOME} && \
    rm /tmp/apache-maven.tar.gz

# Set working directory
WORKDIR /app

# Copy project files
COPY . /app

# Build the Spring Boot project
RUN mvn clean package -DskipTests

# Expose backend port
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "target/family-backend-0.0.1-SNAPSHOT.jar"]