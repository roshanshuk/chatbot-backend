FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /build

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

COPY --from=build /build/target/*.jar chatbot-backend-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","chatbot-backend-0.0.1-SNAPSHOT.jar"]








