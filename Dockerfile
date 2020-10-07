FROM gradle:6.6.1-jdk14
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:12-jdk-alpine AS task-geo
EXPOSE 9000
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]