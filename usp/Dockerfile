FROM maven:3.9.6-amazoncorretto-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
COPY wait-for-db.sh ./
RUN chmod +x ./wait-for-db.sh
RUN mvn clean package -DskipTests

FROM amazoncorretto:21-alpine-jdk
WORKDIR /app
# Instala o cliente PostgreSQL para que o psql esteja disponível
RUN apk add --no-cache postgresql-client
COPY --from=build /app/target/*.jar app.jar
COPY --from=build /app/wait-for-db.sh ./wait-for-db.sh
RUN chmod +x ./wait-for-db.sh
EXPOSE 9001
ENTRYPOINT ["/app/wait-for-db.sh", "db_postgres", "tcc", "tcc_usp", "java", "-jar", "app.jar"]