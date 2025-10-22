# STAGE 1: Build the application
FROM maven:3.8.6-jdk-17 AS builder
WORKDIR /app
# Copy the necessary files
COPY pom.xml .
COPY src ./src
# Build the application
RUN mvn clean package -DskipTests

# STAGE 2: Create the final image
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# Copy the JAR from the build stage
COPY --from=builder /app/target/*.jar app.jar
# Expose the port (e.g., Spring Boot default is 8080)
EXPOSE 8080
# Run the application
ENTRYPOINT ["java","-jar","/app/app.jar"]
