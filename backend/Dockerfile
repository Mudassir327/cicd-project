# Use Java 17 lightweight image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy project files
COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .
COPY src ./src

# Build application
RUN ./mvnw clean package -DskipTests

# Expose backend port
EXPOSE 8081

# Run the application
CMD ["java", "-jar", "target/blood-bank-api-0.0.1-SNAPSHOT.jar"]
