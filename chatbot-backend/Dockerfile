# ---------- Build stage ----------
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /build

# 👇 project is inside chatbot-backend folder
COPY chatbot-backend/pom.xml .
COPY chatbot-backend/src ./src

RUN mvn clean package -DskipTests

# ---------- Runtime stage ----------
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

COPY --from=build /build/target/*.jar chatbot-backend-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","chatbot-backend-0.0.1-SNAPSHOT.jar"]




