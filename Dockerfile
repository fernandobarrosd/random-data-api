FROM maven:3.8.8-eclipse-temurin-21 as build

COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:21-slim

COPY --from=build target/random-data-api-0.0.1-SNAPSHOT.jar randomDataApi-0.0.1-SNAPSHOT.jar


EXPOSE 8080

ENTRYPOINT ["java", "-jar", "randomDataApi-0.0.1-SNAPSHOT.jar"]