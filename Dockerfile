FROM openjdk:12-jdk-alpine AS task-geo
EXPOSE 9000
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]