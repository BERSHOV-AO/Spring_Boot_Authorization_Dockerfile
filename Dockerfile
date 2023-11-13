FROM adoptopenjdk/openjdk11:alpine-jre

EXPOSE 8080

ADD target/Spring_Boot_Authorization_Dockerfile-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]