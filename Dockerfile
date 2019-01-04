FROM openjdk:11-jdk
MAINTAINER Miguel Guilherme
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-DDATASOURCE_URL=jdbc:postgresql://postgres:5432/test", "-jar", "/app.jar"]

#docker run -d --name rest-example -p 8943:8080 --network docker_default rest-example:0.0.1-SNAPSHOT