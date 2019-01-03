FROM openjdk:11-jdk
MAINTAINER Miguel Guilherme
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
#ENTRYPOINT exec java -DDATASOURCE_URL=jdbc:postgresql://postgres:5432/test -jar /app.jar