# ---------- Build stage ----------
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /build

# Copy Maven files
COPY pom.xml
COPY src ./src

# Build the application
RUN mvn clean install -DskipTests

# ---------- Runtime stage ----------
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copy built jar from build stage
COPY --from=build /build/target/*.jar chatbot-backend-0.0.1-SNAPSHOT.jar

# Expose application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java","-jar","chatbot-backend-0.0.1-SNAPSHOT.jar"]











