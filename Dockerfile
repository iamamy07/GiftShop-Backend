# -------- Build Stage --------
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# -------- Runtime Stage --------
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY --from=build /app/target/spring-boot-ecommerce-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD java -jar app.jar --server.port=$PORT
