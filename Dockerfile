FROM openjdk:17
WORKDIR /app
COPY target/*.jar spring_mvc_project-1.0.0.jar
ENTRYPOINT ["java", "-jar", "/app/spring_mvc_project-1.0.0.jar"]